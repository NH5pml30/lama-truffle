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

@NodeChild(value = "val", type = LamaNode.class)
@NodeField(name = "index", type = int.class)
@GenerateNodeFactory
public abstract class ReadSExpElementNode extends LamaNode {
    protected abstract int getIndex();

    public abstract Object executeWith(LamaSExp sExp);

    @Specialization
    public Object read(LamaSExp sExp) {
        return sExp.children()[getIndex()];
    }
}
