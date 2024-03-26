/*
 * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oracle.truffle.lama.parser;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.*;
import com.oracle.truffle.lama.nodes.builtins.*;
import com.oracle.truffle.lama.nodes.controlflow.*;
import com.oracle.truffle.lama.nodes.local.*;
import com.oracle.truffle.lama.nodes.expression.*;
import org.antlr.v4.runtime.Token;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.source.Source;
import org.graalvm.collections.Pair;

public class LamaNodeFactory {
    private final LamaLanguage language;
    private final Source source;

    LamaParseError newSemErr(Token token, String message) {
        assert token != null;
        return newParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
    }

    static LamaParseError newParseError(Source source, int line, int charPositionInLine, Token token, String message) {
        int col = charPositionInLine + 1;
        String location = "-- line " + line + " col " + col + ": ";
        int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
        String msg = token == null
                ? String.format("Error(s) parsing script:\n%s%s", location, message)
                : String.format("Error(s) parsing script:\n%s%s: '%s'", location, message, token.getText());
        return new LamaParseError(source, line, col, length, msg);
    }

    enum OpType {
        InfixLeft, InfixRight, InfixNone
    }

    private record OpInfo<T extends LamaNode>(NodeFactory<? extends T> factory) {
    }

    private static <T extends LamaNode> OpInfo<T> opInfo(NodeFactory<? extends T> factory) {
        return new OpInfo<T>(factory);
    }

    // All of the builtin binary operators
    private static final List<Pair<OpType, Map<String, OpInfo<BuiltinNode>>>> BUILTIN_OPERATOR_INFO = Arrays.asList(
            Pair.create(
                    OpType.InfixRight,
                    Map.of(":=", opInfo(AssignNodeFactory.getInstance()))
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of("!!", opInfo(OrNodeFactory.getInstance()))
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of("&&", opInfo(AndNodeFactory.getInstance()))
            ),
            Pair.create(
                    OpType.InfixNone,
                    Map.of(
                            "==", opInfo(EqNodeFactory.getInstance()),
                            "!=", opInfo(NeqNodeFactory.getInstance()),
                            "<=", opInfo(LeqNodeFactory.getInstance()),
                            "<", opInfo(LtNodeFactory.getInstance()),
                            ">=", opInfo(GeqNodeFactory.getInstance()),
                            ">", opInfo(GtNodeFactory.getInstance())
                    )
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of(
                            "+", opInfo(AddNodeFactory.getInstance()),
                            "-", opInfo(SubNodeFactory.getInstance())
                    )
            ),
            Pair.create(
                    OpType.InfixRight,
                    Map.of(
                            "*", opInfo(MulNodeFactory.getInstance()),
                            "/", opInfo(DivNodeFactory.getInstance()),
                            "%", opInfo(ModNodeFactory.getInstance())
                    )
            )
    );

    private static <S extends LamaNode> OpInfo<S> castOpInfo(OpInfo<? extends S> opInfo) {
        return new OpInfo<>(opInfo.factory);
    }

    // Prepare for user-defined operators, init with builtin operators
    private static final List<Pair<OpType, Map<String, OpInfo<LamaNode>>>> OPERATOR_INFO =
            BUILTIN_OPERATOR_INFO.stream().map(
                            p -> Pair.create(
                                    p.getLeft(),
                                    p.getRight().entrySet().stream()
                                            .map(x -> Map.entry(x.getKey(), LamaNodeFactory.<LamaNode>castOpInfo(x.getValue())))
                                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                            )
                    )
                    .toList();

    // Help parser with explicit precedence climbing
    Pair<Integer, Pair<OpType, OpInfo<LamaNode>>> getOpInfo(Token t) {
        return IntStream.range(0, OPERATOR_INFO.size()).boxed()
                .flatMap(i -> {
                    var info = OPERATOR_INFO.get(i);
                    return Stream.ofNullable(info.getRight().get(t.getText())).map(in -> Pair.create(i, Pair.create(info.getLeft(), in)));
                })
                .findFirst().orElseThrow(() -> newSemErr(t, "Unrecognized operator"));
    }

    int getPrecedence(Token t) {
        return getOpInfo(t).getLeft();
    }

    int getNextPrecedence(Token t) {
        var info = getOpInfo(t);
        return info.getLeft() + (info.getRight().getLeft() == OpType.InfixRight ? 0 : 1);
    }

    enum ValueCategory {
        Val, Ref
    }

    // Make sure lhs of := becomes a Ref
    ValueCategory op2cat(Token t) {
        // System.out.format("Check lvalue: %s\n", t.getText());
        return Objects.equals(t.getText(), ":=") ? ValueCategory.Ref : ValueCategory.Val;
    }

    // Build up global scope with builtin operators and functions
    private final static Map<String, NodeFactory<? extends BuiltinNode>> BUILTINS =
            Stream.concat(
                    BUILTIN_OPERATOR_INFO.stream().flatMap(m -> m.getRight().entrySet().stream())
                            .map(e -> Map.entry(e.getKey(), e.getValue().factory)),
                    Map.of(
                            "write", WriteNodeFactory.getInstance(),
                            "read", ReadNodeFactory.getInstance(),
                            "length", LengthNodeFactory.getInstance()
                    ).entrySet().stream()
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    // Determine if expression should produce a reference or a value (different nodes) during parsing
    interface GenInterface<T> {
        T generate(ValueCategory cat);
    }

    // Generates an expression as LamaNode depending on the value category
    interface ExprGen extends GenInterface<LamaNode> {
    }

    // Generates a list of expressions as List<LamaNode> depending on the value category
    interface ExprsGen extends GenInterface<List<LamaNode>> {
        static ExprsGen of() {
            return a -> new ArrayList<>();
        }

        static ExprsGen of(ExprGen val) {
            return a -> {
                var x = new ArrayList<LamaNode>();
                var gen = val.generate(a);
                // Ignore `skip` -> null
                if (gen != null) {
                    x.add(gen);
                }
                return x;
            };
        }

        static ExprsGen of(ExprGen val1, ExprGen val2) {
            return add(of(val1), of(val2));
        }

        // Left expressions results are discarded => Val
        static ExprsGen add(ExprsGen lhs, ExprsGen rhs) {
            return a -> {
                var x = lhs.generate(ValueCategory.Val);
                x.addAll(rhs.generate(a));
                return x;
            };
        }

        static ExprsGen add(ExprsGen lhs, ExprGen rhs) {
            return add(lhs, of(rhs));
        }
    }

    <T> T assertValue(ValueCategory a, T ret, Token t) {
        if (a == ValueCategory.Ref) {
            throw newSemErr(t, "reference expected");
        }
        return ret;
    }

    // Resolve identifiers during parsing with lexical scoping
    // Block scope => new local variables & their initialization
    private static class LexicalScope {
        protected final LexicalScope outer;

        protected final Map<String, Integer> locals = new HashMap<>();
        public ExprsGen inits;

        public boolean isGlobal() {
            return outer == null;
        }

        public LexicalScope(LexicalScope outer) {
            this(outer, ExprsGen.of());
        }

        public LexicalScope(LexicalScope outer, ExprsGen inits) {
            this.outer = outer;
            this.inits = inits;
        }

        protected FindResult getLocal(int slot) {
            if (isGlobal()) {
                return new FindResult(ifVal(ReadGlobalNodeFactory.create(slot), LamaRef.global(slot)), true);
            }
            return new FindResult(ifVal(ReadLocalNodeFactory.create(slot), LamaRef.local(slot)), false);
        }

        public void addLocalValue(String name, ExprGen value) {
            var slot = locals.get(name);
            inits = ExprsGen.add(inits,
                    (ExprGen) a -> {
                        var valueNode = value.generate(ValueCategory.Val);
                        if (valueNode == null) {
                            // behave as `skip`
                            return null;
                        }
                        return AssignNodeFactory.create(
                                new LamaNode[]{getLocal(slot).result.generate(ValueCategory.Ref), valueNode}
                        );
                    });
        }

        public void addLocal(String name) {
            var slot = addLocalSlot(name);
            locals.put(name, slot);
        }

        protected int addLocalSlot(String name) {
            return outer.addLocalSlot(name);
        }

        public record FindResult(ExprGen result, boolean isGlobal) {}

        public FindResult find(String name) {
            // Try locals
            {
                var slot = locals.get(name);
                if (slot != null) {
                    return getLocal(slot);
                }
            }

            return findUp(name);
        }

        protected FindResult findUp(String name) {
            // Search up
            if (isGlobal()) {
                // Did not find => abort
                return new FindResult(null, false);
            }
            return outer.find(name);
        }

        protected ExprGen ifVal(LamaNode caseVal, LamaNode caseRef) {
            return a -> {
                if (a == ValueCategory.Val) {
                    return caseVal;
                } else {
                    return caseRef;
                }
            };
        }
    }

    // Function scope => block scope & arguments & closure
    private static class LexicalFuncScope extends LexicalScope {
        protected final Map<String, Integer> args = new HashMap<>();
        protected final FrameDescriptor.Builder localBuilder = FrameDescriptor.newBuilder();
        protected final Map<String, Pair<Integer, ExprGen>> closure = new HashMap<>();
        protected final FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();

        public LexicalFuncScope(LexicalScope outer) {
            super(outer);
        }

        public LexicalFuncScope(LexicalScope outer, ExprsGen inits) {
            super(outer, inits);
        }

        public ExprGen getArg(int index) {
            return ifVal(ReadArgumentNodeFactory.create(index), LamaRef.arg(index));
        }

        public FindResult getClosure(int slot) {
            return new FindResult(ifVal(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot)), false);
        }

        @Override
        protected FindResult findUp(String name) {
            // Try arguments
            {
                var index = args.get(name);
                if (index != null) {
                    return new FindResult(getArg(index), false);
                }
            }
            // Try closure
            {
                var cResult = closure.get(name);
                if (cResult != null) {
                    var slot = cResult.getLeft();
                    return getClosure(slot);
                }
            }

            // Maybe add to closure
            var result = super.findUp(name);
            if (result.result == null || result.isGlobal) {
                return result;
            }

            // Some local value, add to closure!
            return addClosure(name, result.result);
        }

        @Override
        public int addLocalSlot(String name) {
            return localBuilder.addSlot(FrameSlotKind.Illegal, name, null);
        }

        public void addArgument(String name, int index) {
            args.put(name, index);
        }

        public FindResult addClosure(String name, ExprGen value) {
            var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
            closure.put(name, Pair.create(slot, value));
            return getClosure(slot);
        }

        public FrameDescriptor getLocalFrameDescriptor() {
            return localBuilder.build();
        }

        public ClosureNode getClosure() {
            if (closure.isEmpty()) {
                return null;
            }
            return new ClosureNode(
                    closureBuilder.build(),
                    closure.values().stream().collect(
                            Collectors.toMap(
                                    Pair::getLeft,
                                    p -> p.getRight().generate(ValueCategory.Val)
                            )
                    )
            );
        }
    }

    // State while parsing a source unit
    private LexicalScope lexicalScope = null;

    LamaNodeFactory(LamaLanguage language, Source source) {
        this.language = language;
        this.source = source;
    }

    <T extends LexicalScope> T pushScope(Function<LexicalScope, T> op) {
        T res = op.apply(lexicalScope);
        lexicalScope = res;
        return res;
    }

    LexicalScope popScope() {
        var res = lexicalScope;
        lexicalScope = lexicalScope.outer;
        return res;
    }

    void startBlock() {
        pushScope(LexicalScope::new);
    }

    LexicalFuncScope startFunction(List<Token> arguments) {
        return pushScope(outerScope -> {
            var scope = new LexicalFuncScope(outerScope);
            int index = 0;
            for (var arg : arguments) {
                scope.addArgument(arg.getText(), index++);
            }
            return scope;
        });
    }

    void startMain() {
        startFunction(List.of());
        addLocals(BUILTINS.keySet());
        addLocalValues(BUILTINS.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> a -> LambdaNodeFactory.create(
                        BuiltinNode.createBuiltinFunction(
                                language, e.getValue(), null
                        ),
                        null
                )
        )));
    }

    // init is optional
    void addLocals(Set<String> locals) {
        for (var local : locals) {
            // System.out.format("Add local name: '%s'\n", local.getText());
            lexicalScope.addLocal(local);
        }
    }

    void addLocalValues(Map<String, ExprGen> locals) {
        for (var local : locals.entrySet()) {
            // System.out.format("Add local value: '%s'\n", local.getKey().getText());
            lexicalScope.addLocalValue(local.getKey(), local.getValue());
        }
    }

    ExprGen finishSeq(ExprsGen body) {
        return a -> {
            var bodyNodes = body.generate(a);
            if (containsNull(bodyNodes.stream())) {
                return null;
            }

            return new BlockNode(bodyNodes.toArray(LamaNode[]::new));
        };
    }

    ExprGen finishBlock(ExprsGen body) {
        var scope = popScope();

        // capture scope
        return finishSeq(ExprsGen.add(scope.inits, body));
    }

    // Asserts that this is a function scope
    ExprGen finishFunction(ExprsGen body, Token t) {
        var scope = (LexicalFuncScope) popScope();

        // capture scope
        return a -> {
            // Generate inits & body first to populate the closure
            var nodes = ExprsGen.add(scope.inits, body).generate(ValueCategory.Val);

            // Now safe to create closure
            var desc = scope.getLocalFrameDescriptor();
            var closure = scope.getClosure();
            if (scope.isGlobal()) {
                // Global scope: need to set the global context first
                nodes.add(0, SetGlobalScopeNodeFactory.create(desc));
            }
            var bodyNode = finishSeq(b -> nodes).generate(ValueCategory.Val);
            return assertValue(a, LambdaNodeFactory.create(
                    new LamaRootNode(language, desc, bodyNode).getCallTarget(),
                    closure
            ), t);
        };
    }

    // Asserts that this is a function scope
    RootCallTarget finishMain(ExprsGen body, Token t) {
        var main = finishFunction(body, t);
        var mainNode = finishSeq(ExprsGen.of(createCall(main, List.of(), t), a -> new IntLiteralNode(0)))
                .generate(ValueCategory.Val);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, mainNode).getCallTarget();
    }

    ExprGen createIntLiteral(Token intLiteral) {
        return a ->
                assertValue(a, new IntLiteralNode(Integer.parseInt(intLiteral.getText())), intLiteral);
    }

    ExprGen createIntLiteral(Token opLiteral, Token intLiteral) {
        return a ->
                assertValue(a, new IntLiteralNode(Integer.parseInt(opLiteral.getText() + intLiteral.getText())), opLiteral);
    }

    ExprGen createStringLiteral(Token strLiteral) {
        String quotedLit = strLiteral.getText();
        String lit = quotedLit.substring(1, quotedLit.length() - 1).replace("\"\"", "\"");
        return a ->
                assertValue(a, new StringLiteralNode(lit), strLiteral);
    }

    ExprGen createBinary(Token opToken, ExprGen left, ExprGen right) {
        return a -> {
            var leftNode = left.generate(op2cat(opToken));
            var rightNode = right.generate(ValueCategory.Val);
            if (leftNode == null || rightNode == null) {
                return null;
            }
            // System.out.format("binary '%s' of ", opToken.getText());
            // System.out.print(leftNode);
            // System.out.print(" ");
            // System.out.println(rightNode);

            return assertValue(
                    a,
                    getOpInfo(opToken).getRight().getRight().factory
                            .createNode((Object) new LamaNode[]{leftNode, rightNode}),
                    opToken
            );
        };
    }

    ExprGen createRead(Token name) {
        var scope = lexicalScope;

        // capture scope
        return a -> {
            var lookup = scope.find(name.getText()).result;
            if (lookup == null) {
                throw newSemErr(name, "variable not in scope");
            }
            return lookup.generate(a);
        };
    }

    ExprGen createElement(ExprGen arr, ExprGen index) {
        return a -> {
            var valueNode = arr.generate(ValueCategory.Val);
            var indexNode = index.generate(ValueCategory.Val);
            if (valueNode == null || indexNode == null) {
                return null;
            }
            return switch (a) {
                case Val -> ReadElementNodeFactory.create(valueNode, indexNode);
                case Ref -> LamaRef.stringElement(valueNode, indexNode);
            };
        };
    }

    ExprGen createCall(ExprGen function, List<ExprGen> parameters, Token t) {
        return a -> {
            var functionNode = function.generate(ValueCategory.Val);
            var parameterNodes = parameters.stream().map(p -> p.generate(ValueCategory.Val)).toArray(LamaNode[]::new);
            if (functionNode == null || containsNull(Arrays.stream(parameterNodes))) {
                return null;
            }

            return assertValue(a, new InvokeNode(functionNode, parameterNodes), t);
        };
    }

    // elsePart is optional
    ExprGen createIfThenElse(ExprGen condition, ExprGen then, ExprGen elsePart) {
        return a ->
                IfNodeFactory.create(
                        condition.generate(ValueCategory.Val),
                        then.generate(a),
                        elsePart == null ? null : elsePart.generate(a)
                );
    }

    ExprGen createWhileDo(ExprGen condition, ExprGen body, Token t) {
        return a ->
                assertValue(a, new WhileDoNode(condition.generate(ValueCategory.Val), body.generate(a)), t);
    }

    ExprGen createDoWhile(ExprGen body, ExprGen condition, Token t) {
        return a ->
                assertValue(a, new DoWhileNode(body.generate(a), condition.generate(ValueCategory.Val)), t);
    }

    ExprGen createForLoop(ExprGen init, ExprGen condition, ExprGen step, ExprGen body, Token t) {
        return a ->
                assertValue(
                        a, new ForNode(
                                init.generate(ValueCategory.Val),
                                condition.generate(ValueCategory.Val),
                                step.generate(ValueCategory.Val),
                                body.generate(a)
                        ),
                        t
                );
    }

    private static boolean containsNull(Stream<?> stream) {
        return stream.anyMatch(Objects::isNull);
    }
}
