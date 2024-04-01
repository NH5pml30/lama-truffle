package com.oracle.truffle.lama.nodes.controlflow.match;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ControlFlowException;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.controlflow.match.pattern.PatternNode;

public abstract class PatternMatchNode extends PatternMatchBaseNode {
    @Child @Executed(with = "value") PatternMatchBaseNode prevMatch;
    @Child PatternNode pattern;
    @Child LamaNode returns;

    public final class ReturnException extends ControlFlowException {
        public final Object returnValue;

        public ReturnException(Object returnValue) {
            this.returnValue = returnValue;
        }
    }

    protected PatternMatchNode(LamaNode value, PatternMatchBaseNode prevMatch, PatternNode pattern, LamaNode returns) {
        super(value);
        this.prevMatch = prevMatch;
        this.pattern = pattern;
        this.returns = returns;
    }

    @Specialization(guards = "prevMatch == NO_MATCH")
    public Object match(VirtualFrame frame, Object valueValue, Object[] prevMatch) {
        if (pattern.executeWith(frame, valueValue) == 0) {
            return NO_MATCH;
        }
        return returns.execute(frame);
    }

    @Fallback
    public Object matchPrev(Object valueValue, Object prevMatch) {
        return prevMatch;
    }
}
