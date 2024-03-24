package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeChild(value = "condition", type = LamaNode.class)
@NodeField(name = "thenNode", type = LamaNode.class)
@NodeField(name = "elseNode", type = LamaNode.class)
@GenerateNodeFactory
public abstract class IfNode extends LamaNode {
    protected abstract LamaNode getThenNode();
    protected abstract LamaNode getElseNode();

    @Specialization
    public Object ifGeneric(VirtualFrame frame, int condition) {
        if (condition != 0) {
            return getThenNode().execute(frame);
        }
        var elseNode = getElseNode();
        if (elseNode != null) {
            return elseNode.execute(frame);
        }
        return null;
    }
}
