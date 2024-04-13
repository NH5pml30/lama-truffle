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
import com.oracle.truffle.lama.runtime.*;
import org.antlr.v4.runtime.Token;

import com.oracle.truffle.api.source.Source;
import org.graalvm.collections.Pair;

import static com.oracle.truffle.lama.parser.LamaOperators.*;

// Parser helper class.
// Use two passes of source analysis:
// First, parse source to something and create all local scopes with local variable names.
// Then, resolve names everywhere (first `GenInterface::generate` call), and build up closures.
// Because of self-referencing between functions, we need to resolve all names everywhere before finally creating closure nodes.
// Then, finalize the closures (second `GenInterface::generate` call) and construct the necessary LamaNode structure.
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

    // Use ValueCategory to track where we need to generate LamaRef constructions for assignment
    <T> T assertValue(ValueCategory a, T ret, Token t) {
        if (a == ValueCategory.Ref) {
            throw newSemErr(t, "reference expected");
        }
        return ret;
    }

    // Operator support functions
    Pair<Integer, LamaOperators.OpType> getOpInfo(LexicalScope scope, Token t) {
        return getOperatorInfo(scope).get(t.getText()).orElseThrow(() -> newSemErr(t, "Unrecognized operator"));
    }

    int getPrecedence(Token t) {
        return getOpInfo(lexicalScope, t).getLeft();
    }

    int getRightPrecedence(Token t) {
        var info = getOpInfo(lexicalScope, t);
        return info.getLeft() + (info.getRight() == LamaOperators.OpType.InfixRight ? 0 : 1);
    }

    int getNextPrecedence(Token t) {
        var info = getOpInfo(lexicalScope, t);
        return info.getLeft() + (info.getRight() == LamaOperators.OpType.InfixLeft ? 0 : -1);
    }

    // Current lexical scope
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

    void startFunction(List<String> arguments, String funName) {
        pushScope(outerScope -> {
            var scope = new LexicalFuncScope(outerScope, funName);
            int index = 0;
            for (var arg : arguments) {
                scope.addArgument(arg, index++);
            }
            return scope;
        });
    }

    GenInterface<ScopedExprsGen, ScopedExprsGen> startFunctionPat(List<PatGen> argumentsPats, String funName, Token t) {
        List<String> arguments = new ArrayList<>();
        pushScope(outerScope -> {
            var scope = new LexicalFuncScope(outerScope, funName);
            int index = 0;
            for (var arg : argumentsPats) {
                var name = freshName();
                scope.addArgument(name, index++);
                arguments.add(name);
            }
            return scope;
        });
        GenInterface<ScopedExprGen, ScopedExprGen> r = x -> x;
        for (int i = 0; i < argumentsPats.size(); i++) {
            var pat = argumentsPats.get(i);
            var name = arguments.get(i);
            r = x -> createPatternMatch(createSymbol(name, t), List.of(Pair.create(pat, x)));
        }
        return GenInterface.compose(GenInterface.map(r, x -> GenInterfaces.of(x)::generate), this::finishSeq);
    }

    void startMain() {
        startFunction(List.of(), "main");
        for (var b : BUILTINS.entrySet()) {
            addLocal(b.getKey(), v -> GenInterface.lift(LambdaNodeFactory.create(
                    BuiltinNode.createBuiltinFunction(
                            language, b.getValue(), null
                    ),
                    b.getKey()
            )));
        }
    }

    void addFun(String name, Fun fun) {
        // Currently, this adds a local (or global) variable
        lexicalScope.addFun(name, fun.closure, fun.body);
    }

    private boolean addLocal(String name, ScopedValGen value) {
        return lexicalScope.addLocalValue(name, value);
    }

    boolean tryAddLocal(Token name, ScopedExprGen value) {
        return addLocal(name.getText(), GenInterface.konst(value, ValueCategory.Val)::generate);
    }

    void addLocal(Token name, ScopedExprGen value) {
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

    ScopedExprGen finishSeq(ScopedExprsGen body) {
        return GenInterface.map(body, l -> GenInterface.map(
                GenInterfaces.sequence(l),
                n -> (LamaNode) new BlockNode(n.toArray(LamaNode[]::new))
        ))::generate;
    }

    ScopedExprGen finishBlock(ScopedExprsGen body) {
        var scope = popScope();

        return finishSeq(scope.getBlock(inits -> GenInterfaces.concat(inits, body)::generate));
    }

    record Fun(Closure closure, ScopedValGen body) {
        ScopedValGen instantiate() {
            return GenInterface.map(
                    body,
                    b -> GenInterface.map(b,
                            bodyNode -> closure.getNode()
                                    .map(node -> (LamaNode) SetClosureNodeFactory.create(bodyNode, node))
                                    .orElse(bodyNode)
                    )
            )::generate;
        }
    }

    // Asserts that this is a function scope
    Fun finishFunction(ScopedExprsGen body) {
        var scope = (LexicalFuncScope) popScope();

        // capture scope
        return scope.getBlock(inits -> scope.getFun((closure, desc) -> {
            ScopedExprsGen initBody = GenInterfaces.concat(inits, body)::generate;
            if (scope.isGlobal()) {
                initBody = GenInterfaces.concat(
                        GenInterfaces.of(GenInterface.lift(GenInterface.lift(SetGlobalScopeNodeFactory.create(desc)))),
                        initBody
                )::generate;
            }

            var bodyGen = GenInterface.konst(GenInterface.map(
                    finishSeq(initBody),
                    i -> GenInterface.map(i, node -> (LamaNode) LambdaNodeFactory.create(
                            new LamaRootNode(language, desc, node).getCallTarget(),
                            scope.funName
                    ))
            ), ValueCategory.Val);
            return new Fun(closure, bodyGen::generate);
        }));
    }

    // Asserts that this is a function scope
    RootCallTarget finishMain(ScopedExprsGen body, Token t) {
        var main = finishFunction(body);
        var mainNode = finishSeq(
                GenInterfaces.of(
                        GenInterface.konst(createCall(
                                genValue(main.instantiate(), t)::generate,
                                List.of(), t
                        ), ValueCategory.Val),
                        GenInterface.lift(GenInterface.lift(IntLiteralNodeFactory.create(0)))
                )::generate
        ).generate(ValueCategory.Val).generate(null);
        if (mainNode == null) {
            return null;
        }

        return new LamaRootNode(language, null, mainNode).getCallTarget();
    }

    <T> GenInterface<ValueCategory, T> genValue(GenInterface<Void, T> r, Token t) {
        return GenInterface.compose(r, a -> assertValue(a, null, t));
    }

    ScopedExprGen createSkip(Token t) {
        return a -> assertValue(a, null, t);
    }

    ScopedExprGen createIntLiteral(Token intLiteral) {
        return a -> assertValue(
                a,
                GenInterface.lift(IntLiteralNodeFactory.create(Integer.parseInt(intLiteral.getText()))),
                intLiteral
        );
    }

    ScopedExprGen createIntLiteral(Token opLiteral, Token intLiteral) {
        return a -> assertValue(
                a,
                GenInterface.lift(IntLiteralNodeFactory.create(Integer.parseInt(opLiteral.getText() + intLiteral.getText()))),
                opLiteral
        );
    }

    ScopedExprGen createFalse(Token t) {
        return a -> assertValue(a, GenInterface.lift(IntLiteralNodeFactory.create(0)), t);
    }

    ScopedExprGen createTrue(Token t) {
        return a -> assertValue(a, GenInterface.lift(IntLiteralNodeFactory.create(1)), t);
    }

    private static String fromStringLiteral(String quotedLit) {
        return quotedLit.substring(1, quotedLit.length() - 1).replace("\"\"", "\"");
    }

    ScopedExprGen createStringLiteral(Token strLiteral) {
        String lit = fromStringLiteral(strLiteral.getText());
        return a ->
                assertValue(a, GenInterface.lift(StringLiteralNodeFactory.create(lit)), strLiteral);
    }

    ScopedExprGen createCharLiteral(Token charLiteral) {
        String quotedLit = charLiteral.getText();
        String lit = quotedLit.substring(1, quotedLit.length() - 1);
        return a -> assertValue(a, GenInterface.lift(IntLiteralNodeFactory.create(lit.charAt(0))), charLiteral);
    }

    ScopedExprGen createBinary(Token opToken, ScopedExprGen left, ScopedExprGen right) {
        var scope = lexicalScope;
        var lhsCat = LamaOperators.op2cat(opToken.getText());
        // capture scope
        return genValue(
                GenInterface.lift3(
                        v -> scope.find(opToken.getText())
                                .orElseThrow(() -> newSemErr(opToken, "operator not in scope"))
                                .get().generate(ValueCategory.Val),
                        GenInterface.konst(left, lhsCat),
                        GenInterface.konst(right, ValueCategory.Val),
                        (op, l, r) ->
                                GenInterface.lift2(l, r, (ln, rn) -> lhsCat == ValueCategory.Ref
                                        ? BUILTIN_OPERATOR_INFO.stream().map(Pair::getRight)
                                            .flatMap(m -> Optional.ofNullable(m.get(opToken.getText())).stream())
                                            .findFirst().orElseThrow(() -> newSemErr(opToken, "operator not in scope"))
                                            .createNode((Object) new LamaNode[]{ln, rn})
                                        : createCallNode(op, new LamaNode[]{ln, rn}))),
                opToken
        )::generate;
    }

    ScopedExprGen createUnary(Token opToken, ScopedExprGen expr) {
        return genValue(
                GenInterface.map(
                        GenInterface.konst(expr, ValueCategory.Val),
                        e -> GenInterface.map(e, en ->
                                (LamaNode) Optional.ofNullable(BUILTIN_UNARY_OPERATOR_INFO.get(opToken.getText()))
                                        .orElseThrow(() -> newSemErr(opToken, "operator not in scope"))
                                        .createNode((Object) new LamaNode[]{en}))),
                opToken
        )::generate;
    }

    ScopedExprGen createInfix(Token opToken) {
        return createSymbol(opToken);
    }

    ScopedExprGen createSymbol(String name, Token t) {
        var scope = lexicalScope;

        // capture scope
        return a -> {
            var lookup = scope.find(name).orElseThrow(() -> newSemErr(t, "variable not in scope"))
                    .get();
            return GenInterface.konst(lookup, a);
        };
    }

    ScopedExprGen createSymbol(Token name) {
        return createSymbol(name.getText(), name);
    }

    ScopedExprGen createElement(ScopedExprGen arr, ScopedExprGen index) {
        return GenInterface.lift3(
                (ValueCategory a) -> a,
                GenInterface.forget(GenInterface.konst(arr, ValueCategory.Val)),
                GenInterface.forget(GenInterface.konst(index, ValueCategory.Val)),
                (a, ar, in) -> GenInterface.lift2(ar, in,
                        (arn, inn) -> switch (a) {
                            case Val -> ReadElementNodeFactory.create(arn, inn);
                            case Ref -> LamaRef.element(arn, inn);
                        }
                )
        )::generate;
    }

    private LamaNode createCallNode(LamaNode func, LamaNode[] args) {
        return new InvokeNode(func, args);
    }

    ScopedExprGen createCall(ScopedExprGen function, List<ScopedExprGen> parameters, Token t) {
        var functionGen = GenInterface.konst(function, ValueCategory.Val);
        var parametersGen = GenInterface.konst(
                GenInterface.map(GenInterfaces.sequence(parameters), GenInterfaces::sequence),
                ValueCategory.Val
        );
        return genValue(
                GenInterface.lift2(functionGen, parametersGen, (fn, pn) ->
                        GenInterface.lift2(fn, pn, (functionNode, parameterNodes) ->
                                createCallNode(functionNode, parameterNodes.toArray(LamaNode[]::new)))),
                t
        )::generate;
    }

    // elsePart is optional (can be `skip`)
    ScopedExprGen createIfThenElse(
            ScopedExprGen condition,
            ScopedExprGen then,
            ScopedExprGen elsePart
    ) {
        return GenInterface.lift3(
                GenInterface.forget(GenInterface.konst(condition, ValueCategory.Val)),
                then, elsePart,
                (c, t, e) -> GenInterface.lift3(c, t, e == null ? v -> null : e,
                        (cn, tn, en) -> (LamaNode) IfNodeFactory.create(cn, tn, en))
        )::generate;
    }

    ScopedExprGen createWhileDo(
            ScopedExprGen condition,
            ScopedExprGen body,
            Token t
    ) {
        return genValue(
                GenInterface.lift2(
                        GenInterface.konst(condition, ValueCategory.Val),
                        GenInterface.konst(body, ValueCategory.Val),
                        (cn, bn) ->
                        GenInterface.lift2(cn, bn, (conditionNode, bodyNode) ->
                                (LamaNode) new WhileDoNode(conditionNode, bodyNode))),
                t
        )::generate;
    }

    ScopedExprGen createDoWhile(
            ScopedExprGen body,
            ScopedExprGen condition,
            Token t
    ) {
        return genValue(
                GenInterface.lift2(
                        GenInterface.konst(body, ValueCategory.Val),
                        GenInterface.konst(condition, ValueCategory.Val),
                        (bn, cn) ->
                                GenInterface.lift2(bn, cn, (bodyNode, conditionNode) ->
                                        (LamaNode) new DoWhileNode(bodyNode, conditionNode))),
                t
        )::generate;
    }

    ScopedExprGen createForLoop(
            ScopedExprGen init,
            ScopedExprGen condition,
            ScopedExprGen step,
            ScopedExprGen body,
            Token t
    ) {
        return genValue(
                GenInterface.lift4(
                        GenInterface.konst(init, ValueCategory.Val),
                        GenInterface.konst(condition, ValueCategory.Val),
                        GenInterface.konst(step, ValueCategory.Val),
                        GenInterface.konst(body, ValueCategory.Val),
                        (in, cn, sn, bn) ->
                                GenInterface.lift4(in, cn, sn, bn, (i, c, s, b) -> (LamaNode) new ForNode(i, c, s, b))),
                t
        )::generate;
    }

    ScopedExprGen createArray(ScopedValsGen vals, Token t) {
        return genValue(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> (LamaNode) new ArrayNode(n.toArray(LamaNode[]::new))
                )),
                t
        )::generate;
    }

    ScopedExprGen createSExp(String name, ScopedValsGen vals, Token t) {
        return genValue(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> (LamaNode) new SExpNode(name, n.toArray(LamaNode[]::new))
                )),
                t
        )::generate;
    }

    private static <T, R> R reduceRight(List<T> list, BiFunction<T, R, R> op, R accum) {
        for (var x : list.reversed()) {
            accum = op.apply(x, accum);
        }
        return accum;
    }

    ScopedExprGen createList(ScopedValsGen vals, Token t) {
        return genValue(
                GenInterface.map(vals, l -> GenInterface.map(
                        GenInterfaces.sequence(l),
                        n -> reduceRight(
                                n,
                                (lhs, rhs) -> ConsNodeFactory.create(new LamaNode[]{lhs, rhs}),
                                (LamaNode) IntLiteralNodeFactory.create(0)
                        )
                )),
                t
        )::generate;
    }

    ScopedExprGen createPatternMatch(ScopedExprGen what, List<Pair<PatGen, ScopedExprGen>> matches) {
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
                            PatternMatchBaseNode match = PatternMatchEmptyNodeFactory.create(whatNode);
                            for (var m : matchesNodes) {
                                // safe to generate PatGen here because they don't influence closures
                                match = PatternMatchNodeFactory.create(whatNode, match, m.getLeft().apply(whatNode), m.getRight());
                            }
                            return (LamaNode) match;
                        })
        )::generate;
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

    String freshName() {
        return "_" + java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
