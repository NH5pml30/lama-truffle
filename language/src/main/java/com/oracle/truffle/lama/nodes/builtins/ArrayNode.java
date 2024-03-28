package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.nodes.LamaNode;

public class ArrayNode extends LamaNode {
    final protected @Children LamaNode[] vals;

    public ArrayNode(LamaNode[] vals) {
        this.vals = vals;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        CompilerAsserts.compilationConstant(vals.length);

        Object[] valsValues = new Object[vals.length];
        for (int i = 0; i < vals.length; i++) {
            valsValues[i] = vals[i].execute(virtualFrame);
        }

        return valsValues;
    }
}
