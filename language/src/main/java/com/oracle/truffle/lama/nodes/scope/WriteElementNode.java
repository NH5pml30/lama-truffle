package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeChild(value = "lhs", type = LamaNode.class)
@NodeChild(value = "index", type = LamaNode.class)
@NodeChild(value = "rhs", type = LamaNode.class)
@GenerateNodeFactory
public abstract class WriteElementNode extends LamaNode {
    @Specialization
    int write(StringBuilder lhs, int index, int rhs) {
        lhs.setCharAt(index, (char) rhs);
        return rhs;
    }

    @Specialization
    Object write(Object[] lhs, int index, Object rhs) {
        return lhs[index] = rhs;
    }
}