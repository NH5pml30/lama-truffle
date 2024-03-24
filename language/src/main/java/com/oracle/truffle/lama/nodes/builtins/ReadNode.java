package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.LamaContext;

import java.util.Scanner;

public abstract class ReadNode extends BuiltinNode {
    @Specialization
    public Integer read() {
        var context = LamaContext.get(this);
        context.getOutput().print("> ");
        return context.getInScanner().nextInt();
    }
}
