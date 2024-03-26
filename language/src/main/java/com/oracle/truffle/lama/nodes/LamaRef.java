package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.LamaContext;
import com.oracle.truffle.lama.nodes.LamaRefFactory.RefNodeFactory;
import com.oracle.truffle.lama.nodes.LamaRefFactory.GlobalRefNodeFactory;
import com.oracle.truffle.lama.nodes.LamaRefFactory.StringElementRefNodeFactory;

public abstract class LamaRef {
    public abstract Object assign(VirtualFrame frame, Object val);

    // TODO: unify logic with reading
    static class GlobalRef extends LamaRef {
        public final LamaContext ctx;
        public final int slot;

        GlobalRef(LamaContext ctx, int slot) {
            this.ctx = ctx;
            this.slot = slot;
        }

        @Override
        public Object assign(VirtualFrame frame, Object val) {
            ctx.getGlobalScope().setObject(slot, val);
            return val;
        }
    }

    static class LocalRef extends LamaRef {
        public final int slot;

        LocalRef(int slot) {
            this.slot = slot;
        }

        @Override
        public Object assign(VirtualFrame frame, Object val) {
            frame.setObject(slot, val);
            return val;
        }
    }

    static class ArgRef extends LamaRef {
        public final int index;

        ArgRef(int index) {
            this.index = index;
        }

        @Override
        public Object assign(VirtualFrame frame, Object val) {
            frame.getArguments()[1 + index] = val;
            return val;
        }
    }

    static class ClosureRef extends LamaRef {
        public final int slot;

        ClosureRef(int slot) {
            this.slot = slot;
        }

        @Override
        public Object assign(VirtualFrame frame, Object val) {
            var closure = (MaterializedFrame) frame.getArguments()[0];
            closure.setObject(slot, val);
            return val;
        }
    }

    static class StringElementRef extends LamaRef {
        public final char[] value;
        public final int index;

        StringElementRef(char[] value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public Object assign(VirtualFrame frame, Object val) {
            int castValue = (int) val;
            value[index] = (char) castValue;
            return castValue;
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

    @NodeField(name = "slot", type = int.class)
    @GenerateNodeFactory
    static abstract class GlobalRefNode extends LamaNode {
        @Specialization
        LamaRef get(int slot) {
            return new GlobalRef(LamaContext.get(this), slot);
        }
    }

    @NodeChild(value = "value", type = LamaNode.class)
    @NodeChild(value = "index", type = LamaNode.class)
    @GenerateNodeFactory
    static abstract class StringElementRefNode extends LamaNode {
        @Specialization
        LamaRef get(char[] value, int index) {
            return new StringElementRef(value, index);
        }
    }

    public static LamaNode local(int slot) {
        return RefNodeFactory.create(new LocalRef(slot));
    }

    public static LamaNode arg(int index) {
        return RefNodeFactory.create(new ArgRef(index));
    }

    public static LamaNode closure(int slot) {
        return RefNodeFactory.create(new ClosureRef(slot));
    }

    public static LamaNode global(int slot) {
        return GlobalRefNodeFactory.create(slot);
    }

    public static LamaNode stringElement(LamaNode value, LamaNode index) {
        return StringElementRefNodeFactory.create(value, index);
    }
}
