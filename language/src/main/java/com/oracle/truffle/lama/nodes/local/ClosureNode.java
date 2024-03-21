package com.oracle.truffle.lama.nodes.local;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.nodes.LamaNode;

import java.util.List;
import java.util.Map;

public class ClosureNode extends LamaNode {
    @NodeField(name = "slot", type = int.class)
    @NodeChild(value = "value", type = LamaNode.class)
    @GenerateNodeFactory
    protected static abstract class ClosureElementNode extends LamaNode {
        public abstract int getSlot();

        @Specialization
        Object eval(Object value) {
            return value;
        }
    }

    protected final FrameDescriptor desc;
    protected final @Children ClosureElementNode[] elements;

    public ClosureNode(FrameDescriptor desc, Map<Integer, LamaNode> elements) {
        this.desc = desc;
        this.elements = elements.entrySet().stream()
                .map(e -> ClosureNodeFactory.ClosureElementNodeFactory.create(e.getValue(), e.getKey()))
                .toArray(ClosureElementNode[]::new);
    }

    @Override
    @ExplodeLoop
    public MaterializedFrame execute(VirtualFrame frame) {
        var closureFrame = Truffle.getRuntime().createMaterializedFrame(new Object[0], desc);
        int numElements = elements.length;
        CompilerAsserts.compilationConstant(numElements);
        for (int i = 0; i < numElements; i++) {
            closureFrame.setObject(elements[i].getSlot(), elements[i].execute(frame));
        }
        return closureFrame;
    }
}
