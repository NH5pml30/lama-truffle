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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.*;
import com.oracle.truffle.lama.nodes.builtins.*;
import com.oracle.truffle.lama.nodes.controlflow.BlockNode;
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
        return new LamaParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
    }

    enum OpType {
        InfixLeft, InfixRight, InfixNone
    }

    private record OpInfo<T extends LamaNode>(NodeFactory<? extends T> factory) {
    }

    private static <T extends LamaNode> OpInfo<T> opInfo(NodeFactory<? extends T> factory) {
        return new OpInfo<T>(factory);
    }

    private static final List<Pair<OpType, Map<String, OpInfo<BuiltinNode>>>> BUILTIN_OPERATOR_INFO = Arrays.asList(
            Pair.create(
                    OpType.InfixRight,
                    Map.of(":=", opInfo(AssignNodeFactory.getInstance()))
            ),
            Pair.create(
                    OpType.InfixLeft,
                    Map.of("+", opInfo(AddNodeFactory.getInstance()))
            ),
            Pair.create(
                    OpType.InfixRight,
                    Map.of("*", opInfo(MulNodeFactory.getInstance()))
            )
    );

    private static <S extends LamaNode> OpInfo<S> castOpInfo(OpInfo<? extends S> opInfo) {
        return new OpInfo<>(opInfo.factory);
    }

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

    ValueCategory op2cat(Token t) {
        // System.out.format("Check lvalue: %s\n", t.getText());
        return Objects.equals(t.getText(), ":=") ? ValueCategory.Ref : ValueCategory.Val;
    }

    private final static Map<String, NodeFactory<? extends BuiltinNode>> BUILTINS =
            Stream.concat(
                    BUILTIN_OPERATOR_INFO.stream().flatMap(m -> m.getRight().entrySet().stream())
                            .map(e -> Map.entry(e.getKey(), e.getValue().factory)),
                    Map.of(
                            "print", PrintNodeFactory.getInstance()
                    ).entrySet().stream()
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    enum ValueCategory {
        Val, Ref
    }

    interface GenInterface<T> {
        T generate(ValueCategory cat);
    }

    interface ExprGen extends GenInterface<LamaNode> {
    }

    interface ExprsGen extends GenInterface<List<LamaNode>> {
        static ExprsGen of() {
            return a -> new ArrayList<>();
        }

        static ExprsGen of(ExprGen val) {
            return a -> {
                var x = new ArrayList<LamaNode>();
                x.add(val.generate(a));
                return x;
            };
        }

        /* static ExprsGen add(ExprsGen lhs, ExprGen rhs) {
            return a -> {
                var x = lhs.generate(ValueCategory.Val);
                x.add(rhs.generate(a));
                return x;
            };
        } */

        static ExprsGen add(ExprsGen lhs, ExprsGen rhs) {
            return a -> {
                var x = lhs.generate(ValueCategory.Val);
                x.addAll(rhs.generate(a));
                return x;
            };
        }
    }

    LamaNode assertValue(ValueCategory a, LamaNode ret, Token t) {
        if (a == ValueCategory.Ref) {
            throw newSemErr(t, "reference expected");
        }
        return ret;
    }

    private static abstract class LexicalScope {
        protected final LexicalScope outer;

        protected LexicalScope(LexicalScope outer) {
            this.outer = outer;
        }

        public void addLocal(String name, LamaNode value) {
            outer.addLocal(name, value);
        }
        protected int addLocalSlot(String name) {
            return outer.addLocalSlot(name);
        }
        public abstract ExprGen find(String name);

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

    // Lexical scope to resolve identifiers during parsing
    private static class LexicalBlockScope extends LexicalScope {
        protected final Map<String, Integer> locals = new HashMap<>();
        public final List<LamaNode> initNodes = new ArrayList<>();

        public LexicalBlockScope(LexicalScope outer) {
            super(outer);
        }

        protected ExprGen getLocal(int slot) {
            return ifVal(ReadLocalNodeFactory.create(slot), LamaRef.local(slot));
        }

        @Override
        public ExprGen find(String name) {
            // Try locals
            {
                var slot = locals.get(name);
                if (slot != null) {
                    return getLocal(slot);
                }
            }

            if (outer == null) {
                return null;
            }
            return outer.find(name);
        }

        @Override
        public void addLocal(String name, LamaNode value) {
            var slot = addLocalSlot(name);
            locals.put(name, slot);
            if (value != null) {
                initNodes.add(AssignNodeFactory.create(new LamaNode[]{getLocal(slot).generate(ValueCategory.Ref), value}));
            }
        }
    }

    private static class LexicalFuncScope extends LexicalBlockScope {
        protected final Map<String, Integer> args = new HashMap<>();
        protected final FrameDescriptor.Builder localBuilder = FrameDescriptor.newBuilder();
        protected final Map<String, Pair<Integer, LamaNode>> closure = new HashMap<>();
        protected final FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();

        public LexicalFuncScope(LexicalScope outer) {
            super(outer);
        }

        public ExprGen getArg(int index) {
            return ifVal(ReadArgumentNodeFactory.create(index), LamaRef.arg(index));
        }

        public ExprGen getClosure(int slot) {
            return ifVal(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot));
        }

        @Override
        public ExprGen find(String name) {
            // Try arguments
            {
                var index = args.get(name);
                if (index != null) {
                    return getArg(index);
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

            // Add to closure
            if (outer == null) {
                return null;
            }
            var result = outer.find(name);
            if (result == null) {
                return null;
            }

            return addClosure(name, result.generate(ValueCategory.Val));
        }

        @Override
        protected int addLocalSlot(String name) {
            return localBuilder.addSlot(FrameSlotKind.Illegal, name, null);
        }

        public void addArgument(String name, int index) {
            args.put(name, index);
        }

        public ExprGen addClosure(String name, LamaNode value) {
            var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
            closure.put(name, Pair.create(slot, value));
            return getClosure(slot);
        }

        public FrameDescriptor getLocalFrameDescriptor() {
            return localBuilder.build();
        }

        public ClosureNode getClosure() {
            return new ClosureNode(
                    closureBuilder.build(),
                    closure.values().stream().collect(
                            Collectors.toMap(
                                    Pair::getLeft,
                                    Pair::getRight
                            )
                    )
            );
        }
    }

    /* State while parsing a source unit. */
    private LexicalScope lexicalScope = null;

    LamaNodeFactory(LamaLanguage language, Source source) {
        this.language = language;
        this.source = source;
    }

    void startBlock() {
        lexicalScope = new LexicalBlockScope(lexicalScope);
    }

    LexicalFuncScope startFunction(List<Token> arguments) {
        var scope = new LexicalFuncScope(lexicalScope);
        int index = 0;
        for (var arg : arguments) {
            scope.addArgument(arg.getText(), index++);
        }
        lexicalScope = scope;
        return scope;
    }

    void startMain() {
        var scope = startFunction(List.of());
        for (var builtin : BUILTINS.entrySet()) {
            scope.addClosure(
                    builtin.getKey(),
                    LambdaNodeFactory.create(
                            BuiltinNode.createBuiltinFunction(
                                    language, builtin.getValue(), null
                            ),
                            null
                    )
            );
        }
    }

    void addLocal(Token name, ExprGen init) {
        lexicalScope.addLocal(name.getText(), init == null ? null : init.generate(ValueCategory.Val));
    }

    ExprGen finishBlock(ExprsGen body) {
        var scope = (LexicalBlockScope) lexicalScope;
        var initNodes = scope.initNodes;
        lexicalScope = lexicalScope.outer;

        return a -> {
            var bodyNodes = body.generate(a);
            if (containsNull(bodyNodes.stream())) {
                return null;
            }

            return new BlockNode(
                    Stream.concat(initNodes.stream(), bodyNodes.stream()).toArray(LamaNode[]::new)
            );
        };
    }

    ExprGen finishFunction(ExprGen body, Token t) {
        // System.out.println("finish function");
        var scope = (LexicalFuncScope) lexicalScope;
        var closure = scope.getClosure();
        var desc = scope.getLocalFrameDescriptor();
        lexicalScope = lexicalScope.outer;

        return a -> {
            var bodyNode = body.generate(ValueCategory.Val);
            if (bodyNode == null) {
                return null;
            }

            return assertValue(a, LambdaNodeFactory.create(
                    new LamaRootNode(language, desc, bodyNode).getCallTarget(),
                    closure
            ), t);
        };
    }

    RootCallTarget finishMain(ExprGen body, Token t) {
        var main = finishFunction(body, t);
        var mainNode = createCall(main, List.of(), t).generate(ValueCategory.Val);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, mainNode).getCallTarget();
    }

    ExprGen createIntLiteral(Token intLiteral) {
        return a ->
                assertValue(a, new IntLiteralNode(Integer.parseInt(intLiteral.getText())), intLiteral);
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
        var lookup = lexicalScope.find(name.getText());
        return a -> {
            if (lookup == null) {
                throw newSemErr(name, String.format("variable not in scope: '%s'", name.getText()));
            }
            return lookup.generate(a);
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

    private static boolean containsNull(Stream<?> stream) {
        return stream.anyMatch(Objects::isNull);
    }
}
