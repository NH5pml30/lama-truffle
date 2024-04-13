package com.oracle.truffle.lama.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.expression.ClosureNode;
import com.oracle.truffle.lama.nodes.scope.ReadClosureNodeFactory;
import com.oracle.truffle.lama.runtime.LamaRef;
import org.graalvm.collections.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.oracle.truffle.lama.parser.LexicalScope.refGen;

// Class to store function closure (captured variables).
// Each function captures variables by value, and the copy is created at the moment of referencing the function.
// Global variables (and functions) are not captured and referenced as global variables everywhere. Currently, each local
// function creates a local variable that stores a `LambdaNode` with its call target.
// If function `f` explicitly calls or references function `g`, then `f`'s closure must be enough to build `g`'s closure.
// Function `f` can explicitly call function `g`, and `g` can explicitly call function `f`, if they are in the same block.
// To support this, each closure has "`Instantiation`s" at each point of explicit mention of the function, and building up
// the closure also propagates all the necessary values to all the instantiations.
// To determine equality between `Capture`d values, parent scopes are compared by reference and names are compared as strings.
class Closure {
    Closure(String scopeName) {
        this.scopeName = scopeName;
    }

    class Instantiation {
        private final Map<Integer, Capture<LamaNode>> slotsInstantiation;
        private LexicalFuncScope target;

        Instantiation(LexicalFuncScope target) {
            this.target = target;
            this.slotsInstantiation = new HashMap<>(Closure.this.closureSlots);
            Closure.this.instantiations.add(this);
        }

        void propagate(LexicalFuncScope through) {
            target = through;
            for (var e : slotsInstantiation.entrySet()) {
                var capture = e.getValue();
                e.setValue(capture.reset(through.closure.propagate(capture, false).generate(ValueCategory.Val)));
            }
        }

        private void addedClosureSlot(int slot) {
            var capture = Closure.this.closureSlots.get(slot);
            LamaNode value = target.find(capture).map(
                    f -> f.get().generate(ValueCategory.Val) // does not contain closure instantiations => safe to generate
            ).orElse(null);
            slotsInstantiation.put(slot, new Capture<>(value, capture.source(), capture.name()));
        }

        static Optional<ClosureNode> getNode(FrameDescriptor desc, Map<Integer, Capture<LamaNode>> values) {
            if (values.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(new ClosureNode(
                    desc,
                    values.entrySet().stream().collect(Collectors.toMap(
                            Map.Entry::getKey,
                            p -> p.getValue().value()
                    ))
            ));
        }

        public void print() {
            System.err.println("slots:");
            for (var x : slotsInstantiation.entrySet()) {
                System.err.format("%d |-> %s@%s(%s)\n", x.getKey(), x.getValue().source().toString(), x.getValue().name(), x.getValue().value().toString());
            }
            System.err.println("names:");
            for (var x : lexicalClosure.entrySet()) {
                System.err.format("%s |-> %d\n", x.getKey(), x.getValue());
            }
        }

        Optional<ClosureNode> getNode() {
            return getNode(closureBuilder.build(), slotsInstantiation);
        }
    }

    private final Map<String, Integer> lexicalClosure = new HashMap<>();
    private final Map<Integer, Capture<LamaNode>> closureSlots = new HashMap<>();
    private final FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();
    private final List<Instantiation> instantiations = new ArrayList<>();
    private final String scopeName;

    private int addClosureSlot(LamaNode value, LexicalScope source, String name) {
        var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
        closureSlots.put(slot, new Capture<>(value, source, name));
        for (var instantiation : List.copyOf(instantiations)) {
            instantiation.addedClosureSlot(slot);
        }
        return slot;
    }

    <T> int getOrAddClosureSlot(Capture<T> capture, Function<T, LamaNode> generate) {
        return lookup(capture).map(Pair::getLeft).orElseGet(() -> addClosureSlot(
                generate.apply(capture.value()),
                capture.source(),
                capture.name()
        ));
    }

    private Optional<Pair<Integer, LamaNode>> lookup(String name) {
        return Optional.ofNullable(lexicalClosure.get(name)).map(x -> Pair.create(x, closureSlots.get(x).value()));
    }

    private Optional<Pair<Integer, Capture<LamaNode>>> lookup(Capture<?> capture) {
        return closureSlots.entrySet().stream().filter(x -> x.getValue().equals(capture)).findAny().
                map(e -> Pair.create(e.getKey(), e.getValue()));
    }

    public void print() {
        System.err.println("slots:");
        for (var x : closureSlots.entrySet()) {
            System.err.format("%d |-> %s@%s(%s)\n", x.getKey(), x.getValue().source().toString(), x.getValue().name(), x.getValue().value().toString());
        }
        System.err.println("names:");
        for (var x : lexicalClosure.entrySet()) {
            System.err.format("%s |-> %d\n", x.getKey(), x.getValue());
        }
    }

    ExprGen getClosure(int slot) {
        return refGen(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot));
    }

    Optional<ExprGen> find(String name) {
        return lookup(name).map(p -> getClosure(p.getLeft()));
    }

    Optional<Capture<ExprGen>> find(Capture<?> capture) {
        return lookup(capture).map(p -> capture.reset(getClosure(p.getLeft())));
    }

    ExprGen propagate(Capture<LamaNode> fromOuter, boolean isBinding) {
        var slot = getOrAddClosureSlot(fromOuter, x -> x);
        if (isBinding) {
            lexicalClosure.put(fromOuter.name(), slot);
        }
        return getClosure(slot);
    }

    Instantiation instantiate(LexicalScope outer) {
        return new Instantiation(outer.getFuncScope());
    }

    Optional<ClosureNode> getNode() {
        return Instantiation.getNode(closureBuilder.build(), closureSlots);
    }
}
