package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.lama.nodes.LamaRef;

@NodeInfo(shortName = ":=")
public abstract class AssignNode extends BuiltinNode {
    @Specialization
    protected Object assign(VirtualFrame frame, LamaRef lhs, Object rhs) {
        return lhs.assign(frame, rhs);
    }
}
