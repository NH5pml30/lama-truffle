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
import com.oracle.truffle.lama.parser.LamaNodeFactory.*;
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

scopeDefinitions returns [Map<String, ExprGen> result] :
    { $result = new HashMap<String, ExprGen>(); }
    (
        definition { $result.putAll($definition.result); }
    )*
;

scopeExpression returns [ExprGen result] :
    { factory.startBlock(); }
    defs=scopeDefinitions { factory.addLocals($defs.result.keySet()); factory.addLocalValues($defs.result); }
    expression  { $result = factory.finishBlock($expression.result); }
;

scopeExpression0 returns [ExprGen result] :
    { factory.startBlock(); }
    defs=scopeDefinitions { factory.addLocals($defs.result.keySet()); factory.addLocalValues($defs.result); }
    { ExprsGen gen = ExprsGen.of(); }
    (
        expression
        { gen = $expression.result; }
    )?
    { $result = factory.finishBlock(gen); }
;

definition returns [Map<String, ExprGen> result] :
    variableDefinition { $result = $variableDefinition.result; } |
    functionDefinition { $result = $functionDefinition.result; }
;

variableDefinition returns [Map<String, ExprGen> result] :
    ('var' | 'public')
    variableDefinitionSequence ';' { $result = $variableDefinitionSequence.result; }
;

variableDefinitionSequence returns [Map<String, ExprGen> result] :
    { $result = new HashMap<String, ExprGen>(); }
    variableDefinitionItem { $result.put($variableDefinitionItem.name, $variableDefinitionItem.value); }
    (
        ',' variableDefinitionItem { $result.put($variableDefinitionItem.name, $variableDefinitionItem.value); }
    )*
;

variableDefinitionItem returns [String name, ExprGen value] :
    LIDENT { $name = $LIDENT.getText(); $value = a -> null; }
    |
    LIDENT '=' basicExpression[0] { $name = $LIDENT.getText(); $value = $basicExpression.result; }
;

functionDefinition returns [Map<String, ExprGen> result] :
    { $result = new HashMap<String, ExprGen>(); }
    'public'?
    t='fun' name=LIDENT
    '(' functionArguments ')' { factory.startFunction($functionArguments.result); }
    '{' functionBody '}'      { $result.put($name.getText(), factory.finishFunction($functionBody.result, $t)); }
;

functionArguments returns [List<Token> result] :
    { $result = new ArrayList<Token>(); }
    (
        LIDENT         { $result.add($LIDENT); }
        (
            ',' LIDENT { $result.add($LIDENT); }
        )*
    )?
;

functionBody returns [ExprsGen result] :
    defs=scopeDefinitions { factory.addLocals($defs.result.keySet()); factory.addLocalValues($defs.result); }
    { $result = ExprsGen.of(); }
    (
        expression
        { $result = $expression.result; }
    )?
;

expression returns [ExprsGen result] :
    basicExpression[0] { $result = ExprsGen.of($basicExpression.result); }
    |
    basicExpression[0] { $result = ExprsGen.of($basicExpression.result); }
    ';' expression     { $result = ExprsGen.add($result, $expression.result); }
;

basicExpression [int _p] returns [ExprGen result] :
    primaryExpression { $result = $primaryExpression.result; }
    (
        {factory.getPrecedence(_input.LT(1)) >= $_p}?
        op=OP rhs=basicExpression[factory.getNextPrecedence($op)] // TODO: fix non-assoc
        { $result = factory.createBinary($op, $result, $rhs.result); }
    )*
;

primaryExpression returns [ExprGen result] :
    primary { $result = $primary.result; }
    (
        '[' expression ']' { $result = factory.createElement($result, factory.finishSeq($expression.result)); }
        |
        functionArgs { $result = factory.createCall($result, $functionArgs.args, $functionArgs.t); }
        |
        t='.' LIDENT { List<ExprGen> args = new ArrayList<ExprGen>(); args.add($result); }
        (
            functionArgs { args.addAll($functionArgs.args); }
        )?
        { $result = factory.createCall(factory.createRead($LIDENT), args, $t); }
    )*
;

functionArgs returns [List<ExprGen> args, Token t] :
    tt='(' { $args = new ArrayList<ExprGen>(); $t = $tt; }
    (
        scopeExpression { $args.add($scopeExpression.result); }
        (
            ',' scopeExpression { $args.add($scopeExpression.result); }
        )*
    )?
    ')'
;

primary returns [ExprGen result] :
    d=DECIMAL { $result = factory.createIntLiteral($d); } |
    s=STRING { $result = factory.createStringLiteral($s); } |
    c=CHAR { $result = factory.createCharLiteral($c); } |
    i=LIDENT { $result = factory.createRead($i); } |
    'true' |
    'false'
    |
    t='fun' '('
    functionArguments { factory.startFunction($functionArguments.result); }
    ')' '{' functionBody '}'  { $result = factory.finishFunction($functionBody.result, $t); }
    |
    'skip' { $result = a -> null; } |
    op=OP d=DECIMAL { $result = factory.createIntLiteral($op, $d); } |
    OP basicExpression[0] |
    '(' scopeExpression ')' { $result = $scopeExpression.result; } |
    // listExpression |
    arrayExpression { $result = $arrayExpression.result; } |
    // sExpression |
    ifExpression { $result = $ifExpression.result; } |
    whileDoExpression { $result = $whileDoExpression.result; } |
    doWhileExpression { $result = $doWhileExpression.result; } |
    forExpression { $result = $forExpression.result; } // |
    // caseExpression
;

ifExpression returns [ExprGen result] :
    { ExprGen falsePart = null; }
    'if' expression
    'then' scopeExpression // TODO: check if it should be a parser error if the block is empty, but assignment happens
    (
        elsePart { falsePart = $elsePart.result; }
    )?
    { $result = factory.createIfThenElse(factory.finishSeq($expression.result), $scopeExpression.result, falsePart); }
    'fi'
;

elsePart returns [ExprGen result] :
    { ExprGen falsePart = null; }
    'elif' expression
    'then' scopeExpression
    (
        elsePart { falsePart = $elsePart.result; }
    )?
    { $result = factory.createIfThenElse(factory.finishSeq($expression.result), $scopeExpression.result, falsePart); }
    |
    'else' scopeExpression { $result = $scopeExpression.result; }
;

whileDoExpression returns [ExprGen result] :
    t='while' expression
    'do' scopeExpression
    { $result = factory.createWhileDo(factory.finishSeq($expression.result), $scopeExpression.result, $t); }
    'od'
;

doWhileExpression returns [ExprGen result] :
    t='do' { factory.startBlock(); }
    defs=scopeDefinitions { factory.addLocals($defs.result.keySet()); }
    { factory.startBlock(); factory.addLocalValues($defs.result); }
    { ExprsGen body = ExprsGen.of(); }
    (
        expression { body = $expression.result; }
    )?
    { ExprGen bodyNode = factory.finishBlock(body); }
    'while' cond=expression
    { $result = factory.finishBlock(ExprsGen.of(
              factory.createDoWhile(bodyNode, factory.finishSeq($cond.result), $t)
      )); }
    'od'
;

forExpression returns [ExprGen result] :
    t='for' { factory.startBlock(); }
    defs=scopeDefinitions { factory.addLocals($defs.result.keySet()); factory.addLocalValues($defs.result); }
    { ExprsGen init = ExprsGen.of(); }
    (
        expression { init = $expression.result; }
    )?
    { ExprGen initNode = factory.finishSeq(init); }
    ',' cond=expression
    ',' step=expression
    'do' scopeExpression0
    { $result = factory.finishBlock(ExprsGen.of(
              factory.createForLoop(initNode, factory.finishSeq($cond.result), factory.finishSeq($step.result), $scopeExpression0.result, $t)
      )); }
    'od'
;

arrayExpression returns [ExprGen result] :
    t='[' { ExprsGen vals = ExprsGen.of(); }
    (
        expression { vals = ExprsGen.add(vals, factory.finishSeq($expression.result)); }
        (
            ',' expression { vals = ExprsGen.add(vals, factory.finishSeq($expression.result)); }
        )*
    )?
    ']' { $result = factory.createArray(vals, $t); }
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
