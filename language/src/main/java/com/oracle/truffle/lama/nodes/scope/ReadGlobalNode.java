package com.oracle.truffle.lama.nodes.scope;

import com.oracle.truffle.api.dsl.Executed;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaNode;

@GenerateNodeFactory
abstract class GetGlobalScopeNode extends LamaNode {
    @Specialization
    VirtualFrame get() {
        return LamaContext.get(this).getGlobalScope();
    }
}

@GenerateNodeFactory
public abstract class ReadGlobalNode extends LamaNode {
    @Child @Executed GetGlobalScopeNode scopeNode;
    @Child @Executed(with = "scopeNode") ReadSlotNode reader;

    ReadGlobalNode(int slot) {
        scopeNode = GetGlobalScopeNodeFactory.create();
        reader = ReadSlotNodeFactory.create(scopeNode, slot);
    }

    @Specialization
    public Object read(VirtualFrame scope, Object readValue) {
        return readValue;
    }
}
