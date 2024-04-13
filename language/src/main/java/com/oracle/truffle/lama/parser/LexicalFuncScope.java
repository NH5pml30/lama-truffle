package com.oracle.truffle.lama.parser;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.nodes.scope.ReadArgumentNodeFactory;
import com.oracle.truffle.lama.runtime.LamaRef;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// Function scope => block scope & arguments & closure
class LexicalFuncScope extends LexicalScope {
    protected final Map<String, Integer> args = new HashMap<>();
    protected final FrameDescriptor.Builder localBuilder = FrameDescriptor.newBuilder();
    protected final Closure closure;
    final String funName; // for debugging

    @Override
    protected LexicalFuncScope getFuncScope() {
        return this;
    }

    @Override
    boolean isGlobal() {
        return outer == null;
    }

    LexicalFuncScope(LexicalScope outer, String funName) {
        super(outer);
        this.funName = funName;
        this.closure = new Closure(funName);
    }

    RefGen getArg(int index) {
        return refGen(ReadArgumentNodeFactory.create(index), LamaRef.arg(index));
    }

    @Override
    protected Optional<FindResult> findHereRef(String name) {
        // Try block
        return super.findHereRef(name)
                // Try args
                .or(() -> Optional.ofNullable(args.get(name))
                        .map(index -> new RefFindResult(this, name, getArg(index))))
                // Try closure
                .or(() -> closure.find(name).map(r -> new RefFindResult(this, name, r)));
    }

    @Override
    protected Optional<FindResult>
    findUp(Supplier<Optional<FindResult>> outerFind, boolean isBinding) {
        // Propagate values through this closure
        return super.findUp(outerFind, isBinding)
                .map(r -> {
                    r.propagate(this, isBinding);
                    return r;
                });
    }

    @Override
    Optional<FindResult> find(Capture<?> capture) {
        return closure.find(capture).map(r -> (FindResult) new RefFindResult(r.source(), r.name(), r.value()))
                .or(() -> super.find(capture));
    }

    @Override
    protected int addLocalSlot(String name) {
        return localBuilder.addSlot(FrameSlotKind.Illegal, name, null);
    }

    void addArgument(String name, int index) {
        args.put(name, index);
    }

    <T> T getFun(BiFunction<Closure, FrameDescriptor, T> get) {
        return get.apply(closure, localBuilder.build());
    }
}
