package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RepeatingNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.nodes.LamaNode;

public class ForNode extends LamaNode {
    private static class ForRepeatingNode extends Node implements RepeatingNode {
        @Child private LamaNode conditionNode;
        @Child private LamaNode stepNode;
        @Child private LamaNode bodyNode;

        private ForRepeatingNode(LamaNode conditionNode, LamaNode stepNode, LamaNode bodyNode) {
            this.conditionNode = conditionNode;
            this.stepNode = stepNode;
            this.bodyNode = bodyNode;
        }

        @Override
        public boolean executeRepeating(VirtualFrame frame) {
            if (!evaluateCondition(frame)) {
                return false;
            }

            bodyNode.execute(frame);
            stepNode.execute(frame);
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

    @Child private LamaNode initNode;
    @Child private LoopNode loopNode;

    public ForNode(LamaNode initNode, LamaNode conditionNode, LamaNode stepNode, LamaNode bodyNode) {
        this.initNode = initNode;
        this.loopNode = Truffle.getRuntime().createLoopNode(new ForRepeatingNode(conditionNode, stepNode, bodyNode));
    }

    @Override
    public Object execute(VirtualFrame frame) {
        initNode.execute(frame);
        loopNode.execute(frame);
        return null;
    }
}
