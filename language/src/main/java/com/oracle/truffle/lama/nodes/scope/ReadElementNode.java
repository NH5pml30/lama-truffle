package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.runtime.LamaSExp;

@NodeChild(value = "arr", type = LamaNode.class)
@NodeChild(value = "index", type = LamaNode.class)
@GenerateNodeFactory
public abstract class ReadElementNode extends LamaNode {
    public abstract Object executeWith(VirtualFrame frame, Object arr);

    @Specialization
    public int read(StringBuilder str, int index) {
        return str.charAt(index);
    }

    @Specialization
    public Object read(Object[] arr, int index) {
        return arr[index];
    }

    @Specialization
    public Object read(LamaSExp s, int index) {
        return s.children()[index];
    }
}
