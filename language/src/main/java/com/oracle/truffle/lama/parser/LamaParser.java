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
import com.oracle.truffle.lama.parser.LamaNodeFactory.*;

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
		STRING=32, CHAR=33, UNARY=34, BINARY=35;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeExpression = 2, 
		RULE_definition = 3, RULE_variableDefinition = 4, RULE_variableDefinitionSequence = 5, 
		RULE_variableDefinitionItem = 6, RULE_functionDefinition = 7, RULE_functionArguments = 8, 
		RULE_functionBody = 9, RULE_expression = 10, RULE_basicExpression = 11, 
		RULE_primaryExpression = 12, RULE_primary = 13, RULE_ifExpression = 14, 
		RULE_elsePart = 15, RULE_whileDoExpression = 16, RULE_doWhileExpression = 17, 
		RULE_forExpression = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeExpression", "definition", "variableDefinition", 
			"variableDefinitionSequence", "variableDefinitionItem", "functionDefinition", 
			"functionArguments", "functionBody", "expression", "basicExpression", 
			"primaryExpression", "primary", "ifExpression", "elsePart", "whileDoExpression", 
			"doWhileExpression", "forExpression"
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
			"STRING", "CHAR", "UNARY", "BINARY"
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

	private int getOpPrecedence() {
	    return factory.getPrecedence(_input.LT(1));
	}

	private int getNextPrecedence() {
	    return factory.getNextPrecedence(_input.LT(-1));
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(38);
				importStt();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(45);
			((CompilationUnitContext)_localctx).scopeExpression = scopeExpression();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).scopeExpression.result, _input.LT(1)); 
			setState(47);
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
			setState(49);
			match(T__0);
			setState(50);
			match(UIDENT);
			setState(51);
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
		public ExprsGen result;
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
			setState(56);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					definition();
					}
					} 
				}
				setState(58);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			 ((ScopeExpressionContext)_localctx).result =  ExprsGen.of(); 
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(60);
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
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
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(70);
			variableDefinitionSequence();
			setState(71);
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
			setState(73);
			variableDefinitionItem();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(74);
				match(T__4);
				setState(75);
				variableDefinitionItem();
				}
				}
				setState(80);
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 factory.addLocal(((VariableDefinitionItemContext)_localctx).LIDENT, null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(84);
				match(T__5);
				setState(85);
				((VariableDefinitionItemContext)_localctx).basicExpression = basicExpression(0);
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
		public Token t;
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(90);
				match(T__3);
				}
			}

			setState(93);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(94);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(95);
			match(T__7);
			setState(96);
			((FunctionDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(97);
			match(T__8);
			 factory.startFunction(((FunctionDefinitionContext)_localctx).functionArguments.result); 
			setState(99);
			((FunctionDefinitionContext)_localctx).functionBody = functionBody();
			 factory.addLocal(((FunctionDefinitionContext)_localctx).name, factory.finishFunction(((FunctionDefinitionContext)_localctx).functionBody.result, ((FunctionDefinitionContext)_localctx).t)); 
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
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(103);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(105);
					match(T__4);
					setState(106);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
					}
					}
					setState(112);
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
		public ExprsGen result;
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
			setState(115);
			match(T__9);
			setState(116);
			((FunctionBodyContext)_localctx).scopeExpression = scopeExpression();
			setState(117);
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
		public ExprsGen result;
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
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				setState(125);
				match(T__1);
				setState(126);
				((ExpressionContext)_localctx).expression = expression();
				 ((ExpressionContext)_localctx).result =  ExprsGen.add(_localctx.result, ((ExpressionContext)_localctx).expression.result); 
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
		public int _p;
		public ExprGen result;
		public PrimaryExpressionContext primaryExpression;
		public PrimaryExpressionContext lhs;
		public Token op;
		public BasicExpressionContext rhs;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<TerminalNode> BINARY() { return getTokens(LamaParser.BINARY); }
		public TerminalNode BINARY(int i) {
			return getToken(LamaParser.BINARY, i);
		}
		public List<BasicExpressionContext> basicExpression() {
			return getRuleContexts(BasicExpressionContext.class);
		}
		public BasicExpressionContext basicExpression(int i) {
			return getRuleContext(BasicExpressionContext.class,i);
		}
		public BasicExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public BasicExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_basicExpression; }
	}

	public final BasicExpressionContext basicExpression(int _p) throws RecognitionException {
		BasicExpressionContext _localctx = new BasicExpressionContext(_ctx, getState(), _p);
		enterRule(_localctx, 22, RULE_basicExpression);
		try {
			int _alt;
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
				 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((BasicExpressionContext)_localctx).lhs = primaryExpression();
				setState(140); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(135);
						if (!(getOpPrecedence() >= _localctx._p)) throw new FailedPredicateException(this, "getOpPrecedence() >= $_p");
						setState(136);
						((BasicExpressionContext)_localctx).op = match(BINARY);
						setState(137);
						((BasicExpressionContext)_localctx).rhs = basicExpression(getNextPrecedence());
						 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, ((BasicExpressionContext)_localctx).lhs.result, ((BasicExpressionContext)_localctx).rhs.result); 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(142); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public ExprGen result;
		public PrimaryContext primary;
		public BasicExpressionContext basicExpression;
		public Token t;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BasicExpressionContext> basicExpression() {
			return getRuleContexts(BasicExpressionContext.class);
		}
		public BasicExpressionContext basicExpression(int i) {
			return getRuleContext(BasicExpressionContext.class,i);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primaryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(169);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(148);
						match(T__11);
						setState(149);
						expression();
						setState(150);
						match(T__12);
						}
						break;
					case T__7:
						{
						setState(152);
						match(T__7);
						 List<ExprGen> args = new ArrayList<ExprGen>(); 
						setState(165);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33332380032L) != 0)) {
							{
							setState(154);
							((PrimaryExpressionContext)_localctx).basicExpression = basicExpression(0);
							 args.add(((PrimaryExpressionContext)_localctx).basicExpression.result); 
							setState(162);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(156);
								match(T__4);
								setState(157);
								((PrimaryExpressionContext)_localctx).basicExpression = basicExpression(0);
								 args.add(((PrimaryExpressionContext)_localctx).basicExpression.result); 
								}
								}
								setState(164);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(167);
						((PrimaryExpressionContext)_localctx).t = match(T__8);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, args, ((PrimaryExpressionContext)_localctx).t); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class PrimaryContext extends ParserRuleContext {
		public ExprGen result;
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
		public TerminalNode UNARY() { return getToken(LamaParser.UNARY, 0); }
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
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
		enterRule(_localctx, 26, RULE_primary);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(STRING);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(CHAR);
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				match(T__14);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				match(T__6);
				setState(183);
				match(T__7);
				setState(184);
				functionArguments();
				setState(185);
				match(T__8);
				setState(186);
				functionBody();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 8);
				{
				setState(188);
				match(T__15);
				}
				break;
			case UNARY:
				enterOuterAlt(_localctx, 9);
				{
				setState(189);
				match(UNARY);
				setState(190);
				basicExpression(0);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 10);
				{
				setState(191);
				match(T__7);
				setState(192);
				scopeExpression();
				setState(193);
				match(T__8);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 11);
				{
				setState(195);
				ifExpression();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 12);
				{
				setState(196);
				whileDoExpression();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 13);
				{
				setState(197);
				doWhileExpression();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 14);
				{
				setState(198);
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
		enterRule(_localctx, 28, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__16);
			setState(202);
			expression();
			setState(203);
			match(T__17);
			setState(204);
			scopeExpression();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==T__20) {
				{
				setState(205);
				elsePart();
				}
			}

			setState(208);
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
		enterRule(_localctx, 30, RULE_elsePart);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(T__19);
				setState(211);
				expression();
				setState(212);
				match(T__17);
				setState(213);
				scopeExpression();
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19 || _la==T__20) {
					{
					setState(214);
					elsePart();
					}
				}

				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(T__20);
				setState(218);
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
		enterRule(_localctx, 32, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__21);
			setState(222);
			expression();
			setState(223);
			match(T__22);
			setState(224);
			scopeExpression();
			setState(225);
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
		enterRule(_localctx, 34, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__22);
			setState(228);
			scopeExpression();
			setState(229);
			match(T__21);
			setState(230);
			expression();
			setState(231);
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
		enterRule(_localctx, 36, RULE_forExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__24);
			setState(234);
			scopeExpression();
			setState(235);
			match(T__4);
			setState(236);
			expression();
			setState(237);
			match(T__4);
			setState(238);
			expression();
			setState(239);
			match(T__22);
			setState(240);
			scopeExpression();
			setState(241);
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
		case 11:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getOpPrecedence() >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u00f4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u00027\b\u0002\n\u0002\f\u0002"+
		":\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003D\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005M\b\u0005\n\u0005\f\u0005P\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006Y\b"+
		"\u0006\u0001\u0007\u0003\u0007\\\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bm\b\b\n"+
		"\b\f\bp\t\b\u0003\br\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0082\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u008d\b\u000b"+
		"\u000b\u000b\f\u000b\u008e\u0003\u000b\u0091\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00a1\b\f\n\f\f\f\u00a4\t\f\u0003\f\u00a6\b"+
		"\f\u0001\f\u0001\f\u0005\f\u00aa\b\f\n\f\f\f\u00ad\t\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c8\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cf\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00d8\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00dc\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0001\u0001\u0000\u0003\u0004"+
		"\u0100\u0000)\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000\u0004"+
		"8\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bE\u0001\u0000"+
		"\u0000\u0000\nI\u0001\u0000\u0000\u0000\fX\u0001\u0000\u0000\u0000\u000e"+
		"[\u0001\u0000\u0000\u0000\u0010f\u0001\u0000\u0000\u0000\u0012s\u0001"+
		"\u0000\u0000\u0000\u0014\u0081\u0001\u0000\u0000\u0000\u0016\u0090\u0001"+
		"\u0000\u0000\u0000\u0018\u0092\u0001\u0000\u0000\u0000\u001a\u00c7\u0001"+
		"\u0000\u0000\u0000\u001c\u00c9\u0001\u0000\u0000\u0000\u001e\u00db\u0001"+
		"\u0000\u0000\u0000 \u00dd\u0001\u0000\u0000\u0000\"\u00e3\u0001\u0000"+
		"\u0000\u0000$\u00e9\u0001\u0000\u0000\u0000&(\u0003\u0002\u0001\u0000"+
		"\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000"+
		"\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000,-\u0006\u0000\uffff\uffff\u0000-.\u0003\u0004\u0002\u0000"+
		"./\u0006\u0000\uffff\uffff\u0000/0\u0005\u0000\u0000\u00010\u0001\u0001"+
		"\u0000\u0000\u000012\u0005\u0001\u0000\u000023\u0005\u001d\u0000\u0000"+
		"34\u0005\u0002\u0000\u00004\u0003\u0001\u0000\u0000\u000057\u0003\u0006"+
		"\u0003\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000;=\u0006\u0002\uffff\uffff\u0000<>\u0003\u0014"+
		"\n\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0006\u0002\uffff\uffff\u0000@\u0005\u0001\u0000\u0000"+
		"\u0000AD\u0003\b\u0004\u0000BD\u0003\u000e\u0007\u0000CA\u0001\u0000\u0000"+
		"\u0000CB\u0001\u0000\u0000\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0007"+
		"\u0000\u0000\u0000FG\u0003\n\u0005\u0000GH\u0005\u0002\u0000\u0000H\t"+
		"\u0001\u0000\u0000\u0000IN\u0003\f\u0006\u0000JK\u0005\u0005\u0000\u0000"+
		"KM\u0003\f\u0006\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u000b\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0005\u001e\u0000\u0000RY\u0006"+
		"\u0006\uffff\uffff\u0000ST\u0005\u001e\u0000\u0000TU\u0005\u0006\u0000"+
		"\u0000UV\u0003\u0016\u000b\u0000VW\u0006\u0006\uffff\uffff\u0000WY\u0001"+
		"\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000"+
		"Y\r\u0001\u0000\u0000\u0000Z\\\u0005\u0004\u0000\u0000[Z\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005\u0007"+
		"\u0000\u0000^_\u0005\u001e\u0000\u0000_`\u0005\b\u0000\u0000`a\u0003\u0010"+
		"\b\u0000ab\u0005\t\u0000\u0000bc\u0006\u0007\uffff\uffff\u0000cd\u0003"+
		"\u0012\t\u0000de\u0006\u0007\uffff\uffff\u0000e\u000f\u0001\u0000\u0000"+
		"\u0000fq\u0006\b\uffff\uffff\u0000gh\u0005\u001e\u0000\u0000hn\u0006\b"+
		"\uffff\uffff\u0000ij\u0005\u0005\u0000\u0000jk\u0005\u001e\u0000\u0000"+
		"km\u0006\b\uffff\uffff\u0000li\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000or\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qg\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000r\u0011\u0001\u0000\u0000\u0000st\u0005\n\u0000\u0000"+
		"tu\u0003\u0004\u0002\u0000uv\u0005\u000b\u0000\u0000vw\u0006\t\uffff\uffff"+
		"\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0003\u0016\u000b\u0000yz\u0006"+
		"\n\uffff\uffff\u0000z\u0082\u0001\u0000\u0000\u0000{|\u0003\u0016\u000b"+
		"\u0000|}\u0006\n\uffff\uffff\u0000}~\u0005\u0002\u0000\u0000~\u007f\u0003"+
		"\u0014\n\u0000\u007f\u0080\u0006\n\uffff\uffff\u0000\u0080\u0082\u0001"+
		"\u0000\u0000\u0000\u0081x\u0001\u0000\u0000\u0000\u0081{\u0001\u0000\u0000"+
		"\u0000\u0082\u0015\u0001\u0000\u0000\u0000\u0083\u0084\u0003\u0018\f\u0000"+
		"\u0084\u0085\u0006\u000b\uffff\uffff\u0000\u0085\u0091\u0001\u0000\u0000"+
		"\u0000\u0086\u008c\u0003\u0018\f\u0000\u0087\u0088\u0004\u000b\u0000\u0001"+
		"\u0088\u0089\u0005#\u0000\u0000\u0089\u008a\u0003\u0016\u000b\u0000\u008a"+
		"\u008b\u0006\u000b\uffff\uffff\u0000\u008b\u008d\u0001\u0000\u0000\u0000"+
		"\u008c\u0087\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000"+
		"\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u0083\u0001\u0000\u0000\u0000"+
		"\u0090\u0086\u0001\u0000\u0000\u0000\u0091\u0017\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0003\u001a\r\u0000\u0093\u00ab\u0006\f\uffff\uffff\u0000"+
		"\u0094\u0095\u0005\f\u0000\u0000\u0095\u0096\u0003\u0014\n\u0000\u0096"+
		"\u0097\u0005\r\u0000\u0000\u0097\u00aa\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\b\u0000\u0000\u0099\u00a5\u0006\f\uffff\uffff\u0000\u009a\u009b"+
		"\u0003\u0016\u000b\u0000\u009b\u00a2\u0006\f\uffff\uffff\u0000\u009c\u009d"+
		"\u0005\u0005\u0000\u0000\u009d\u009e\u0003\u0016\u000b\u0000\u009e\u009f"+
		"\u0006\f\uffff\uffff\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009c"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u009a"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\t\u0000\u0000\u00a8\u00aa\u0006"+
		"\f\uffff\uffff\u0000\u00a9\u0094\u0001\u0000\u0000\u0000\u00a9\u0098\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u0019\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae\u00af\u0005"+
		"\u001f\u0000\u0000\u00af\u00c8\u0006\r\uffff\uffff\u0000\u00b0\u00c8\u0005"+
		" \u0000\u0000\u00b1\u00c8\u0005!\u0000\u0000\u00b2\u00b3\u0005\u001e\u0000"+
		"\u0000\u00b3\u00c8\u0006\r\uffff\uffff\u0000\u00b4\u00c8\u0005\u000e\u0000"+
		"\u0000\u00b5\u00c8\u0005\u000f\u0000\u0000\u00b6\u00b7\u0005\u0007\u0000"+
		"\u0000\u00b7\u00b8\u0005\b\u0000\u0000\u00b8\u00b9\u0003\u0010\b\u0000"+
		"\u00b9\u00ba\u0005\t\u0000\u0000\u00ba\u00bb\u0003\u0012\t\u0000\u00bb"+
		"\u00c8\u0001\u0000\u0000\u0000\u00bc\u00c8\u0005\u0010\u0000\u0000\u00bd"+
		"\u00be\u0005\"\u0000\u0000\u00be\u00c8\u0003\u0016\u000b\u0000\u00bf\u00c0"+
		"\u0005\b\u0000\u0000\u00c0\u00c1\u0003\u0004\u0002\u0000\u00c1\u00c2\u0005"+
		"\t\u0000\u0000\u00c2\u00c8\u0001\u0000\u0000\u0000\u00c3\u00c8\u0003\u001c"+
		"\u000e\u0000\u00c4\u00c8\u0003 \u0010\u0000\u00c5\u00c8\u0003\"\u0011"+
		"\u0000\u00c6\u00c8\u0003$\u0012\u0000\u00c7\u00ae\u0001\u0000\u0000\u0000"+
		"\u00c7\u00b0\u0001\u0000\u0000\u0000\u00c7\u00b1\u0001\u0000\u0000\u0000"+
		"\u00c7\u00b2\u0001\u0000\u0000\u0000\u00c7\u00b4\u0001\u0000\u0000\u0000"+
		"\u00c7\u00b5\u0001\u0000\u0000\u0000\u00c7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00c7\u00bc\u0001\u0000\u0000\u0000\u00c7\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u001b\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0005\u0011\u0000\u0000\u00ca\u00cb\u0003\u0014\n\u0000\u00cb"+
		"\u00cc\u0005\u0012\u0000\u0000\u00cc\u00ce\u0003\u0004\u0002\u0000\u00cd"+
		"\u00cf\u0003\u001e\u000f\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0005\u0013\u0000\u0000\u00d1\u001d\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005\u0014\u0000\u0000\u00d3\u00d4\u0003\u0014\n\u0000\u00d4\u00d5"+
		"\u0005\u0012\u0000\u0000\u00d5\u00d7\u0003\u0004\u0002\u0000\u00d6\u00d8"+
		"\u0003\u001e\u000f\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00dc\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005\u0015\u0000\u0000\u00da\u00dc\u0003\u0004\u0002\u0000\u00db\u00d2"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u001f"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0016\u0000\u0000\u00de\u00df"+
		"\u0003\u0014\n\u0000\u00df\u00e0\u0005\u0017\u0000\u0000\u00e0\u00e1\u0003"+
		"\u0004\u0002\u0000\u00e1\u00e2\u0005\u0018\u0000\u0000\u00e2!\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0005\u0017\u0000\u0000\u00e4\u00e5\u0003\u0004"+
		"\u0002\u0000\u00e5\u00e6\u0005\u0016\u0000\u0000\u00e6\u00e7\u0003\u0014"+
		"\n\u0000\u00e7\u00e8\u0005\u0018\u0000\u0000\u00e8#\u0001\u0000\u0000"+
		"\u0000\u00e9\u00ea\u0005\u0019\u0000\u0000\u00ea\u00eb\u0003\u0004\u0002"+
		"\u0000\u00eb\u00ec\u0005\u0005\u0000\u0000\u00ec\u00ed\u0003\u0014\n\u0000"+
		"\u00ed\u00ee\u0005\u0005\u0000\u0000\u00ee\u00ef\u0003\u0014\n\u0000\u00ef"+
		"\u00f0\u0005\u0017\u0000\u0000\u00f0\u00f1\u0003\u0004\u0002\u0000\u00f1"+
		"\u00f2\u0005\u0018\u0000\u0000\u00f2%\u0001\u0000\u0000\u0000\u0014)8"+
		"=CNX[nq\u0081\u008e\u0090\u00a2\u00a5\u00a9\u00ab\u00c7\u00ce\u00d7\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}