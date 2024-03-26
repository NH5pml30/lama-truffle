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
		STRING=32, CHAR=33, OP=34;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeDefinitions = 2, 
		RULE_scopeExpression = 3, RULE_scopeExpression0 = 4, RULE_definition = 5, 
		RULE_variableDefinition = 6, RULE_variableDefinitionSequence = 7, RULE_variableDefinitionItem = 8, 
		RULE_functionDefinition = 9, RULE_functionArguments = 10, RULE_functionBody = 11, 
		RULE_expression = 12, RULE_basicExpression = 13, RULE_primaryExpression = 14, 
		RULE_primary = 15, RULE_ifExpression = 16, RULE_elsePart = 17, RULE_whileDoExpression = 18, 
		RULE_doWhileExpression = 19, RULE_forExpression = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeDefinitions", "scopeExpression", 
			"scopeExpression0", "definition", "variableDefinition", "variableDefinitionSequence", 
			"variableDefinitionItem", "functionDefinition", "functionArguments", 
			"functionBody", "expression", "basicExpression", "primaryExpression", 
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
			"STRING", "CHAR", "OP"
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(42);
				importStt();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(49);
			((CompilationUnitContext)_localctx).functionBody = functionBody();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).functionBody.result, _input.LT(1)); 
			setState(51);
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
			setState(53);
			match(T__0);
			setState(54);
			match(UIDENT);
			setState(55);
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
		public Map<String, ExprGen> result;
		public DefinitionContext definition;
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
			 ((ScopeDefinitionsContext)_localctx).result =  new HashMap<String, ExprGen>(); 
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(58);
					((ScopeDefinitionsContext)_localctx).definition = definition();
					 _localctx.result.putAll(((ScopeDefinitionsContext)_localctx).definition.result); 
					}
					} 
				}
				setState(65);
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
		public ExprGen result;
		public ScopeDefinitionsContext defs;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeDefinitionsContext scopeDefinitions() {
			return getRuleContext(ScopeDefinitionsContext.class,0);
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
			setState(67);
			((ScopeExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ScopeExpressionContext)_localctx).defs.result.keySet()); factory.addLocalValues(((ScopeExpressionContext)_localctx).defs.result); 
			setState(69);
			((ScopeExpressionContext)_localctx).expression = expression();
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
		public ExprGen result;
		public ScopeDefinitionsContext defs;
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
			setState(73);
			((ScopeExpression0Context)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ScopeExpression0Context)_localctx).defs.result.keySet()); factory.addLocalValues(((ScopeExpression0Context)_localctx).defs.result); 
			 ExprsGen gen = ExprsGen.of(); 
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33332380032L) != 0)) {
				{
				setState(76);
				((ScopeExpression0Context)_localctx).expression = expression();
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
		public Map<String, ExprGen> result;
		public VariableDefinitionContext variableDefinition;
		public FunctionDefinitionContext functionDefinition;
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
		enterRule(_localctx, 10, RULE_definition);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				((DefinitionContext)_localctx).variableDefinition = variableDefinition();
				 ((DefinitionContext)_localctx).result =  ((DefinitionContext)_localctx).variableDefinition.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				((DefinitionContext)_localctx).functionDefinition = functionDefinition();
				 ((DefinitionContext)_localctx).result =  ((DefinitionContext)_localctx).functionDefinition.result; 
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
		public Map<String, ExprGen> result;
		public VariableDefinitionSequenceContext variableDefinitionSequence;
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
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(92);
			((VariableDefinitionContext)_localctx).variableDefinitionSequence = variableDefinitionSequence();
			setState(93);
			match(T__1);
			 ((VariableDefinitionContext)_localctx).result =  ((VariableDefinitionContext)_localctx).variableDefinitionSequence.result; 
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
		public Map<String, ExprGen> result;
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
			 ((VariableDefinitionSequenceContext)_localctx).result =  new HashMap<String, ExprGen>(); 
			setState(97);
			((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
			 _localctx.result.put(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(99);
				match(T__4);
				setState(100);
				((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
				 _localctx.result.put(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
				}
				}
				setState(107);
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
		public String name;
		public ExprGen value;
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT.getText(); ((VariableDefinitionItemContext)_localctx).value =  a -> null; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(111);
				match(T__5);
				setState(112);
				((VariableDefinitionItemContext)_localctx).basicExpression = basicExpression(0);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT.getText(); ((VariableDefinitionItemContext)_localctx).value =  ((VariableDefinitionItemContext)_localctx).basicExpression.result; 
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
		public Map<String, ExprGen> result;
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
		enterRule(_localctx, 18, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDefinitionContext)_localctx).result =  new HashMap<String, ExprGen>(); 
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(118);
				match(T__3);
				}
			}

			setState(121);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(122);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(123);
			match(T__7);
			setState(124);
			((FunctionDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(125);
			match(T__8);
			 factory.startFunction(((FunctionDefinitionContext)_localctx).functionArguments.result); 
			setState(127);
			match(T__9);
			setState(128);
			((FunctionDefinitionContext)_localctx).functionBody = functionBody();
			setState(129);
			match(T__10);
			 _localctx.result.put(((FunctionDefinitionContext)_localctx).name.getText(), factory.finishFunction(((FunctionDefinitionContext)_localctx).functionBody.result, ((FunctionDefinitionContext)_localctx).t)); 
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
		enterRule(_localctx, 20, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionArgumentsContext)_localctx).result =  new ArrayList<Token>(); 
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(133);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(135);
					match(T__4);
					setState(136);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
					}
					}
					setState(142);
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
		public ScopeDefinitionsContext defs;
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
		enterRule(_localctx, 22, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			((FunctionBodyContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((FunctionBodyContext)_localctx).defs.result.keySet()); factory.addLocalValues(((FunctionBodyContext)_localctx).defs.result); 
			 ((FunctionBodyContext)_localctx).result =  ExprsGen.of(); 
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33332380032L) != 0)) {
				{
				setState(148);
				((FunctionBodyContext)_localctx).expression = expression();
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
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				setState(158);
				match(T__1);
				setState(159);
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
		enterRule(_localctx, 26, RULE_basicExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; 
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(166);
					if (!(factory.getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "factory.getPrecedence(_input.LT(1)) >= $_p");
					setState(167);
					((BasicExpressionContext)_localctx).op = match(OP);
					setState(168);
					((BasicExpressionContext)_localctx).rhs = basicExpression(factory.getNextPrecedence(((BasicExpressionContext)_localctx).op));
					 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, _localctx.result, ((BasicExpressionContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(175);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public ExprGen result;
		public PrimaryContext primary;
		public ScopeExpressionContext scopeExpression;
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
		public List<ScopeExpressionContext> scopeExpression() {
			return getRuleContexts(ScopeExpressionContext.class);
		}
		public ScopeExpressionContext scopeExpression(int i) {
			return getRuleContext(ScopeExpressionContext.class,i);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primaryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(199);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(178);
						match(T__11);
						setState(179);
						expression();
						setState(180);
						match(T__12);
						}
						break;
					case T__7:
						{
						setState(182);
						match(T__7);
						 List<ExprGen> args = new ArrayList<ExprGen>(); 
						setState(195);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33332380056L) != 0)) {
							{
							setState(184);
							((PrimaryExpressionContext)_localctx).scopeExpression = scopeExpression();
							 args.add(((PrimaryExpressionContext)_localctx).scopeExpression.result); 
							setState(192);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__4) {
								{
								{
								setState(186);
								match(T__4);
								setState(187);
								((PrimaryExpressionContext)_localctx).scopeExpression = scopeExpression();
								 args.add(((PrimaryExpressionContext)_localctx).scopeExpression.result); 
								}
								}
								setState(194);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(197);
						((PrimaryExpressionContext)_localctx).t = match(T__8);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, args, ((PrimaryExpressionContext)_localctx).t); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(203);
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
		public Token t;
		public FunctionArgumentsContext functionArguments;
		public FunctionBodyContext functionBody;
		public Token op;
		public ScopeExpressionContext scopeExpression;
		public IfExpressionContext ifExpression;
		public WhileDoExpressionContext whileDoExpression;
		public DoWhileExpressionContext doWhileExpression;
		public ForExpressionContext forExpression;
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
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
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
		enterRule(_localctx, 30, RULE_primary);
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(CHAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				match(T__13);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(211);
				match(T__14);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(212);
				((PrimaryContext)_localctx).t = match(T__6);
				setState(213);
				match(T__7);
				setState(214);
				((PrimaryContext)_localctx).functionArguments = functionArguments();
				 factory.startFunction(((PrimaryContext)_localctx).functionArguments.result); 
				setState(216);
				match(T__8);
				setState(217);
				match(T__9);
				setState(218);
				((PrimaryContext)_localctx).functionBody = functionBody();
				setState(219);
				match(T__10);
				 ((PrimaryContext)_localctx).result =  factory.finishFunction(((PrimaryContext)_localctx).functionBody.result, ((PrimaryContext)_localctx).t); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(222);
				match(T__15);
				 ((PrimaryContext)_localctx).result =  a -> null; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(224);
				((PrimaryContext)_localctx).op = match(OP);
				setState(225);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).op, ((PrimaryContext)_localctx).d); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				match(OP);
				setState(228);
				basicExpression(0);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(229);
				match(T__7);
				setState(230);
				((PrimaryContext)_localctx).scopeExpression = scopeExpression();
				setState(231);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).scopeExpression.result; 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(234);
				((PrimaryContext)_localctx).ifExpression = ifExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).ifExpression.result; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(237);
				((PrimaryContext)_localctx).whileDoExpression = whileDoExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).whileDoExpression.result; 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(240);
				((PrimaryContext)_localctx).doWhileExpression = doWhileExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).doWhileExpression.result; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(243);
				((PrimaryContext)_localctx).forExpression = forExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).forExpression.result; 
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
		public ExprGen result;
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
		enterRule(_localctx, 32, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ExprGen falsePart = null; 
			setState(249);
			match(T__16);
			setState(250);
			((IfExpressionContext)_localctx).expression = expression();
			setState(251);
			match(T__17);
			setState(252);
			((IfExpressionContext)_localctx).scopeExpression = scopeExpression();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==T__20) {
				{
				setState(253);
				((IfExpressionContext)_localctx).elsePart = elsePart();
				 falsePart = ((IfExpressionContext)_localctx).elsePart.result; 
				}
			}

			 ((IfExpressionContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((IfExpressionContext)_localctx).expression.result), ((IfExpressionContext)_localctx).scopeExpression.result, falsePart); 
			setState(259);
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
		public ExprGen result;
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
		enterRule(_localctx, 34, RULE_elsePart);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				 ExprGen falsePart = null; 
				setState(262);
				match(T__19);
				setState(263);
				((ElsePartContext)_localctx).expression = expression();
				setState(264);
				match(T__17);
				setState(265);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19 || _la==T__20) {
					{
					setState(266);
					((ElsePartContext)_localctx).elsePart = elsePart();
					 falsePart = ((ElsePartContext)_localctx).elsePart.result; 
					}
				}

				 ((ElsePartContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((ElsePartContext)_localctx).expression.result), ((ElsePartContext)_localctx).scopeExpression.result, falsePart); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(T__20);
				setState(274);
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
		public ExprGen result;
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
		enterRule(_localctx, 36, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			((WhileDoExpressionContext)_localctx).t = match(T__21);
			setState(280);
			((WhileDoExpressionContext)_localctx).expression = expression();
			setState(281);
			match(T__22);
			setState(282);
			((WhileDoExpressionContext)_localctx).scopeExpression = scopeExpression();
			 ((WhileDoExpressionContext)_localctx).result =  factory.createWhileDo(factory.finishSeq(((WhileDoExpressionContext)_localctx).expression.result), ((WhileDoExpressionContext)_localctx).scopeExpression.result, ((WhileDoExpressionContext)_localctx).t); 
			setState(284);
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
		public ExprGen result;
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
		enterRule(_localctx, 38, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((DoWhileExpressionContext)_localctx).t = match(T__22);
			 factory.startBlock(); 
			setState(288);
			((DoWhileExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((DoWhileExpressionContext)_localctx).defs.result.keySet()); 
			 factory.startBlock(); factory.addLocalValues(((DoWhileExpressionContext)_localctx).defs.result); 
			 ExprsGen body = ExprsGen.of(); 
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(292);
				((DoWhileExpressionContext)_localctx).expression = expression();
				 body = ((DoWhileExpressionContext)_localctx).expression.result; 
				}
				break;
			}
			 ExprGen bodyNode = factory.finishBlock(body); 
			setState(298);
			match(T__21);
			setState(299);
			((DoWhileExpressionContext)_localctx).cond = ((DoWhileExpressionContext)_localctx).expression = expression();
			 ((DoWhileExpressionContext)_localctx).result =  factory.finishBlock(ExprsGen.of(
			              factory.createDoWhile(bodyNode, factory.finishSeq(((DoWhileExpressionContext)_localctx).cond.result), ((DoWhileExpressionContext)_localctx).t)
			      )); 
			setState(301);
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
		public ExprGen result;
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
		enterRule(_localctx, 40, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			((ForExpressionContext)_localctx).t = match(T__24);
			 factory.startBlock(); 
			setState(305);
			((ForExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ForExpressionContext)_localctx).defs.result.keySet()); factory.addLocalValues(((ForExpressionContext)_localctx).defs.result); 
			 ExprsGen init = ExprsGen.of(); 
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33332380032L) != 0)) {
				{
				setState(308);
				((ForExpressionContext)_localctx).expression = expression();
				 init = ((ForExpressionContext)_localctx).expression.result; 
				}
			}

			 ExprGen initNode = factory.finishSeq(init); 
			setState(314);
			match(T__4);
			setState(315);
			((ForExpressionContext)_localctx).cond = ((ForExpressionContext)_localctx).expression = expression();
			setState(316);
			match(T__4);
			setState(317);
			((ForExpressionContext)_localctx).step = ((ForExpressionContext)_localctx).expression = expression();
			setState(318);
			match(T__22);
			setState(319);
			((ForExpressionContext)_localctx).scopeExpression0 = scopeExpression0();
			 ((ForExpressionContext)_localctx).result =  factory.finishBlock(ExprsGen.of(
			              factory.createForLoop(initNode, factory.finishSeq(((ForExpressionContext)_localctx).cond.result), factory.finishSeq(((ForExpressionContext)_localctx).step.result), ((ForExpressionContext)_localctx).scopeExpression0.result, ((ForExpressionContext)_localctx).t)
			      )); 
			setState(321);
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
		case 13:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return factory.getPrecedence(_input.LT(1)) >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u0144\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0005\u0000"+
		",\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004P\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005Z\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007h\b\u0007\n\u0007\f\u0007"+
		"k\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\bt\b\b\u0001\t\u0001\t\u0003\tx\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u008b\b\n\n\n\f\n\u008e\t\n\u0003\n"+
		"\u0090\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0098\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a3\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00ac\b\r\n\r\f\r\u00af"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00bf\b\u000e\n\u000e\f\u000e"+
		"\u00c2\t\u000e\u0003\u000e\u00c4\b\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00c8\b\u000e\n\u000e\f\u000e\u00cb\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f7\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u0101\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u010e\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u0116\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0128\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0138\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0000\u0000\u0015\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(\u0000\u0001\u0001\u0000\u0003\u0004\u0151\u0000-\u0001\u0000"+
		"\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\bH\u0001\u0000\u0000\u0000\nY\u0001\u0000"+
		"\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000\u0000"+
		"\u0010s\u0001\u0000\u0000\u0000\u0012u\u0001\u0000\u0000\u0000\u0014\u0084"+
		"\u0001\u0000\u0000\u0000\u0016\u0091\u0001\u0000\u0000\u0000\u0018\u00a2"+
		"\u0001\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000\u001c\u00b0"+
		"\u0001\u0000\u0000\u0000\u001e\u00f6\u0001\u0000\u0000\u0000 \u00f8\u0001"+
		"\u0000\u0000\u0000\"\u0115\u0001\u0000\u0000\u0000$\u0117\u0001\u0000"+
		"\u0000\u0000&\u011e\u0001\u0000\u0000\u0000(\u012f\u0001\u0000\u0000\u0000"+
		"*,\u0003\u0002\u0001\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.0\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000001\u0006\u0000\uffff\uffff\u0000"+
		"12\u0003\u0016\u000b\u000023\u0006\u0000\uffff\uffff\u000034\u0005\u0000"+
		"\u0000\u00014\u0001\u0001\u0000\u0000\u000056\u0005\u0001\u0000\u0000"+
		"67\u0005\u001d\u0000\u000078\u0005\u0002\u0000\u00008\u0003\u0001\u0000"+
		"\u0000\u00009?\u0006\u0002\uffff\uffff\u0000:;\u0003\n\u0005\u0000;<\u0006"+
		"\u0002\uffff\uffff\u0000<>\u0001\u0000\u0000\u0000=:\u0001\u0000\u0000"+
		"\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@\u0005\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"BC\u0006\u0003\uffff\uffff\u0000CD\u0003\u0004\u0002\u0000DE\u0006\u0003"+
		"\uffff\uffff\u0000EF\u0003\u0018\f\u0000FG\u0006\u0003\uffff\uffff\u0000"+
		"G\u0007\u0001\u0000\u0000\u0000HI\u0006\u0004\uffff\uffff\u0000IJ\u0003"+
		"\u0004\u0002\u0000JK\u0006\u0004\uffff\uffff\u0000KO\u0006\u0004\uffff"+
		"\uffff\u0000LM\u0003\u0018\f\u0000MN\u0006\u0004\uffff\uffff\u0000NP\u0001"+
		"\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000QR\u0006\u0004\uffff\uffff\u0000R\t\u0001\u0000"+
		"\u0000\u0000ST\u0003\f\u0006\u0000TU\u0006\u0005\uffff\uffff\u0000UZ\u0001"+
		"\u0000\u0000\u0000VW\u0003\u0012\t\u0000WX\u0006\u0005\uffff\uffff\u0000"+
		"XZ\u0001\u0000\u0000\u0000YS\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000"+
		"\u0000Z\u000b\u0001\u0000\u0000\u0000[\\\u0007\u0000\u0000\u0000\\]\u0003"+
		"\u000e\u0007\u0000]^\u0005\u0002\u0000\u0000^_\u0006\u0006\uffff\uffff"+
		"\u0000_\r\u0001\u0000\u0000\u0000`a\u0006\u0007\uffff\uffff\u0000ab\u0003"+
		"\u0010\b\u0000bi\u0006\u0007\uffff\uffff\u0000cd\u0005\u0005\u0000\u0000"+
		"de\u0003\u0010\b\u0000ef\u0006\u0007\uffff\uffff\u0000fh\u0001\u0000\u0000"+
		"\u0000gc\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000j\u000f\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000lm\u0005\u001e\u0000\u0000mt\u0006\b\uffff\uffff"+
		"\u0000no\u0005\u001e\u0000\u0000op\u0005\u0006\u0000\u0000pq\u0003\u001a"+
		"\r\u0000qr\u0006\b\uffff\uffff\u0000rt\u0001\u0000\u0000\u0000sl\u0001"+
		"\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000t\u0011\u0001\u0000\u0000"+
		"\u0000uw\u0006\t\uffff\uffff\u0000vx\u0005\u0004\u0000\u0000wv\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005"+
		"\u0007\u0000\u0000z{\u0005\u001e\u0000\u0000{|\u0005\b\u0000\u0000|}\u0003"+
		"\u0014\n\u0000}~\u0005\t\u0000\u0000~\u007f\u0006\t\uffff\uffff\u0000"+
		"\u007f\u0080\u0005\n\u0000\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081"+
		"\u0082\u0005\u000b\u0000\u0000\u0082\u0083\u0006\t\uffff\uffff\u0000\u0083"+
		"\u0013\u0001\u0000\u0000\u0000\u0084\u008f\u0006\n\uffff\uffff\u0000\u0085"+
		"\u0086\u0005\u001e\u0000\u0000\u0086\u008c\u0006\n\uffff\uffff\u0000\u0087"+
		"\u0088\u0005\u0005\u0000\u0000\u0088\u0089\u0005\u001e\u0000\u0000\u0089"+
		"\u008b\u0006\n\uffff\uffff\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008b"+
		"\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008f\u0085\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0015\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0003\u0004\u0002\u0000\u0092\u0093\u0006\u000b\uffff\uffff\u0000"+
		"\u0093\u0097\u0006\u000b\uffff\uffff\u0000\u0094\u0095\u0003\u0018\f\u0000"+
		"\u0095\u0096\u0006\u000b\uffff\uffff\u0000\u0096\u0098\u0001\u0000\u0000"+
		"\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0017\u0001\u0000\u0000\u0000\u0099\u009a\u0003\u001a\r\u0000"+
		"\u009a\u009b\u0006\f\uffff\uffff\u0000\u009b\u00a3\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0003\u001a\r\u0000\u009d\u009e\u0006\f\uffff\uffff\u0000"+
		"\u009e\u009f\u0005\u0002\u0000\u0000\u009f\u00a0\u0003\u0018\f\u0000\u00a0"+
		"\u00a1\u0006\f\uffff\uffff\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2"+
		"\u0099\u0001\u0000\u0000\u0000\u00a2\u009c\u0001\u0000\u0000\u0000\u00a3"+
		"\u0019\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003\u001c\u000e\u0000\u00a5"+
		"\u00ad\u0006\r\uffff\uffff\u0000\u00a6\u00a7\u0004\r\u0000\u0001\u00a7"+
		"\u00a8\u0005\"\u0000\u0000\u00a8\u00a9\u0003\u001a\r\u0000\u00a9\u00aa"+
		"\u0006\r\uffff\uffff\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a6"+
		"\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u001b"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0003\u001e\u000f\u0000\u00b1\u00c9\u0006\u000e\uffff\uffff\u0000\u00b2"+
		"\u00b3\u0005\f\u0000\u0000\u00b3\u00b4\u0003\u0018\f\u0000\u00b4\u00b5"+
		"\u0005\r\u0000\u0000\u00b5\u00c8\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\b\u0000\u0000\u00b7\u00c3\u0006\u000e\uffff\uffff\u0000\u00b8\u00b9\u0003"+
		"\u0006\u0003\u0000\u00b9\u00c0\u0006\u000e\uffff\uffff\u0000\u00ba\u00bb"+
		"\u0005\u0005\u0000\u0000\u00bb\u00bc\u0003\u0006\u0003\u0000\u00bc\u00bd"+
		"\u0006\u000e\uffff\uffff\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3"+
		"\u00b8\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\t\u0000\u0000\u00c6\u00c8"+
		"\u0006\u000e\uffff\uffff\u0000\u00c7\u00b2\u0001\u0000\u0000\u0000\u00c7"+
		"\u00b6\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u001d\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0005\u001f\u0000\u0000\u00cd\u00f7\u0006\u000f\uffff\uffff\u0000"+
		"\u00ce\u00f7\u0005 \u0000\u0000\u00cf\u00f7\u0005!\u0000\u0000\u00d0\u00d1"+
		"\u0005\u001e\u0000\u0000\u00d1\u00f7\u0006\u000f\uffff\uffff\u0000\u00d2"+
		"\u00f7\u0005\u000e\u0000\u0000\u00d3\u00f7\u0005\u000f\u0000\u0000\u00d4"+
		"\u00d5\u0005\u0007\u0000\u0000\u00d5\u00d6\u0005\b\u0000\u0000\u00d6\u00d7"+
		"\u0003\u0014\n\u0000\u00d7\u00d8\u0006\u000f\uffff\uffff\u0000\u00d8\u00d9"+
		"\u0005\t\u0000\u0000\u00d9\u00da\u0005\n\u0000\u0000\u00da\u00db\u0003"+
		"\u0016\u000b\u0000\u00db\u00dc\u0005\u000b\u0000\u0000\u00dc\u00dd\u0006"+
		"\u000f\uffff\uffff\u0000\u00dd\u00f7\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005\u0010\u0000\u0000\u00df\u00f7\u0006\u000f\uffff\uffff\u0000\u00e0"+
		"\u00e1\u0005\"\u0000\u0000\u00e1\u00e2\u0005\u001f\u0000\u0000\u00e2\u00f7"+
		"\u0006\u000f\uffff\uffff\u0000\u00e3\u00e4\u0005\"\u0000\u0000\u00e4\u00f7"+
		"\u0003\u001a\r\u0000\u00e5\u00e6\u0005\b\u0000\u0000\u00e6\u00e7\u0003"+
		"\u0006\u0003\u0000\u00e7\u00e8\u0005\t\u0000\u0000\u00e8\u00e9\u0006\u000f"+
		"\uffff\uffff\u0000\u00e9\u00f7\u0001\u0000\u0000\u0000\u00ea\u00eb\u0003"+
		" \u0010\u0000\u00eb\u00ec\u0006\u000f\uffff\uffff\u0000\u00ec\u00f7\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0003$\u0012\u0000\u00ee\u00ef\u0006\u000f"+
		"\uffff\uffff\u0000\u00ef\u00f7\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003"+
		"&\u0013\u0000\u00f1\u00f2\u0006\u000f\uffff\uffff\u0000\u00f2\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0003(\u0014\u0000\u00f4\u00f5\u0006\u000f"+
		"\uffff\uffff\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00cc\u0001"+
		"\u0000\u0000\u0000\u00f6\u00ce\u0001\u0000\u0000\u0000\u00f6\u00cf\u0001"+
		"\u0000\u0000\u0000\u00f6\u00d0\u0001\u0000\u0000\u0000\u00f6\u00d2\u0001"+
		"\u0000\u0000\u0000\u00f6\u00d3\u0001\u0000\u0000\u0000\u00f6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00f6\u00de\u0001\u0000\u0000\u0000\u00f6\u00e0\u0001"+
		"\u0000\u0000\u0000\u00f6\u00e3\u0001\u0000\u0000\u0000\u00f6\u00e5\u0001"+
		"\u0000\u0000\u0000\u00f6\u00ea\u0001\u0000\u0000\u0000\u00f6\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f0\u0001\u0000\u0000\u0000\u00f6\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f7\u001f\u0001\u0000\u0000\u0000\u00f8\u00f9\u0006"+
		"\u0010\uffff\uffff\u0000\u00f9\u00fa\u0005\u0011\u0000\u0000\u00fa\u00fb"+
		"\u0003\u0018\f\u0000\u00fb\u00fc\u0005\u0012\u0000\u0000\u00fc\u0100\u0003"+
		"\u0006\u0003\u0000\u00fd\u00fe\u0003\"\u0011\u0000\u00fe\u00ff\u0006\u0010"+
		"\uffff\uffff\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fd\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u0006\u0010\uffff\uffff\u0000\u0103\u0104"+
		"\u0005\u0013\u0000\u0000\u0104!\u0001\u0000\u0000\u0000\u0105\u0106\u0006"+
		"\u0011\uffff\uffff\u0000\u0106\u0107\u0005\u0014\u0000\u0000\u0107\u0108"+
		"\u0003\u0018\f\u0000\u0108\u0109\u0005\u0012\u0000\u0000\u0109\u010d\u0003"+
		"\u0006\u0003\u0000\u010a\u010b\u0003\"\u0011\u0000\u010b\u010c\u0006\u0011"+
		"\uffff\uffff\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010a\u0001"+
		"\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0006\u0011\uffff\uffff\u0000\u0110\u0116"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u0015\u0000\u0000\u0112\u0113"+
		"\u0003\u0006\u0003\u0000\u0113\u0114\u0006\u0011\uffff\uffff\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u0105\u0001\u0000\u0000\u0000\u0115"+
		"\u0111\u0001\u0000\u0000\u0000\u0116#\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0005\u0016\u0000\u0000\u0118\u0119\u0003\u0018\f\u0000\u0119\u011a\u0005"+
		"\u0017\u0000\u0000\u011a\u011b\u0003\u0006\u0003\u0000\u011b\u011c\u0006"+
		"\u0012\uffff\uffff\u0000\u011c\u011d\u0005\u0018\u0000\u0000\u011d%\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0005\u0017\u0000\u0000\u011f\u0120\u0006"+
		"\u0013\uffff\uffff\u0000\u0120\u0121\u0003\u0004\u0002\u0000\u0121\u0122"+
		"\u0006\u0013\uffff\uffff\u0000\u0122\u0123\u0006\u0013\uffff\uffff\u0000"+
		"\u0123\u0127\u0006\u0013\uffff\uffff\u0000\u0124\u0125\u0003\u0018\f\u0000"+
		"\u0125\u0126\u0006\u0013\uffff\uffff\u0000\u0126\u0128\u0001\u0000\u0000"+
		"\u0000\u0127\u0124\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u0006\u0013\uffff"+
		"\uffff\u0000\u012a\u012b\u0005\u0016\u0000\u0000\u012b\u012c\u0003\u0018"+
		"\f\u0000\u012c\u012d\u0006\u0013\uffff\uffff\u0000\u012d\u012e\u0005\u0018"+
		"\u0000\u0000\u012e\'\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u0019\u0000"+
		"\u0000\u0130\u0131\u0006\u0014\uffff\uffff\u0000\u0131\u0132\u0003\u0004"+
		"\u0002\u0000\u0132\u0133\u0006\u0014\uffff\uffff\u0000\u0133\u0137\u0006"+
		"\u0014\uffff\uffff\u0000\u0134\u0135\u0003\u0018\f\u0000\u0135\u0136\u0006"+
		"\u0014\uffff\uffff\u0000\u0136\u0138\u0001\u0000\u0000\u0000\u0137\u0134"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0006\u0014\uffff\uffff\u0000\u013a"+
		"\u013b\u0005\u0005\u0000\u0000\u013b\u013c\u0003\u0018\f\u0000\u013c\u013d"+
		"\u0005\u0005\u0000\u0000\u013d\u013e\u0003\u0018\f\u0000\u013e\u013f\u0005"+
		"\u0017\u0000\u0000\u013f\u0140\u0003\b\u0004\u0000\u0140\u0141\u0006\u0014"+
		"\uffff\uffff\u0000\u0141\u0142\u0005\u0018\u0000\u0000\u0142)\u0001\u0000"+
		"\u0000\u0000\u0016-?OYisw\u008c\u008f\u0097\u00a2\u00ad\u00c0\u00c3\u00c7"+
		"\u00c9\u00f6\u0100\u010d\u0115\u0127\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}