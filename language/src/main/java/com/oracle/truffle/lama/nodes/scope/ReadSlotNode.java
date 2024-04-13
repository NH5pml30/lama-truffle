package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "slot", type = int.class)
@NodeChild(value = "theFrame", type = LamaNode.class)
@GenerateNodeFactory
public abstract class ReadSlotNode extends LamaNode {
    abstract Object executeWith(VirtualFrame frame, VirtualFrame theFrame);

    @Specialization
    Object read(int slot, VirtualFrame theFrame) {
        return theFrame.getValue(slot);
    }
}
