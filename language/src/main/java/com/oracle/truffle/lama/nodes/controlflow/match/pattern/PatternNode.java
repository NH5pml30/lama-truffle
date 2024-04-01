package com.oracle.truffle.lama.nodes.controlflow.match.pattern;

import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaNode;

@GenerateNodeFactory
public abstract class PatternNode extends LamaNode {
    @Child @Executed LamaNode value;

    protected PatternNode(LamaNode value) {
        this.value = value;
    }

    public abstract int executeWith(VirtualFrame frame, Object value);
}
