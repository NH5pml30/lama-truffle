package com.oracle.truffle.lama.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.MaterializedFrame;

public record LamaFunction(RootCallTarget callTarget, MaterializedFrame closure, String name) {
}
