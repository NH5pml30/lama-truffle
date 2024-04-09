package com.oracle.truffle.lama.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.expression.ClosureNode;
import com.oracle.truffle.lama.nodes.scope.ReadClosureNodeFactory;
import com.oracle.truffle.lama.runtime.LamaRef;
import org.graalvm.collections.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.oracle.truffle.lama.parser.LexicalScope.refGen;

class Closure {
    record Capture<T>(T value, LexicalScope source, String name) {
        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Capture<?> o)) {
                return false;
            }
            return source == o.source && name.equals(o.name);
        }
    }

    private final Map<String, Integer> lexicalClosure = new HashMap<>();
    private final Map<Integer, Capture<LamaNode>> closureSlots = new HashMap<>();
    private FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();
    private boolean done = false;

    private int addClosureSlot(LamaNode value, LexicalScope source, String name) {
        if (done) {
            throw new IllegalArgumentException();
        }
        var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
        closureSlots.put(slot, new Capture<>(value, source, name));
        // System.err.format("'%s'(%d): Add closure slot '%d'->'%s' to '%s'\n", this.toString(), closure.size(), slot, name, value.toString());
        return slot;
    }

    ExprGen addClosure(LamaNode value, LexicalScope source, String name) {
        var slot = addClosureSlot(value, source, name);
        var prev = lexicalClosure.put(name, slot);
        if (prev != null) {
            throw new IllegalArgumentException("Aaaa");
        }
        return getClosure(slot);
    }

    <T> ExprGen getOrAddClosureSlot(Capture<T> capture, Function<T, LamaNode> generate) {
        System.err.format("getOrAddClosureSlot %s:%s\n", capture.source.toString(), capture.name);
        int slot = lookup(capture).map(Pair::getLeft).orElseGet(() -> addClosureSlot(
                generate.apply(capture.value),
                capture.source,
                capture.name
        ));
        return getClosure(slot);
    }

    Optional<ClosureNode> getNode() {
        done = true;
        if (closureSlots.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new ClosureNode(
                closureBuilder.build(),
                closureSlots.entrySet().stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        p -> p.getValue().value
                ))
        ));
    }

    private Optional<Pair<Integer, LamaNode>> lookup(String name) {
        return Optional.ofNullable(lexicalClosure.get(name)).map(x -> Pair.create(x, closureSlots.get(x).value));
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
            System.err.format("%d |-> %s@%s(%s)", x.getKey(), x.getValue().source.toString(), x.getValue().name, x.getValue().value.toString());
        }
        System.err.println("names:");
        for (var x : lexicalClosure.entrySet()) {
            System.err.format("%s |-> %d", x.getKey(), x.getValue());
        }
    }

    ExprGen getClosure(int slot) {
        System.err.format("%s: getClosure@%d -> %s\n", this.toString(), slot, slot2name(slot));
        return refGen(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot));
    }

    Optional<ExprGen> find(String name) {
        return lookup(name).map(p -> getClosure(p.getLeft()));
    }

    Closure propagate(Closure fromOuter) {
        if (fromOuter == this) {

        }
        // System.out.format("Propagate closure '%s'(%d) through '%s'(%d)\n", fromOuter, fromOuter.closure.size(), this.toString(), closure.size());
        // if (this == fromOuter) {
        //     System.out.println("HUHH");
        // }
        var inner = new Closure();
        inner.closureBuilder = fromOuter.closureBuilder;
        for (var e : fromOuter.closureSlots.entrySet()) {
            var innerSlot = e.getKey();
            var capture = e.getValue();
            var node = getOrAddClosureSlot(capture, Function.identity()).generate(ValueCategory.Val);
            inner.closureSlots.put(innerSlot, new Capture<>(node, capture.source, capture.name));
        }
        return inner;
    }

    ExprGen propagate(Capture<ExprGen> fromOuter) {
        return getOrAddClosureSlot(fromOuter, x -> x.generate(ValueCategory.Val));
    }
}
