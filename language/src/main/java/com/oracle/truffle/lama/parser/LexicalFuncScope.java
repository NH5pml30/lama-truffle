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
    protected final Closure closure = new Closure();
    private final String funName;

    @Override
    protected LexicalFuncScope getFuncScope() {
        return this;
    }

    @Override
    public boolean isGlobal() {
        return outer == null;
    }

    public LexicalFuncScope(LexicalScope outer, String funName) {
        super(outer);
        this.funName = funName;
    }

    public RefGen getArg(int index) {
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
                    System.err.format("findUp propagate something through function '%s' closure\n", funName);
                    r.propagate(this, isBinding);
                    return r;
                });
    }

    @Override
    public Optional<FindResult> find(Capture<?> capture) {
        return closure.find(capture).map(r -> (FindResult) new RefFindResult(r.source(), r.name(), r.value()))
                .or(() -> super.find(capture));
    }

    @Override
    public int addLocalSlot(String name) {
        System.err.format("Add local slot for '%s' in localBuilder'%s'\n", name, localBuilder.toString());
        return localBuilder.addSlot(FrameSlotKind.Illegal, name, null);
    }

    public void addArgument(String name, int index) {
        args.put(name, index);
    }

    public <T> T getFun(BiFunction<Closure, FrameDescriptor, T> get) {
        System.err.format("Finish up localBuilder '%s'\n", localBuilder.toString());
        return get.apply(closure, localBuilder.build());
    }
}
