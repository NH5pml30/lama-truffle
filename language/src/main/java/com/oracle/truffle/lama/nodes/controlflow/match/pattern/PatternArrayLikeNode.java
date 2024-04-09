package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.PatGen;
import com.oracle.truffle.lama.nodes.expression.IntLiteralNode;
import com.oracle.truffle.lama.nodes.scope.ReadElementNode;
import com.oracle.truffle.lama.nodes.scope.ReadElementNodeFactory;

import java.util.List;
import java.util.stream.IntStream;

abstract class PatternChildLikeNode extends PatternNode {
    @Child @Executed(with = "value") ReadElementNode element;
    @Child @Executed(with = "element") PatternNode pat;

    PatternChildLikeNode(LamaNode value, int index, PatGen patGen) {
        super(value);
        this.element = ReadElementNodeFactory.create(value, new IntLiteralNode(index));
        this.pat = patGen.apply(this.element);
    }

    @Specialization
    public int match(Object valueValue, Object elementValue, int patValue) {
        return patValue;
    }
}

public abstract class PatternArrayLikeNode extends PatternNode {
    @Children PatternChildLikeNode[] pats;

    protected PatternArrayLikeNode(LamaNode value, List<PatGen> patGens) {
        super(value);
        this.pats = IntStream.range(0, patGens.size()).boxed()
                .map(i -> PatternChildLikeNodeFactory.create(value, i, patGens.get(i)))
                .toArray(PatternChildLikeNode[]::new);
    }

    protected int match(VirtualFrame frame, Object[] value) {
        if (value.length != pats.length) {
            return 0;
        }
        CompilerAsserts.compilationConstant(pats.length);
        for (int i = 0; i < pats.length; i++) {
            if (pats[i].executeWith(frame, value) == 0) {
                return 0;
            }
        }
        return 1;
    }

    @Fallback
    public int match(Object value) {
        System.err.format("fallback on %s", value.toString());
        return 0;
    }
}
