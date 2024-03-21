package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.MaterializedFrame;

public class LamaFunction {
    public final RootCallTarget callTarget;
    public final MaterializedFrame closure;

    public LamaFunction(RootCallTarget callTarget, MaterializedFrame closure) {
        this.callTarget = callTarget;
        this.closure = closure;
    }
}
