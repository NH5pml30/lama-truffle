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

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.*;
import com.oracle.truffle.lama.nodes.builtins.*;
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
        InfixLeft, InfixRight, Infix,
        Prefix,
        Postfix
    }
    private record OpInfo<T extends LamaNode>(OpType type, NodeFactory<? extends T> factory) {}

    private static <S extends LamaNode, T extends S> OpInfo<S> castOpInfo(OpInfo<T> opInfo) {
        return new OpInfo<>(opInfo.type, opInfo.factory);
    }

    private static final List<Map<String, OpInfo<BuiltinNode>>> BUILTIN_OPERATOR_INFO = Arrays.asList(
            Map.of(":=", new OpInfo<>(OpType.InfixRight, AssignNodeFactory.getInstance())),
            Map.of("+", new OpInfo<>(OpType.InfixLeft, AddNodeFactory.getInstance())),
            Map.of("*", new OpInfo<>(OpType.InfixLeft, MulNodeFactory.getInstance()))
    );

    private static final List<Map<String, OpInfo<LamaNode>>> OPERATOR_INFO =
            BUILTIN_OPERATOR_INFO.stream().map(
                    x -> x.entrySet().stream()
                            .map(y -> Map.entry(y.getKey(), LamaNodeFactory.<LamaNode, BuiltinNode>castOpInfo(y.getValue())))
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            ).toList();

    Pair<Integer, OpInfo<LamaNode>> getOpInfo(Token t) {
        return IntStream.range(0, OPERATOR_INFO.size()).boxed()
                .flatMap(i -> Stream.ofNullable(OPERATOR_INFO.get(i).get(t.getText())).map(in -> Pair.create(i, in)))
                .findFirst().orElseThrow(() -> newSemErr(t, "Unrecognized operator"));
    }

    int getPrecedence(Token t) {
        return getOpInfo(t).getLeft();
    }

    int getNextPrecedence(Token t) {
        var info = getOpInfo(t);
        return switch (info.getRight().type) {
            case InfixRight, Prefix -> info.getLeft();
            default -> info.getLeft() + 1;
        };
    }

    ValueCategory op2cat(Token t) {
        // System.out.format("Check lvalue: %s\n", t.getText());
        return Objects.equals(t.getText(), ":=") ? ValueCategory.Ref : ValueCategory.Val;
    }

    private final static Map<String, NodeFactory<? extends BuiltinNode>> BUILTINS =
            Stream.concat(
                BUILTIN_OPERATOR_INFO.stream().flatMap(m -> m.entrySet().stream())
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

    interface ExprGen extends GenInterface<LamaNode> {}
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

    // Lexical scope to resolve identifiers during parsing
    // TODO: make block scope without closure
    private static class LexicalScope {
        protected final LexicalScope outer;

        protected final Map<String, Integer> args = new HashMap<>();
        protected final Map<String, Integer> locals = new HashMap<>();
        protected final Map<String, Pair<Integer, LamaNode>> closure = new HashMap<>();
        public final FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();
        public final FrameDescriptor.Builder localBuilder = FrameDescriptor.newBuilder();
        public final List<LamaNode> initNodes = new ArrayList<>();

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
        }

        ExprGen ifVal(LamaNode caseVal, LamaNode caseRef) {
            return a -> {
                if (a == ValueCategory.Val) {
                    return caseVal;
                } else {
                    return caseRef;
                }
            };
        }

        ExprGen getLocal(int slot) {
            return ifVal(ReadLocalNodeFactory.create(slot), LamaRef.local(slot));
        }

        ExprGen getArg(int index) {
            return ifVal(ReadArgumentNodeFactory.create(index), LamaRef.arg(index));
        }

        ExprGen getClosure(int slot) {
            return ifVal(ReadClosureNodeFactory.create(slot), LamaRef.closure(slot));
        }

        public ExprGen find(String name) {
            // Try locals
            {
                var slot = locals.get(name);
                if (slot != null) {
                    return getLocal(slot);
                }
            }
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
                return a -> null;
            }
            var result = outer.find(name);
            if (result == null) {
                return a -> null;
            }

            return addClosure(name, result.generate(ValueCategory.Val));
        }

        public void addArgument(String name, int index) {
            args.put(name, index);
        }

        public void addLocal(String name, LamaNode value) {
            var slot = localBuilder.addSlot(FrameSlotKind.Illegal, name, null);
            locals.put(name, slot);
            if (value != null) {
                initNodes.add(AssignNodeFactory.create(new LamaNode[]{getLocal(slot).generate(ValueCategory.Ref), value}));
            }
        }

        public ExprGen addClosure(String name, LamaNode value) {
            var slot = closureBuilder.addSlot(FrameSlotKind.Illegal, name, null);
            closure.put(name, Pair.create(slot, value));
            return getClosure(slot);
        }

        ClosureNode getClosure() {
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
    private LexicalScope lexicalScope = new LexicalScope(null);

    LamaNodeFactory(LamaLanguage language, Source source) {
        this.language = language;
        this.source = source;
    }

    void startFunction(List<Token> arguments) {
        lexicalScope = new LexicalScope(lexicalScope);
        int index = 0;
        for (var arg : arguments) {
            lexicalScope.addArgument(arg.getText(), index++);
        }
    }

    void startMain() {
        startFunction(List.of());
        for (var builtin : BUILTINS.entrySet()) {
            lexicalScope.addClosure(
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

    ExprGen addLocal(Token name, ExprGen init) {
        lexicalScope.addLocal(name.getText(), init == null ? null : init.generate(ValueCategory.Val));

        return a -> {
            // System.out.format("Add local: %s\n", name.getText());
            return assertValue(a, null, name);
        };
    }

    ExprGen finishFunction(ExprsGen body, Token t) {
        // System.out.println("finish function");
        var closure = lexicalScope.getClosure();
        var desc = lexicalScope.localBuilder.build();
        var initNodes = lexicalScope.initNodes;
        lexicalScope = lexicalScope.outer;

        return a -> {
            var bodyNodes = body.generate(ValueCategory.Val);
            if (containsNull(bodyNodes.stream())) {
                return null;
            }

            return assertValue(a, LambdaNodeFactory.create(
                    new LamaRootNode(
                            language, desc,
                            Stream.concat(initNodes.stream(), bodyNodes.stream()).toArray(LamaNode[]::new)
                    ).getCallTarget(),
                    closure
            ), t);
        };
    }

    RootCallTarget finishMain(ExprsGen body, Token t) {
        var mainNode = finishFunction(body, t);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, new LamaNode[]{
                createCall(
                        mainNode,
                        List.of(),
                        t
                ).generate(ValueCategory.Val)
        }).getCallTarget();
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
                    getOpInfo(opToken).getRight().factory
                            .createNode((Object) new LamaNode[]{leftNode, rightNode}),
                    opToken
            );
        };
    }

     ExprGen createRead(Token name) {
        var lookup = lexicalScope.find(name.getText());
        return a -> {
            var node = lookup.generate(a);
            if (node != null) {
                // System.out.format("Found this for [%s] name '%s': ", a == ValueCategory.Ref ? "l" : "r", name.getText());
                // System.out.println(node);
                return node;
            }
            System.out.format("Didn't find name: %s\n", name.getText());
            return null;
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
