package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.LamaContext;

public abstract class WriteNode extends BuiltinNode {
    @TruffleBoundary
    @Specialization
    public int write(int value) {
        LamaContext.get(this).getOutput().println(value);
        return value;
    }
}
