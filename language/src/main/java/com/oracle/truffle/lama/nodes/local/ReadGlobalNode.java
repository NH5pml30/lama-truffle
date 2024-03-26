package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "slot", type = int.class)
@GenerateNodeFactory
public abstract class ReadGlobalNode extends LamaNode {
    public abstract int getSlot();

    @Specialization
    public Object read() {
        return LamaContext.get(this).getGlobalScope().getValue(this.getSlot());
    }
}
