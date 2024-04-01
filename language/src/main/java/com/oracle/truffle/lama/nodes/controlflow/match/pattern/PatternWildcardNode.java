package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

public abstract class PatternWildcardNode extends PatternNode {
    protected PatternWildcardNode(LamaNode value) {
        super(value);
    }

    @Specialization
    public int match(Object val) {
        return 1;
    }
}
