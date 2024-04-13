package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.runtime.LamaFunction;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "callTarget", type = RootCallTarget.class)
@NodeField(name = "name", type = String.class)
@GenerateNodeFactory
public abstract class LambdaNode extends LamaNode {
    @Specialization
    LamaFunction function(RootCallTarget callTarget, String name) {
        return new LamaFunction(callTarget, null, name);
    }
}
