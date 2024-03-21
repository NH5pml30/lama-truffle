package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "topFrame", type = MaterializedFrame.class)
@GenerateNodeFactory
public abstract class TopFrameNode extends LamaNode {
    public abstract MaterializedFrame getTopFrame();

    @Specialization
    MaterializedFrame read() {
        return getTopFrame();
    }
}
