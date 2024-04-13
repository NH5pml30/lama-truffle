package com.oracle.truffle.lama.parser;

import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.builtins.*;
import com.oracle.truffle.lama.nodes.expression.*;
import com.oracle.truffle.lama.nodes.scope.ReadGlobalNodeFactory;
import com.oracle.truffle.lama.nodes.scope.ReadLocalNodeFactory;
import com.oracle.truffle.lama.runtime.LamaRef;
import org.graalvm.collections.Pair;
import org.graalvm.polyglot.Value;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.oracle.truffle.lama.parser.LamaOperators.getOperatorInfo;

// Resolve identifiers during parsing with lexical scoping
// Block scope => new local variables & their initialization
class LexicalScope {
    protected final LexicalScope outer;
    protected final Map<String, Integer> locals = new HashMap<>();
    protected final Map<String, Pair<Closure, Integer>> funs = new HashMap<>();
    public final LamaOperators.OperatorInfo operatorInfo;
    protected ScopedValsGen inits = ScopedsGen.of()::generate;

    protected LexicalFuncScope getFuncScope() {
        return outer.getFuncScope();
    }

    boolean isGlobal() {
        return getFuncScope().isGlobal();
    }

    LexicalScope(LexicalScope outer) {
        this.outer = outer;
        this.operatorInfo = getOperatorInfo(outer).clone();
    }

    void pullLocalValues(LexicalScope from) {
        inits = from.inits;
        from.inits = ScopedsGen.of()::generate;
    }

    interface RefGen extends ExprGen {
        LamaNode generateVal();
        LamaRef generateRef();

        @Override
        default LamaNode generate(ValueCategory a) {
            if (a == ValueCategory.Val) {
                return generateVal();
            } else {
                return LamaRef.refNode(generateRef());
            }
        }
    }

    protected static RefGen refGen(LamaNode val, LamaRef ref) {
        return new RefGen() {
            @Override
            public LamaNode generateVal() {
                return val;
            }

            @Override
            public LamaRef generateRef() {
                return ref;
            }
        };
    }

    static abstract class FindResult {
        protected final LexicalScope source;
        final String name;

        FindResult(LexicalScope source, String name) {
            this.source = source;
            this.name = name;
        }

        abstract ExprGen get();

        abstract void propagate(LexicalFuncScope through, boolean isBinding);
    }

    record Fun(Closure.Instantiation closure, ExprGen lambda) {
        ExprGen instantiate() {
            return a -> {
                var lambdaNode = lambda.generate(ValueCategory.Val);
                return closure.getNode()
                        .map(node -> (LamaNode) SetClosureNodeFactory.create(lambdaNode, node))
                        .orElse(lambdaNode);
            };
        }
    }

    static class FunFindResult extends FindResult {
        private final Closure.Instantiation closure;
        private final FindResult lambda;

        FunFindResult(LexicalScope source, String name, Closure.Instantiation closure, FindResult lambda) {
            super(source, name);
            this.closure = closure;
            this.lambda = lambda;
        }

        @Override
        ExprGen get() {
            return new Fun(closure, lambda.get()).instantiate();
        }

        @Override
        void propagate(LexicalFuncScope through, boolean isBinding) {
            // don't save lambda, properly search for the function every time and instantiate the closure
            lambda.propagate(through, false);
            closure.propagate(through);
        }
    }

    static class RefFindResult extends FindResult {
        private ExprGen result;

        RefFindResult(LexicalScope source, String name, ExprGen result) {
            super(source, name);
            this.result = result;
        }

        @Override
        ExprGen get() {
            return result;
        }

        @Override
        void propagate(LexicalFuncScope through, boolean isBinding) {
            if (source.isGlobal()) {
                return;
            }
            result = through.closure.propagate(
                    new Capture<>(
                            result.generate(ValueCategory.Val), // not a closure instantiation, safe to generate here
                            source, name
                    ),
                    isBinding
            );
        }
    }

    protected RefGen getLocal(int slot) {
        if (isGlobal()) {
            return refGen(ReadGlobalNodeFactory.create(slot), LamaRef.global(slot));
        }
        return refGen(ReadLocalNodeFactory.create(slot), LamaRef.local(slot));
    }

    protected void assignLocalValue(int slot, ScopedValGen value) {
        inits = ScopedsGen.add(inits, GenInterface.map(
                value,
                v -> GenInterface.map(v, vn -> vn == null
                                ? null // propagate `skip`
                                : (LamaNode) AssignNodeFactory.create(
                                new LamaNode[]{getLocal(slot).generate(ValueCategory.Ref), vn}
                        )
                )
        ))::generate;
    }

    boolean addLocalValue(String name, ScopedValGen value) {
        if (locals.containsKey(name)) {
            return false;
        }
        var slot = addLocal(name);
        assignLocalValue(slot, value);
        return true;
    }

    protected Integer addLocal(String name) {
        int slot = addLocalSlot(name);
        locals.put(name, slot);
        return slot;
    }

    RefGen getOrAddLocal(String name) {
        return getLocal(Optional.ofNullable(locals.get(name))
                .orElseGet(() -> addLocal(name)));
    }

    void addFun(String name, Closure closure, ScopedValGen value) {
        var slot = addLocalSlot(name);
        funs.put(name, Pair.create(closure, slot));
        assignLocalValue(slot, value);
    }

    protected int addLocalSlot(String name) {
        return outer.addLocalSlot(name);
    }

    protected Optional<FindResult> findHereRef(String name) {
        // Try locals
        return Optional.ofNullable(locals.get(name)).map(slot -> new RefFindResult(this, name, getLocal(slot)));
    }

    protected Optional<FindResult> findHere(String name) {
        // Try funs
        return Optional.ofNullable(funs.get(name)).map(
                fun -> new FunFindResult(
                        this, name,
                        fun.getLeft().instantiate(this),
                        new RefFindResult(this, name, getLocal(fun.getRight()))
                )
        );
    }

    protected Optional<FindResult> findHereCapture(String name) {
        // Try funs
        return Optional.ofNullable(funs.get(name)).map(
                fun -> new RefFindResult(this, name, getLocal(fun.getRight()))
        );
    }

    protected Optional<FindResult>
    findUp(Supplier<Optional<FindResult>> outerFind, boolean isBinding) {
        // Search up
        if (outer == null) {
            return Optional.empty();
        }
        return outerFind.get();
    }

    // General find, return variable reference potentially with closure instantiation
    Optional<FindResult> find(String name) {
        return findHere(name)
                .or(() -> findHereRef(name))
                .or(() -> findUp(() -> outer.find(name), true));
    }

    // Find for closure, return only RefFindResult without closure instantiations
    Optional<FindResult> find(Capture<?> capture) {
        if (capture.source() == this) {
            return findHereCapture(capture.name())
                    .or(() -> findHereRef(capture.name()));
        }
        return findUp(() -> outer.find(capture), false);
    }

    void addOp(String name, LamaOperators.OpType infixity, Pair<Integer, LamaOperators.OpType> relInfo, int rel) {
        int relLevel = relInfo.getLeft();
        if (rel == 0) {
            // ignore infixity
            operatorInfo.addInfo(relLevel, name);
        } else {
            operatorInfo.addLevel(relLevel + Integer.max(rel, 0), infixity, name);
        }
    }

    <T> T getBlock(Function<ScopedValsGen, T> get) {
        return get.apply(inits);
    }
}
