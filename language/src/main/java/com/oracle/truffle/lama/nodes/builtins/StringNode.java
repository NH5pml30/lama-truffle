package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaSExp;

public abstract class StringNode extends BuiltinNode {
    abstract StringBuilder executeWith(Object x);

    @Specialization
    StringBuilder toString(int x) {
        return new StringBuilder().append(x);
    }

    @Specialization
    StringBuilder toString(StringBuilder x) {
        var res = new StringBuilder("\"").append(x);
        int fromIndex = 1;
        while (true) {
            int idx = res.indexOf("\"", fromIndex);
            if (idx == -1) {
                break;
            }
            res.replace(idx, idx + 1, "\"\"");
            fromIndex = idx + 2;
        }
        return res.append("\"");
    }

    @Specialization
    StringBuilder toString(Object[] x) {
        var builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < x.length; i++) {
            builder.append(executeWith(x[i]));
            if (i + 1 != x.length) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder;
    }

    @Specialization
    StringBuilder toString(LamaSExp x) {
        var builder = new StringBuilder(SExpNode.fromHashCode(x.hash()));
        var children = x.children();
        if (children.length > 0) {
            builder.append(" (");
            for (int i = 0; i < children.length; i++) {
                builder.append(executeWith(children[i]));
                if (i + 1 != children.length) {
                    builder.append(", ");
                }
            }
            builder.append(')');
        }
        return builder;
    }
}
