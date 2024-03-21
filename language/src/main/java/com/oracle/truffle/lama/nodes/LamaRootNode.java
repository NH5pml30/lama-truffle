package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

public class LamaRootNode extends RootNode {
    @Children private final LamaNode[] bodyNodes;

    public LamaRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, LamaNode[] bodyNodes) {
        super(language, frameDescriptor);
        this.bodyNodes = bodyNodes;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame frame) {
        int last = bodyNodes.length - 1;
        CompilerAsserts.compilationConstant(last);
        for (int i = 0; i < last; i++) {
            bodyNodes[i].execute(frame);
        }
        return bodyNodes[last].execute(frame);
    }
}
