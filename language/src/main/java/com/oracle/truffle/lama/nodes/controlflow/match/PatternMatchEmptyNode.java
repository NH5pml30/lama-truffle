package com.oracle.truffle.lama.nodes.controlflow.match;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

public abstract class PatternMatchEmptyNode extends PatternMatchBaseNode {
    protected PatternMatchEmptyNode(LamaNode value) {
        super(value);
    }

    @Specialization
    public Object[] match(Object valueValue) {
        return NO_MATCH;
    }
}
