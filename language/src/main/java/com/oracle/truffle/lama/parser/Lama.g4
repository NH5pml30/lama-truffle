/*
 * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
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

/*
 * The parser and lexer need to be generated using "mx create-sl-parser".
 */

grammar Lama;

@parser::header
{
// DO NOT MODIFY - generated from Lama.g4 using "mx create-sl-parser"
import java.util.*;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.LamaLanguage;
import com.oracle.truffle.lama.parser.LamaOperators.OpType;
import com.oracle.truffle.lama.parser.LamaNodeFactory.*;
import com.oracle.truffle.lama.nodes.controlflow.match.PatGen;
import org.graalvm.collections.Pair;

}

@lexer::header
{
// DO NOT MODIFY - generated from Lama.g4 using "mx create-sl-parser"
}

@parser::members
{
private LamaNodeFactory factory;
private Source source;

private static final class BailoutErrorListener extends BaseErrorListener {
    private final Source source;
    BailoutErrorListener(Source source) {
        this.source = source;
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
    }
}

public void SemErr(Token token, String message) {
    throw factory.newSemErr(token, message);
}

private static boolean checkPrec(int cur, int low, int high) {
  return cur >= low && cur <= high;
}

private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
    throw LamaNodeFactory.newParseError(source, line, charPositionInLine, token, message);
}

public static CallTarget parseLama(LamaLanguage language, Source source) {
    LamaLexer lexer = new LamaLexer(CharStreams.fromString(source.getCharacters().toString()));
    LamaParser parser = new LamaParser(new CommonTokenStream(lexer));
    lexer.removeErrorListeners();
    parser.removeErrorListeners();
    BailoutErrorListener listener = new BailoutErrorListener(source);
    lexer.addErrorListener(listener);
    parser.addErrorListener(listener);
    parser.factory = new LamaNodeFactory(language, source);
    parser.source = source;
    return parser.compilationUnit().result;
}
}

// parser

compilationUnit returns [CallTarget result] :
    importStt*      { factory.startMain(); }
    functionBody    { $result = factory.finishMain($functionBody.result, _input.LT(1)); }
    EOF
;

importStt :
    'import' UIDENT ';'
;

scopeDefinitions :
    definition*
;

scopeExpression returns [ScopedExprGen result] :
    { factory.startBlock(); }
    scopeDefinitions
    expression  { $result = factory.finishBlock($expression.result); }
;

scopeExpression0 returns [ScopedExprGen result] :
    { factory.startBlock(); }
    scopeDefinitions
    { ScopedExprsGen gen = ScopedsGen.of()::generate; }
    (
        expression
        { gen = $expression.result; }
    )?
    { $result = factory.finishBlock(gen); }
;

definition :
    variableDefinition |
    functionDefinition |
    infixDefinition
;

variableDefinition :
    ('var' | 'public')
    variableDefinitionSequence ';'
;

variableDefinitionSequence :
    variableDefinitionItem { factory.addLocal($variableDefinitionItem.name, $variableDefinitionItem.value); }
    (
        ',' variableDefinitionItem { factory.addLocal($variableDefinitionItem.name, $variableDefinitionItem.value); }
    )*
;

variableDefinitionItem returns [Token name, ScopedExprGen value] :
    LIDENT { $name = $LIDENT; $value = factory.createSkip($LIDENT); }
    |
    LIDENT '=' basicExpression[0] { $name = $LIDENT; $value = $basicExpression.result; }
;

functionDefinition :
    'public'?
    t='fun' name=LIDENT
    functionArgumentsAndBody[$name.getText(), $t] { factory.addFun($name.getText(), $functionArgumentsAndBody.result); }
;

functionArgumentsAndBody [String name, Token t] returns [Fun result] :
    (
        '(' functionArguments ')' { factory.startFunction($functionArguments.result, $name); }
        '{' functionBody '}'      { $result = factory.finishFunction($functionBody.result); }
    |
        '(' patList ')' { var c = factory.startFunctionPat($patList.result, $name, $t); }
        '{' functionBody '}'         { $result = factory.finishFunction(c.generate($functionBody.result)); }
    )
;

functionArguments returns [List<String> result] :
    { $result = new ArrayList<>(); }
    (
        LIDENT         { $result.add($LIDENT.getText()); }
        (
            ',' LIDENT { $result.add($LIDENT.getText()); }
        )*
    )?
;

functionBody returns [ScopedExprsGen result] :
    scopeDefinitions
    { $result = ScopedsGen.of()::generate; }
    (
        expression
        { $result = $expression.result; }
    )?
;

infixDefinition :
    'public'? infixity name=OP level
    functionArgumentsAndBody[$name.getText(), $name] { factory.addFun($name.getText(), $functionArgumentsAndBody.result); }
    // add operator eagerly for parsing
    { factory.addOp($name, $infixity.result, $level.relOp, $level.rel); }
;

infixity returns [OpType result] :
    'infix'  { $result = OpType.InfixNone; } |
    'infixl' { $result = OpType.InfixLeft; } |
    'infixr' { $result = OpType.InfixRight; }
;

level returns [Token relOp, int rel] :
    ('at' { $rel = 0; } | 'before' { $rel = -1; } | 'after' { $rel = 1; })
    OP { $relOp = $OP; }
;

expression returns [ScopedExprsGen result] :
    basicExpression[0] { $result = ScopedsGen.of($basicExpression.result)::generate; }
    |
    first=expression ';'
    basicExpression[0]
    { $result = ScopedsGen.add(ExprGen.konstVal($first.result), $basicExpression.result)::generate; }
;

basicExpression [int _p] returns [ScopedExprGen result, int _r] :
    primaryExpression { $result = $primaryExpression.result; $_r = Integer.MAX_VALUE; }
    (
        {checkPrec(factory.getPrecedence(_input.LT(1)), $_p, $_r)}?
        op=OP rhs=basicExpression[factory.getRightPrecedence($op)]
        { $result = factory.createBinary($op, $result, $rhs.result); }
        { $_r = factory.getNextPrecedence($op); }
    )*
;

primaryExpression returns [ScopedExprGen result] :
    primary { $result = $primary.result; }
    (
        '[' expression ']' { $result = factory.createElement($result, factory.finishSeq($expression.result)); }
        |
        functionParams { $result = factory.createCall($result, $functionParams.args, $functionParams.t); }
        |
        t='.' LIDENT { List<ScopedExprGen> args = new ArrayList<>(); args.add($result); }
        (
            functionParams { args.addAll($functionParams.args); }
        )?
        { $result = factory.createCall(factory.createSymbol($LIDENT), args, $t); }
    )*
;

functionParams returns [List<ScopedExprGen> args, Token t] :
    tt='(' { $args = new ArrayList<>(); $t = $tt; }
    (
        scopeExpression { $args.add($scopeExpression.result); }
        (
            ',' scopeExpression { $args.add($scopeExpression.result); }
        )*
    )?
    ')'
;

primary returns [ScopedExprGen result] :
    d=DECIMAL { $result = factory.createIntLiteral($d); } |
    s=STRING { $result = factory.createStringLiteral($s); } |
    c=CHAR { $result = factory.createCharLiteral($c); } |
    i=LIDENT { $result = factory.createSymbol($i); } |
    tru='true' { $result = factory.createTrue($tru); } |
    fls='false' { $result = factory.createFalse($fls); } |
    'infix' OP { $result = factory.createInfix($OP); }
    |
    t='fun'
    functionArgumentsAndBody["<lambda>", $t]
    { $result = factory.genValue($functionArgumentsAndBody.result.instantiate(), $t)::generate; }
    |
    t='skip' { $result = factory.createSkip($t); } |
    op=OP d=DECIMAL { $result = factory.createIntLiteral($op, $d); } |
    OP basicExpression[0] { $result = factory.createUnary($OP, $basicExpression.result); } |
    '(' scopeExpression ')' { $result = $scopeExpression.result; } |
    listExpression { $result = $listExpression.result; } |
    arrayExpression { $result = $arrayExpression.result; } |
    sExpression { $result = $sExpression.result; } |
    ifExpression { $result = $ifExpression.result; } |
    whileDoExpression { $result = $whileDoExpression.result; } |
    doWhileExpression { $result = $doWhileExpression.result; } |
    forExpression { $result = $forExpression.result; } |
    caseExpression { $result = $caseExpression.result; } |
    etaExpression { $result = $etaExpression.result; }
;

ifExpression returns [ScopedExprGen result] :
    { ScopedExprGen falsePart; }
    t='if' expression
    'then' scopeExpression
    { falsePart = factory.createSkip($t); }
    (
        elsePart { falsePart = $elsePart.result; }
    )?
    { $result = factory.createIfThenElse(factory.finishSeq($expression.result), $scopeExpression.result, falsePart); }
    'fi'
;

elsePart returns [ScopedExprGen result] :
    { ScopedExprGen falsePart; }
    t='elif' expression
    'then' scopeExpression
    { falsePart = factory.createSkip($t); }
    (
        elsePart { falsePart = $elsePart.result; }
    )?
    { $result = factory.createIfThenElse(factory.finishSeq($expression.result), $scopeExpression.result, falsePart); }
    |
    'else' scopeExpression { $result = $scopeExpression.result; }
;

whileDoExpression returns [ScopedExprGen result] :
    t='while' expression
    'do' scopeExpression
    { $result = factory.createWhileDo(factory.finishSeq($expression.result), $scopeExpression.result, $t); }
    'od'
;

doWhileExpression returns [ScopedExprGen result] :
    t='do' { var scope = factory.startBlock(); }
    defs=scopeDefinitions
    { factory.startBlock(); factory.pullLocalValues(scope); }
    { ScopedExprsGen body = ScopedsGen.of()::generate; }
    (
        expression { body = $expression.result; }
    )?
    { ScopedExprGen bodyNode = factory.finishBlock(body); }
    'while' cond=expression
    { $result = factory.finishBlock(ScopedsGen.of(
              factory.createDoWhile(bodyNode, factory.finishSeq($cond.result), $t)
      )::generate); }
    'od'
;

forExpression returns [ScopedExprGen result] :
    t='for' { factory.startBlock(); }
    defs=scopeDefinitions
    { ScopedExprsGen init = ScopedsGen.of()::generate; }
    (
        expression { init = $expression.result; }
    )?
    { ScopedExprGen initNode = factory.finishSeq(init); }
    ',' cond=expression
    ',' step=expression
    'do' scopeExpression0
    { $result = factory.finishBlock(ScopedsGen.of(
              factory.createForLoop(initNode, factory.finishSeq($cond.result), factory.finishSeq($step.result), $scopeExpression0.result, $t)
      )::generate); }
    'od'
;

valList returns [List<ScopedValGen> result] :
    { $result = new ArrayList<>(); }
    (
        expression { $result.add(ExprGen.konstVal(factory.finishSeq($expression.result))::generate); }
        (
            ',' expression { $result.add(ExprGen.konstVal(factory.finishSeq($expression.result))::generate); }
        )*
    )?
;

arrayExpression returns [ScopedExprGen result] :
    t='[' valList ']'
    { $result = factory.createArray($valList.result, $t); }
;

sExpression returns [ScopedExprGen result] :
    t=UIDENT { List<ScopedValGen> vals = List.of(); }
    (
      '(' valList ')' { vals = $valList.result; }
    )?
    { $result = factory.createSExp($t.getText(), vals, $t); }
;

listExpression returns [ScopedExprGen result] :
    t='{' valList '}'
    { $result = factory.createList($valList.result, $t); }
;

caseExpression returns [ScopedExprGen result] :
    'case' expression
    'of' caseBranches
    'esac'
    { $result = factory.createPatternMatch(factory.finishSeq($expression.result), $caseBranches.result); }
;

caseBranches returns [List<Pair<PatGen, ScopedExprGen>> result] :
    { $result = new ArrayList<>(); }
    caseBranch { $result.add(Pair.create($caseBranch.pat, $caseBranch.returns)); }
    (
        '|' caseBranch { $result.add(Pair.create($caseBranch.pat, $caseBranch.returns)); }
    )*
;

caseBranch returns [PatGen pat, ScopedExprGen returns] :
    { factory.startBlock(); }
    pattern { $pat = $pattern.result; } '->'
    scopeExpression { $returns = factory.finishBlock(ScopedsGen.of($scopeExpression.result)::generate); }
;

pattern returns [PatGen result] :
    simplePattern { $result = $simplePattern.result; } |
    consPattern { $result = $consPattern.result; }
;

simplePattern returns [PatGen result] :
    wildcardPattern { $result = $wildcardPattern.result; } |
    sExpPattern { $result = $sExpPattern.result; } |
    arrayPattern { $result = $arrayPattern.result; } |
    listPattern { $result = $listPattern.result; }
    |
    name=LIDENT { factory.tryAddLocal($name, factory.createSkip($name)); PatGen bind = factory.createWildcardPattern(); }
    ('@' pattern { bind = $pattern.result; } )?
    { $result = factory.createBindPattern($name, bind); }
    |
    d=DECIMAL { $result = factory.createIntValPattern($d.getText()); } |
    op=OP d=DECIMAL { $result = factory.createIntValPattern($op.getText() + $d.getText()); } |
    tru='true' { $result = factory.createIntValPattern("1"); } |
    fls='false' { $result = factory.createIntValPattern("0"); } |
    s=STRING { $result = factory.createStrValPattern($s.getText()); }
    |
    '#fun' { $result = factory.createFunPattern(); } |
    '#val' { $result = factory.createValPattern(); } |
    '#str' { $result = factory.createStrPattern(); } |
    '(' pattern ')' { $result = $pattern.result; }
;

consPattern returns [PatGen result] :
    simplePattern OP {$OP.getText().equals(":")}? pattern { $result = factory.createConsPattern($simplePattern.result, $pattern.result); }
;

patList returns [List<PatGen> result] :
    { $result = new ArrayList<>(); }
    (
        pattern { $result.add($pattern.result); }
        (
            ',' pattern { $result.add($pattern.result); }
        )*
    )?
;

listPattern returns [PatGen result] :
    '{' patList '}'
    { $result = factory.createListPattern($patList.result); }
;

wildcardPattern returns [PatGen result] :
    '_' { $result = factory.createWildcardPattern(); }
;

sExpPattern returns [PatGen result] :
    t=UIDENT { List<PatGen> pats = List.of(); }
    (
        '(' patList ')' { pats = $patList.result; }
    )?
    { $result = factory.createSExpPattern($t.getText(), pats); }
;

arrayPattern returns [PatGen result] :
    '[' patList ']'
    { $result = factory.createArrayPattern($patList.result); }
;

etaExpression returns [ScopedExprGen result] :
    t='eta' { String synthName = factory.freshName(); factory.startFunction(List.of(synthName), "<eta>"); }
    basicExpression[0]
    {
      var params = List.of(factory.createSymbol(synthName, $t));
      var func = $basicExpression.result;
      var fun = factory.finishFunction(ScopedsGen.of(factory.createCall(func, params, $t))::generate).instantiate();
      $result = factory.genValue(fun, $t)::generate;
    }
;

// lexer

WS : [ \t\r\n\u000C]+ -> skip;
COMMENT : '(*' .*? '*)' -> skip;
LINE_COMMENT : '--' ~[\r\n]* -> skip;

fragment ULETTER : [A-Z];
fragment LLETTER : [a-z];
fragment LETTER : [A-Z] | [a-z] | '_';
fragment DIGIT : [0-9];
fragment STRING_CHAR : ~'"' | '""';
fragment CHAR_CHAR : ~'\'' | '\'\'' | '\\n' | '\\t';
fragment OP_CHAR : [+\-*/:=<>!&%];

UIDENT : ULETTER (LETTER | DIGIT)*;
LIDENT : LLETTER (LETTER | DIGIT)*;
DECIMAL : DIGIT+;
STRING : '"' STRING_CHAR* '"';
CHAR : '\'' CHAR_CHAR '\'';
OP : OP_CHAR+;
