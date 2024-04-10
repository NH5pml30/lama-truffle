package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.runtime.LamaFunction;

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

        Object[] argumentValues = new Object[this.argumentNodes.length + 1];
        argumentValues[0] = function.closure();
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i + 1] = argumentNodes[i].execute(virtualFrame);
        }

        return this.callNode.call(function.callTarget(), argumentValues);
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
