package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.RootNode;

public class LamaRootNode extends RootNode {
    @Child private LamaNode bodyNode;

    public LamaRootNode(TruffleLanguage<?> language, FrameDescriptor frameDescriptor, LamaNode bodyNode) {
        super(language, frameDescriptor);
        this.bodyNode = bodyNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return bodyNode.execute(frame);
    }
}
