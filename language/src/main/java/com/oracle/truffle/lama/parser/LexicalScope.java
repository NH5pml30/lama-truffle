package com.oracle.truffle.lama.parser;

import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.builtins.AssignNodeFactory;
import com.oracle.truffle.lama.nodes.expression.SetClosureNodeFactory;
import com.oracle.truffle.lama.nodes.scope.ReadGlobalNodeFactory;
import com.oracle.truffle.lama.nodes.scope.ReadLocalNodeFactory;
import com.oracle.truffle.lama.runtime.LamaRef;
import org.graalvm.collections.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
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
    protected GenInterfaces<Void, GenInterface<Void, LamaNode>> inits;

    public boolean isGlobal() {
        return outer == null || outer.isGlobal();
    }

    public LexicalScope(LexicalScope outer) {
        this(outer, GenInterfaces.of());
    }

    public LexicalScope(LexicalScope outer, GenInterfaces<Void, GenInterface<Void, LamaNode>> inits) {
        this.outer = outer;
        this.operatorInfo = getOperatorInfo(outer).clone();
        this.inits = inits;
    }

    public void pullLocalValues(LexicalScope from) {
        inits = from.inits;
        from.inits = GenInterfaces.of();
    }

    public interface RefGen extends ExprGen {
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

    protected static abstract class FindResult {
        protected final LexicalScope source;
        final String name;

        FindResult(LexicalScope source, String name) {
            this.source = source;
            this.name = name;
        }

        abstract ExprGen get();

        FindResult propagate(Closure through) {
            System.err.format("Propagate '%s'\n", name);
            return this;
        }
    }

    record Fun(Closure closure, ExprGen lambda) {
        ExprGen instantiate() {
            return a -> {
                var lambdaNode = lambda.generate(ValueCategory.Val);
                System.err.format("instantiate closure '%s' + lambda node '%s'\nClosure:\n", closure.toString(), lambdaNode.toString());
                closure.print();
                return closure.getNode()
                        .map(node -> (LamaNode) SetClosureNodeFactory.create(lambdaNode, node))
                        .orElse(lambdaNode);
            };
        }
    }

    protected static class FunFindResult extends FindResult {
        private final Closure closure;
        private final FindResult lambda;

        FunFindResult(LexicalScope source, String name, Closure closure, FindResult lambda) {
            super(source, name);
            this.closure = closure;
            this.lambda = lambda;
        }

        @Override
        ExprGen get() {
            return new Fun(closure, lambda.get()).instantiate();
        }

        @Override
        FindResult propagate(Closure through) {
            System.err.format("Propagate fun '%s'\n", name);
            var l = lambda.propagate(through);
            return new FunFindResult(source, name, through.propagate(closure), l);
        }
    }

    protected static class RefFindResult extends FindResult {
        private final ExprGen result;

        RefFindResult(LexicalScope source, String name, ExprGen result) {
            super(source, name);
            this.result = result;
        }

        @Override
        ExprGen get() {
            return result;
        }

        @Override
        FindResult propagate(Closure through) {
            System.err.format("Propagate ref '%s'\n", name);
            if (source.isGlobal()) {
                System.err.println("Nvm, it's global");
                return this;
            }
            return new RefFindResult(source, name, through.propagate(new Closure.Capture<>(result, source, name)));
        }
    }

    protected RefGen getLocal(int slot) {
        if (isGlobal()) {
            return refGen(ReadGlobalNodeFactory.create(slot), LamaRef.global(slot));
        }
        return refGen(ReadLocalNodeFactory.create(slot), LamaRef.local(slot));
    }

    protected void assignLocalValue(int slot, GenInterface<Void, GenInterface<Void, LamaNode>> value) {
        inits = GenInterfaces.add(inits, v -> {
            var namesResolved = value.generate(null);
            if (namesResolved == null) {
                return null; // propagate `skip`
            }
            return vv -> {
                var valueNode = namesResolved.generate(null);
                return AssignNodeFactory.create(
                        new LamaNode[]{getLocal(slot).generate(ValueCategory.Ref), valueNode}
                );
            };
        });
    }

    public boolean addLocalValue(String name, GenInterface<Void, GenInterface<Void, LamaNode>> value) {
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

    public RefGen getOrAddLocal(String name) {
        return getLocal(Optional.ofNullable(locals.get(name))
                .orElseGet(() -> addLocal(name)));
    }

    public RefGen addFun(String name, Closure closure, GenInterface<Void, GenInterface<Void, LamaNode>> value) {
        var slot = addLocalSlot(name);
        funs.put(name, Pair.create(closure, slot));
        assignLocalValue(slot, value);
        return getLocal(slot);
    }

    protected int addLocalSlot(String name) {
        return outer.addLocalSlot(name);
    }

    protected Optional<FindResult> findHereRef(LexicalScope maybeFrom, String name) {
        // Try locals
        return Optional.ofNullable(locals.get(name)).map(slot -> new RefFindResult(this, name, getLocal(slot)));
    }

    protected Optional<FindResult> findHere(LexicalScope maybeFrom, String name) {
        // Try funs
        // TODO: copy-paste
        // TODO: use maybeFrom to add dependent LexicalScope/Closures edges
        return Optional.ofNullable(funs.get(name)).map(
                fun -> new FunFindResult(this, name, fun.getLeft(), new RefFindResult(this, name, getLocal(fun.getRight())))
        );
    }

    protected Optional<FindResult>
    findUp(String name, Supplier<Optional<FindResult>> outerFind) {
        // Search up
        if (outer == null) {
            return Optional.empty();
        }
        return outerFind.get();
    }

    protected Optional<FindResult> findImpl(LexicalScope maybeFrom, String name) {
        return findHere(maybeFrom, name)
                .or(() -> findHereRef(maybeFrom, name))
                .or(() -> findUp(name, () -> outer.findImpl(this, name)));
    }

    public Optional<FindResult> find(String name) {
        return findImpl(null, name);
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

    <T> T getBlock(Function<GenInterfaces<Void, GenInterface<Void, LamaNode>>, T> get) {
        return get.apply(inits);
    }
}
