package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@GenerateNodeFactory
abstract class GetClosureNode extends LamaNode {

    @Specialization
    VirtualFrame get(VirtualFrame frame) {
        return (MaterializedFrame) frame.getArguments()[0];
    }
}

@GenerateNodeFactory
public abstract class ReadClosureNode extends LamaNode {
    @Child @Executed GetClosureNode closure;
    @Child @Executed(with = "closure") ReadSlotNode reader;

    ReadClosureNode(int slot) {
        closure = GetClosureNodeFactory.create();
        reader = ReadSlotNodeFactory.create(closure, slot);
    }

    @Specialization
    Object read(VirtualFrame closure, Object readValue) {
        return readValue;
    }
}
