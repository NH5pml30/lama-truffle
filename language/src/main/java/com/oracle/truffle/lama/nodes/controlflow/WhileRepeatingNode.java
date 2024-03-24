package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.nodes.LamaNode;

public class WhileRepeatingNode extends Node implements RepeatingNode {
    @Child private LamaNode conditionNode;
    @Child private LamaNode bodyNode;

    public WhileRepeatingNode(LamaNode conditionNode, LamaNode bodyNode) {
        this.conditionNode = conditionNode;
        this.bodyNode = bodyNode;
    }

    @Override
    public boolean executeRepeating(VirtualFrame frame) {
        if (!evaluateCondition(frame)) {
            return false;
        }

        bodyNode.execute(frame);
        return true;
    }

    private boolean evaluateCondition(VirtualFrame frame) {
        try {
            return conditionNode.executeInt(frame) != 0;
        } catch (UnexpectedResultException ex) {
            throw new UnsupportedSpecializationException(this, new Node[]{conditionNode}, ex.getResult());
        }
    }
}
