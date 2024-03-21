package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class InvokeNode extends LamaNode {
    @Child protected LamaNode functionNode;
    @Children protected LamaNode[] argumentNodes;
    @Child protected IndirectCallNode callNode;

    public InvokeNode(LamaNode function, LamaNode[] argumentNodes) {
        this.functionNode = function;
        this.argumentNodes = argumentNodes;
        callNode = Truffle.getRuntime().createIndirectCallNode();
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame virtualFrame) {
        LamaFunction function = this.evaluateFunction(virtualFrame);
        CompilerAsserts.compilationConstant(this.argumentNodes.length);

        Object[] argumentValues;
        int i = 0;
        if (function.closure != null) {
            argumentValues = new Object[this.argumentNodes.length + 1];
            argumentValues[i++] = function.closure;
        } else {
            argumentValues = new Object[this.argumentNodes.length];
        }
        for (int j = 0; j < argumentNodes.length; j++) {
            argumentValues[i++] = argumentNodes[j].execute(virtualFrame);
        }

        return this.callNode.call(function.callTarget, argumentValues);
    }

    private LamaFunction evaluateFunction(VirtualFrame virtualFrame) {
        try {
            return this.functionNode.executeLamaFunction(virtualFrame);
        } catch (UnexpectedResultException e) {
            throw new UnsupportedSpecializationException(this,
                    new Node[] {this.functionNode}, e);
        }
    }
}
