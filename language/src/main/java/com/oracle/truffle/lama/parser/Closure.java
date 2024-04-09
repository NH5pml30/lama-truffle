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

class Closure {
    class Instantiation {
        private final Map<Integer, Capture<LamaNode>> slotsInstantiation;
        private LexicalFuncScope target;

        Instantiation(LexicalFuncScope target) {
            this.target = target;
            this.slotsInstantiation = new HashMap<>(Closure.this.closureSlots);
            Closure.this.instantiations.add(this);
        }

        public void propagate(LexicalFuncScope through) {
            System.err.format("Propagate closure '%s' instantiation '%s' through '%s'\n", Closure.this.toString(), this.toString(), through.toString());
            target = through;
            for (var e : slotsInstantiation.entrySet()) {
                var capture = e.getValue();
                e.setValue(new Capture<>(
                        through.closure.propagate(capture, false).generate(ValueCategory.Val),
                        capture.source(),
                        capture.name()
                ));
            }
        }

        private void addedClosureSlot(int slot) {
            System.err.format("Respond in %s of %s to added slot %d\n", this.toString(), Closure.this.toString(), slot);
            var capture = Closure.this.closureSlots.get(slot);
            LamaNode value = target.find(capture).map(f -> f.get().generate(ValueCategory.Val)).orElse(null);
            slotsInstantiation.put(slot, new Capture<>(value, capture.source(), capture.name()));
        }

        public Closure getParent() {
            return Closure.this;
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

        Optional<ClosureNode> getNode() {
            System.err.format("getNode in %s of %s with %d slots\n", this.toString(), Closure.this.toString(), slotsInstantiation.size());
            done = true;
            return getNode(closureBuilder.build(), slotsInstantiation);
        }
    }

    private final Map<String, Integer> lexicalClosure = new HashMap<>();
    private final Map<Integer, Capture<LamaNode>> closureSlots = new HashMap<>();
    private FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();
    private final List<Instantiation> instantiations = new ArrayList<>();
    private boolean done = false;

    private int addClosureSlot(LamaNode value, LexicalScope source, String name) {
        if (done) {
            throw new IllegalArgumentException();
        }
        var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
        closureSlots.put(slot, new Capture<>(value, source, name));
        for (var instantiation : List.copyOf(instantiations)) {
            instantiation.addedClosureSlot(slot);
        }
        // System.err.format("'%s'(%d): Add closure slot '%d'->'%s' to '%s'\n", this.toString(), closure.size(), slot, name, value.toString());
        return slot;
    }

    <T> int getOrAddClosureSlot(Capture<T> capture, Function<T, LamaNode> generate) {
        System.err.format("getOrAddClosureSlot %s:%s\n", capture.source().toString(), capture.name());
        int slot = lookup(capture).map(Pair::getLeft).orElseGet(() -> addClosureSlot(
                generate.apply(capture.value()),
                capture.source(),
                capture.name()
        ));
        return slot;
    }

    private Optional<Pair<Integer, LamaNode>> lookup(String name) {
        return Optional.ofNullable(lexicalClosure.get(name)).map(x -> Pair.create(x, closureSlots.get(x).value()));
    }

    private Optional<Pair<Integer, Capture<LamaNode>>> lookup(Capture<?> capture) {
        return closureSlots.entrySet().stream().filter(x -> x.getValue().equals(capture)).findAny().
                map(e -> Pair.create(e.getKey(), e.getValue()));
    }

    private String slot2name(int slot) {
        for (var x : lexicalClosure.entrySet()) {
            if (x.getValue() == slot) {
                return x.getKey();
            }
        }
        return "<did not find???>";
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
        System.err.format("%s: getClosure@%d -> %s\n", this.toString(), slot, slot2name(slot));
        return refGen(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot));
    }

    Optional<ExprGen> find(String name) {
        return lookup(name).map(p -> getClosure(p.getLeft()));
    }

    Optional<Capture<ExprGen>> find(Capture<?> capture) {
        return lookup(capture).map(p -> new Capture<>(getClosure(p.getLeft()), capture.source(), capture.name()));
    }

    Closure propagate(Closure fromOuter) {
        // System.out.format("Propagate closure '%s'(%d) through '%s'(%d)\n", fromOuter, fromOuter.closure.size(), this.toString(), closure.size());
        // if (this == fromOuter) {
        //     System.out.println("HUHH");
        // }
        var inner = new Closure();
        inner.closureBuilder = fromOuter.closureBuilder;
        for (var e : fromOuter.closureSlots.entrySet()) {
            var innerSlot = e.getKey();
            var capture = e.getValue();
            var node = getClosure(getOrAddClosureSlot(capture, Function.identity())).generate(ValueCategory.Val);
            inner.closureSlots.put(innerSlot, new Capture<>(node, capture.source(), capture.name()));
        }
        return inner;
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
        System.err.format("getNode in %s with %d slots\n", this.toString(), closureSlots.size());
        done = true;
        return Instantiation.getNode(closureBuilder.build(), closureSlots);
    }
}
