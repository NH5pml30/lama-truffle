package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.PatGen;
import com.oracle.truffle.lama.runtime.LamaRef;

public abstract class PatternBindNode extends PatternNode {
    protected @Child @Executed(with = "value") PatternNode pat;
    protected final LamaRef ref;

    protected PatternBindNode(LamaNode value, PatGen patGen, LamaRef ref) {
        super(value);
        this.pat = patGen.apply(value);
        this.ref = ref;
    }

    @Specialization
    public int match(VirtualFrame frame, Object value, int pat) {
        if (pat == 0) {
            return 0;
        }
        ref.assign(LamaContext.get(this), frame, value);
        return 1;
    }
}
