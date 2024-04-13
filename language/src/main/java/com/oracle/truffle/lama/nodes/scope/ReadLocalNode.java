package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@GenerateNodeFactory
abstract class GetFrameNode extends LamaNode {
    @Specialization
    VirtualFrame get(VirtualFrame frame) {
        return frame;
    }
}

@GenerateNodeFactory
public abstract class ReadLocalNode extends LamaNode {
    @Child @Executed GetFrameNode frameNode;
    @Child @Executed(with = "frameNode") ReadSlotNode reader;

    ReadLocalNode(int slot) {
        frameNode = GetFrameNodeFactory.create();
        reader = ReadSlotNodeFactory.create(frameNode, slot);
    }

    @Specialization
    Object read(VirtualFrame frameToo, Object readValue) {
        return readValue;
    }
}
