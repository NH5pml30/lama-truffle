package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.strings.TruffleString;

@NodeInfo(shortName = "print")
public abstract class PrintNode extends BuiltinNode {
    @Specialization
    public Integer print(Integer value) {
        System.out.println(value);
        return value;
    }

    @Specialization
    public TruffleString print(TruffleString value) {
        System.out.println(value);
        return value;
    }
}
