package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.PatGen;

import java.util.List;

public abstract class PatternArrayNode extends PatternArrayLikeNode {
    protected PatternArrayNode(LamaNode value, List<PatGen> patGens) {
        super(value, patGens);
    }

    @Specialization
    public int match(VirtualFrame frame, Object[] value) {
        return super.match(frame, value);
    }
}
