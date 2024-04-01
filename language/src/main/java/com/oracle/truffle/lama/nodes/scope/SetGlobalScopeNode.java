package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaNode;

@NodeField(name = "desc", type = FrameDescriptor.class)
@GenerateNodeFactory
public abstract class SetGlobalScopeNode extends LamaNode {
    @Specialization
    public Object set(FrameDescriptor desc) {
        LamaContext.get(this).setGlobalScope(Truffle.getRuntime().createMaterializedFrame(new Object[0], desc));
        return null;
    }
}
