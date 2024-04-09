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
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.nodes.*;
import com.oracle.truffle.lama.nodes.builtins.*;
import com.oracle.truffle.lama.nodes.controlflow.*;
import com.oracle.truffle.lama.nodes.controlflow.match.*;
import com.oracle.truffle.lama.nodes.controlflow.match.pattern.*;
import com.oracle.truffle.lama.nodes.scope.*;
import com.oracle.truffle.lama.nodes.expression.*;
import com.oracle.truffle.lama.runtime.LamaRef;
import org.antlr.v4.runtime.Token;

import com.oracle.truffle.api.source.Source;
import org.graalvm.collections.Pair;

import static com.oracle.truffle.lama.parser.LamaOperators.BUILTIN_OPERATOR_INFO;
import static com.oracle.truffle.lama.parser.LamaOperators.getOperatorInfo;

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

    // Build up global scope with builtin operators and functions
    private final static Map<String, NodeFactory<? extends BuiltinNode>> BUILTINS =
            Stream.concat(
                    BUILTIN_OPERATOR_INFO.stream().flatMap(m -> m.getRight().entrySet().stream())
                            .map(e -> Map.entry(e.getKey(), e.getValue())),
                    Map.of(
                            "write", WriteNodeFactory.getInstance(),
                            "read", ReadNodeFactory.getInstance(),
                            "length", LengthNodeFactory.getInstance(),
                            "string", StringNodeFactory.getInstance()
                    ).entrySet().stream()
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    <T> T assertValue(ValueCategory a, T ret, Token t) {
        if (a == ValueCategory.Ref) {
            throw newSemErr(t, "reference expected");
        }
        return ret;
    }

    Pair<Integer, LamaOperators.OpType> getOpInfo(LexicalScope scope, Token t) {
        // System.err.format("Search for '%s' operator\n", t.getText());
        // System.err.println(scope);
        // getOperatorInfo(scope).print();
        return getOperatorInfo(scope).get(t.getText()).orElseThrow(() -> newSemErr(t, "Unrecognized operator"));
    }

    int getPrecedence(Token t) {
        var res = getOpInfo(lexicalScope, t).getLeft();
        // System.err.format("Got precedence: %d\n", res);
        return res;
    }

    int getNextPrecedence(Token t) {
        var info = getOpInfo(lexicalScope, t);
        var res = info.getLeft() + (info.getRight() == LamaOperators.OpType.InfixRight ? 0 : 1);
        // System.err.format("Got next precedence: %d\n", res);
        return res;
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

    LexicalScope startBlock() {
        return pushScope(LexicalScope::new);
    }

    void pullLocalValues(LexicalScope from) {
        lexicalScope.pullLocalValues(from);
    }

    LexicalFuncScope startFunction(List<Token> arguments, String funName) {
        return pushScope(outerScope -> {
            var scope = new LexicalFuncScope(outerScope, funName);
            int index = 0;
            for (var arg : arguments) {
                scope.addArgument(arg.getText(), index++);
            }
            return scope;
        });
    }

    void startMain() {
        startFunction(List.of(), "main");
        for (var b : BUILTINS.entrySet()) {
            addLocal(b.getKey(), GenInterface.lift(GenInterface.lift(LambdaNodeFactory.create(
                    BuiltinNode.createBuiltinFunction(
                            language, b.getValue(), null
                    )
            ))));
        }
    }

    void addFun(String name, Fun fun) {
        lexicalScope.addFun(name, fun.closure, fun.body);
    }

    private boolean addLocal(String name, GenInterface<Void, GenInterface<Void, LamaNode>> value) {
        System.err.format("Add local '%s'\n", name);
        return lexicalScope.addLocalValue(name, value);
    }

    boolean tryAddLocal(Token name, GenInterface<ValueCategory, GenInterface<Void, LamaNode>> value) {
        return addLocal(name.getText(), GenInterface.konst(value, ValueCategory.Val));
    }

    void addLocal(Token name, GenInterface<ValueCategory, GenInterface<Void, LamaNode>> value) {
        if (!tryAddLocal(name, value)) {
            throw newSemErr(name, "Local with this name already defined");
        }
    }

    void addOp(Token name, LamaOperators.OpType infixity, Token relOp, int rel) {
        if (rel == 0 && infixity != LamaOperators.OpType.InfixNone) {
            throw newSemErr(relOp, "Invalid infixity for 'at' infix level (must be 'infix')");
        }

        lexicalScope.addOp(name.getText(), infixity, getOpInfo(lexicalScope, relOp), rel);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> finishSeq(GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body) {
        return a -> {
            // First, bind names
            var nameResolved = body.generate(a);

            return v -> {
                // Second, generate nodes
                var bodyNodes = nameResolved.stream().map(x -> x.generate(null)).toArray(LamaNode[]::new);
                if (containsNull(Arrays.stream(bodyNodes))) {
                    System.err.println("Seq contains null!!!\n");
                    return null;
                }

                return new BlockNode(bodyNodes);
            };
        };
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> finishBlock(GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body) {
        var scope = popScope();

        return finishSeq(scope.getBlock(inits -> GenInterfaces.concat(inits, body)));
    }

    record Fun(Closure closure, GenInterface<Void, GenInterface<Void, LamaNode>> body) {
        GenInterface<Void, GenInterface<Void, LamaNode>> instantiate() {
            return GenInterface.map(
                    body,
                    b -> GenInterface.map(b,
                            bodyNode -> closure.getNode()
                                    .map(node -> (LamaNode) SetClosureNodeFactory.create(bodyNode, node))
                                    .orElse(bodyNode)
                    )
            );
        }
    }

    // Asserts that this is a function scope
    Fun finishFunction(GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body) {
        var scope = (LexicalFuncScope) popScope();

        // capture scope
        return scope.getBlock(inits -> scope.getFun((closure, desc) -> {
            var initBody = GenInterfaces.concat(inits, body);
            if (scope.isGlobal()) {
                initBody = GenInterfaces.concat(
                        GenInterfaces.of(GenInterface.lift(GenInterface.lift(SetGlobalScopeNodeFactory.create(desc)))),
                        initBody
                );
            }

            System.err.format("finish function with '%d' local slots\n", desc.getNumberOfSlots());

            // System.out.format("finish function with '%s'(%d)\n", scope.closure.toString(), scope.closure.closure.size());
            var bodyGen = GenInterface.konst(GenInterface.map(
                    finishSeq(initBody),
                    i -> GenInterface.map(i, node -> {
                        if (node == null) {
                            System.err.println("Creating function with null node!!!\n");
                        }
                        System.err.format("Creating root node with node '%s'\n", node.toString());
                        return (LamaNode) LambdaNodeFactory.create(
                                new LamaRootNode(language, desc, node).getCallTarget()
                        );
                    })
            ), ValueCategory.Val);
            return new Fun(closure, bodyGen);
        }));
    }

    // Asserts that this is a function scope
    RootCallTarget finishMain(GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body, Token t) {
        var main = finishFunction(body);
        var mainNode = finishSeq(
                GenInterfaces.of(
                        GenInterface.konst(createCall(
                                genValue(main.instantiate(), t),
                                List.of(), t
                        ), ValueCategory.Val),
                        GenInterface.lift(GenInterface.lift(new IntLiteralNode(0)))
                )
        ).generate(ValueCategory.Val).generate(null);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, mainNode).getCallTarget();
    }

    <T> GenInterface<ValueCategory, T> genValue(GenInterface<Void, T> r, Token t) {
        return GenInterface.compose(r, a -> assertValue(a, null, t));
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createSkip(Token t) {
        return a -> assertValue(a, null, t);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createIntLiteral(Token intLiteral) {
        return a -> assertValue(
                a,
                GenInterface.lift(new IntLiteralNode(Integer.parseInt(intLiteral.getText()))),
                intLiteral
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createIntLiteral(Token opLiteral, Token intLiteral) {
        return a -> assertValue(
                a,
                GenInterface.lift(new IntLiteralNode(Integer.parseInt(opLiteral.getText() + intLiteral.getText()))),
                opLiteral
        );
    }

    private static String fromStringLiteral(String quotedLit) {
        return quotedLit.substring(1, quotedLit.length() - 1).replace("\"\"", "\"");
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createStringLiteral(Token strLiteral) {
        String lit = fromStringLiteral(strLiteral.getText());
        return a ->
                assertValue(a, GenInterface.lift(new StringLiteralNode(lit)), strLiteral);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createCharLiteral(Token charLiteral) {
        String quotedLit = charLiteral.getText();
        String lit = quotedLit.substring(1, quotedLit.length() - 1);
        return a -> assertValue(a, GenInterface.lift(new IntLiteralNode(lit.charAt(0))), charLiteral);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createBinary(
            Token opToken,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> left,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> right
    ) {
        var scope = lexicalScope;
        var lhsCat = LamaOperators.op2cat(opToken.getText());
        // capture scope
        return GenInterface.compose(
                GenInterface.lift3(
                        v -> scope.find(opToken.getText())
                                .orElseThrow(() -> newSemErr(opToken, "operator not in scope"))
                                .get().generate(ValueCategory.Val),
                        GenInterface.konst(left, lhsCat),
                        GenInterface.konst(right, ValueCategory.Val),
                        (op, l, r) ->
                                GenInterface.lift2(l, r, (ln, rn) -> {
                                    if (ln == null || rn == null) {
                                        return null;
                                    }
                                    // System.err.format("Create binary '%s'\n", opToken.getText());
                                    return lhsCat == ValueCategory.Ref
                                            ? BUILTIN_OPERATOR_INFO.stream().map(Pair::getRight)
                                            .flatMap(m -> Optional.ofNullable(m.get(opToken.getText())).stream())
                                            .findFirst().orElseThrow(() -> newSemErr(opToken, "operator not in scope"))
                                            .createNode((Object) new LamaNode[]{ln, rn})
                                            : createCallNode(op, new LamaNode[]{ln, rn});
                                })),
                a -> assertValue(a, null, opToken)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createInfix(Token opToken) {
        return createRead(opToken);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createRead(Token name) {
        var scope = lexicalScope;

        // capture scope
        return a -> {
            var lookup = scope.find(name.getText()).orElseThrow(() -> newSemErr(name, "variable not in scope"))
                    .get();
            // System.err.format("Found for '%s': %s\n", name.getText(), Objects.toString(lookup));
            return GenInterface.konst(lookup, a);
        };
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createElement(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> arr,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> index
    ) {
        return GenInterface.lift3(
                a -> a,
                GenInterface.forget(GenInterface.konst(arr, ValueCategory.Val)),
                GenInterface.forget(GenInterface.konst(index, ValueCategory.Val)),
                (a, ar, in) -> GenInterface.lift2(ar, in,
                        (arn, inn) -> {
                            if (arn == null || inn == null) {
                                return null;
                            }
                            return switch (a) {
                                case Val -> ReadElementNodeFactory.create(arn, inn);
                                case Ref -> LamaRef.element(arn, inn);
                            };
                        }
                )
        );
    }

    // TODO: main idea:
    //   - each closure contains a list of its "instantiations" for each user scope
    //   - instantiations contain a reference to the closure, its user scope and map of slot |-> value
    //   - every time a value is added to the closure (at the name resolving stage == GenInterface<ValueCategory, ...>),
    //     we add it to all the children, which request it from the user scope by its Capture (unique)
    //     (need to eagerly add a value to not loop)
    //   - every time we resolve a name to a function, we instantiate the closure and propagate it down
    //     (we won't loop because all values are already present (?))
    //   - closure instantiations can be turned into a LamaNodes at the last stage of GenInterface<Void, LamaNode>

    private LamaNode createCallNode(LamaNode func, LamaNode[] args) {
        return new InvokeNode(func, args);
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createCall(GenInterface<ValueCategory, GenInterface<Void, LamaNode>> function, List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> parameters, Token t) {
        var functionGen = GenInterface.konst(function, ValueCategory.Val);
        var parametersGen = GenInterface.konst(GenInterface.map(GenInterfaces.sequence(parameters), GenInterfaces::sequence), ValueCategory.Val);
        return GenInterface.compose(
                GenInterface.lift2(functionGen, parametersGen, (fn, pn) ->
                        GenInterface.lift2(fn, pn, (functionNode, parameterNodes) -> {
                            if (functionNode == null || containsNull(parameterNodes.stream())) {
                                return null;
                            }
                            return createCallNode(functionNode, parameterNodes.toArray(LamaNode[]::new));
                        })),
                a -> assertValue(a, null, t)
        );
    }

    // elsePart is optional
    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createIfThenElse(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> condition,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> then,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> elsePart
    ) {
        return GenInterface.lift3(
                GenInterface.forget(GenInterface.konst(condition, ValueCategory.Val)),
                then, elsePart,
                (c, t, e) -> GenInterface.lift3(c, t, e == null ? v -> null : e, IfNodeFactory::create)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createWhileDo(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> condition,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> body,
            Token t
    ) {
        return GenInterface.compose(
                GenInterface.lift2(
                        GenInterface.forget(GenInterface.konst(condition, ValueCategory.Val)),
                        body,
                        (cn, bn) ->
                        GenInterface.lift2(cn, bn, (conditionNode, bodyNode) -> {
                            if (conditionNode == null || bodyNode == null) {
                                return null;
                            }
                            return new WhileDoNode(conditionNode, bodyNode);
                        })),
                a -> assertValue(a, null, t)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createDoWhile(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> body,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> condition,
            Token t
    ) {
        return GenInterface.compose(
                GenInterface.lift2(
                        body,
                        GenInterface.forget(GenInterface.konst(condition, ValueCategory.Val)),
                        (bn, cn) ->
                                GenInterface.lift2(bn, cn, (bodyNode, conditionNode) -> {
                                    if (conditionNode == null || bodyNode == null) {
                                        return null;
                                    }
                                    return new DoWhileNode(bodyNode, conditionNode);
                                })),
                a -> assertValue(a, null, t)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createForLoop(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> init,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> condition,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> step,
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> body,
            Token t
    ) {
        return GenInterface.compose(
                GenInterface.lift4(
                        GenInterface.forget(GenInterface.konst(init, ValueCategory.Val)),
                        GenInterface.forget(GenInterface.konst(condition, ValueCategory.Val)),
                        GenInterface.forget(GenInterface.konst(step, ValueCategory.Val)),
                        body,
                        (in, cn, sn, bn) ->
                                GenInterface.lift4(in, cn, sn, bn, (i, c, s, b) -> {
                                    if (i == null || c == null || s == null || b == null) {
                                        return null;
                                    }
                                    return new ForNode(i, c, s, b);
                                })),
                a -> assertValue(a, null, t)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createArray(
            GenInterfaces<Void, GenInterface<Void, LamaNode>> vals, Token t
    ) {
        return GenInterface.compose(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> new ArrayNode(n.toArray(LamaNode[]::new))
                )),
                a -> assertValue(a, null, t)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createSExp(
            String name, GenInterfaces<Void, GenInterface<Void, LamaNode>> vals, Token t
    ) {
        return GenInterface.compose(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> new SExpNode(name, n.toArray(LamaNode[]::new))
                )),
                a -> assertValue(a, null, t)
        );
    }

    private static <T, R> R reduceRight(List<T> list, BiFunction<T, R, R> op, R accum) {
        for (var x : list.reversed()) {
            accum = op.apply(x, accum);
        }
        return accum;
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createList(
            GenInterfaces<Void, GenInterface<Void, LamaNode>> vals, Token t
    ) {
        return GenInterface.compose(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> reduceRight(
                                n,
                                (lhs, rhs) -> ConsNodeFactory.create(new LamaNode[]{lhs, rhs}),
                                (LamaNode) new IntLiteralNode(0)
                        )
                )),
                a -> assertValue(a, null, t)
        );
    }

    GenInterface<ValueCategory, GenInterface<Void, LamaNode>> createPatternMatch(
            GenInterface<ValueCategory, GenInterface<Void, LamaNode>> what,
            List<Pair<PatGen, GenInterface<ValueCategory, GenInterface<Void, LamaNode>>>> matches
    ) {
        var matchesGen = GenInterface.map(GenInterfaces.sequence(
                matches.stream().map(p -> GenInterface.map(
                        p.getRight(),
                        r -> GenInterface.map(r, rr -> Pair.create(p.getLeft(), rr))
                )).toList()
        ), GenInterfaces::sequence);
        return GenInterface.lift2(
                GenInterface.forget(GenInterface.konst(what, ValueCategory.Val)),
                matchesGen,
                (wn, mn) ->
                        GenInterface.lift2(wn, mn, (whatNode, matchesNodes) -> {
                            if (whatNode == null || containsNull(matchesNodes.stream().map(Pair::getRight))) {
                                return null;
                            }
                            PatternMatchBaseNode match = PatternMatchEmptyNodeFactory.create(whatNode);
                            for (var m : matchesNodes) {
                                // safe to generate PatGen here because they don't influence closures
                                match = PatternMatchNodeFactory.create(whatNode, match, m.getLeft().apply(whatNode), m.getRight());
                            }
                            return match;
                        })
        );
    }

    PatGen createSExpPattern(String name, List<PatGen> pats) {
        return node -> PatternSExpNodeFactory.create(node, SExpNode.hashCode(name), pats);
    }

    PatGen createArrayPattern(List<PatGen> pats) {
        return node -> PatternArrayNodeFactory.create(node, pats);
    }

    PatGen createBindPattern(Token name, PatGen pat) {
        var nameText = name.getText();
        var scope = lexicalScope;

        // capture scope
        return node -> {
            var ref = scope.getOrAddLocal(nameText);
            return PatternBindNodeFactory.create(node, pat, ref.generateRef());
        };
    }

    PatGen createWildcardPattern() {
        return PatternWildcardNodeFactory::create;
    }

    PatGen createIntValPattern(int val) {
        return node -> PatternIntValNodeFactory.create(node, val);
    }
    PatGen createIntValPattern(String str) {
        return createIntValPattern(Integer.parseInt(str));
    }

    PatGen createStrValPattern(String strLiteral) {
        String val = fromStringLiteral(strLiteral);
        return node -> PatternStrValNodeFactory.create(node, val);
    }

    PatGen createConsPattern(PatGen lhs, PatGen rhs) {
        return createSExpPattern(ConsNode.NAME, List.of(lhs, rhs));
    }

    PatGen createListPattern(List<PatGen> els) {
        return reduceRight(els, this::createConsPattern, createIntValPattern(0));
    }

    PatGen createFunPattern() {
        return PatternFunNodeFactory::create;
    }
    PatGen createValPattern() {
        return PatternValNodeFactory::create;
    }
    PatGen createStrPattern() {
        return PatternStrNodeFactory::create;
    }

    private static boolean containsNull(Stream<?> stream) {
        return stream.anyMatch(Objects::isNull);
    }
}
