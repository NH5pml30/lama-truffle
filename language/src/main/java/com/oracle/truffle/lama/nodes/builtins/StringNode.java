package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.lama.runtime.LamaSExp;

public abstract class StringNode extends BuiltinNode {
    abstract char[] executeWith(Object x);

    @Specialization
    @TruffleBoundary
    char[] toString(int x) {
        return Integer.toString(x).toCharArray();
    }

    @Specialization
    @TruffleBoundary
    char[] toString(char[] x) {
        var builder = new StringBuilder("\"");
        for (var c : x) {
            if (c == '"') {
                builder.append("\"\"");
            } else {
                builder.append(c);
            }
        }
        builder.append('"');
        return builder.toString().toCharArray();
    }

    @Specialization
    @TruffleBoundary
    char[] toString(Object[] x) {
        var builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < x.length; i++) {
            builder.append(executeWith(x[i]));
            if (i + 1 != x.length) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString().toCharArray();
    }

    @Specialization
    @TruffleBoundary
    char[] toString(LamaSExp x) {
        var builder = new StringBuilder();
        builder.append(SExpNode.fromHashCode(x.hash()));
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
        return builder.toString().toCharArray();
    }
}
