// Generated from language/src/main/java/com/oracle/truffle/lama/parser/Lama.g4 by ANTLR 4.12.0
package com.oracle.truffle.lama.parser;

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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, WS=44, COMMENT=45, LINE_COMMENT=46, 
		UIDENT=47, LIDENT=48, DECIMAL=49, STRING=50, CHAR=51, OP=52;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeDefinitions = 2, 
		RULE_scopeExpression = 3, RULE_scopeExpression0 = 4, RULE_definition = 5, 
		RULE_variableDefinition = 6, RULE_variableDefinitionSequence = 7, RULE_variableDefinitionItem = 8, 
		RULE_functionDefinition = 9, RULE_functionArgumentsAndBody = 10, RULE_functionArguments = 11, 
		RULE_functionBody = 12, RULE_infixDefinition = 13, RULE_infixity = 14, 
		RULE_level = 15, RULE_expression = 16, RULE_basicExpression = 17, RULE_primaryExpression = 18, 
		RULE_functionParams = 19, RULE_primary = 20, RULE_ifExpression = 21, RULE_elsePart = 22, 
		RULE_whileDoExpression = 23, RULE_doWhileExpression = 24, RULE_forExpression = 25, 
		RULE_valList = 26, RULE_arrayExpression = 27, RULE_sExpression = 28, RULE_listExpression = 29, 
		RULE_caseExpression = 30, RULE_caseBranches = 31, RULE_caseBranch = 32, 
		RULE_pattern = 33, RULE_simplePattern = 34, RULE_consPattern = 35, RULE_patList = 36, 
		RULE_listPattern = 37, RULE_wildcardPattern = 38, RULE_sExpPattern = 39, 
		RULE_arrayPattern = 40, RULE_etaExpression = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeDefinitions", "scopeExpression", 
			"scopeExpression0", "definition", "variableDefinition", "variableDefinitionSequence", 
			"variableDefinitionItem", "functionDefinition", "functionArgumentsAndBody", 
			"functionArguments", "functionBody", "infixDefinition", "infixity", "level", 
			"expression", "basicExpression", "primaryExpression", "functionParams", 
			"primary", "ifExpression", "elsePart", "whileDoExpression", "doWhileExpression", 
			"forExpression", "valList", "arrayExpression", "sExpression", "listExpression", 
			"caseExpression", "caseBranches", "caseBranch", "pattern", "simplePattern", 
			"consPattern", "patList", "listPattern", "wildcardPattern", "sExpPattern", 
			"arrayPattern", "etaExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "';'", "'var'", "'public'", "','", "'='", "'fun'", 
			"'('", "')'", "'{'", "'}'", "'infix'", "'infixl'", "'infixr'", "'at'", 
			"'before'", "'after'", "'['", "']'", "'.'", "'true'", "'false'", "'skip'", 
			"'if'", "'then'", "'fi'", "'elif'", "'else'", "'while'", "'do'", "'od'", 
			"'for'", "'case'", "'of'", "'esac'", "'|'", "'->'", "'@'", "'#fun'", 
			"'#val'", "'#str'", "'_'", "'eta'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"UIDENT", "LIDENT", "DECIMAL", "STRING", "CHAR", "OP"
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

	public LamaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public CallTarget result;
		public FunctionBodyContext functionBody;
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
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
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(84);
				importStt();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(91);
			((CompilationUnitContext)_localctx).functionBody = functionBody();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).functionBody.result, _input.LT(1)); 
			setState(93);
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
			setState(95);
			match(T__0);
			setState(96);
			match(UIDENT);
			setState(97);
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
	public static class ScopeDefinitionsContext extends ParserRuleContext {
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ScopeDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeDefinitions; }
	}

	public final ScopeDefinitionsContext scopeDefinitions() throws RecognitionException {
		ScopeDefinitionsContext _localctx = new ScopeDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_scopeDefinitions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					definition();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
	public static class ScopeExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public ExpressionContext expression;
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
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
		enterRule(_localctx, 6, RULE_scopeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock(); 
			setState(106);
			scopeDefinitions();
			setState(107);
			((ScopeExpressionContext)_localctx).expression = expression(0);
			 ((ScopeExpressionContext)_localctx).result =  factory.finishBlock(((ScopeExpressionContext)_localctx).expression.result); 
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
	public static class ScopeExpression0Context extends ParserRuleContext {
		public ScopedExprGen result;
		public ExpressionContext expression;
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeExpression0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeExpression0; }
	}

	public final ScopeExpression0Context scopeExpression0() throws RecognitionException {
		ScopeExpression0Context _localctx = new ScopeExpression0Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_scopeExpression0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock(); 
			setState(111);
			scopeDefinitions();
			 ScopedExprsGen gen = ScopedsGen.of()::generate; 
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8875272386647424L) != 0)) {
				{
				setState(113);
				((ScopeExpression0Context)_localctx).expression = expression(0);
				 gen = ((ScopeExpression0Context)_localctx).expression.result; 
				}
			}

			 ((ScopeExpression0Context)_localctx).result =  factory.finishBlock(gen); 
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
		public InfixDefinitionContext infixDefinition() {
			return getRuleContext(InfixDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_definition);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				infixDefinition();
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
		enterRule(_localctx, 12, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(126);
			variableDefinitionSequence();
			setState(127);
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
		public VariableDefinitionItemContext variableDefinitionItem;
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
		enterRule(_localctx, 14, RULE_variableDefinitionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
			 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(131);
				match(T__4);
				setState(132);
				((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
				 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
				}
				}
				setState(139);
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
		public Token name;
		public ScopedExprGen value;
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
		enterRule(_localctx, 16, RULE_variableDefinitionItem);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT; ((VariableDefinitionItemContext)_localctx).value =  factory.createSkip(((VariableDefinitionItemContext)_localctx).LIDENT); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(143);
				match(T__5);
				setState(144);
				((VariableDefinitionItemContext)_localctx).basicExpression = basicExpression(0);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT; ((VariableDefinitionItemContext)_localctx).value =  ((VariableDefinitionItemContext)_localctx).basicExpression.result; 
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
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody;
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody() {
			return getRuleContext(FunctionArgumentsAndBodyContext.class,0);
		}
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(149);
				match(T__3);
				}
			}

			setState(152);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(153);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(154);
			((FunctionDefinitionContext)_localctx).functionArgumentsAndBody = functionArgumentsAndBody(((FunctionDefinitionContext)_localctx).name.getText(), ((FunctionDefinitionContext)_localctx).t);
			 factory.addFun(((FunctionDefinitionContext)_localctx).name.getText(), ((FunctionDefinitionContext)_localctx).functionArgumentsAndBody.result); 
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
	public static class FunctionArgumentsAndBodyContext extends ParserRuleContext {
		public String name;
		public Token t;
		public Fun result;
		public FunctionArgumentsContext functionArguments;
		public FunctionBodyContext functionBody;
		public PatListContext patList;
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public PatListContext patList() {
			return getRuleContext(PatListContext.class,0);
		}
		public FunctionArgumentsAndBodyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FunctionArgumentsAndBodyContext(ParserRuleContext parent, int invokingState, String name, Token t) {
			super(parent, invokingState);
			this.name = name;
			this.t = t;
		}
		@Override public int getRuleIndex() { return RULE_functionArgumentsAndBody; }
	}

	public final FunctionArgumentsAndBodyContext functionArgumentsAndBody(String name,Token t) throws RecognitionException {
		FunctionArgumentsAndBodyContext _localctx = new FunctionArgumentsAndBodyContext(_ctx, getState(), name, t);
		enterRule(_localctx, 20, RULE_functionArgumentsAndBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(157);
				match(T__7);
				setState(158);
				((FunctionArgumentsAndBodyContext)_localctx).functionArguments = functionArguments();
				setState(159);
				match(T__8);
				 factory.startFunction(((FunctionArgumentsAndBodyContext)_localctx).functionArguments.result, _localctx.name); 
				setState(161);
				match(T__9);
				setState(162);
				((FunctionArgumentsAndBodyContext)_localctx).functionBody = functionBody();
				setState(163);
				match(T__10);
				 ((FunctionArgumentsAndBodyContext)_localctx).result =  factory.finishFunction(((FunctionArgumentsAndBodyContext)_localctx).functionBody.result); 
				}
				break;
			case 2:
				{
				setState(166);
				match(T__7);
				setState(167);
				((FunctionArgumentsAndBodyContext)_localctx).patList = patList();
				setState(168);
				match(T__8);
				 var c = factory.startFunctionPat(((FunctionArgumentsAndBodyContext)_localctx).patList.result, _localctx.name, _localctx.t); 
				setState(170);
				match(T__9);
				setState(171);
				((FunctionArgumentsAndBodyContext)_localctx).functionBody = functionBody();
				setState(172);
				match(T__10);
				 ((FunctionArgumentsAndBodyContext)_localctx).result =  factory.finishFunction(c.generate(((FunctionArgumentsAndBodyContext)_localctx).functionBody.result)); 
				}
				break;
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
	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<String> result;
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
		enterRule(_localctx, 22, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsContext)_localctx).result =  new ArrayList<>(); 
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(178);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT.getText()); 
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(180);
					match(T__4);
					setState(181);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT.getText()); 
					}
					}
					setState(187);
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
		public ScopedExprsGen result;
		public ExpressionContext expression;
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			scopeDefinitions();
			 ((FunctionBodyContext)_localctx).result =  ScopedsGen.of()::generate; 
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8875272386647424L) != 0)) {
				{
				setState(192);
				((FunctionBodyContext)_localctx).expression = expression(0);
				 ((FunctionBodyContext)_localctx).result =  ((FunctionBodyContext)_localctx).expression.result; 
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
	public static class InfixDefinitionContext extends ParserRuleContext {
		public InfixityContext infixity;
		public Token name;
		public LevelContext level;
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody;
		public InfixityContext infixity() {
			return getRuleContext(InfixityContext.class,0);
		}
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody() {
			return getRuleContext(FunctionArgumentsAndBodyContext.class,0);
		}
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public InfixDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixDefinition; }
	}

	public final InfixDefinitionContext infixDefinition() throws RecognitionException {
		InfixDefinitionContext _localctx = new InfixDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_infixDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(197);
				match(T__3);
				}
			}

			setState(200);
			((InfixDefinitionContext)_localctx).infixity = infixity();
			setState(201);
			((InfixDefinitionContext)_localctx).name = match(OP);
			setState(202);
			((InfixDefinitionContext)_localctx).level = level();
			setState(203);
			((InfixDefinitionContext)_localctx).functionArgumentsAndBody = functionArgumentsAndBody(((InfixDefinitionContext)_localctx).name.getText(), ((InfixDefinitionContext)_localctx).name);
			 factory.addFun(((InfixDefinitionContext)_localctx).name.getText(), ((InfixDefinitionContext)_localctx).functionArgumentsAndBody.result); 
			 factory.addOp(((InfixDefinitionContext)_localctx).name, ((InfixDefinitionContext)_localctx).infixity.result, ((InfixDefinitionContext)_localctx).level.relOp, ((InfixDefinitionContext)_localctx).level.rel); 
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
	public static class InfixityContext extends ParserRuleContext {
		public OpType result;
		public InfixityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixity; }
	}

	public final InfixityContext infixity() throws RecognitionException {
		InfixityContext _localctx = new InfixityContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_infixity);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(T__11);
				 ((InfixityContext)_localctx).result =  OpType.InfixNone; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(T__12);
				 ((InfixityContext)_localctx).result =  OpType.InfixLeft; 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(T__13);
				 ((InfixityContext)_localctx).result =  OpType.InfixRight; 
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
	public static class LevelContext extends ParserRuleContext {
		public Token relOp;
		public int rel;
		public Token OP;
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(215);
				match(T__14);
				 ((LevelContext)_localctx).rel =  0; 
				}
				break;
			case T__15:
				{
				setState(217);
				match(T__15);
				 ((LevelContext)_localctx).rel =  -1; 
				}
				break;
			case T__16:
				{
				setState(219);
				match(T__16);
				 ((LevelContext)_localctx).rel =  1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(223);
			((LevelContext)_localctx).OP = match(OP);
			 ((LevelContext)_localctx).relOp =  ((LevelContext)_localctx).OP; 
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
		public ScopedExprsGen result;
		public ExpressionContext first;
		public BasicExpressionContext basicExpression;
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
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(227);
			((ExpressionContext)_localctx).basicExpression = basicExpression(0);
			 ((ExpressionContext)_localctx).result =  ScopedsGen.of(((ExpressionContext)_localctx).basicExpression.result)::generate; 
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					_localctx.first = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(230);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(231);
					match(T__1);
					setState(232);
					((ExpressionContext)_localctx).basicExpression = basicExpression(0);
					 ((ExpressionContext)_localctx).result =  ScopedsGen.add(ExprGen.konstVal(((ExpressionContext)_localctx).first.result), ((ExpressionContext)_localctx).basicExpression.result)::generate; 
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class BasicExpressionContext extends ParserRuleContext {
		public int _p;
		public ScopedExprGen result;
		public int _r;
		public PrimaryExpressionContext primaryExpression;
		public Token op;
		public BasicExpressionContext rhs;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<TerminalNode> OP() { return getTokens(LamaParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(LamaParser.OP, i);
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
		enterRule(_localctx, 34, RULE_basicExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; ((BasicExpressionContext)_localctx)._r =  Integer.MAX_VALUE; 
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(242);
					if (!(checkPrec(factory.getPrecedence(_input.LT(1)), _localctx._p, _localctx._r))) throw new FailedPredicateException(this, "checkPrec(factory.getPrecedence(_input.LT(1)), $_p, $_r)");
					setState(243);
					((BasicExpressionContext)_localctx).op = match(OP);
					setState(244);
					((BasicExpressionContext)_localctx).rhs = basicExpression(factory.getRightPrecedence(((BasicExpressionContext)_localctx).op));
					 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, _localctx.result, ((BasicExpressionContext)_localctx).rhs.result); 
					 ((BasicExpressionContext)_localctx)._r =  factory.getNextPrecedence(((BasicExpressionContext)_localctx).op); 
					}
					} 
				}
				setState(252);
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public PrimaryContext primary;
		public ExpressionContext expression;
		public FunctionParamsContext functionParams;
		public Token t;
		public Token LIDENT;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<FunctionParamsContext> functionParams() {
			return getRuleContexts(FunctionParamsContext.class);
		}
		public FunctionParamsContext functionParams(int i) {
			return getRuleContext(FunctionParamsContext.class,i);
		}
		public List<TerminalNode> LIDENT() { return getTokens(LamaParser.LIDENT); }
		public TerminalNode LIDENT(int i) {
			return getToken(LamaParser.LIDENT, i);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(272);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__17:
						{
						setState(255);
						match(T__17);
						setState(256);
						((PrimaryExpressionContext)_localctx).expression = expression(0);
						setState(257);
						match(T__18);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createElement(_localctx.result, factory.finishSeq(((PrimaryExpressionContext)_localctx).expression.result)); 
						}
						break;
					case T__7:
						{
						setState(260);
						((PrimaryExpressionContext)_localctx).functionParams = functionParams();
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, ((PrimaryExpressionContext)_localctx).functionParams.args, ((PrimaryExpressionContext)_localctx).functionParams.t); 
						}
						break;
					case T__19:
						{
						setState(263);
						((PrimaryExpressionContext)_localctx).t = match(T__19);
						setState(264);
						((PrimaryExpressionContext)_localctx).LIDENT = match(LIDENT);
						 List<ScopedExprGen> args = new ArrayList<>(); args.add(_localctx.result); 
						setState(269);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
						case 1:
							{
							setState(266);
							((PrimaryExpressionContext)_localctx).functionParams = functionParams();
							 args.addAll(((PrimaryExpressionContext)_localctx).functionParams.args); 
							}
							break;
						}
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(factory.createSymbol(((PrimaryExpressionContext)_localctx).LIDENT), args, ((PrimaryExpressionContext)_localctx).t); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class FunctionParamsContext extends ParserRuleContext {
		public List<ScopedExprGen> args;
		public Token t;
		public Token tt;
		public ScopeExpressionContext scopeExpression;
		public List<ScopeExpressionContext> scopeExpression() {
			return getRuleContexts(ScopeExpressionContext.class);
		}
		public ScopeExpressionContext scopeExpression(int i) {
			return getRuleContext(ScopeExpressionContext.class,i);
		}
		public FunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParams; }
	}

	public final FunctionParamsContext functionParams() throws RecognitionException {
		FunctionParamsContext _localctx = new FunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			((FunctionParamsContext)_localctx).tt = match(T__7);
			 ((FunctionParamsContext)_localctx).args =  new ArrayList<>(); ((FunctionParamsContext)_localctx).t =  ((FunctionParamsContext)_localctx).tt; 
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8875272386672024L) != 0)) {
				{
				setState(279);
				((FunctionParamsContext)_localctx).scopeExpression = scopeExpression();
				 _localctx.args.add(((FunctionParamsContext)_localctx).scopeExpression.result); 
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(281);
					match(T__4);
					setState(282);
					((FunctionParamsContext)_localctx).scopeExpression = scopeExpression();
					 _localctx.args.add(((FunctionParamsContext)_localctx).scopeExpression.result); 
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(292);
			match(T__8);
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
		public ScopedExprGen result;
		public Token d;
		public Token s;
		public Token c;
		public Token i;
		public Token tru;
		public Token fls;
		public Token OP;
		public Token t;
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody;
		public Token op;
		public BasicExpressionContext basicExpression;
		public ScopeExpressionContext scopeExpression;
		public ListExpressionContext listExpression;
		public ArrayExpressionContext arrayExpression;
		public SExpressionContext sExpression;
		public IfExpressionContext ifExpression;
		public WhileDoExpressionContext whileDoExpression;
		public DoWhileExpressionContext doWhileExpression;
		public ForExpressionContext forExpression;
		public CaseExpressionContext caseExpression;
		public EtaExpressionContext etaExpression;
		public TerminalNode DECIMAL() { return getToken(LamaParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(LamaParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LamaParser.CHAR, 0); }
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody() {
			return getRuleContext(FunctionArgumentsAndBodyContext.class,0);
		}
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public ArrayExpressionContext arrayExpression() {
			return getRuleContext(ArrayExpressionContext.class,0);
		}
		public SExpressionContext sExpression() {
			return getRuleContext(SExpressionContext.class,0);
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
		public CaseExpressionContext caseExpression() {
			return getRuleContext(CaseExpressionContext.class,0);
		}
		public EtaExpressionContext etaExpression() {
			return getRuleContext(EtaExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primary);
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				((PrimaryContext)_localctx).s = match(STRING);
				 ((PrimaryContext)_localctx).result =  factory.createStringLiteral(((PrimaryContext)_localctx).s); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				((PrimaryContext)_localctx).c = match(CHAR);
				 ((PrimaryContext)_localctx).result =  factory.createCharLiteral(((PrimaryContext)_localctx).c); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createSymbol(((PrimaryContext)_localctx).i); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(302);
				((PrimaryContext)_localctx).tru = match(T__20);
				 ((PrimaryContext)_localctx).result =  factory.createTrue(((PrimaryContext)_localctx).tru); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(304);
				((PrimaryContext)_localctx).fls = match(T__21);
				 ((PrimaryContext)_localctx).result =  factory.createFalse(((PrimaryContext)_localctx).fls); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(306);
				match(T__11);
				setState(307);
				((PrimaryContext)_localctx).OP = match(OP);
				 ((PrimaryContext)_localctx).result =  factory.createInfix(((PrimaryContext)_localctx).OP); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(309);
				((PrimaryContext)_localctx).t = match(T__6);
				setState(310);
				((PrimaryContext)_localctx).functionArgumentsAndBody = functionArgumentsAndBody("<lambda>", ((PrimaryContext)_localctx).t);
				 ((PrimaryContext)_localctx).result =  factory.genValue(((PrimaryContext)_localctx).functionArgumentsAndBody.result.instantiate(), ((PrimaryContext)_localctx).t)::generate; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(313);
				((PrimaryContext)_localctx).t = match(T__22);
				 ((PrimaryContext)_localctx).result =  factory.createSkip(((PrimaryContext)_localctx).t); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(315);
				((PrimaryContext)_localctx).op = match(OP);
				setState(316);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).op, ((PrimaryContext)_localctx).d); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(318);
				((PrimaryContext)_localctx).OP = match(OP);
				setState(319);
				((PrimaryContext)_localctx).basicExpression = basicExpression(0);
				 ((PrimaryContext)_localctx).result =  factory.createUnary(((PrimaryContext)_localctx).OP, ((PrimaryContext)_localctx).basicExpression.result); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(322);
				match(T__7);
				setState(323);
				((PrimaryContext)_localctx).scopeExpression = scopeExpression();
				setState(324);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).scopeExpression.result; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(327);
				((PrimaryContext)_localctx).listExpression = listExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).listExpression.result; 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(330);
				((PrimaryContext)_localctx).arrayExpression = arrayExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).arrayExpression.result; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(333);
				((PrimaryContext)_localctx).sExpression = sExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).sExpression.result; 
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(336);
				((PrimaryContext)_localctx).ifExpression = ifExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).ifExpression.result; 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(339);
				((PrimaryContext)_localctx).whileDoExpression = whileDoExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).whileDoExpression.result; 
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(342);
				((PrimaryContext)_localctx).doWhileExpression = doWhileExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).doWhileExpression.result; 
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(345);
				((PrimaryContext)_localctx).forExpression = forExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).forExpression.result; 
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(348);
				((PrimaryContext)_localctx).caseExpression = caseExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).caseExpression.result; 
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(351);
				((PrimaryContext)_localctx).etaExpression = etaExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).etaExpression.result; 
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
	public static class IfExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public Token t;
		public ExpressionContext expression;
		public ScopeExpressionContext scopeExpression;
		public ElsePartContext elsePart;
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
		enterRule(_localctx, 42, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ScopedExprGen falsePart; 
			setState(357);
			((IfExpressionContext)_localctx).t = match(T__23);
			setState(358);
			((IfExpressionContext)_localctx).expression = expression(0);
			setState(359);
			match(T__24);
			setState(360);
			((IfExpressionContext)_localctx).scopeExpression = scopeExpression();
			 falsePart = factory.createSkip(((IfExpressionContext)_localctx).t); 
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26 || _la==T__27) {
				{
				setState(362);
				((IfExpressionContext)_localctx).elsePart = elsePart();
				 falsePart = ((IfExpressionContext)_localctx).elsePart.result; 
				}
			}

			 ((IfExpressionContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((IfExpressionContext)_localctx).expression.result), ((IfExpressionContext)_localctx).scopeExpression.result, falsePart); 
			setState(368);
			match(T__25);
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
		public ScopedExprGen result;
		public Token t;
		public ExpressionContext expression;
		public ScopeExpressionContext scopeExpression;
		public ElsePartContext elsePart;
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
		enterRule(_localctx, 44, RULE_elsePart);
		int _la;
		try {
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				 ScopedExprGen falsePart; 
				setState(371);
				((ElsePartContext)_localctx).t = match(T__26);
				setState(372);
				((ElsePartContext)_localctx).expression = expression(0);
				setState(373);
				match(T__24);
				setState(374);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				 falsePart = factory.createSkip(((ElsePartContext)_localctx).t); 
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__26 || _la==T__27) {
					{
					setState(376);
					((ElsePartContext)_localctx).elsePart = elsePart();
					 falsePart = ((ElsePartContext)_localctx).elsePart.result; 
					}
				}

				 ((ElsePartContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((ElsePartContext)_localctx).expression.result), ((ElsePartContext)_localctx).scopeExpression.result, falsePart); 
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				match(T__27);
				setState(384);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				 ((ElsePartContext)_localctx).result =  ((ElsePartContext)_localctx).scopeExpression.result; 
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
		public ScopedExprGen result;
		public Token t;
		public ExpressionContext expression;
		public ScopeExpressionContext scopeExpression;
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
		enterRule(_localctx, 46, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			((WhileDoExpressionContext)_localctx).t = match(T__28);
			setState(390);
			((WhileDoExpressionContext)_localctx).expression = expression(0);
			setState(391);
			match(T__29);
			setState(392);
			((WhileDoExpressionContext)_localctx).scopeExpression = scopeExpression();
			 ((WhileDoExpressionContext)_localctx).result =  factory.createWhileDo(factory.finishSeq(((WhileDoExpressionContext)_localctx).expression.result), ((WhileDoExpressionContext)_localctx).scopeExpression.result, ((WhileDoExpressionContext)_localctx).t); 
			setState(394);
			match(T__30);
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
		public ScopedExprGen result;
		public Token t;
		public ScopeDefinitionsContext defs;
		public ExpressionContext expression;
		public ExpressionContext cond;
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DoWhileExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileExpression; }
	}

	public final DoWhileExpressionContext doWhileExpression() throws RecognitionException {
		DoWhileExpressionContext _localctx = new DoWhileExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			((DoWhileExpressionContext)_localctx).t = match(T__29);
			 var scope = factory.startBlock(); 
			setState(398);
			((DoWhileExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.startBlock(); factory.pullLocalValues(scope); 
			 ScopedExprsGen body = ScopedsGen.of()::generate; 
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(401);
				((DoWhileExpressionContext)_localctx).expression = expression(0);
				 body = ((DoWhileExpressionContext)_localctx).expression.result; 
				}
				break;
			}
			 ScopedExprGen bodyNode = factory.finishBlock(body); 
			setState(407);
			match(T__28);
			setState(408);
			((DoWhileExpressionContext)_localctx).cond = ((DoWhileExpressionContext)_localctx).expression = expression(0);
			 ((DoWhileExpressionContext)_localctx).result =  factory.finishBlock(ScopedsGen.of(
			              factory.createDoWhile(bodyNode, factory.finishSeq(((DoWhileExpressionContext)_localctx).cond.result), ((DoWhileExpressionContext)_localctx).t)
			      )::generate); 
			setState(410);
			match(T__30);
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
		public ScopedExprGen result;
		public Token t;
		public ScopeDefinitionsContext defs;
		public ExpressionContext expression;
		public ExpressionContext cond;
		public ExpressionContext step;
		public ScopeExpression0Context scopeExpression0;
		public ScopeExpression0Context scopeExpression0() {
			return getRuleContext(ScopeExpression0Context.class,0);
		}
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
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
		enterRule(_localctx, 50, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			((ForExpressionContext)_localctx).t = match(T__31);
			 factory.startBlock(); 
			setState(414);
			((ForExpressionContext)_localctx).defs = scopeDefinitions();
			 ScopedExprsGen init = ScopedsGen.of()::generate; 
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8875272386647424L) != 0)) {
				{
				setState(416);
				((ForExpressionContext)_localctx).expression = expression(0);
				 init = ((ForExpressionContext)_localctx).expression.result; 
				}
			}

			 ScopedExprGen initNode = factory.finishSeq(init); 
			setState(422);
			match(T__4);
			setState(423);
			((ForExpressionContext)_localctx).cond = ((ForExpressionContext)_localctx).expression = expression(0);
			setState(424);
			match(T__4);
			setState(425);
			((ForExpressionContext)_localctx).step = ((ForExpressionContext)_localctx).expression = expression(0);
			setState(426);
			match(T__29);
			setState(427);
			((ForExpressionContext)_localctx).scopeExpression0 = scopeExpression0();
			 ((ForExpressionContext)_localctx).result =  factory.finishBlock(ScopedsGen.of(
			              factory.createForLoop(initNode, factory.finishSeq(((ForExpressionContext)_localctx).cond.result), factory.finishSeq(((ForExpressionContext)_localctx).step.result), ((ForExpressionContext)_localctx).scopeExpression0.result, ((ForExpressionContext)_localctx).t)
			      )::generate); 
			setState(429);
			match(T__30);
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
	public static class ValListContext extends ParserRuleContext {
		public List<ScopedValGen> result;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ValListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valList; }
	}

	public final ValListContext valList() throws RecognitionException {
		ValListContext _localctx = new ValListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_valList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ValListContext)_localctx).result =  new ArrayList<>(); 
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8875272386647424L) != 0)) {
				{
				setState(432);
				((ValListContext)_localctx).expression = expression(0);
				 _localctx.result.add(ExprGen.konstVal(factory.finishSeq(((ValListContext)_localctx).expression.result))::generate); 
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(434);
					match(T__4);
					setState(435);
					((ValListContext)_localctx).expression = expression(0);
					 _localctx.result.add(ExprGen.konstVal(factory.finishSeq(((ValListContext)_localctx).expression.result))::generate); 
					}
					}
					setState(442);
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
	public static class ArrayExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public Token t;
		public ValListContext valList;
		public ValListContext valList() {
			return getRuleContext(ValListContext.class,0);
		}
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			((ArrayExpressionContext)_localctx).t = match(T__17);
			setState(446);
			((ArrayExpressionContext)_localctx).valList = valList();
			setState(447);
			match(T__18);
			 ((ArrayExpressionContext)_localctx).result =  factory.createArray(((ArrayExpressionContext)_localctx).valList.result, ((ArrayExpressionContext)_localctx).t); 
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
	public static class SExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public Token t;
		public ValListContext valList;
		public TerminalNode UIDENT() { return getToken(LamaParser.UIDENT, 0); }
		public ValListContext valList() {
			return getRuleContext(ValListContext.class,0);
		}
		public SExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExpression; }
	}

	public final SExpressionContext sExpression() throws RecognitionException {
		SExpressionContext _localctx = new SExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			((SExpressionContext)_localctx).t = match(UIDENT);
			 List<ScopedValGen> vals = List.of(); 
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(452);
				match(T__7);
				setState(453);
				((SExpressionContext)_localctx).valList = valList();
				setState(454);
				match(T__8);
				 vals = ((SExpressionContext)_localctx).valList.result; 
				}
				break;
			}
			 ((SExpressionContext)_localctx).result =  factory.createSExp(((SExpressionContext)_localctx).t.getText(), vals, ((SExpressionContext)_localctx).t); 
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
	public static class ListExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public Token t;
		public ValListContext valList;
		public ValListContext valList() {
			return getRuleContext(ValListContext.class,0);
		}
		public ListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpression; }
	}

	public final ListExpressionContext listExpression() throws RecognitionException {
		ListExpressionContext _localctx = new ListExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_listExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			((ListExpressionContext)_localctx).t = match(T__9);
			setState(462);
			((ListExpressionContext)_localctx).valList = valList();
			setState(463);
			match(T__10);
			 ((ListExpressionContext)_localctx).result =  factory.createList(((ListExpressionContext)_localctx).valList.result, ((ListExpressionContext)_localctx).t); 
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
	public static class CaseExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public ExpressionContext expression;
		public CaseBranchesContext caseBranches;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CaseBranchesContext caseBranches() {
			return getRuleContext(CaseBranchesContext.class,0);
		}
		public CaseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpression; }
	}

	public final CaseExpressionContext caseExpression() throws RecognitionException {
		CaseExpressionContext _localctx = new CaseExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_caseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(T__32);
			setState(467);
			((CaseExpressionContext)_localctx).expression = expression(0);
			setState(468);
			match(T__33);
			setState(469);
			((CaseExpressionContext)_localctx).caseBranches = caseBranches();
			setState(470);
			match(T__34);
			 ((CaseExpressionContext)_localctx).result =  factory.createPatternMatch(factory.finishSeq(((CaseExpressionContext)_localctx).expression.result), ((CaseExpressionContext)_localctx).caseBranches.result); 
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
	public static class CaseBranchesContext extends ParserRuleContext {
		public List<Pair<PatGen, ScopedExprGen>> result;
		public CaseBranchContext caseBranch;
		public List<CaseBranchContext> caseBranch() {
			return getRuleContexts(CaseBranchContext.class);
		}
		public CaseBranchContext caseBranch(int i) {
			return getRuleContext(CaseBranchContext.class,i);
		}
		public CaseBranchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBranches; }
	}

	public final CaseBranchesContext caseBranches() throws RecognitionException {
		CaseBranchesContext _localctx = new CaseBranchesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_caseBranches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((CaseBranchesContext)_localctx).result =  new ArrayList<>(); 
			setState(474);
			((CaseBranchesContext)_localctx).caseBranch = caseBranch();
			 _localctx.result.add(Pair.create(((CaseBranchesContext)_localctx).caseBranch.pat, ((CaseBranchesContext)_localctx).caseBranch.returns)); 
			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(476);
				match(T__35);
				setState(477);
				((CaseBranchesContext)_localctx).caseBranch = caseBranch();
				 _localctx.result.add(Pair.create(((CaseBranchesContext)_localctx).caseBranch.pat, ((CaseBranchesContext)_localctx).caseBranch.returns)); 
				}
				}
				setState(484);
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
	public static class CaseBranchContext extends ParserRuleContext {
		public PatGen pat;
		public ScopedExprGen returns;
		public PatternContext pattern;
		public ScopeExpressionContext scopeExpression;
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ScopeExpressionContext scopeExpression() {
			return getRuleContext(ScopeExpressionContext.class,0);
		}
		public CaseBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBranch; }
	}

	public final CaseBranchContext caseBranch() throws RecognitionException {
		CaseBranchContext _localctx = new CaseBranchContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_caseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 factory.startBlock(); 
			setState(486);
			((CaseBranchContext)_localctx).pattern = pattern();
			 ((CaseBranchContext)_localctx).pat =  ((CaseBranchContext)_localctx).pattern.result; 
			setState(488);
			match(T__36);
			setState(489);
			((CaseBranchContext)_localctx).scopeExpression = scopeExpression();
			 ((CaseBranchContext)_localctx).returns =  factory.finishBlock(ScopedsGen.of(((CaseBranchContext)_localctx).scopeExpression.result)::generate); 
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
	public static class PatternContext extends ParserRuleContext {
		public PatGen result;
		public SimplePatternContext simplePattern;
		public ConsPatternContext consPattern;
		public SimplePatternContext simplePattern() {
			return getRuleContext(SimplePatternContext.class,0);
		}
		public ConsPatternContext consPattern() {
			return getRuleContext(ConsPatternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pattern);
		try {
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				((PatternContext)_localctx).simplePattern = simplePattern();
				 ((PatternContext)_localctx).result =  ((PatternContext)_localctx).simplePattern.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				((PatternContext)_localctx).consPattern = consPattern();
				 ((PatternContext)_localctx).result =  ((PatternContext)_localctx).consPattern.result; 
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
	public static class SimplePatternContext extends ParserRuleContext {
		public PatGen result;
		public WildcardPatternContext wildcardPattern;
		public SExpPatternContext sExpPattern;
		public ArrayPatternContext arrayPattern;
		public ListPatternContext listPattern;
		public Token name;
		public PatternContext pattern;
		public Token d;
		public Token op;
		public Token tru;
		public Token fls;
		public Token s;
		public WildcardPatternContext wildcardPattern() {
			return getRuleContext(WildcardPatternContext.class,0);
		}
		public SExpPatternContext sExpPattern() {
			return getRuleContext(SExpPatternContext.class,0);
		}
		public ArrayPatternContext arrayPattern() {
			return getRuleContext(ArrayPatternContext.class,0);
		}
		public ListPatternContext listPattern() {
			return getRuleContext(ListPatternContext.class,0);
		}
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode DECIMAL() { return getToken(LamaParser.DECIMAL, 0); }
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public TerminalNode STRING() { return getToken(LamaParser.STRING, 0); }
		public SimplePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simplePattern; }
	}

	public final SimplePatternContext simplePattern() throws RecognitionException {
		SimplePatternContext _localctx = new SimplePatternContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_simplePattern);
		int _la;
		try {
			setState(543);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				((SimplePatternContext)_localctx).wildcardPattern = wildcardPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).wildcardPattern.result; 
				}
				break;
			case UIDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				((SimplePatternContext)_localctx).sExpPattern = sExpPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).sExpPattern.result; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(506);
				((SimplePatternContext)_localctx).arrayPattern = arrayPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).arrayPattern.result; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				((SimplePatternContext)_localctx).listPattern = listPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).listPattern.result; 
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(512);
				((SimplePatternContext)_localctx).name = match(LIDENT);
				 factory.tryAddLocal(((SimplePatternContext)_localctx).name, factory.createSkip(((SimplePatternContext)_localctx).name)); PatGen bind = factory.createWildcardPattern(); 
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__37) {
					{
					setState(514);
					match(T__37);
					setState(515);
					((SimplePatternContext)_localctx).pattern = pattern();
					 bind = ((SimplePatternContext)_localctx).pattern.result; 
					}
				}

				 ((SimplePatternContext)_localctx).result =  factory.createBindPattern(((SimplePatternContext)_localctx).name, bind); 
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(521);
				((SimplePatternContext)_localctx).d = match(DECIMAL);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern(((SimplePatternContext)_localctx).d.getText()); 
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 7);
				{
				setState(523);
				((SimplePatternContext)_localctx).op = match(OP);
				setState(524);
				((SimplePatternContext)_localctx).d = match(DECIMAL);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern(((SimplePatternContext)_localctx).op.getText() + ((SimplePatternContext)_localctx).d.getText()); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 8);
				{
				setState(526);
				((SimplePatternContext)_localctx).tru = match(T__20);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern("1"); 
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 9);
				{
				setState(528);
				((SimplePatternContext)_localctx).fls = match(T__21);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern("0"); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 10);
				{
				setState(530);
				((SimplePatternContext)_localctx).s = match(STRING);
				 ((SimplePatternContext)_localctx).result =  factory.createStrValPattern(((SimplePatternContext)_localctx).s.getText()); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 11);
				{
				setState(532);
				match(T__38);
				 ((SimplePatternContext)_localctx).result =  factory.createFunPattern(); 
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 12);
				{
				setState(534);
				match(T__39);
				 ((SimplePatternContext)_localctx).result =  factory.createValPattern(); 
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 13);
				{
				setState(536);
				match(T__40);
				 ((SimplePatternContext)_localctx).result =  factory.createStrPattern(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 14);
				{
				setState(538);
				match(T__7);
				setState(539);
				((SimplePatternContext)_localctx).pattern = pattern();
				setState(540);
				match(T__8);
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).pattern.result; 
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
	public static class ConsPatternContext extends ParserRuleContext {
		public PatGen result;
		public SimplePatternContext simplePattern;
		public Token OP;
		public PatternContext pattern;
		public SimplePatternContext simplePattern() {
			return getRuleContext(SimplePatternContext.class,0);
		}
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ConsPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consPattern; }
	}

	public final ConsPatternContext consPattern() throws RecognitionException {
		ConsPatternContext _localctx = new ConsPatternContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_consPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			((ConsPatternContext)_localctx).simplePattern = simplePattern();
			setState(546);
			((ConsPatternContext)_localctx).OP = match(OP);
			setState(547);
			if (!(((ConsPatternContext)_localctx).OP.getText().equals(":"))) throw new FailedPredicateException(this, "$OP.getText().equals(\":\")");
			setState(548);
			((ConsPatternContext)_localctx).pattern = pattern();
			 ((ConsPatternContext)_localctx).result =  factory.createConsPattern(((ConsPatternContext)_localctx).simplePattern.result, ((ConsPatternContext)_localctx).pattern.result); 
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
	public static class PatListContext extends ParserRuleContext {
		public List<PatGen> result;
		public PatternContext pattern;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public PatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patList; }
	}

	public final PatListContext patList() throws RecognitionException {
		PatListContext _localctx = new PatListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_patList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((PatListContext)_localctx).result =  new ArrayList<>(); 
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6622908296463616L) != 0)) {
				{
				setState(552);
				((PatListContext)_localctx).pattern = pattern();
				 _localctx.result.add(((PatListContext)_localctx).pattern.result); 
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(554);
					match(T__4);
					setState(555);
					((PatListContext)_localctx).pattern = pattern();
					 _localctx.result.add(((PatListContext)_localctx).pattern.result); 
					}
					}
					setState(562);
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
	public static class ListPatternContext extends ParserRuleContext {
		public PatGen result;
		public PatListContext patList;
		public PatListContext patList() {
			return getRuleContext(PatListContext.class,0);
		}
		public ListPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPattern; }
	}

	public final ListPatternContext listPattern() throws RecognitionException {
		ListPatternContext _localctx = new ListPatternContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_listPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			match(T__9);
			setState(566);
			((ListPatternContext)_localctx).patList = patList();
			setState(567);
			match(T__10);
			 ((ListPatternContext)_localctx).result =  factory.createListPattern(((ListPatternContext)_localctx).patList.result); 
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
	public static class WildcardPatternContext extends ParserRuleContext {
		public PatGen result;
		public WildcardPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardPattern; }
	}

	public final WildcardPatternContext wildcardPattern() throws RecognitionException {
		WildcardPatternContext _localctx = new WildcardPatternContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_wildcardPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(T__41);
			 ((WildcardPatternContext)_localctx).result =  factory.createWildcardPattern(); 
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
	public static class SExpPatternContext extends ParserRuleContext {
		public PatGen result;
		public Token t;
		public PatListContext patList;
		public TerminalNode UIDENT() { return getToken(LamaParser.UIDENT, 0); }
		public PatListContext patList() {
			return getRuleContext(PatListContext.class,0);
		}
		public SExpPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExpPattern; }
	}

	public final SExpPatternContext sExpPattern() throws RecognitionException {
		SExpPatternContext _localctx = new SExpPatternContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sExpPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			((SExpPatternContext)_localctx).t = match(UIDENT);
			 List<PatGen> pats = List.of(); 
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(575);
				match(T__7);
				setState(576);
				((SExpPatternContext)_localctx).patList = patList();
				setState(577);
				match(T__8);
				 pats = ((SExpPatternContext)_localctx).patList.result; 
				}
			}

			 ((SExpPatternContext)_localctx).result =  factory.createSExpPattern(((SExpPatternContext)_localctx).t.getText(), pats); 
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
	public static class ArrayPatternContext extends ParserRuleContext {
		public PatGen result;
		public PatListContext patList;
		public PatListContext patList() {
			return getRuleContext(PatListContext.class,0);
		}
		public ArrayPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayPattern; }
	}

	public final ArrayPatternContext arrayPattern() throws RecognitionException {
		ArrayPatternContext _localctx = new ArrayPatternContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arrayPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			match(T__17);
			setState(585);
			((ArrayPatternContext)_localctx).patList = patList();
			setState(586);
			match(T__18);
			 ((ArrayPatternContext)_localctx).result =  factory.createArrayPattern(((ArrayPatternContext)_localctx).patList.result); 
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
	public static class EtaExpressionContext extends ParserRuleContext {
		public ScopedExprGen result;
		public Token t;
		public BasicExpressionContext basicExpression;
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public EtaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_etaExpression; }
	}

	public final EtaExpressionContext etaExpression() throws RecognitionException {
		EtaExpressionContext _localctx = new EtaExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_etaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			((EtaExpressionContext)_localctx).t = match(T__42);
			 String synthName = factory.freshName(); factory.startFunction(List.of(synthName), "<eta>"); 
			setState(591);
			((EtaExpressionContext)_localctx).basicExpression = basicExpression(0);

			      var params = List.of(factory.createSymbol(synthName, ((EtaExpressionContext)_localctx).t));
			      var func = ((EtaExpressionContext)_localctx).basicExpression.result;
			      var fun = factory.finishFunction(ScopedsGen.of(factory.createCall(func, params, ((EtaExpressionContext)_localctx).t))::generate).instantiate();
			      ((EtaExpressionContext)_localctx).result =  factory.genValue(fun, ((EtaExpressionContext)_localctx).t)::generate;
			    
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
		case 16:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 17:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		case 35:
			return consPattern_sempred((ConsPatternContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return checkPrec(factory.getPrecedence(_input.LT(1)), _localctx._p, _localctx._r);
		}
		return true;
	}
	private boolean consPattern_sempred(ConsPatternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return ((ConsPatternContext)_localctx).OP.getText().equals(":");
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u0253\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0005\u0000V\b\u0000\n\u0000\f\u0000"+
		"Y\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002"+
		"e\b\u0002\n\u0002\f\u0002h\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004u\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005|\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0088\b\u0007\n\u0007"+
		"\f\u0007\u008b\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\b\u0094\b\b\u0001\t\u0003\t\u0097\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00b0\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b8\b\u000b\n\u000b"+
		"\f\u000b\u00bb\t\u000b\u0003\u000b\u00bd\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00c4\b\f\u0001\r\u0003\r\u00c7\b\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00d6\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00de\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00ec\b\u0010\n\u0010\f\u0010\u00ef"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f9\b\u0011\n\u0011\f\u0011"+
		"\u00fc\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u010e\b\u0012\u0001\u0012\u0005\u0012\u0111\b\u0012\n\u0012\f\u0012\u0114"+
		"\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u011e\b\u0013\n\u0013\f\u0013"+
		"\u0121\t\u0013\u0003\u0013\u0123\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0163\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u016e"+
		"\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u017c\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0184\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0195\b\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01a4"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u01b7\b\u001a\n\u001a\f\u001a\u01ba\t\u001a\u0003\u001a\u01bc\b"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u01ca\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u01e1\b\u001f\n\u001f\f\u001f\u01e4\t\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01f3\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0003\"\u0207\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u0220\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$"+
		"\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u022f\b$\n$\f$\u0232"+
		"\t$\u0003$\u0234\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0245"+
		"\b\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0000\u0001 *\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246"+
		"8:<>@BDFHJLNPR\u0000\u0001\u0001\u0000\u0003\u0004\u0270\u0000W\u0001"+
		"\u0000\u0000\u0000\u0002_\u0001\u0000\u0000\u0000\u0004f\u0001\u0000\u0000"+
		"\u0000\u0006i\u0001\u0000\u0000\u0000\bn\u0001\u0000\u0000\u0000\n{\u0001"+
		"\u0000\u0000\u0000\f}\u0001\u0000\u0000\u0000\u000e\u0081\u0001\u0000"+
		"\u0000\u0000\u0010\u0093\u0001\u0000\u0000\u0000\u0012\u0096\u0001\u0000"+
		"\u0000\u0000\u0014\u00af\u0001\u0000\u0000\u0000\u0016\u00b1\u0001\u0000"+
		"\u0000\u0000\u0018\u00be\u0001\u0000\u0000\u0000\u001a\u00c6\u0001\u0000"+
		"\u0000\u0000\u001c\u00d5\u0001\u0000\u0000\u0000\u001e\u00dd\u0001\u0000"+
		"\u0000\u0000 \u00e2\u0001\u0000\u0000\u0000\"\u00f0\u0001\u0000\u0000"+
		"\u0000$\u00fd\u0001\u0000\u0000\u0000&\u0115\u0001\u0000\u0000\u0000("+
		"\u0162\u0001\u0000\u0000\u0000*\u0164\u0001\u0000\u0000\u0000,\u0183\u0001"+
		"\u0000\u0000\u0000.\u0185\u0001\u0000\u0000\u00000\u018c\u0001\u0000\u0000"+
		"\u00002\u019c\u0001\u0000\u0000\u00004\u01af\u0001\u0000\u0000\u00006"+
		"\u01bd\u0001\u0000\u0000\u00008\u01c2\u0001\u0000\u0000\u0000:\u01cd\u0001"+
		"\u0000\u0000\u0000<\u01d2\u0001\u0000\u0000\u0000>\u01d9\u0001\u0000\u0000"+
		"\u0000@\u01e5\u0001\u0000\u0000\u0000B\u01f2\u0001\u0000\u0000\u0000D"+
		"\u021f\u0001\u0000\u0000\u0000F\u0221\u0001\u0000\u0000\u0000H\u0227\u0001"+
		"\u0000\u0000\u0000J\u0235\u0001\u0000\u0000\u0000L\u023a\u0001\u0000\u0000"+
		"\u0000N\u023d\u0001\u0000\u0000\u0000P\u0248\u0001\u0000\u0000\u0000R"+
		"\u024d\u0001\u0000\u0000\u0000TV\u0003\u0002\u0001\u0000UT\u0001\u0000"+
		"\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"Z[\u0006\u0000\uffff\uffff\u0000[\\\u0003\u0018\f\u0000\\]\u0006\u0000"+
		"\uffff\uffff\u0000]^\u0005\u0000\u0000\u0001^\u0001\u0001\u0000\u0000"+
		"\u0000_`\u0005\u0001\u0000\u0000`a\u0005/\u0000\u0000ab\u0005\u0002\u0000"+
		"\u0000b\u0003\u0001\u0000\u0000\u0000ce\u0003\n\u0005\u0000dc\u0001\u0000"+
		"\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000g\u0005\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000ij\u0006\u0003\uffff\uffff\u0000jk\u0003\u0004\u0002\u0000kl\u0003"+
		" \u0010\u0000lm\u0006\u0003\uffff\uffff\u0000m\u0007\u0001\u0000\u0000"+
		"\u0000no\u0006\u0004\uffff\uffff\u0000op\u0003\u0004\u0002\u0000pt\u0006"+
		"\u0004\uffff\uffff\u0000qr\u0003 \u0010\u0000rs\u0006\u0004\uffff\uffff"+
		"\u0000su\u0001\u0000\u0000\u0000tq\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0006\u0004\uffff\uffff\u0000"+
		"w\t\u0001\u0000\u0000\u0000x|\u0003\f\u0006\u0000y|\u0003\u0012\t\u0000"+
		"z|\u0003\u001a\r\u0000{x\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{z\u0001\u0000\u0000\u0000|\u000b\u0001\u0000\u0000\u0000}~\u0007\u0000"+
		"\u0000\u0000~\u007f\u0003\u000e\u0007\u0000\u007f\u0080\u0005\u0002\u0000"+
		"\u0000\u0080\r\u0001\u0000\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000"+
		"\u0082\u0089\u0006\u0007\uffff\uffff\u0000\u0083\u0084\u0005\u0005\u0000"+
		"\u0000\u0084\u0085\u0003\u0010\b\u0000\u0085\u0086\u0006\u0007\uffff\uffff"+
		"\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000"+
		"\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u000f\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008d\u00050\u0000\u0000"+
		"\u008d\u0094\u0006\b\uffff\uffff\u0000\u008e\u008f\u00050\u0000\u0000"+
		"\u008f\u0090\u0005\u0006\u0000\u0000\u0090\u0091\u0003\"\u0011\u0000\u0091"+
		"\u0092\u0006\b\uffff\uffff\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u008c\u0001\u0000\u0000\u0000\u0093\u008e\u0001\u0000\u0000\u0000\u0094"+
		"\u0011\u0001\u0000\u0000\u0000\u0095\u0097\u0005\u0004\u0000\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0007\u0000\u0000\u0099"+
		"\u009a\u00050\u0000\u0000\u009a\u009b\u0003\u0014\n\u0000\u009b\u009c"+
		"\u0006\t\uffff\uffff\u0000\u009c\u0013\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005\b\u0000\u0000\u009e\u009f\u0003\u0016\u000b\u0000\u009f\u00a0\u0005"+
		"\t\u0000\u0000\u00a0\u00a1\u0006\n\uffff\uffff\u0000\u00a1\u00a2\u0005"+
		"\n\u0000\u0000\u00a2\u00a3\u0003\u0018\f\u0000\u00a3\u00a4\u0005\u000b"+
		"\u0000\u0000\u00a4\u00a5\u0006\n\uffff\uffff\u0000\u00a5\u00b0\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\b\u0000\u0000\u00a7\u00a8\u0003H$\u0000"+
		"\u00a8\u00a9\u0005\t\u0000\u0000\u00a9\u00aa\u0006\n\uffff\uffff\u0000"+
		"\u00aa\u00ab\u0005\n\u0000\u0000\u00ab\u00ac\u0003\u0018\f\u0000\u00ac"+
		"\u00ad\u0005\u000b\u0000\u0000\u00ad\u00ae\u0006\n\uffff\uffff\u0000\u00ae"+
		"\u00b0\u0001\u0000\u0000\u0000\u00af\u009d\u0001\u0000\u0000\u0000\u00af"+
		"\u00a6\u0001\u0000\u0000\u0000\u00b0\u0015\u0001\u0000\u0000\u0000\u00b1"+
		"\u00bc\u0006\u000b\uffff\uffff\u0000\u00b2\u00b3\u00050\u0000\u0000\u00b3"+
		"\u00b9\u0006\u000b\uffff\uffff\u0000\u00b4\u00b5\u0005\u0005\u0000\u0000"+
		"\u00b5\u00b6\u00050\u0000\u0000\u00b6\u00b8\u0006\u000b\uffff\uffff\u0000"+
		"\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b2\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bd\u0017\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\u0004\u0002\u0000"+
		"\u00bf\u00c3\u0006\f\uffff\uffff\u0000\u00c0\u00c1\u0003 \u0010\u0000"+
		"\u00c1\u00c2\u0006\f\uffff\uffff\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u0019\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005\u0004\u0000\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003\u001c\u000e\u0000"+
		"\u00c9\u00ca\u00054\u0000\u0000\u00ca\u00cb\u0003\u001e\u000f\u0000\u00cb"+
		"\u00cc\u0003\u0014\n\u0000\u00cc\u00cd\u0006\r\uffff\uffff\u0000\u00cd"+
		"\u00ce\u0006\r\uffff\uffff\u0000\u00ce\u001b\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005\f\u0000\u0000\u00d0\u00d6\u0006\u000e\uffff\uffff\u0000\u00d1"+
		"\u00d2\u0005\r\u0000\u0000\u00d2\u00d6\u0006\u000e\uffff\uffff\u0000\u00d3"+
		"\u00d4\u0005\u000e\u0000\u0000\u00d4\u00d6\u0006\u000e\uffff\uffff\u0000"+
		"\u00d5\u00cf\u0001\u0000\u0000\u0000\u00d5\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u001d\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u0005\u000f\u0000\u0000\u00d8\u00de\u0006\u000f\uffff\uffff"+
		"\u0000\u00d9\u00da\u0005\u0010\u0000\u0000\u00da\u00de\u0006\u000f\uffff"+
		"\uffff\u0000\u00db\u00dc\u0005\u0011\u0000\u0000\u00dc\u00de\u0006\u000f"+
		"\uffff\uffff\u0000\u00dd\u00d7\u0001\u0000\u0000\u0000\u00dd\u00d9\u0001"+
		"\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u00054\u0000\u0000\u00e0\u00e1\u0006\u000f"+
		"\uffff\uffff\u0000\u00e1\u001f\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006"+
		"\u0010\uffff\uffff\u0000\u00e3\u00e4\u0003\"\u0011\u0000\u00e4\u00e5\u0006"+
		"\u0010\uffff\uffff\u0000\u00e5\u00ed\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\n\u0001\u0000\u0000\u00e7\u00e8\u0005\u0002\u0000\u0000\u00e8\u00e9\u0003"+
		"\"\u0011\u0000\u00e9\u00ea\u0006\u0010\uffff\uffff\u0000\u00ea\u00ec\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e6\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ee!\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0003$\u0012\u0000\u00f1\u00fa\u0006\u0011\uffff"+
		"\uffff\u0000\u00f2\u00f3\u0004\u0011\u0001\u0001\u00f3\u00f4\u00054\u0000"+
		"\u0000\u00f4\u00f5\u0003\"\u0011\u0000\u00f5\u00f6\u0006\u0011\uffff\uffff"+
		"\u0000\u00f6\u00f7\u0006\u0011\uffff\uffff\u0000\u00f7\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f2\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb#\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0003(\u0014\u0000\u00fe\u0112\u0006\u0012\uffff\uffff"+
		"\u0000\u00ff\u0100\u0005\u0012\u0000\u0000\u0100\u0101\u0003 \u0010\u0000"+
		"\u0101\u0102\u0005\u0013\u0000\u0000\u0102\u0103\u0006\u0012\uffff\uffff"+
		"\u0000\u0103\u0111\u0001\u0000\u0000\u0000\u0104\u0105\u0003&\u0013\u0000"+
		"\u0105\u0106\u0006\u0012\uffff\uffff\u0000\u0106\u0111\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005\u0014\u0000\u0000\u0108\u0109\u00050\u0000\u0000"+
		"\u0109\u010d\u0006\u0012\uffff\uffff\u0000\u010a\u010b\u0003&\u0013\u0000"+
		"\u010b\u010c\u0006\u0012\uffff\uffff\u0000\u010c\u010e\u0001\u0000\u0000"+
		"\u0000\u010d\u010a\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0111\u0006\u0012\uffff"+
		"\uffff\u0000\u0110\u00ff\u0001\u0000\u0000\u0000\u0110\u0104\u0001\u0000"+
		"\u0000\u0000\u0110\u0107\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000"+
		"\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000"+
		"\u0000\u0000\u0113%\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0005\b\u0000\u0000\u0116\u0122\u0006\u0013\uffff\uffff"+
		"\u0000\u0117\u0118\u0003\u0006\u0003\u0000\u0118\u011f\u0006\u0013\uffff"+
		"\uffff\u0000\u0119\u011a\u0005\u0005\u0000\u0000\u011a\u011b\u0003\u0006"+
		"\u0003\u0000\u011b\u011c\u0006\u0013\uffff\uffff\u0000\u011c\u011e\u0001"+
		"\u0000\u0000\u0000\u011d\u0119\u0001\u0000\u0000\u0000\u011e\u0121\u0001"+
		"\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001"+
		"\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001"+
		"\u0000\u0000\u0000\u0122\u0117\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0005"+
		"\t\u0000\u0000\u0125\'\u0001\u0000\u0000\u0000\u0126\u0127\u00051\u0000"+
		"\u0000\u0127\u0163\u0006\u0014\uffff\uffff\u0000\u0128\u0129\u00052\u0000"+
		"\u0000\u0129\u0163\u0006\u0014\uffff\uffff\u0000\u012a\u012b\u00053\u0000"+
		"\u0000\u012b\u0163\u0006\u0014\uffff\uffff\u0000\u012c\u012d\u00050\u0000"+
		"\u0000\u012d\u0163\u0006\u0014\uffff\uffff\u0000\u012e\u012f\u0005\u0015"+
		"\u0000\u0000\u012f\u0163\u0006\u0014\uffff\uffff\u0000\u0130\u0131\u0005"+
		"\u0016\u0000\u0000\u0131\u0163\u0006\u0014\uffff\uffff\u0000\u0132\u0133"+
		"\u0005\f\u0000\u0000\u0133\u0134\u00054\u0000\u0000\u0134\u0163\u0006"+
		"\u0014\uffff\uffff\u0000\u0135\u0136\u0005\u0007\u0000\u0000\u0136\u0137"+
		"\u0003\u0014\n\u0000\u0137\u0138\u0006\u0014\uffff\uffff\u0000\u0138\u0163"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0005\u0017\u0000\u0000\u013a\u0163"+
		"\u0006\u0014\uffff\uffff\u0000\u013b\u013c\u00054\u0000\u0000\u013c\u013d"+
		"\u00051\u0000\u0000\u013d\u0163\u0006\u0014\uffff\uffff\u0000\u013e\u013f"+
		"\u00054\u0000\u0000\u013f\u0140\u0003\"\u0011\u0000\u0140\u0141\u0006"+
		"\u0014\uffff\uffff\u0000\u0141\u0163\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005\b\u0000\u0000\u0143\u0144\u0003\u0006\u0003\u0000\u0144\u0145\u0005"+
		"\t\u0000\u0000\u0145\u0146\u0006\u0014\uffff\uffff\u0000\u0146\u0163\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0003:\u001d\u0000\u0148\u0149\u0006\u0014"+
		"\uffff\uffff\u0000\u0149\u0163\u0001\u0000\u0000\u0000\u014a\u014b\u0003"+
		"6\u001b\u0000\u014b\u014c\u0006\u0014\uffff\uffff\u0000\u014c\u0163\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u00038\u001c\u0000\u014e\u014f\u0006\u0014"+
		"\uffff\uffff\u0000\u014f\u0163\u0001\u0000\u0000\u0000\u0150\u0151\u0003"+
		"*\u0015\u0000\u0151\u0152\u0006\u0014\uffff\uffff\u0000\u0152\u0163\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0003.\u0017\u0000\u0154\u0155\u0006\u0014"+
		"\uffff\uffff\u0000\u0155\u0163\u0001\u0000\u0000\u0000\u0156\u0157\u0003"+
		"0\u0018\u0000\u0157\u0158\u0006\u0014\uffff\uffff\u0000\u0158\u0163\u0001"+
		"\u0000\u0000\u0000\u0159\u015a\u00032\u0019\u0000\u015a\u015b\u0006\u0014"+
		"\uffff\uffff\u0000\u015b\u0163\u0001\u0000\u0000\u0000\u015c\u015d\u0003"+
		"<\u001e\u0000\u015d\u015e\u0006\u0014\uffff\uffff\u0000\u015e\u0163\u0001"+
		"\u0000\u0000\u0000\u015f\u0160\u0003R)\u0000\u0160\u0161\u0006\u0014\uffff"+
		"\uffff\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0126\u0001\u0000"+
		"\u0000\u0000\u0162\u0128\u0001\u0000\u0000\u0000\u0162\u012a\u0001\u0000"+
		"\u0000\u0000\u0162\u012c\u0001\u0000\u0000\u0000\u0162\u012e\u0001\u0000"+
		"\u0000\u0000\u0162\u0130\u0001\u0000\u0000\u0000\u0162\u0132\u0001\u0000"+
		"\u0000\u0000\u0162\u0135\u0001\u0000\u0000\u0000\u0162\u0139\u0001\u0000"+
		"\u0000\u0000\u0162\u013b\u0001\u0000\u0000\u0000\u0162\u013e\u0001\u0000"+
		"\u0000\u0000\u0162\u0142\u0001\u0000\u0000\u0000\u0162\u0147\u0001\u0000"+
		"\u0000\u0000\u0162\u014a\u0001\u0000\u0000\u0000\u0162\u014d\u0001\u0000"+
		"\u0000\u0000\u0162\u0150\u0001\u0000\u0000\u0000\u0162\u0153\u0001\u0000"+
		"\u0000\u0000\u0162\u0156\u0001\u0000\u0000\u0000\u0162\u0159\u0001\u0000"+
		"\u0000\u0000\u0162\u015c\u0001\u0000\u0000\u0000\u0162\u015f\u0001\u0000"+
		"\u0000\u0000\u0163)\u0001\u0000\u0000\u0000\u0164\u0165\u0006\u0015\uffff"+
		"\uffff\u0000\u0165\u0166\u0005\u0018\u0000\u0000\u0166\u0167\u0003 \u0010"+
		"\u0000\u0167\u0168\u0005\u0019\u0000\u0000\u0168\u0169\u0003\u0006\u0003"+
		"\u0000\u0169\u016d\u0006\u0015\uffff\uffff\u0000\u016a\u016b\u0003,\u0016"+
		"\u0000\u016b\u016c\u0006\u0015\uffff\uffff\u0000\u016c\u016e\u0001\u0000"+
		"\u0000\u0000\u016d\u016a\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000"+
		"\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0006\u0015"+
		"\uffff\uffff\u0000\u0170\u0171\u0005\u001a\u0000\u0000\u0171+\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0006\u0016\uffff\uffff\u0000\u0173\u0174\u0005"+
		"\u001b\u0000\u0000\u0174\u0175\u0003 \u0010\u0000\u0175\u0176\u0005\u0019"+
		"\u0000\u0000\u0176\u0177\u0003\u0006\u0003\u0000\u0177\u017b\u0006\u0016"+
		"\uffff\uffff\u0000\u0178\u0179\u0003,\u0016\u0000\u0179\u017a\u0006\u0016"+
		"\uffff\uffff\u0000\u017a\u017c\u0001\u0000\u0000\u0000\u017b\u0178\u0001"+
		"\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017d\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0006\u0016\uffff\uffff\u0000\u017e\u0184"+
		"\u0001\u0000\u0000\u0000\u017f\u0180\u0005\u001c\u0000\u0000\u0180\u0181"+
		"\u0003\u0006\u0003\u0000\u0181\u0182\u0006\u0016\uffff\uffff\u0000\u0182"+
		"\u0184\u0001\u0000\u0000\u0000\u0183\u0172\u0001\u0000\u0000\u0000\u0183"+
		"\u017f\u0001\u0000\u0000\u0000\u0184-\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0005\u001d\u0000\u0000\u0186\u0187\u0003 \u0010\u0000\u0187\u0188\u0005"+
		"\u001e\u0000\u0000\u0188\u0189\u0003\u0006\u0003\u0000\u0189\u018a\u0006"+
		"\u0017\uffff\uffff\u0000\u018a\u018b\u0005\u001f\u0000\u0000\u018b/\u0001"+
		"\u0000\u0000\u0000\u018c\u018d\u0005\u001e\u0000\u0000\u018d\u018e\u0006"+
		"\u0018\uffff\uffff\u0000\u018e\u018f\u0003\u0004\u0002\u0000\u018f\u0190"+
		"\u0006\u0018\uffff\uffff\u0000\u0190\u0194\u0006\u0018\uffff\uffff\u0000"+
		"\u0191\u0192\u0003 \u0010\u0000\u0192\u0193\u0006\u0018\uffff\uffff\u0000"+
		"\u0193\u0195\u0001\u0000\u0000\u0000\u0194\u0191\u0001\u0000\u0000\u0000"+
		"\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000"+
		"\u0196\u0197\u0006\u0018\uffff\uffff\u0000\u0197\u0198\u0005\u001d\u0000"+
		"\u0000\u0198\u0199\u0003 \u0010\u0000\u0199\u019a\u0006\u0018\uffff\uffff"+
		"\u0000\u019a\u019b\u0005\u001f\u0000\u0000\u019b1\u0001\u0000\u0000\u0000"+
		"\u019c\u019d\u0005 \u0000\u0000\u019d\u019e\u0006\u0019\uffff\uffff\u0000"+
		"\u019e\u019f\u0003\u0004\u0002\u0000\u019f\u01a3\u0006\u0019\uffff\uffff"+
		"\u0000\u01a0\u01a1\u0003 \u0010\u0000\u01a1\u01a2\u0006\u0019\uffff\uffff"+
		"\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0006\u0019\uffff\uffff\u0000\u01a6\u01a7\u0005\u0005"+
		"\u0000\u0000\u01a7\u01a8\u0003 \u0010\u0000\u01a8\u01a9\u0005\u0005\u0000"+
		"\u0000\u01a9\u01aa\u0003 \u0010\u0000\u01aa\u01ab\u0005\u001e\u0000\u0000"+
		"\u01ab\u01ac\u0003\b\u0004\u0000\u01ac\u01ad\u0006\u0019\uffff\uffff\u0000"+
		"\u01ad\u01ae\u0005\u001f\u0000\u0000\u01ae3\u0001\u0000\u0000\u0000\u01af"+
		"\u01bb\u0006\u001a\uffff\uffff\u0000\u01b0\u01b1\u0003 \u0010\u0000\u01b1"+
		"\u01b8\u0006\u001a\uffff\uffff\u0000\u01b2\u01b3\u0005\u0005\u0000\u0000"+
		"\u01b3\u01b4\u0003 \u0010\u0000\u01b4\u01b5\u0006\u001a\uffff\uffff\u0000"+
		"\u01b5\u01b7\u0001\u0000\u0000\u0000\u01b6\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b7\u01ba\u0001\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000"+
		"\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01b0\u0001\u0000\u0000\u0000"+
		"\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc5\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0005\u0012\u0000\u0000\u01be\u01bf\u00034\u001a\u0000\u01bf\u01c0"+
		"\u0005\u0013\u0000\u0000\u01c0\u01c1\u0006\u001b\uffff\uffff\u0000\u01c1"+
		"7\u0001\u0000\u0000\u0000\u01c2\u01c3\u0005/\u0000\u0000\u01c3\u01c9\u0006"+
		"\u001c\uffff\uffff\u0000\u01c4\u01c5\u0005\b\u0000\u0000\u01c5\u01c6\u0003"+
		"4\u001a\u0000\u01c6\u01c7\u0005\t\u0000\u0000\u01c7\u01c8\u0006\u001c"+
		"\uffff\uffff\u0000\u01c8\u01ca\u0001\u0000\u0000\u0000\u01c9\u01c4\u0001"+
		"\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001"+
		"\u0000\u0000\u0000\u01cb\u01cc\u0006\u001c\uffff\uffff\u0000\u01cc9\u0001"+
		"\u0000\u0000\u0000\u01cd\u01ce\u0005\n\u0000\u0000\u01ce\u01cf\u00034"+
		"\u001a\u0000\u01cf\u01d0\u0005\u000b\u0000\u0000\u01d0\u01d1\u0006\u001d"+
		"\uffff\uffff\u0000\u01d1;\u0001\u0000\u0000\u0000\u01d2\u01d3\u0005!\u0000"+
		"\u0000\u01d3\u01d4\u0003 \u0010\u0000\u01d4\u01d5\u0005\"\u0000\u0000"+
		"\u01d5\u01d6\u0003>\u001f\u0000\u01d6\u01d7\u0005#\u0000\u0000\u01d7\u01d8"+
		"\u0006\u001e\uffff\uffff\u0000\u01d8=\u0001\u0000\u0000\u0000\u01d9\u01da"+
		"\u0006\u001f\uffff\uffff\u0000\u01da\u01db\u0003@ \u0000\u01db\u01e2\u0006"+
		"\u001f\uffff\uffff\u0000\u01dc\u01dd\u0005$\u0000\u0000\u01dd\u01de\u0003"+
		"@ \u0000\u01de\u01df\u0006\u001f\uffff\uffff\u0000\u01df\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e0\u01dc\u0001\u0000\u0000\u0000\u01e1\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e3?\u0001\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0006 \uffff\uffff\u0000\u01e6\u01e7\u0003B!\u0000"+
		"\u01e7\u01e8\u0006 \uffff\uffff\u0000\u01e8\u01e9\u0005%\u0000\u0000\u01e9"+
		"\u01ea\u0003\u0006\u0003\u0000\u01ea\u01eb\u0006 \uffff\uffff\u0000\u01eb"+
		"A\u0001\u0000\u0000\u0000\u01ec\u01ed\u0003D\"\u0000\u01ed\u01ee\u0006"+
		"!\uffff\uffff\u0000\u01ee\u01f3\u0001\u0000\u0000\u0000\u01ef\u01f0\u0003"+
		"F#\u0000\u01f0\u01f1\u0006!\uffff\uffff\u0000\u01f1\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f2\u01ec\u0001\u0000\u0000\u0000\u01f2\u01ef\u0001\u0000"+
		"\u0000\u0000\u01f3C\u0001\u0000\u0000\u0000\u01f4\u01f5\u0003L&\u0000"+
		"\u01f5\u01f6\u0006\"\uffff\uffff\u0000\u01f6\u0220\u0001\u0000\u0000\u0000"+
		"\u01f7\u01f8\u0003N\'\u0000\u01f8\u01f9\u0006\"\uffff\uffff\u0000\u01f9"+
		"\u0220\u0001\u0000\u0000\u0000\u01fa\u01fb\u0003P(\u0000\u01fb\u01fc\u0006"+
		"\"\uffff\uffff\u0000\u01fc\u0220\u0001\u0000\u0000\u0000\u01fd\u01fe\u0003"+
		"J%\u0000\u01fe\u01ff\u0006\"\uffff\uffff\u0000\u01ff\u0220\u0001\u0000"+
		"\u0000\u0000\u0200\u0201\u00050\u0000\u0000\u0201\u0206\u0006\"\uffff"+
		"\uffff\u0000\u0202\u0203\u0005&\u0000\u0000\u0203\u0204\u0003B!\u0000"+
		"\u0204\u0205\u0006\"\uffff\uffff\u0000\u0205\u0207\u0001\u0000\u0000\u0000"+
		"\u0206\u0202\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000"+
		"\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u0220\u0006\"\uffff\uffff\u0000"+
		"\u0209\u020a\u00051\u0000\u0000\u020a\u0220\u0006\"\uffff\uffff\u0000"+
		"\u020b\u020c\u00054\u0000\u0000\u020c\u020d\u00051\u0000\u0000\u020d\u0220"+
		"\u0006\"\uffff\uffff\u0000\u020e\u020f\u0005\u0015\u0000\u0000\u020f\u0220"+
		"\u0006\"\uffff\uffff\u0000\u0210\u0211\u0005\u0016\u0000\u0000\u0211\u0220"+
		"\u0006\"\uffff\uffff\u0000\u0212\u0213\u00052\u0000\u0000\u0213\u0220"+
		"\u0006\"\uffff\uffff\u0000\u0214\u0215\u0005\'\u0000\u0000\u0215\u0220"+
		"\u0006\"\uffff\uffff\u0000\u0216\u0217\u0005(\u0000\u0000\u0217\u0220"+
		"\u0006\"\uffff\uffff\u0000\u0218\u0219\u0005)\u0000\u0000\u0219\u0220"+
		"\u0006\"\uffff\uffff\u0000\u021a\u021b\u0005\b\u0000\u0000\u021b\u021c"+
		"\u0003B!\u0000\u021c\u021d\u0005\t\u0000\u0000\u021d\u021e\u0006\"\uffff"+
		"\uffff\u0000\u021e\u0220\u0001\u0000\u0000\u0000\u021f\u01f4\u0001\u0000"+
		"\u0000\u0000\u021f\u01f7\u0001\u0000\u0000\u0000\u021f\u01fa\u0001\u0000"+
		"\u0000\u0000\u021f\u01fd\u0001\u0000\u0000\u0000\u021f\u0200\u0001\u0000"+
		"\u0000\u0000\u021f\u0209\u0001\u0000\u0000\u0000\u021f\u020b\u0001\u0000"+
		"\u0000\u0000\u021f\u020e\u0001\u0000\u0000\u0000\u021f\u0210\u0001\u0000"+
		"\u0000\u0000\u021f\u0212\u0001\u0000\u0000\u0000\u021f\u0214\u0001\u0000"+
		"\u0000\u0000\u021f\u0216\u0001\u0000\u0000\u0000\u021f\u0218\u0001\u0000"+
		"\u0000\u0000\u021f\u021a\u0001\u0000\u0000\u0000\u0220E\u0001\u0000\u0000"+
		"\u0000\u0221\u0222\u0003D\"\u0000\u0222\u0223\u00054\u0000\u0000\u0223"+
		"\u0224\u0004#\u0002\u0001\u0224\u0225\u0003B!\u0000\u0225\u0226\u0006"+
		"#\uffff\uffff\u0000\u0226G\u0001\u0000\u0000\u0000\u0227\u0233\u0006$"+
		"\uffff\uffff\u0000\u0228\u0229\u0003B!\u0000\u0229\u0230\u0006$\uffff"+
		"\uffff\u0000\u022a\u022b\u0005\u0005\u0000\u0000\u022b\u022c\u0003B!\u0000"+
		"\u022c\u022d\u0006$\uffff\uffff\u0000\u022d\u022f\u0001\u0000\u0000\u0000"+
		"\u022e\u022a\u0001\u0000\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000"+
		"\u0230\u022e\u0001\u0000\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000"+
		"\u0231\u0234\u0001\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000"+
		"\u0233\u0228\u0001\u0000\u0000\u0000\u0233\u0234\u0001\u0000\u0000\u0000"+
		"\u0234I\u0001\u0000\u0000\u0000\u0235\u0236\u0005\n\u0000\u0000\u0236"+
		"\u0237\u0003H$\u0000\u0237\u0238\u0005\u000b\u0000\u0000\u0238\u0239\u0006"+
		"%\uffff\uffff\u0000\u0239K\u0001\u0000\u0000\u0000\u023a\u023b\u0005*"+
		"\u0000\u0000\u023b\u023c\u0006&\uffff\uffff\u0000\u023cM\u0001\u0000\u0000"+
		"\u0000\u023d\u023e\u0005/\u0000\u0000\u023e\u0244\u0006\'\uffff\uffff"+
		"\u0000\u023f\u0240\u0005\b\u0000\u0000\u0240\u0241\u0003H$\u0000\u0241"+
		"\u0242\u0005\t\u0000\u0000\u0242\u0243\u0006\'\uffff\uffff\u0000\u0243"+
		"\u0245\u0001\u0000\u0000\u0000\u0244\u023f\u0001\u0000\u0000\u0000\u0244"+
		"\u0245\u0001\u0000\u0000\u0000\u0245\u0246\u0001\u0000\u0000\u0000\u0246"+
		"\u0247\u0006\'\uffff\uffff\u0000\u0247O\u0001\u0000\u0000\u0000\u0248"+
		"\u0249\u0005\u0012\u0000\u0000\u0249\u024a\u0003H$\u0000\u024a\u024b\u0005"+
		"\u0013\u0000\u0000\u024b\u024c\u0006(\uffff\uffff\u0000\u024cQ\u0001\u0000"+
		"\u0000\u0000\u024d\u024e\u0005+\u0000\u0000\u024e\u024f\u0006)\uffff\uffff"+
		"\u0000\u024f\u0250\u0003\"\u0011\u0000\u0250\u0251\u0006)\uffff\uffff"+
		"\u0000\u0251S\u0001\u0000\u0000\u0000%Wft{\u0089\u0093\u0096\u00af\u00b9"+
		"\u00bc\u00c3\u00c6\u00d5\u00dd\u00ed\u00fa\u010d\u0110\u0112\u011f\u0122"+
		"\u0162\u016d\u017b\u0183\u0194\u01a3\u01b8\u01bb\u01c9\u01e2\u01f2\u0206"+
		"\u021f\u0230\u0233\u0244";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}