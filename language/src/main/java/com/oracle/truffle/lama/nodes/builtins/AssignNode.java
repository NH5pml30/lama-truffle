package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.runtime.LamaRef;

public abstract class AssignNode extends BuiltinNode {
    @Specialization
    protected Object assign(VirtualFrame frame, LamaRef lhs, Object rhs) {
        return lhs.assign(LamaContext.get(this), frame, rhs);
    }
}
