package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.lama.nodes.LamaNode;

public class WhileNode extends LamaNode {
    @Child private LoopNode loopNode;

    public WhileNode(LamaNode conditionNode, LamaNode bodyNode) {
        this.loopNode = Truffle.getRuntime().createLoopNode(new WhileRepeatingNode(conditionNode, bodyNode));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        loopNode.execute(frame);
        return null;
    }
}
