package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeChild(value = "rhs", type = LamaNode.class)
@NodeField(name = "slot", type = int.class)
@GenerateNodeFactory
public abstract class WriteLocalNode extends LamaNode {
    @Specialization
    public Object execute(VirtualFrame frame, int slot, Object rhs) {
        frame.setObject(slot, rhs);
        return rhs;
    }
}
