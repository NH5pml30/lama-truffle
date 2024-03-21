// Generated from language/src/main/java/com/oracle/truffle/lama/parser/Lama.g4 by ANTLR 4.12.0
package com.oracle.truffle.lama.parser;

// DO NOT MODIFY - generated from Lama.g4 using "mx create-sl-parser"
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.strings.TruffleString;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.LamaLanguage;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LamaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, WS=26, COMMENT=27, LINE_COMMENT=28, UIDENT=29, LIDENT=30, DECIMAL=31, 
		STRING=32, CHAR=33, INFIX=34;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeExpression = 2, 
		RULE_definition = 3, RULE_variableDefinition = 4, RULE_variableDefinitionSequence = 5, 
		RULE_variableDefinitionItem = 6, RULE_functionDefinition = 7, RULE_functionArguments = 8, 
		RULE_functionBody = 9, RULE_expression = 10, RULE_basicExpression = 11, 
		RULE_binaryExpression = 12, RULE_binaryOperand = 13, RULE_minusPostfixExpression = 14, 
		RULE_postfixExpression = 15, RULE_primary = 16, RULE_ifExpression = 17, 
		RULE_elsePart = 18, RULE_whileDoExpression = 19, RULE_doWhileExpression = 20, 
		RULE_forExpression = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeExpression", "definition", "variableDefinition", 
			"variableDefinitionSequence", "variableDefinitionItem", "functionDefinition", 
			"functionArguments", "functionBody", "expression", "basicExpression", 
			"binaryExpression", "binaryOperand", "minusPostfixExpression", "postfixExpression", 
			"primary", "ifExpression", "elsePart", "whileDoExpression", "doWhileExpression", 
			"forExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "';'", "'var'", "'public'", "','", "'='", "'fun'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "'true'", "'false'", "'skip'", 
			"'if'", "'then'", "'fi'", "'elif'", "'else'", "'while'", "'do'", "'od'", 
			"'for'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "COMMENT", "LINE_COMMENT", "UIDENT", "LIDENT", "DECIMAL", 
			"STRING", "CHAR", "INFIX"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lama.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new LamaParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
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

	public LamaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public CallTarget result;
		public ScopeExpressionContext scopeExpression;
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LamaParser.EOF, 0); }
		public List<ImportSttContext> importStt() {
			return getRuleContexts(ImportSttContext.class);
		}
		public ImportSttContext importStt(int i) {
			return getRuleContext(ImportSttContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(44);
				importStt();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(51);
			((CompilationUnitContext)_localctx).scopeExpression = scopeExpression();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).scopeExpression.result); 
			setState(53);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportSttContext extends ParserRuleContext {
		public TerminalNode UIDENT() { return getToken(LamaParser.UIDENT, 0); }
		public ImportSttContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStt; }
	}

	public final ImportSttContext importStt() throws RecognitionException {
		ImportSttContext _localctx = new ImportSttContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importStt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__0);
			setState(56);
			match(UIDENT);
			setState(57);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeExpressionContext extends ParserRuleContext {
		public List<LamaNode> result;
		public ExpressionContext expression;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeExpression; }
	}

	public final ScopeExpressionContext scopeExpression() throws RecognitionException {
		ScopeExpressionContext _localctx = new ScopeExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_scopeExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					definition();
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			 ((ScopeExpressionContext)_localctx).result =  List.of(); 
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(66);
				((ScopeExpressionContext)_localctx).expression = expression();
				}
				break;
			}
			 ((ScopeExpressionContext)_localctx).result =  ((ScopeExpressionContext)_localctx).expression.result; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				functionDefinition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public VariableDefinitionSequenceContext variableDefinitionSequence() {
			return getRuleContext(VariableDefinitionSequenceContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(76);
			variableDefinitionSequence();
			setState(77);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionSequenceContext extends ParserRuleContext {
		public List<VariableDefinitionItemContext> variableDefinitionItem() {
			return getRuleContexts(VariableDefinitionItemContext.class);
		}
		public VariableDefinitionItemContext variableDefinitionItem(int i) {
			return getRuleContext(VariableDefinitionItemContext.class,i);
		}
		public VariableDefinitionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinitionSequence; }
	}

	public final VariableDefinitionSequenceContext variableDefinitionSequence() throws RecognitionException {
		VariableDefinitionSequenceContext _localctx = new VariableDefinitionSequenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDefinitionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			variableDefinitionItem();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(80);
				match(T__4);
				setState(81);
				variableDefinitionItem();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionItemContext extends ParserRuleContext {
		public Token LIDENT;
		public BasicExpressionContext basicExpression;
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public VariableDefinitionItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinitionItem; }
	}

	public final VariableDefinitionItemContext variableDefinitionItem() throws RecognitionException {
		VariableDefinitionItemContext _localctx = new VariableDefinitionItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableDefinitionItem);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 factory.addLocal(((VariableDefinitionItemContext)_localctx).LIDENT, null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(90);
				match(T__5);
				setState(91);
				((VariableDefinitionItemContext)_localctx).basicExpression = basicExpression();
				 factory.addLocal(((VariableDefinitionItemContext)_localctx).LIDENT, ((VariableDefinitionItemContext)_localctx).basicExpression.result); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public LamaNode result;
		public Token name;
		public FunctionArgumentsContext functionArguments;
		public FunctionBodyContext functionBody;
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(96);
				match(T__3);
				}
			}

			setState(99);
			match(T__6);
			setState(100);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(101);
			match(T__7);
			setState(102);
			((FunctionDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(103);
			match(T__8);
			 factory.startFunction(((FunctionDefinitionContext)_localctx).functionArguments.result); 
			setState(105);
			((FunctionDefinitionContext)_localctx).functionBody = functionBody();
			 factory.addLocal(((FunctionDefinitionContext)_localctx).name, factory.finishFunction(((FunctionDefinitionContext)_localctx).functionBody.result)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<Token> result;
		public Token LIDENT;
		public List<TerminalNode> LIDENT() { return getTokens(LamaParser.LIDENT); }
		public TerminalNode LIDENT(int i) {
			return getToken(LamaParser.LIDENT, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsContext)_localctx).result =  new ArrayList<Token>(); 
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(109);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(111);
					match(T__4);
					setState(112);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public List<LamaNode> result;
		public ScopeExpressionContext scopeExpression;
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__9);
			setState(122);
			((FunctionBodyContext)_localctx).scopeExpression = scopeExpression();
			setState(123);
			match(T__10);
			 ((FunctionBodyContext)_localctx).result =  ((FunctionBodyContext)_localctx).scopeExpression.result; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<LamaNode> result;
		public BasicExpressionContext basicExpression;
		public ExpressionContext expression;
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((ExpressionContext)_localctx).basicExpression = basicExpression();
				 ((ExpressionContext)_localctx).result =  new ArrayList<LamaNode>(); _localctx.result.add(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((ExpressionContext)_localctx).basicExpression = basicExpression();
				 ((ExpressionContext)_localctx).result =  new ArrayList<LamaNode>(); _localctx.result.add(((ExpressionContext)_localctx).basicExpression.result); 
				setState(131);
				match(T__1);
				setState(132);
				((ExpressionContext)_localctx).expression = expression();
				 _localctx.result.addAll(((ExpressionContext)_localctx).expression.result); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicExpressionContext extends ParserRuleContext {
		public LamaNode result;
		public BinaryExpressionContext binaryExpression;
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public BasicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExpression; }
	}

	public final BasicExpressionContext basicExpression() throws RecognitionException {
		BasicExpressionContext _localctx = new BasicExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_basicExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((BasicExpressionContext)_localctx).binaryExpression = binaryExpression(0);
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).binaryExpression.result; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpressionContext extends ParserRuleContext {
		public LamaNode result;
		public BinaryExpressionContext lhs1;
		public MinusPostfixExpressionContext lhs2;
		public MinusPostfixExpressionContext minusPostfixExpression;
		public Token op;
		public BinaryOperandContext binaryOperand;
		public BinaryOperandContext binaryOperand() {
			return getRuleContext(BinaryOperandContext.class,0);
		}
		public MinusPostfixExpressionContext minusPostfixExpression() {
			return getRuleContext(MinusPostfixExpressionContext.class,0);
		}
		public TerminalNode INFIX() { return getToken(LamaParser.INFIX, 0); }
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		return binaryExpression(0);
	}

	private BinaryExpressionContext binaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, _parentState);
		BinaryExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_binaryExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(141);
				((BinaryExpressionContext)_localctx).lhs2 = ((BinaryExpressionContext)_localctx).minusPostfixExpression = minusPostfixExpression();
				setState(142);
				((BinaryExpressionContext)_localctx).op = match(INFIX);
				setState(143);
				((BinaryExpressionContext)_localctx).binaryOperand = binaryOperand();
				 ((BinaryExpressionContext)_localctx).result =  factory.createBinary(((BinaryExpressionContext)_localctx).op, ((BinaryExpressionContext)_localctx).lhs2.result, ((BinaryExpressionContext)_localctx).binaryOperand.result); 
				}
				break;
			case 2:
				{
				setState(146);
				((BinaryExpressionContext)_localctx).minusPostfixExpression = minusPostfixExpression();
				 ((BinaryExpressionContext)_localctx).result =  ((BinaryExpressionContext)_localctx).minusPostfixExpression.result; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryExpressionContext(_parentctx, _parentState);
					_localctx.lhs1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_binaryExpression);
					setState(151);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(152);
					((BinaryExpressionContext)_localctx).op = match(INFIX);
					setState(153);
					((BinaryExpressionContext)_localctx).binaryOperand = binaryOperand();
					 ((BinaryExpressionContext)_localctx).result =  factory.createBinary(((BinaryExpressionContext)_localctx).op, ((BinaryExpressionContext)_localctx).lhs1.result, ((BinaryExpressionContext)_localctx).binaryOperand.result); 
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOperandContext extends ParserRuleContext {
		public LamaNode result;
		public BinaryExpressionContext binaryExpression;
		public MinusPostfixExpressionContext minusPostfixExpression;
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public MinusPostfixExpressionContext minusPostfixExpression() {
			return getRuleContext(MinusPostfixExpressionContext.class,0);
		}
		public BinaryOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperand; }
	}

	public final BinaryOperandContext binaryOperand() throws RecognitionException {
		BinaryOperandContext _localctx = new BinaryOperandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_binaryOperand);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				((BinaryOperandContext)_localctx).binaryExpression = binaryExpression(0);
				 ((BinaryOperandContext)_localctx).result =  ((BinaryOperandContext)_localctx).binaryExpression.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				((BinaryOperandContext)_localctx).minusPostfixExpression = minusPostfixExpression();
				 ((BinaryOperandContext)_localctx).result =  ((BinaryOperandContext)_localctx).minusPostfixExpression.result; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MinusPostfixExpressionContext extends ParserRuleContext {
		public LamaNode result;
		public PostfixExpressionContext postfixExpression;
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public MinusPostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minusPostfixExpression; }
	}

	public final MinusPostfixExpressionContext minusPostfixExpression() throws RecognitionException {
		MinusPostfixExpressionContext _localctx = new MinusPostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_minusPostfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((MinusPostfixExpressionContext)_localctx).postfixExpression = postfixExpression(0);
			 ((MinusPostfixExpressionContext)_localctx).result =  ((MinusPostfixExpressionContext)_localctx).postfixExpression.result; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public LamaNode result;
		public PostfixExpressionContext callee;
		public PrimaryContext primary;
		public BasicExpressionContext basicExpression;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public List<BasicExpressionContext> basicExpression() {
			return getRuleContexts(BasicExpressionContext.class);
		}
		public BasicExpressionContext basicExpression(int i) {
			return getRuleContext(BasicExpressionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(173);
			((PostfixExpressionContext)_localctx).primary = primary();
			 ((PostfixExpressionContext)_localctx).result =  ((PostfixExpressionContext)_localctx).primary.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						_localctx.callee = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(176);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(177);
						match(T__7);
						 List<LamaNode> args = new ArrayList<LamaNode>(); 
						setState(190);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16152510848L) != 0)) {
							{
							setState(179);
							((PostfixExpressionContext)_localctx).basicExpression = basicExpression();
							 args.add(((PostfixExpressionContext)_localctx).basicExpression.result); 
							setState(187);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(181);
								match(T__4);
								setState(182);
								((PostfixExpressionContext)_localctx).basicExpression = basicExpression();
								 args.add(((PostfixExpressionContext)_localctx).basicExpression.result); 
								}
								}
								setState(189);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(192);
						match(T__8);
						 ((PostfixExpressionContext)_localctx).result =  factory.createCall(((PostfixExpressionContext)_localctx).callee.result, args); 
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(194);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(195);
						match(T__11);
						setState(196);
						expression();
						setState(197);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LamaNode result;
		public Token d;
		public Token i;
		public TerminalNode DECIMAL() { return getToken(LamaParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(LamaParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LamaParser.CHAR, 0); }
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public WhileDoExpressionContext whileDoExpression() {
			return getRuleContext(WhileDoExpressionContext.class,0);
		}
		public DoWhileExpressionContext doWhileExpression() {
			return getRuleContext(DoWhileExpressionContext.class,0);
		}
		public ForExpressionContext forExpression() {
			return getRuleContext(ForExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(STRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(CHAR);
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(211);
				match(T__14);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(212);
				match(T__6);
				setState(213);
				match(T__7);
				setState(214);
				functionArguments();
				setState(215);
				match(T__8);
				setState(216);
				functionBody();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				match(T__15);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 9);
				{
				setState(219);
				match(T__7);
				setState(220);
				scopeExpression();
				setState(221);
				match(T__8);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 10);
				{
				setState(223);
				ifExpression();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 11);
				{
				setState(224);
				whileDoExpression();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 12);
				{
				setState(225);
				doWhileExpression();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 13);
				{
				setState(226);
				forExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__16);
			setState(230);
			expression();
			setState(231);
			match(T__17);
			setState(232);
			scopeExpression();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==T__20) {
				{
				setState(233);
				elsePart();
				}
			}

			setState(236);
			match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsePartContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elsePart);
		int _la;
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				match(T__19);
				setState(239);
				expression();
				setState(240);
				match(T__17);
				setState(241);
				scopeExpression();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19 || _la==T__20) {
					{
					setState(242);
					elsePart();
					}
				}

				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(T__20);
				setState(246);
				scopeExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileDoExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public WhileDoExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileDoExpression; }
	}

	public final WhileDoExpressionContext whileDoExpression() throws RecognitionException {
		WhileDoExpressionContext _localctx = new WhileDoExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__21);
			setState(250);
			expression();
			setState(251);
			match(T__22);
			setState(252);
			scopeExpression();
			setState(253);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileExpressionContext extends ParserRuleContext {
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DoWhileExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileExpression; }
	}

	public final DoWhileExpressionContext doWhileExpression() throws RecognitionException {
		DoWhileExpressionContext _localctx = new DoWhileExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__22);
			setState(256);
			scopeExpression();
			setState(257);
			match(T__21);
			setState(258);
			expression();
			setState(259);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public List<ScopeExpressionContext> scopeExpression() {
			return getRuleContexts(ScopeExpressionContext.class);
		}
		public ScopeExpressionContext scopeExpression(int i) {
			return getRuleContext(ScopeExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__24);
			setState(262);
			scopeExpression();
			setState(263);
			match(T__4);
			setState(264);
			expression();
			setState(265);
			match(T__4);
			setState(266);
			expression();
			setState(267);
			match(T__22);
			setState(268);
			scopeExpression();
			setState(269);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return binaryExpression_sempred((BinaryExpressionContext)_localctx, predIndex);
		case 15:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binaryExpression_sempred(BinaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u0110\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002=\b\u0002\n\u0002\f\u0002"+
		"@\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002D\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005S\b\u0005\n\u0005\f\u0005V\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006_\b"+
		"\u0006\u0001\u0007\u0003\u0007b\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bs\b\b\n"+
		"\b\f\bv\t\b\u0003\bx\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0088\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0096\b\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u009d\b\f\n\f\f\f\u00a0\t\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a8\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ba\b\u000f\n"+
		"\u000f\f\u000f\u00bd\t\u000f\u0003\u000f\u00bf\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00c8\b\u000f\n\u000f\f\u000f\u00cb\t\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00e4\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00eb\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00f4\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00f8\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0000\u0002\u0018\u001e\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0001\u0001\u0000"+
		"\u0003\u0004\u0119\u0000/\u0001\u0000\u0000\u0000\u00027\u0001\u0000\u0000"+
		"\u0000\u0004>\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\b"+
		"K\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\f^\u0001\u0000\u0000"+
		"\u0000\u000ea\u0001\u0000\u0000\u0000\u0010l\u0001\u0000\u0000\u0000\u0012"+
		"y\u0001\u0000\u0000\u0000\u0014\u0087\u0001\u0000\u0000\u0000\u0016\u0089"+
		"\u0001\u0000\u0000\u0000\u0018\u0095\u0001\u0000\u0000\u0000\u001a\u00a7"+
		"\u0001\u0000\u0000\u0000\u001c\u00a9\u0001\u0000\u0000\u0000\u001e\u00ac"+
		"\u0001\u0000\u0000\u0000 \u00e3\u0001\u0000\u0000\u0000\"\u00e5\u0001"+
		"\u0000\u0000\u0000$\u00f7\u0001\u0000\u0000\u0000&\u00f9\u0001\u0000\u0000"+
		"\u0000(\u00ff\u0001\u0000\u0000\u0000*\u0105\u0001\u0000\u0000\u0000,"+
		".\u0003\u0002\u0001\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0006\u0000\uffff\uffff\u0000"+
		"34\u0003\u0004\u0002\u000045\u0006\u0000\uffff\uffff\u000056\u0005\u0000"+
		"\u0000\u00016\u0001\u0001\u0000\u0000\u000078\u0005\u0001\u0000\u0000"+
		"89\u0005\u001d\u0000\u00009:\u0005\u0002\u0000\u0000:\u0003\u0001\u0000"+
		"\u0000\u0000;=\u0003\u0006\u0003\u0000<;\u0001\u0000\u0000\u0000=@\u0001"+
		"\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000"+
		"?A\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000AC\u0006\u0002\uffff"+
		"\uffff\u0000BD\u0003\u0014\n\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000"+
		"\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0006\u0002\uffff\uffff\u0000"+
		"F\u0005\u0001\u0000\u0000\u0000GJ\u0003\b\u0004\u0000HJ\u0003\u000e\u0007"+
		"\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000J\u0007\u0001"+
		"\u0000\u0000\u0000KL\u0007\u0000\u0000\u0000LM\u0003\n\u0005\u0000MN\u0005"+
		"\u0002\u0000\u0000N\t\u0001\u0000\u0000\u0000OT\u0003\f\u0006\u0000PQ"+
		"\u0005\u0005\u0000\u0000QS\u0003\f\u0006\u0000RP\u0001\u0000\u0000\u0000"+
		"SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000U\u000b\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005"+
		"\u001e\u0000\u0000X_\u0006\u0006\uffff\uffff\u0000YZ\u0005\u001e\u0000"+
		"\u0000Z[\u0005\u0006\u0000\u0000[\\\u0003\u0016\u000b\u0000\\]\u0006\u0006"+
		"\uffff\uffff\u0000]_\u0001\u0000\u0000\u0000^W\u0001\u0000\u0000\u0000"+
		"^Y\u0001\u0000\u0000\u0000_\r\u0001\u0000\u0000\u0000`b\u0005\u0004\u0000"+
		"\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0005\u0007\u0000\u0000de\u0005\u001e\u0000\u0000ef\u0005"+
		"\b\u0000\u0000fg\u0003\u0010\b\u0000gh\u0005\t\u0000\u0000hi\u0006\u0007"+
		"\uffff\uffff\u0000ij\u0003\u0012\t\u0000jk\u0006\u0007\uffff\uffff\u0000"+
		"k\u000f\u0001\u0000\u0000\u0000lw\u0006\b\uffff\uffff\u0000mn\u0005\u001e"+
		"\u0000\u0000nt\u0006\b\uffff\uffff\u0000op\u0005\u0005\u0000\u0000pq\u0005"+
		"\u001e\u0000\u0000qs\u0006\b\uffff\uffff\u0000ro\u0001\u0000\u0000\u0000"+
		"sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wm\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0011\u0001\u0000\u0000\u0000"+
		"yz\u0005\n\u0000\u0000z{\u0003\u0004\u0002\u0000{|\u0005\u000b\u0000\u0000"+
		"|}\u0006\t\uffff\uffff\u0000}\u0013\u0001\u0000\u0000\u0000~\u007f\u0003"+
		"\u0016\u000b\u0000\u007f\u0080\u0006\n\uffff\uffff\u0000\u0080\u0088\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0003\u0016\u000b\u0000\u0082\u0083\u0006"+
		"\n\uffff\uffff\u0000\u0083\u0084\u0005\u0002\u0000\u0000\u0084\u0085\u0003"+
		"\u0014\n\u0000\u0085\u0086\u0006\n\uffff\uffff\u0000\u0086\u0088\u0001"+
		"\u0000\u0000\u0000\u0087~\u0001\u0000\u0000\u0000\u0087\u0081\u0001\u0000"+
		"\u0000\u0000\u0088\u0015\u0001\u0000\u0000\u0000\u0089\u008a\u0003\u0018"+
		"\f\u0000\u008a\u008b\u0006\u000b\uffff\uffff\u0000\u008b\u0017\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0006\f\uffff\uffff\u0000\u008d\u008e\u0003\u001c"+
		"\u000e\u0000\u008e\u008f\u0005\"\u0000\u0000\u008f\u0090\u0003\u001a\r"+
		"\u0000\u0090\u0091\u0006\f\uffff\uffff\u0000\u0091\u0096\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0003\u001c\u000e\u0000\u0093\u0094\u0006\f\uffff\uffff"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u008c\u0001\u0000\u0000"+
		"\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u009e\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\n\u0003\u0000\u0000\u0098\u0099\u0005\"\u0000\u0000"+
		"\u0099\u009a\u0003\u001a\r\u0000\u009a\u009b\u0006\f\uffff\uffff\u0000"+
		"\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u0097\u0001\u0000\u0000\u0000"+
		"\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u0019\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u0018\f\u0000\u00a2"+
		"\u00a3\u0006\r\uffff\uffff\u0000\u00a3\u00a8\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0003\u001c\u000e\u0000\u00a5\u00a6\u0006\r\uffff\uffff\u0000\u00a6"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a8\u001b\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0003\u001e\u000f\u0000\u00aa\u00ab\u0006\u000e\uffff\uffff\u0000"+
		"\u00ab\u001d\u0001\u0000\u0000\u0000\u00ac\u00ad\u0006\u000f\uffff\uffff"+
		"\u0000\u00ad\u00ae\u0003 \u0010\u0000\u00ae\u00af\u0006\u000f\uffff\uffff"+
		"\u0000\u00af\u00c9\u0001\u0000\u0000\u0000\u00b0\u00b1\n\u0002\u0000\u0000"+
		"\u00b1\u00b2\u0005\b\u0000\u0000\u00b2\u00be\u0006\u000f\uffff\uffff\u0000"+
		"\u00b3\u00b4\u0003\u0016\u000b\u0000\u00b4\u00bb\u0006\u000f\uffff\uffff"+
		"\u0000\u00b5\u00b6\u0005\u0005\u0000\u0000\u00b6\u00b7\u0003\u0016\u000b"+
		"\u0000\u00b7\u00b8\u0006\u000f\uffff\uffff\u0000\u00b8\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b5\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00b3\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\t\u0000"+
		"\u0000\u00c1\u00c8\u0006\u000f\uffff\uffff\u0000\u00c2\u00c3\n\u0001\u0000"+
		"\u0000\u00c3\u00c4\u0005\f\u0000\u0000\u00c4\u00c5\u0003\u0014\n\u0000"+
		"\u00c5\u00c6\u0005\r\u0000\u0000\u00c6\u00c8\u0001\u0000\u0000\u0000\u00c7"+
		"\u00b0\u0001\u0000\u0000\u0000\u00c7\u00c2\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u001f\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001f\u0000\u0000\u00cd"+
		"\u00e4\u0006\u0010\uffff\uffff\u0000\u00ce\u00e4\u0005 \u0000\u0000\u00cf"+
		"\u00e4\u0005!\u0000\u0000\u00d0\u00d1\u0005\u001e\u0000\u0000\u00d1\u00e4"+
		"\u0006\u0010\uffff\uffff\u0000\u00d2\u00e4\u0005\u000e\u0000\u0000\u00d3"+
		"\u00e4\u0005\u000f\u0000\u0000\u00d4\u00d5\u0005\u0007\u0000\u0000\u00d5"+
		"\u00d6\u0005\b\u0000\u0000\u00d6\u00d7\u0003\u0010\b\u0000\u00d7\u00d8"+
		"\u0005\t\u0000\u0000\u00d8\u00d9\u0003\u0012\t\u0000\u00d9\u00e4\u0001"+
		"\u0000\u0000\u0000\u00da\u00e4\u0005\u0010\u0000\u0000\u00db\u00dc\u0005"+
		"\b\u0000\u0000\u00dc\u00dd\u0003\u0004\u0002\u0000\u00dd\u00de\u0005\t"+
		"\u0000\u0000\u00de\u00e4\u0001\u0000\u0000\u0000\u00df\u00e4\u0003\"\u0011"+
		"\u0000\u00e0\u00e4\u0003&\u0013\u0000\u00e1\u00e4\u0003(\u0014\u0000\u00e2"+
		"\u00e4\u0003*\u0015\u0000\u00e3\u00cc\u0001\u0000\u0000\u0000\u00e3\u00ce"+
		"\u0001\u0000\u0000\u0000\u00e3\u00cf\u0001\u0000\u0000\u0000\u00e3\u00d0"+
		"\u0001\u0000\u0000\u0000\u00e3\u00d2\u0001\u0000\u0000\u0000\u00e3\u00d3"+
		"\u0001\u0000\u0000\u0000\u00e3\u00d4\u0001\u0000\u0000\u0000\u00e3\u00da"+
		"\u0001\u0000\u0000\u0000\u00e3\u00db\u0001\u0000\u0000\u0000\u00e3\u00df"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4!\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0005\u0011\u0000\u0000\u00e6\u00e7\u0003"+
		"\u0014\n\u0000\u00e7\u00e8\u0005\u0012\u0000\u0000\u00e8\u00ea\u0003\u0004"+
		"\u0002\u0000\u00e9\u00eb\u0003$\u0012\u0000\u00ea\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0005\u0013\u0000\u0000\u00ed#\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0005\u0014\u0000\u0000\u00ef\u00f0\u0003\u0014\n\u0000\u00f0"+
		"\u00f1\u0005\u0012\u0000\u0000\u00f1\u00f3\u0003\u0004\u0002\u0000\u00f2"+
		"\u00f4\u0003$\u0012\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f8\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0005\u0015\u0000\u0000\u00f6\u00f8\u0003\u0004\u0002\u0000\u00f7\u00ee"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8%\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0005\u0016\u0000\u0000\u00fa\u00fb\u0003"+
		"\u0014\n\u0000\u00fb\u00fc\u0005\u0017\u0000\u0000\u00fc\u00fd\u0003\u0004"+
		"\u0002\u0000\u00fd\u00fe\u0005\u0018\u0000\u0000\u00fe\'\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0005\u0017\u0000\u0000\u0100\u0101\u0003\u0004\u0002"+
		"\u0000\u0101\u0102\u0005\u0016\u0000\u0000\u0102\u0103\u0003\u0014\n\u0000"+
		"\u0103\u0104\u0005\u0018\u0000\u0000\u0104)\u0001\u0000\u0000\u0000\u0105"+
		"\u0106\u0005\u0019\u0000\u0000\u0106\u0107\u0003\u0004\u0002\u0000\u0107"+
		"\u0108\u0005\u0005\u0000\u0000\u0108\u0109\u0003\u0014\n\u0000\u0109\u010a"+
		"\u0005\u0005\u0000\u0000\u010a\u010b\u0003\u0014\n\u0000\u010b\u010c\u0005"+
		"\u0017\u0000\u0000\u010c\u010d\u0003\u0004\u0002\u0000\u010d\u010e\u0005"+
		"\u0018\u0000\u0000\u010e+\u0001\u0000\u0000\u0000\u0015/>CIT^atw\u0087"+
		"\u0095\u009e\u00a7\u00bb\u00be\u00c7\u00c9\u00e3\u00ea\u00f3\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}