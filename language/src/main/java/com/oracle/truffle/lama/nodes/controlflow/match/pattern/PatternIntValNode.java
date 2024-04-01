package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

public abstract class PatternIntValNode extends PatternNode {
    int val;
    protected PatternIntValNode(LamaNode value, int val) {
        super(value);
        this.val = val;
    }

    @Specialization
    public int match(int val) {
        if (val == this.val) {
            return 1;
        }
        return 0;
    }

    @Fallback
    public int match(Object val) {
        return 0;
    }
}
