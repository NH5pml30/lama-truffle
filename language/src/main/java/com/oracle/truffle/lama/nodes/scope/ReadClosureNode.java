package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "slot", type = int.class)
@GenerateNodeFactory
public abstract class ReadClosureNode extends LamaNode {
    public abstract int getSlot();

    @Specialization
    Object read(VirtualFrame frame) {
        var closure = (MaterializedFrame) frame.getArguments()[0];
        System.err.format("Try to read slot '%d'\n", getSlot());
        return closure.getValue(getSlot());
    }
}
