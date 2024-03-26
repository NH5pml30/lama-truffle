package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.nodes.LamaNode;

public class DoWhileNode extends LamaNode {
    private static class DoWhileRepeatingNode extends Node implements RepeatingNode {
        @Child private LamaNode bodyNode;
        @Child private LamaNode conditionNode;

        public DoWhileRepeatingNode(LamaNode bodyNode, LamaNode conditionNode) {
            this.bodyNode = bodyNode;
            this.conditionNode = conditionNode;
        }

        @Override
        public boolean executeRepeating(VirtualFrame frame) {
            bodyNode.execute(frame);
            return evaluateCondition(frame);
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

    public DoWhileNode(LamaNode bodyNode, LamaNode conditionNode) {
        this.loopNode = Truffle.getRuntime().createLoopNode(new DoWhileRepeatingNode(bodyNode, conditionNode));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        loopNode.execute(frame);
        return null;
    }
}
