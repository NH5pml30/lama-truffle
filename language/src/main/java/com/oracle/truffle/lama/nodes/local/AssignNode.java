package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.LamaRef;

@NodeChild(value = "arguments", type = LamaNode[].class)
@GenerateNodeFactory
public abstract class AssignNode extends LamaNode {
    @Specialization
    public Object assign(VirtualFrame frame, LamaRef lhs, Object rhs) {
        return lhs.assign(frame, rhs);
    }
}
