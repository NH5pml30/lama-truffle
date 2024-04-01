package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaSExp;

public abstract class ConsNode extends BuiltinNode {
    public final static String NAME = "cons";
    private final static int HASH = SExpNode.hashCode(NAME);

    @Specialization
    public Object cons(Object head, Object tail) {
        return new LamaSExp(HASH, new Object[]{head, tail});
    }
}
