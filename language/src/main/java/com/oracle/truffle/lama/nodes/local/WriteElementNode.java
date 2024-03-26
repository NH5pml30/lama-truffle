package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.LamaRef;

@NodeChild(value = "lhs", type = LamaNode.class)
@NodeChild(value = "index", type = LamaNode.class)
@NodeChild(value = "rhs", type = LamaNode.class)
@GenerateNodeFactory
public abstract class WriteElementNode extends LamaNode {
    @Specialization
    int write(char[] lhs, int index, int rhs) {
        return lhs[index] = (char) rhs;
    }
}