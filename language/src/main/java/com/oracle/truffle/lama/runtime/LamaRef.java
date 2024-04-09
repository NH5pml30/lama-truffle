package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.runtime.LamaRefFactory.*;

public abstract class LamaRef {
    public abstract Object assign(LamaContext ctx, VirtualFrame frame, Object val);

    // TODO: unify logic with reading
    static class GlobalRef extends LamaRef {
        public final int slot;

        public GlobalRef(int slot) {
            this.slot = slot;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            // System.err.format("Set global '%d' to '%s'\n", slot, val.toString());
            ctx.getGlobalScope().setObject(slot, val);
            return val;
        }
    }

    static class LocalRef extends LamaRef {
        public final int slot;

        public LocalRef(int slot) {
            this.slot = slot;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            frame.setObject(slot, val);
            return val;
        }
    }

    static class ArgRef extends LamaRef {
        public final int index;

        public ArgRef(int index) {
            this.index = index;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            frame.getArguments()[1 + index] = val;
            return val;
        }
    }

    static class ClosureRef extends LamaRef {
        public final int slot;

        public ClosureRef(int slot) {
            this.slot = slot;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            var closure = (MaterializedFrame) frame.getArguments()[0];
            closure.setObject(slot, val);
            return val;
        }
    }

    static class StringElementRef extends LamaRef {
        public final StringBuilder value;
        public final int index;

        public StringElementRef(StringBuilder value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            int castValue = (int) val;
            value.setCharAt(index, (char) castValue);
            return castValue;
        }
    }

    static class ArrayElementRef extends LamaRef {
        public final Object[] value;
        public final int index;

        public ArrayElementRef(Object[] value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public Object assign(LamaContext ctx, VirtualFrame frame, Object val) {
            return value[index] = val;
        }
    }

    @NodeField(name = "ref", type = LamaRef.class)
    @GenerateNodeFactory
    static abstract class RefNode extends LamaNode {
        @Specialization
        LamaRef get(LamaRef ref) {
            return ref;
        }
    }

    @NodeChild(value = "value", type = LamaNode.class)
    @NodeChild(value = "index", type = LamaNode.class)
    @GenerateNodeFactory
    static abstract class ElementRefNode extends LamaNode {
        @Specialization
        LamaRef get(StringBuilder value, int index) {
            return new StringElementRef(value, index);
        }

        @Specialization
        LamaRef get(Object[] value, int index) {
            return new ArrayElementRef(value, index);
        }
    }

    public static LamaRef local(int slot) {
        return new LocalRef(slot);
    }

    public static LamaRef arg(int index) {
        return new ArgRef(index);
    }

    public static LamaRef closure(int slot) {
        return new ClosureRef(slot);
    }

    public static LamaRef global(int slot) {
        return new GlobalRef(slot);
    }

    public static LamaNode refNode(LamaRef ref) {
        return RefNodeFactory.create(ref);
    }

    public static LamaNode element(LamaNode value, LamaNode index) {
        return ElementRefNodeFactory.create(value, index);
    }
}
