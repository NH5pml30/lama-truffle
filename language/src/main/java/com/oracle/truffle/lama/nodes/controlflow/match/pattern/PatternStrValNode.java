package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

import java.util.Arrays;

public abstract class PatternStrValNode extends PatternNode {
    char[] val;
    protected PatternStrValNode(LamaNode value, String val) {
        super(value);
        this.val = val.toCharArray();
    }

    @Specialization
    public int match(char[] val) {
        if (Arrays.compare(this.val, val) == 0) {
            return 1;
        }
        return 0;
    }

    @Fallback
    public int match(Object val) {
        return 0;
    }
}
