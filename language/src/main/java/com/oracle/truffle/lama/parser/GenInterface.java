package com.oracle.truffle.lama.parser;

import com.oracle.truffle.lama.nodes.LamaNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

interface GenInterface<T, R> {
    R generate(T val);

    static <T, R> GenInterface<T, R> lift(R result) {
        return ignored -> result;
    }

    static <T1, T2, R> GenInterface<T2, R> compose(GenInterface<T1, R> r, Function<T2, T1> f) {
        return t -> r.generate(f.apply(t));
    }

    static <T, R> GenInterface<Void, R> konst(GenInterface<T, R> r, T i) {
        return compose(r, ignored -> i);
    }

    static <T, R> GenInterface<T, R> forget(GenInterface<Void, R> r) {
        return compose(r, ignored -> null);
    }

    static <T, R1, R2> GenInterface<T, R2> mapS(GenInterface<T, R1> r, BiFunction<T, R1, R2> mapper) {
        return t -> mapper.apply(t, r.generate(t));
    }

    static <T, R1, R2> GenInterface<T, R2> map(GenInterface<T, R1> r, Function<R1, R2> mapper) {
        return mapS(r, (ignored, t) -> mapper.apply(t));
    }

    static <T, R1, R2, R3> GenInterface<T, R3> lift2(GenInterface<T, R1> r1, GenInterface<T, R2> r2, BiFunction<R1, R2, R3> f) {
        return t -> f.apply(r1.generate(t), r2.generate(t));
    }

    interface TriFunction<T1, T2, T3, R> {
        R apply(T1 a1, T2 a2, T3 a3);
    }

    static <T, R1, R2, R3, R4> GenInterface<T, R4> lift3(
            GenInterface<T, R1> r1, GenInterface<T, R2> r2, GenInterface<T, R3> r3,
            TriFunction<R1, R2, R3, ? extends R4> f
    ) {
        return t -> f.apply(r1.generate(t), r2.generate(t), r3.generate(t));
    }

    interface QuadFunction<T1, T2, T3, T4, R> {
        R apply(T1 a1, T2 a2, T3 a3, T4 a4);
    }

    static <T, R1, R2, R3, R4, R5> GenInterface<T, R5> lift4(
            GenInterface<T, R1> r1, GenInterface<T, R2> r2, GenInterface<T, R3> r3, GenInterface<T, R4> r4,
            QuadFunction<R1, R2, R3, R4, R5> f
    ) {
        return t -> f.apply(r1.generate(t), r2.generate(t), r3.generate(t), r4.generate(t));
    }
}

// Generates a list of expressions as List<LamaNode> depending on the value category
interface GenInterfaces<T, R> extends GenInterface<T, List<R>> {
    static <T, R> GenInterfaces<T, R> of() {
        return a -> new ArrayList<>();
    }

    static <T, R> GenInterfaces<T, R> of(GenInterface<T, R> rhs) {
        return a -> {
            var res = new ArrayList<R>();
            var value = rhs.generate(a);
            // Behave as flatMap over list of Optional<R>
            if (value != null) {
                res.add(value);
            }
            return res;
        };
    }

    static <T, R> GenInterfaces<T, R> of(GenInterface<Void, R> lhs, GenInterface<T, R> rhs) {
        return concat(of(lhs), of(rhs));
    }

    static <T, R> GenInterfaces<T, R> concat(GenInterface<Void, List<R>> lhs, GenInterface<T, List<R>> rhs) {
        return a -> {
            var x = lhs.generate(null);
            x.addAll(rhs.generate(a));
            return x;
        };
    }

    static <T, R> GenInterfaces<T, R> add(GenInterface<Void, List<R>> lhs, GenInterface<T, R> rhs) {
        return concat(lhs, of(rhs));
    }

    static <T, R1, R2> GenInterfaces<T, R2> map(GenInterface<T, List<R1>> r, BiFunction<T, R1, R2> mapper) {
        return v ->
                GenInterface.mapS(r, (t, l) -> l.stream().map(el -> mapper.apply(t, el)).collect(Collectors.toList()))
                        .generate(v);
    }

    static <T, R> GenInterfaces<T, R> sequence(List<? extends GenInterface<T, R>> l) {
        return v -> l.stream().map(el -> el.generate(v)).collect(Collectors.toList());
    }
}

// Generates an expression as LamaNode depending on the value category
interface ExprGen extends GenInterface<ValueCategory, LamaNode> {}
interface ValGen extends GenInterface<Void, LamaNode> {}

// Constructs closures, and then generates an expression as LamaNode(s)
interface ScopedExprGen extends GenInterface<ValueCategory, GenInterface<Void, LamaNode>> {}
interface ScopedExprsGen extends GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> {
    static ScopedExprsGen of() {
        return GenInterfaces.<ValueCategory, GenInterface<Void, LamaNode>>of()::generate;
    }
}
interface ScopedValGen extends GenInterface<Void, GenInterface<Void, LamaNode>> {}
interface ScopedValsGen extends GenInterfaces<Void, GenInterface<Void, LamaNode>> {
    static ScopedValsGen of() {
        return GenInterfaces.<Void, GenInterface<Void, LamaNode>>of()::generate;
    }
}
