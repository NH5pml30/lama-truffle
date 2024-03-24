package com.oracle.truffle.lama.nodes.controlflow;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.BlockNode.ElementExecutor;
import com.oracle.truffle.lama.nodes.LamaNode;

public class BlockNode extends LamaNode implements ElementExecutor<LamaNode> {
    @Child private com.oracle.truffle.api.nodes.BlockNode<LamaNode> block;

    public BlockNode(LamaNode[] bodyNodes) {
        this.block = bodyNodes.length > 0
                ? com.oracle.truffle.api.nodes.BlockNode.create(bodyNodes, this)
                : null;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        if (block == null) {
            return null;
        }
        return block.executeGeneric(virtualFrame, com.oracle.truffle.api.nodes.BlockNode.NO_ARGUMENT);
    }

    @Override
    public void executeVoid(VirtualFrame frame, LamaNode node, int index, int argument) {
        node.execute(frame);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame, LamaNode node, int index, int argument) {
        return node.execute(frame);
    }
}
