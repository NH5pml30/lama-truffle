package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.nodes.LamaRefFactory.RefNodeFactory;

public abstract class LamaRef {
    public abstract Object assign(VirtualFrame frame, Object val);
    // TODO: unify logic with reading
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

    @NodeField(name = "ref", type = LamaRef.class)
    @GenerateNodeFactory
    static abstract class RefNode extends LamaNode {
        @Specialization
        LamaRef get(LamaRef ref) {
            return ref;
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
}
