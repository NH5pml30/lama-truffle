package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

public abstract class PatternStrNode extends PatternNode {
    protected PatternStrNode(LamaNode value) {
        super(value);
    }

    @Specialization
    public int match(char[] str) {
        return 1;
    }

    @Fallback
    public int match(Object val) {
        return 0;
    }
}
