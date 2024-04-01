package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.PatGen;
import com.oracle.truffle.lama.runtime.LamaSExp;

import java.util.List;

public abstract class PatternSExpNode extends PatternArrayLikeNode {
    int hash;

    protected PatternSExpNode(LamaNode value, int hash, List<PatGen> patGens) {
        super(value, patGens);
        this.hash = hash;
    }

    @Specialization
    public int match(VirtualFrame frame, LamaSExp value) {
        if (value.hash() != hash) {
            return 0;
        }
        return super.match(frame, value.children());
    }
}
