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

scopeExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    { factory.startBlock(); }
    scopeDefinitions
    expression  { $result = factory.finishBlock($expression.result); }
;

scopeExpression0 returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    { factory.startBlock(); }
    scopeDefinitions
    { GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> gen = GenInterfaces.of(); }
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

variableDefinitionItem returns [Token name, GenInterface<ValueCategory, GenInterface<Void, LamaNode>> value] :
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
        '(' functionPatArguments ')' { var c = factory.startFunctionPat($functionPatArguments.result, $name, $t); }
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

functionPatArguments returns [List<PatGen> result] :
    { $result = new ArrayList<>(); }
    (
        pattern         { $result.add($pattern.result); }
        (
            ',' pattern { $result.add($pattern.result); }
        )*
    )?
;

functionBody returns [GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> result] :
    scopeDefinitions
    { $result = GenInterfaces.of(); }
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

expression returns [GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> result] :
    basicExpression[0] { $result = GenInterfaces.of($basicExpression.result); }
    |
    basicExpression[0] { $result = GenInterfaces.of($basicExpression.result); }
    ';' expression     { $result = GenInterfaces.concat(GenInterface.konst($result, ValueCategory.Val), $expression.result); }
;

basicExpression [int _p] returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    primaryExpression { $result = $primaryExpression.result; }
    (
        {factory.getPrecedence(_input.LT(1)) >= $_p}?
        op=OP rhs=basicExpression[factory.getNextPrecedence($op)] // TODO: fix non-assoc
        { $result = factory.createBinary($op, $result, $rhs.result); }
    )*
;

primaryExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    primary { $result = $primary.result; }
    (
        '[' expression ']' { $result = factory.createElement($result, factory.finishSeq($expression.result)); }
        |
        functionParams { $result = factory.createCall($result, $functionParams.args, $functionParams.t); }
        |
        t='.' LIDENT { List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> args = new ArrayList<>(); args.add($result); }
        (
            functionParams { args.addAll($functionParams.args); }
        )?
        { $result = factory.createCall(factory.createRead($LIDENT), args, $t); }
    )*
;

functionParams returns [List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> args, Token t] :
    tt='(' { $args = new ArrayList<>(); $t = $tt; }
    (
        scopeExpression { $args.add($scopeExpression.result); }
        (
            ',' scopeExpression { $args.add($scopeExpression.result); }
        )*
    )?
    ')'
;

primary returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    d=DECIMAL { $result = factory.createIntLiteral($d); } |
    s=STRING { $result = factory.createStringLiteral($s); } |
    c=CHAR { $result = factory.createCharLiteral($c); } |
    i=LIDENT { $result = factory.createRead($i); } |
    'infix' OP { $result = factory.createInfix($OP); }
    |
    t='fun'
    functionArgumentsAndBody["<lambda>", $t]
    { $result = factory.genValue($functionArgumentsAndBody.result.instantiate(), $t); }
    |
    t='skip' { $result = factory.createSkip($t); } |
    op=OP d=DECIMAL { $result = factory.createIntLiteral($op, $d); } |
    OP basicExpression[0] | // TODO: fix!!!
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

ifExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    { GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; }
    t='if' expression
    'then' scopeExpression
    { falsePart = factory.createSkip($t); }
    (
        elsePart { falsePart = $elsePart.result; }
    )?
    { $result = factory.createIfThenElse(factory.finishSeq($expression.result), $scopeExpression.result, falsePart); }
    'fi'
;

elsePart returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    { GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; }
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

whileDoExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='while' expression
    'do' scopeExpression
    { $result = factory.createWhileDo(factory.finishSeq($expression.result), $scopeExpression.result, $t); }
    'od'
;

doWhileExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='do' { var scope = factory.startBlock(); }
    defs=scopeDefinitions
    { factory.startBlock(); factory.pullLocalValues(scope); }
    { GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body = GenInterfaces.of(); }
    (
        expression { body = $expression.result; }
    )?
    { GenInterface<ValueCategory, GenInterface<Void, LamaNode>> bodyNode = factory.finishBlock(body); }
    'while' cond=expression
    { $result = factory.finishBlock(GenInterfaces.of(
              factory.createDoWhile(bodyNode, factory.finishSeq($cond.result), $t)
      )); }
    'od'
;

forExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='for' { factory.startBlock(); }
    defs=scopeDefinitions
    { GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> init = GenInterfaces.of(); }
    (
        expression { init = $expression.result; }
    )?
    { GenInterface<ValueCategory, GenInterface<Void, LamaNode>> initNode = factory.finishSeq(init); }
    ',' cond=expression
    ',' step=expression
    'do' scopeExpression0
    { $result = factory.finishBlock(GenInterfaces.of(
              factory.createForLoop(initNode, factory.finishSeq($cond.result), factory.finishSeq($step.result), $scopeExpression0.result, $t)
      )); }
    'od'
;

arrayExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='[' { GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); }
    (
        expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        (
            ',' expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        )*
    )?
    ']' { $result = factory.createArray(vals, $t); }
;

sExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t=UIDENT
    { GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); }
    (
        '(' expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        (
            ',' expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        )*
        ')'
    )?
    { $result = factory.createSExp($t.getText(), vals, $t); }
;

listExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='{'
    { GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); }
    (
        expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        (
            ',' expression { vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq($expression.result), ValueCategory.Val)); }
        )*
    )? '}'
    { $result = factory.createList(vals, $t); }
;

caseExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    'case' expression
    'of' caseBranches
    'esac'
    { $result = factory.createPatternMatch(factory.finishSeq($expression.result), $caseBranches.result); }
;

caseBranches returns [List<Pair<PatGen, GenInterface<ValueCategory, GenInterface<Void, LamaNode>>>> result] :
    { $result = new ArrayList<>(); }
    caseBranch { $result.add(Pair.create($caseBranch.pat, $caseBranch.returns)); }
    (
        '|' caseBranch { $result.add(Pair.create($caseBranch.pat, $caseBranch.returns)); }
    )*
;

caseBranch returns [PatGen pat, GenInterface<ValueCategory, GenInterface<Void, LamaNode>> returns] :
    { factory.startBlock(); }
    pattern { $pat = $pattern.result; } '->'
    scopeExpression { $returns = factory.finishBlock(GenInterfaces.of($scopeExpression.result)); }
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

listPattern returns [PatGen result] :
    '{'
    { List<PatGen> pats = new ArrayList<>(); }
    (
        pattern { pats.add($pattern.result); }
        (
            ',' pattern { pats.add($pattern.result); }
        )*
    )? '}'
    { $result = factory.createListPattern(pats); }
;

wildcardPattern returns [PatGen result] :
    '_' { $result = factory.createWildcardPattern(); }
;

sExpPattern returns [PatGen result] :
    t=UIDENT
    { List<PatGen> pats = new ArrayList<>(); }
    (
        '(' pattern { pats.add($pattern.result); }
        (
            ',' pattern { pats.add($pattern.result); }
        )*
        ')'
    )?
    { $result = factory.createSExpPattern($t.getText(), pats); }
;

arrayPattern returns [PatGen result] :
    '[' { List<PatGen> pats = new ArrayList<>(); }
    (
        pattern { pats.add($pattern.result); }
        (
            ',' pattern { pats.add($pattern.result); }
        )*
    )? ']'
    { $result = factory.createArrayPattern(pats); }
;

etaExpression returns [GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result] :
    t='eta' { String synthName = factory.freshName(); factory.startFunction(List.of(synthName), "<eta>"); }
    basicExpression[0]
    {
      var params = List.of(factory.createRead(synthName, $t));
      var func = $basicExpression.result;
      var fun = factory.finishFunction(GenInterfaces.of(factory.createCall(func, params, $t))).instantiate();
      $result = factory.genValue(fun, $t);
    }
;

/*
function
:
'function'
IDENTIFIER
s='('
                                                { factory.startFunction($IDENTIFIER, $s); }
(
    IDENTIFIER                                  { factory.addFormalParameter($IDENTIFIER); }
    (
        ','
        IDENTIFIER                              { factory.addFormalParameter($IDENTIFIER); }
    )*
)?
')'
body=block[false]                               { factory.finishFunction($body.result); }
;



block [boolean inLoop] returns [SLStatementNode result]
:                                               { factory.startBlock();
                                                  List<SLStatementNode> body = new ArrayList<>(); }
s='{'
(
    statement[inLoop]                           { body.add($statement.result); }
)*
e='}'
                                                { $result = factory.finishBlock(body, $s.getStartIndex(), $e.getStopIndex() - $s.getStartIndex() + 1); }
;


statement [boolean inLoop] returns [SLStatementNode result]
:
(
    while_statement                             { $result = $while_statement.result; }
|
    b='break'                                   { if (inLoop) { $result = factory.createBreak($b); } else { SemErr($b, "break used outside of loop"); } }
    ';'
|
    c='continue'                                { if (inLoop) { $result = factory.createContinue($c); } else { SemErr($c, "continue used outside of loop"); } }
    ';'
|
    if_statement[inLoop]                        { $result = $if_statement.result; }
|
    return_statement                            { $result = $return_statement.result; }
|
    expression ';'                              { $result = $expression.result; }
|
    d='debugger'                                { $result = factory.createDebugger($d); }
    ';'
)
;


while_statement returns [SLStatementNode result]
:
w='while'
'('
condition=expression
')'
body=block[true]                                { $result = factory.createWhile($w, $condition.result, $body.result); }
;


if_statement [boolean inLoop] returns [SLStatementNode result]
:
i='if'
'('
condition=expression
')'
then=block[inLoop]                              { SLStatementNode elsePart = null; }
(
    'else'
    block[inLoop]                               { elsePart = $block.result; }
)?                                              { $result = factory.createIf($i, $condition.result, $then.result, elsePart); }
;


return_statement returns [SLStatementNode result]
:
r='return'                                      { SLExpressionNode value = null; }
(
    expression                                  { value = $expression.result; }
)?                                              { $result = factory.createReturn($r, value); }
';'
;


expression returns [SLExpressionNode result]
:
logic_term                                      { $result = $logic_term.result; }
(
    op='||'
    logic_term                                  { $result = factory.createBinary($op, $result, $logic_term.result); }
)*
;


logic_term returns [SLExpressionNode result]
:
logic_factor                                    { $result = $logic_factor.result; }
(
    op='&&'
    logic_factor                                { $result = factory.createBinary($op, $result, $logic_factor.result); }
)*
;


logic_factor returns [SLExpressionNode result]
:
arithmetic                                      { $result = $arithmetic.result; }
(
    op=('<' | '<=' | '>' | '>=' | '==' | '!=' )
    arithmetic                                  { $result = factory.createBinary($op, $result, $arithmetic.result); }
)?
;


arithmetic returns [SLExpressionNode result]
:
term                                            { $result = $term.result; }
(
    op=('+' | '-')
    term                                        { $result = factory.createBinary($op, $result, $term.result); }
)*
;


term returns [SLExpressionNode result]
:
factor                                          { $result = $factor.result; }
(
    op=('*' | '/')
    factor                                      { $result = factory.createBinary($op, $result, $factor.result); }
)*
;


factor returns [SLExpressionNode result]
:
(
    IDENTIFIER                                  { SLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
    (
        member_expression[null, null, assignmentName] { $result = $member_expression.result; }
    |
                                                { $result = factory.createRead(assignmentName); }
    )
|
    STRING_LITERAL                              { $result = factory.createStringLiteral($STRING_LITERAL, true); }
|
    NUMERIC_LITERAL                             { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
|
    s='('
    expr=expression
    e=')'                                       { $result = factory.createParenExpression($expr.result, $s.getStartIndex(), $e.getStopIndex() - $s.getStartIndex() + 1); }
)
;


member_expression [SLExpressionNode r, SLExpressionNode assignmentReceiver, SLExpressionNode assignmentName] returns [SLExpressionNode result]
:                                               { SLExpressionNode receiver = r;
                                                  SLExpressionNode nestedAssignmentName = null; }
(
    '('                                         { List<SLExpressionNode> parameters = new ArrayList<>();
                                                  if (receiver == null) {
                                                      receiver = factory.createRead(assignmentName);
                                                  } }
    (
        expression                              { parameters.add($expression.result); }
        (
            ','
            expression                          { parameters.add($expression.result); }
        )*
    )?
    e=')'
                                                { $result = factory.createCall(receiver, parameters, $e); }
|
    '='
    expression                                  { if (assignmentName == null) {
                                                      SemErr($expression.start, "invalid assignment target");
                                                  } else if (assignmentReceiver == null) {
                                                      $result = factory.createAssignment(assignmentName, $expression.result);
                                                  } else {
                                                      $result = factory.createWriteProperty(assignmentReceiver, assignmentName, $expression.result);
                                                  } }
|
    '.'                                         { if (receiver == null) {
                                                       receiver = factory.createRead(assignmentName);
                                                  } }
    IDENTIFIER
                                                { nestedAssignmentName = factory.createStringLiteral($IDENTIFIER, false);
                                                  $result = factory.createReadProperty(receiver, nestedAssignmentName); }
|
    '['                                         { if (receiver == null) {
                                                      receiver = factory.createRead(assignmentName);
                                                  } }
    expression
                                                { nestedAssignmentName = $expression.result;
                                                  $result = factory.createReadProperty(receiver, nestedAssignmentName); }
    ']'
)
(
    member_expression[$result, receiver, nestedAssignmentName] { $result = $member_expression.result; }
)?
;
*/

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
