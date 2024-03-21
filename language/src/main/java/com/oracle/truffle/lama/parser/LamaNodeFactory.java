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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.InvokeNode;
import com.oracle.truffle.lama.nodes.LamaFunction;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.builtins.BuiltinNode;
import com.oracle.truffle.lama.nodes.builtins.PrintNodeFactory;
import com.oracle.truffle.lama.nodes.local.*;
import org.antlr.v4.runtime.Token;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.nodes.expression.IntLiteralNode;
import com.oracle.truffle.lama.nodes.builtins.AddNodeFactory;
import org.graalvm.collections.Pair;

public class LamaNodeFactory {
    private final LamaLanguage language;

    private final static Map<String, NodeFactory<? extends BuiltinNode>> BUILTINS = Map.of(
            "print", PrintNodeFactory.getInstance(),
            "+", AddNodeFactory.getInstance()
    );

    // Lexical scope to resolve identifiers during parsing
    static class LexicalScope {
        protected final LexicalScope outer;

        protected final Map<String, ReadArgumentNode> args = new HashMap<>();
        protected final Map<String, ReadLocalNode> locals = new HashMap<>();
        protected final Map<String, Pair<ReadClosureNode, LamaNode>> closure = new HashMap<>();
        public final FrameDescriptor.Builder closureBuilder = FrameDescriptor.newBuilder();
        public final FrameDescriptor.Builder localBuilder = FrameDescriptor.newBuilder();
        public final List<LamaNode> initNodes = new ArrayList<>();

        LexicalScope(LexicalScope outer) {
            this.outer = outer;
        }

        public LamaNode find(String name) {
            LamaNode result = locals.get(name);
            if (result != null) {
                return result;
            }
            result = args.get(name);
            if (result != null) {
                return result;
            }
            {
                var cResult = closure.get(name);
                if (cResult != null) {
                    return cResult.getLeft();
                }
            }

            if (outer == null) {
                return null;
            }
            result = outer.find(name);
            if (result == null) {
                return null;
            }

            return addClosure(name, result);
        }

        public ReadArgumentNode addArgument(String name, int index) {
            var result = ReadArgumentNodeFactory.create(index);
            args.put(name, result);
            return result;
        }

        public ReadLocalNode addLocal(String name, LamaNode value) {
            var result = ReadLocalNodeFactory.create(
                    localBuilder.addSlot(FrameSlotKind.Illegal, name, null)
            );
            locals.put(name, result);
            if (value != null) {
                initNodes.add(WriteLocalNodeFactory.create(value, result.getSlot()));
            }
            return result;
        }

        public ReadClosureNode addClosure(String name, LamaNode value) {
            var result = ReadClosureNodeFactory.create(
                    closureBuilder.addSlot(FrameSlotKind.Illegal, name, null)
            );
            closure.put(name, Pair.create(result, value));
            return result;
        }

        ClosureNode getClosure() {
            return new ClosureNode(
                    closureBuilder.build(),
                    closure.values().stream().collect(
                            Collectors.toMap(
                                    e -> e.getLeft().getSlot(),
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

    void addLocal(Token name, LamaNode init) {
        lexicalScope.addLocal(name.getText(), init);
    }

    LamaNode finishFunction(List<LamaNode> bodyNodes) {
        var closure = lexicalScope.getClosure();
        var desc = lexicalScope.localBuilder.build();
        var initNodes = lexicalScope.initNodes;
        lexicalScope = lexicalScope.outer;

        if (containsNull(bodyNodes)) {
            return null;
        }

        return LambdaNodeFactory.create(
                new LamaRootNode(
                        language, desc,
                        Stream.concat(initNodes.stream(), bodyNodes.stream()).toArray(LamaNode[]::new)
                ).getCallTarget(),
                closure

        );
    }

    CallTarget finishMain(List<LamaNode> bodyNodes) {
        var mainNode = finishFunction(bodyNodes);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, new LamaNode[] {
                createCall(
                        mainNode,
                        List.of()
                )
        }).getCallTarget();
    }

    LamaNode createIntLiteral(Token intLiteral) {
        return new IntLiteralNode(Integer.parseInt(intLiteral.getText()));
    }

    LamaNode createBinary(Token opToken, LamaNode leftNode, LamaNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return null;
        }

        return switch (opToken.getText()) {
            case "+" -> AddNodeFactory.create(new LamaNode[]{leftNode, rightNode});
            case ":=" -> {
                var left = (ReadLocalNode) leftNode;
                yield WriteLocalNodeFactory.create(rightNode, left.getSlot());
            }
            default -> throw new RuntimeException("unexpected operation: " + opToken.getText());
        };
    }

    LamaNode createRead(Token name) {
        final var node = lexicalScope.find(name.getText());
        if (node != null) {
            System.out.format("Found this for name '%s': ", name.getText());
            System.out.println(node);
            return node;
        }
        System.out.format("Didn't find name: %s\n", name.getText());
        return null;
    }

    LamaNode createCall(LamaNode functionNode, List<LamaNode> parameterNodes) {
        if (functionNode == null || containsNull(parameterNodes)) {
            return null;
        }

        return new InvokeNode(functionNode, parameterNodes.toArray(new LamaNode[0]));
    }

    private static boolean containsNull(List<?> list) {
        for (Object e : list) {
            if (e == null) {
                return true;
            }
        }
        return false;
    }

}
