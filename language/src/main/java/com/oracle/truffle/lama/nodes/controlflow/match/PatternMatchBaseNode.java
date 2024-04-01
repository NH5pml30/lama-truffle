package com.oracle.truffle.lama.nodes.controlflow.match;

import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@GenerateNodeFactory
public abstract class PatternMatchBaseNode extends LamaNode {
    protected final static Object[] NO_MATCH = new Object[0];
    @Child
    @Executed
    LamaNode value;

    protected PatternMatchBaseNode(LamaNode value) {
        this.value = value;
    }

    public abstract Object executeWith(VirtualFrame frame, Object valueValue);
}
