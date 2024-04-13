package com.oracle.truffle.lama.nodes.builtins;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.strings.TruffleStringBuilder;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.runtime.LamaSExp;

public class SExpNode extends LamaNode {
    final protected int hash;
    final protected @Children LamaNode[] vals;

    private final static String CHARS = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'";
    private final static int HASH_MAX_CHARS = 5;
    private final static int HASH_BITS_PER_CHAR = 6;
    public static int hashCode(CharSequence cs) {
        int h = 0;
        for (int i = 0; i < cs.length() && i < HASH_MAX_CHARS; i++) {
            h = (h << HASH_BITS_PER_CHAR) | CHARS.indexOf(cs.charAt(i));
        }
        return h;
    }

    public static char[] fromHashCode(int hashCode) {
        var numChars = (Integer.SIZE - Integer.numberOfLeadingZeros(hashCode) + HASH_BITS_PER_CHAR - 1) / HASH_BITS_PER_CHAR;
        char[] res = new char[numChars];
        for (int i = numChars - 1; i >= 0 && hashCode != 0; i--, hashCode >>= 6) {
            res[i] = CHARS.charAt(hashCode & 0x003F);
        }
        return res;
    }

    public SExpNode(String name, LamaNode[] vals) {
        this.hash = hashCode(name);
        this.vals = vals;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        return executeLamaSExp(virtualFrame);
    }

    @Override
    @ExplodeLoop
    public LamaSExp executeLamaSExp(VirtualFrame virtualFrame) {
        CompilerAsserts.compilationConstant(vals.length);

        Object[] valsValues = new Object[vals.length];
        for (int i = 0; i < vals.length; i++) {
            valsValues[i] = vals[i].execute(virtualFrame);
        }

        return new LamaSExp(hash, valsValues);
    }
}
