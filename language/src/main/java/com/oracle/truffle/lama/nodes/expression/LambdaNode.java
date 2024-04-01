package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.runtime.LamaFunction;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "callTarget", type = RootCallTarget.class)
@NodeField(name = "closure", type = LamaNode.class)
@GenerateNodeFactory
public abstract class LambdaNode extends LamaNode {
    @Specialization
    LamaFunction function(VirtualFrame frame, RootCallTarget callTarget, LamaNode closure) {
        try {
            return new LamaFunction(callTarget, closure == null ? null : closure.executeMaterializedFrame(frame));
        } catch (UnexpectedResultException e) {
            throw new UnsupportedSpecializationException(this,
                    new Node[]{closure}, e);
        }
    }
}
