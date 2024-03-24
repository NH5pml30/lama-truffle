package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.strings.TruffleString;

public abstract class WriteNode extends BuiltinNode {
    @Specialization
    public Integer write(Integer value) {
        System.out.println(value);
        return value;
    }

    @Specialization
    public TruffleString write(TruffleString value) {
        System.out.println(value);
        return value;
    }
}
