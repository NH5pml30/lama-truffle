package com.oracle.truffle.lama.nodes.expression;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.runtime.LamaFunction;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeChild(value = "lambda", type = LamaNode.class)
@NodeChild(value = "closure", type = LamaNode.class)
@GenerateNodeFactory
public abstract class SetClosureNode extends LamaNode {
    @Specialization
    LamaFunction set(LamaFunction lambda, MaterializedFrame closure) {
        return new LamaFunction(lambda.callTarget(), closure);
    }
}
