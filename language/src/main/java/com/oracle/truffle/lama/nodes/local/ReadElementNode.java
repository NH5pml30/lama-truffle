package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeChild(value = "arr", type = LamaNode.class)
@NodeChild(value = "index", type = LamaNode.class)
@GenerateNodeFactory
public abstract class ReadElementNode extends LamaNode {
    @Specialization
    public int read(char[] str, int index) {
        return str[index];
    }
}
