package com.oracle.truffle.lama.nodes.controlflow.match;

import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.pattern.PatternNode;

import java.util.function.Function;

public interface PatGen extends Function<LamaNode, PatternNode> {}
