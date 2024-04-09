package com.oracle.truffle.lama.parser;

import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.builtins.*;
import org.antlr.v4.runtime.Token;
import org.graalvm.collections.Pair;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LamaOperators {
    enum OpType {
        InfixLeft, InfixRight, InfixNone
    }

    // All the builtin binary operators
    static final List<Pair<OpType, Map<String, NodeFactory<? extends BuiltinNode>>>> BUILTIN_OPERATOR_INFO = Arrays.asList(
            Pair.create(
                    OpType.InfixRight,
                    Map.of(":=", AssignNodeFactory.getInstance())
            ),
            Pair.create(
                    OpType.InfixRight,
                    Map.of(":", ConsNodeFactory.getInstance())
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of("!!", OrNodeFactory.getInstance())
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of("&&", AndNodeFactory.getInstance())
            ),
            Pair.create(
                    OpType.InfixNone,
                    Map.of(
                            "==", EqNodeFactory.getInstance(),
                            "!=", NeqNodeFactory.getInstance(),
                            "<=", LeqNodeFactory.getInstance(),
                            "<", LtNodeFactory.getInstance(),
                            ">=", GeqNodeFactory.getInstance(),
                            ">", GtNodeFactory.getInstance()
                    )
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of(
                            "+", AddNodeFactory.getInstance(),
                            "-", SubNodeFactory.getInstance()
                    )
            ),
            Pair.create(
                    OpType.InfixRight,
                    Map.of(
                            "*", MulNodeFactory.getInstance(),
                            "/", DivNodeFactory.getInstance(),
                            "%", ModNodeFactory.getInstance()
                    )
            )
    );

    static class OperatorInfo implements Cloneable {
        List<Pair<OpType, Set<String>>> data;

        public OperatorInfo() {
            this(new ArrayList<>());
        }

        public OperatorInfo(List<Pair<OpType, Set<String>>> data) {
            this.data = data;
        }

        Optional<Pair<Integer, OpType>> get(String t) {
            return IntStream.range(0, data.size()).boxed()
                    .flatMap(i -> {
                        var info = data.get(i);
                        return info.getRight().contains(t) ? Stream.of(Pair.create(i, info.getLeft())) : Stream.empty();
                    })
                    .findFirst();
        }

        void addLevel(int before, OpType infixity, String name) {
            var set = new HashSet<String>();
            set.add(name);
            data.add(before, Pair.create(infixity, set));
        }

        void addInfo(int at, String name) {
            data.get(at).getRight().add(name);
        }

        void print() {
            int i = 0;
            for (var x : data) {
                System.err.format("%d: %s\n", i++, x.getLeft().toString());
                for (var name : x.getRight()) {
                    System.err.println("  " + name);
                }
            }
        }

        @Override
        public OperatorInfo clone() {
            OperatorInfo obj;
            try {
                obj = (OperatorInfo) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            obj.data = data.stream().map(x ->
                    Pair.<OpType, Set<String>>create(x.getLeft(), new HashSet<>(x.getRight()))
            ).collect(Collectors.toList());
            return obj;
        }
    }

    // Prepare for user-defined operators, init with builtin operators
    static final OperatorInfo OPERATOR_INFO = new OperatorInfo(
            BUILTIN_OPERATOR_INFO.stream().map(
                            p -> Pair.<OpType, Set<String>>create(
                                    p.getLeft(),
                                    new HashSet<>(p.getRight().keySet())
                            )
                    )
                    .toList()
    );

    static LamaOperators.OperatorInfo getOperatorInfo(LexicalScope scope) {
        return scope == null ? OPERATOR_INFO : scope.operatorInfo;
    }

    // Make sure lhs of := becomes a Ref
    static ValueCategory op2cat(String name) {
        // System.out.format("Check lvalue: %s\n", t.getText());
        return Objects.equals(name, ":=") ? ValueCategory.Ref : ValueCategory.Val;
    }
}
