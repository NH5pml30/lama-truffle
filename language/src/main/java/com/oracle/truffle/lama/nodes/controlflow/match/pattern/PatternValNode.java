package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.runtime.LamaFunction;

public abstract class PatternValNode extends PatternNode {
    protected PatternValNode(LamaNode value) {
        super(value);
    }

    @Specialization
    public int match(int val) {
        return 1;
    }

    @Fallback
    public int match(Object val) {
        return 0;
    }
}
