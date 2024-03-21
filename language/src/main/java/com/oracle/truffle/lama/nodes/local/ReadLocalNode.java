package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "slot", type = int.class)
@GenerateNodeFactory
public abstract class ReadLocalNode extends LamaNode {
    public abstract int getSlot();

    @Specialization
    public Object read(VirtualFrame virtualFrame) {
        return virtualFrame.getValue(this.getSlot());
    }
}
