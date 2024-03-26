package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.nodes.LamaNode;

public class WhileDoNode extends LamaNode {
    private static class WhileDoRepeatingNode extends Node implements RepeatingNode {
        @Child private LamaNode conditionNode;
        @Child private LamaNode bodyNode;

        public WhileDoRepeatingNode(LamaNode conditionNode, LamaNode bodyNode) {
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

    @Child private LoopNode loopNode;

    public WhileDoNode(LamaNode conditionNode, LamaNode bodyNode) {
        this.loopNode = Truffle.getRuntime().createLoopNode(new WhileDoRepeatingNode(conditionNode, bodyNode));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        loopNode.execute(frame);
        return null;
    }
}
