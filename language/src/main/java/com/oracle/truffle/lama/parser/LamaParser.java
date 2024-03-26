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
		T__24=25, T__25=26, WS=27, COMMENT=28, LINE_COMMENT=29, UIDENT=30, LIDENT=31, 
		DECIMAL=32, STRING=33, CHAR=34, OP=35;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeDefinitions = 2, 
		RULE_scopeExpression = 3, RULE_scopeExpression0 = 4, RULE_definition = 5, 
		RULE_variableDefinition = 6, RULE_variableDefinitionSequence = 7, RULE_variableDefinitionItem = 8, 
		RULE_functionDefinition = 9, RULE_functionArguments = 10, RULE_functionBody = 11, 
		RULE_expression = 12, RULE_basicExpression = 13, RULE_primaryExpression = 14, 
		RULE_functionArgs = 15, RULE_primary = 16, RULE_ifExpression = 17, RULE_elsePart = 18, 
		RULE_whileDoExpression = 19, RULE_doWhileExpression = 20, RULE_forExpression = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeDefinitions", "scopeExpression", 
			"scopeExpression0", "definition", "variableDefinition", "variableDefinitionSequence", 
			"variableDefinitionItem", "functionDefinition", "functionArguments", 
			"functionBody", "expression", "basicExpression", "primaryExpression", 
			"functionArgs", "primary", "ifExpression", "elsePart", "whileDoExpression", 
			"doWhileExpression", "forExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "';'", "'var'", "'public'", "','", "'='", "'fun'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "'.'", "'true'", "'false'", 
			"'skip'", "'if'", "'then'", "'fi'", "'elif'", "'else'", "'while'", "'do'", 
			"'od'", "'for'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WS", "COMMENT", "LINE_COMMENT", "UIDENT", "LIDENT", 
			"DECIMAL", "STRING", "CHAR", "OP"
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
			((CompilationUnitContext)_localctx).functionBody = functionBody();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).functionBody.result, _input.LT(1)); 
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
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					((ScopeDefinitionsContext)_localctx).definition = definition();
					 _localctx.result.putAll(((ScopeDefinitionsContext)_localctx).definition.result); 
					}
					} 
				}
				setState(67);
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
			setState(69);
			((ScopeExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ScopeExpressionContext)_localctx).defs.result.keySet()); factory.addLocalValues(((ScopeExpressionContext)_localctx).defs.result); 
			setState(71);
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
			setState(75);
			((ScopeExpression0Context)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ScopeExpression0Context)_localctx).defs.result.keySet()); factory.addLocalValues(((ScopeExpression0Context)_localctx).defs.result); 
			 ExprsGen gen = ExprsGen.of(); 
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66664759680L) != 0)) {
				{
				setState(78);
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
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((DefinitionContext)_localctx).variableDefinition = variableDefinition();
				 ((DefinitionContext)_localctx).result =  ((DefinitionContext)_localctx).variableDefinition.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
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
			setState(93);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(94);
			((VariableDefinitionContext)_localctx).variableDefinitionSequence = variableDefinitionSequence();
			setState(95);
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
			setState(99);
			((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
			 _localctx.result.put(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(101);
				match(T__4);
				setState(102);
				((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
				 _localctx.result.put(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
				}
				}
				setState(109);
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT.getText(); ((VariableDefinitionItemContext)_localctx).value =  a -> null; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(113);
				match(T__5);
				setState(114);
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(120);
				match(T__3);
				}
			}

			setState(123);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(124);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(125);
			match(T__7);
			setState(126);
			((FunctionDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(127);
			match(T__8);
			 factory.startFunction(((FunctionDefinitionContext)_localctx).functionArguments.result); 
			setState(129);
			match(T__9);
			setState(130);
			((FunctionDefinitionContext)_localctx).functionBody = functionBody();
			setState(131);
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
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(135);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(137);
					match(T__4);
					setState(138);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
					}
					}
					setState(144);
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
			setState(147);
			((FunctionBodyContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((FunctionBodyContext)_localctx).defs.result.keySet()); factory.addLocalValues(((FunctionBodyContext)_localctx).defs.result); 
			 ((FunctionBodyContext)_localctx).result =  ExprsGen.of(); 
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66664759680L) != 0)) {
				{
				setState(150);
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
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  ExprsGen.of(((ExpressionContext)_localctx).basicExpression.result); 
				setState(160);
				match(T__1);
				setState(161);
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
			setState(166);
			((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; 
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(168);
					if (!(factory.getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "factory.getPrecedence(_input.LT(1)) >= $_p");
					setState(169);
					((BasicExpressionContext)_localctx).op = match(OP);
					setState(170);
					((BasicExpressionContext)_localctx).rhs = basicExpression(factory.getNextPrecedence(((BasicExpressionContext)_localctx).op));
					 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, _localctx.result, ((BasicExpressionContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(177);
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
		public ExpressionContext expression;
		public FunctionArgsContext functionArgs;
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
		public List<FunctionArgsContext> functionArgs() {
			return getRuleContexts(FunctionArgsContext.class);
		}
		public FunctionArgsContext functionArgs(int i) {
			return getRuleContext(FunctionArgsContext.class,i);
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
		enterRule(_localctx, 28, RULE_primaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(197);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__11:
						{
						setState(180);
						match(T__11);
						setState(181);
						((PrimaryExpressionContext)_localctx).expression = expression();
						setState(182);
						match(T__12);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createElement(_localctx.result, factory.finishSeq(((PrimaryExpressionContext)_localctx).expression.result)); 
						}
						break;
					case T__7:
						{
						setState(185);
						((PrimaryExpressionContext)_localctx).functionArgs = functionArgs();
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, ((PrimaryExpressionContext)_localctx).functionArgs.args, ((PrimaryExpressionContext)_localctx).functionArgs.t); 
						}
						break;
					case T__13:
						{
						setState(188);
						((PrimaryExpressionContext)_localctx).t = match(T__13);
						setState(189);
						((PrimaryExpressionContext)_localctx).LIDENT = match(LIDENT);
						 List<ExprGen> args = new ArrayList<ExprGen>(); args.add(_localctx.result); 
						setState(194);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
						case 1:
							{
							setState(191);
							((PrimaryExpressionContext)_localctx).functionArgs = functionArgs();
							 args.addAll(((PrimaryExpressionContext)_localctx).functionArgs.args); 
							}
							break;
						}
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(factory.createRead(((PrimaryExpressionContext)_localctx).LIDENT), args, ((PrimaryExpressionContext)_localctx).t); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(201);
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
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionArgsContext extends ParserRuleContext {
		public List<ExprGen> args;
		public Token t;
		public Token tt;
		public ScopeExpressionContext scopeExpression;
		public List<ScopeExpressionContext> scopeExpression() {
			return getRuleContexts(ScopeExpressionContext.class);
		}
		public ScopeExpressionContext scopeExpression(int i) {
			return getRuleContext(ScopeExpressionContext.class,i);
		}
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			((FunctionArgsContext)_localctx).tt = match(T__7);
			 ((FunctionArgsContext)_localctx).args =  new ArrayList<ExprGen>(); ((FunctionArgsContext)_localctx).t =  ((FunctionArgsContext)_localctx).tt; 
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66664759704L) != 0)) {
				{
				setState(204);
				((FunctionArgsContext)_localctx).scopeExpression = scopeExpression();
				 _localctx.args.add(((FunctionArgsContext)_localctx).scopeExpression.result); 
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(206);
					match(T__4);
					setState(207);
					((FunctionArgsContext)_localctx).scopeExpression = scopeExpression();
					 _localctx.args.add(((FunctionArgsContext)_localctx).scopeExpression.result); 
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(217);
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
		public ExprGen result;
		public Token d;
		public Token s;
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
		enterRule(_localctx, 32, RULE_primary);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				((PrimaryContext)_localctx).s = match(STRING);
				 ((PrimaryContext)_localctx).result =  factory.createStringLiteral(((PrimaryContext)_localctx).s); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				match(CHAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				match(T__14);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				match(T__15);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				((PrimaryContext)_localctx).t = match(T__6);
				setState(229);
				match(T__7);
				setState(230);
				((PrimaryContext)_localctx).functionArguments = functionArguments();
				 factory.startFunction(((PrimaryContext)_localctx).functionArguments.result); 
				setState(232);
				match(T__8);
				setState(233);
				match(T__9);
				setState(234);
				((PrimaryContext)_localctx).functionBody = functionBody();
				setState(235);
				match(T__10);
				 ((PrimaryContext)_localctx).result =  factory.finishFunction(((PrimaryContext)_localctx).functionBody.result, ((PrimaryContext)_localctx).t); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(238);
				match(T__16);
				 ((PrimaryContext)_localctx).result =  a -> null; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(240);
				((PrimaryContext)_localctx).op = match(OP);
				setState(241);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).op, ((PrimaryContext)_localctx).d); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(243);
				match(OP);
				setState(244);
				basicExpression(0);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(245);
				match(T__7);
				setState(246);
				((PrimaryContext)_localctx).scopeExpression = scopeExpression();
				setState(247);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).scopeExpression.result; 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(250);
				((PrimaryContext)_localctx).ifExpression = ifExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).ifExpression.result; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(253);
				((PrimaryContext)_localctx).whileDoExpression = whileDoExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).whileDoExpression.result; 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(256);
				((PrimaryContext)_localctx).doWhileExpression = doWhileExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).doWhileExpression.result; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(259);
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
		enterRule(_localctx, 34, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ExprGen falsePart = null; 
			setState(265);
			match(T__17);
			setState(266);
			((IfExpressionContext)_localctx).expression = expression();
			setState(267);
			match(T__18);
			setState(268);
			((IfExpressionContext)_localctx).scopeExpression = scopeExpression();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20 || _la==T__21) {
				{
				setState(269);
				((IfExpressionContext)_localctx).elsePart = elsePart();
				 falsePart = ((IfExpressionContext)_localctx).elsePart.result; 
				}
			}

			 ((IfExpressionContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((IfExpressionContext)_localctx).expression.result), ((IfExpressionContext)_localctx).scopeExpression.result, falsePart); 
			setState(275);
			match(T__19);
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
		enterRule(_localctx, 36, RULE_elsePart);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				 ExprGen falsePart = null; 
				setState(278);
				match(T__20);
				setState(279);
				((ElsePartContext)_localctx).expression = expression();
				setState(280);
				match(T__18);
				setState(281);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20 || _la==T__21) {
					{
					setState(282);
					((ElsePartContext)_localctx).elsePart = elsePart();
					 falsePart = ((ElsePartContext)_localctx).elsePart.result; 
					}
				}

				 ((ElsePartContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((ElsePartContext)_localctx).expression.result), ((ElsePartContext)_localctx).scopeExpression.result, falsePart); 
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(T__21);
				setState(290);
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
		enterRule(_localctx, 38, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			((WhileDoExpressionContext)_localctx).t = match(T__22);
			setState(296);
			((WhileDoExpressionContext)_localctx).expression = expression();
			setState(297);
			match(T__23);
			setState(298);
			((WhileDoExpressionContext)_localctx).scopeExpression = scopeExpression();
			 ((WhileDoExpressionContext)_localctx).result =  factory.createWhileDo(factory.finishSeq(((WhileDoExpressionContext)_localctx).expression.result), ((WhileDoExpressionContext)_localctx).scopeExpression.result, ((WhileDoExpressionContext)_localctx).t); 
			setState(300);
			match(T__24);
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
		enterRule(_localctx, 40, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			((DoWhileExpressionContext)_localctx).t = match(T__23);
			 factory.startBlock(); 
			setState(304);
			((DoWhileExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((DoWhileExpressionContext)_localctx).defs.result.keySet()); 
			 factory.startBlock(); factory.addLocalValues(((DoWhileExpressionContext)_localctx).defs.result); 
			 ExprsGen body = ExprsGen.of(); 
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(308);
				((DoWhileExpressionContext)_localctx).expression = expression();
				 body = ((DoWhileExpressionContext)_localctx).expression.result; 
				}
				break;
			}
			 ExprGen bodyNode = factory.finishBlock(body); 
			setState(314);
			match(T__22);
			setState(315);
			((DoWhileExpressionContext)_localctx).cond = ((DoWhileExpressionContext)_localctx).expression = expression();
			 ((DoWhileExpressionContext)_localctx).result =  factory.finishBlock(ExprsGen.of(
			              factory.createDoWhile(bodyNode, factory.finishSeq(((DoWhileExpressionContext)_localctx).cond.result), ((DoWhileExpressionContext)_localctx).t)
			      )); 
			setState(317);
			match(T__24);
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
		enterRule(_localctx, 42, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((ForExpressionContext)_localctx).t = match(T__25);
			 factory.startBlock(); 
			setState(321);
			((ForExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.addLocals(((ForExpressionContext)_localctx).defs.result.keySet()); factory.addLocalValues(((ForExpressionContext)_localctx).defs.result); 
			 ExprsGen init = ExprsGen.of(); 
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66664759680L) != 0)) {
				{
				setState(324);
				((ForExpressionContext)_localctx).expression = expression();
				 init = ((ForExpressionContext)_localctx).expression.result; 
				}
			}

			 ExprGen initNode = factory.finishSeq(init); 
			setState(330);
			match(T__4);
			setState(331);
			((ForExpressionContext)_localctx).cond = ((ForExpressionContext)_localctx).expression = expression();
			setState(332);
			match(T__4);
			setState(333);
			((ForExpressionContext)_localctx).step = ((ForExpressionContext)_localctx).expression = expression();
			setState(334);
			match(T__23);
			setState(335);
			((ForExpressionContext)_localctx).scopeExpression0 = scopeExpression0();
			 ((ForExpressionContext)_localctx).result =  factory.finishBlock(ExprsGen.of(
			              factory.createForLoop(initNode, factory.finishSeq(((ForExpressionContext)_localctx).cond.result), factory.finishSeq(((ForExpressionContext)_localctx).step.result), ((ForExpressionContext)_localctx).scopeExpression0.result, ((ForExpressionContext)_localctx).t)
			      )); 
			setState(337);
			match(T__24);
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
		"\u0004\u0001#\u0154\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002@\b\u0002\n\u0002\f\u0002C\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"R\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\\\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"j\b\u0007\n\u0007\f\u0007m\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bv\b\b\u0001\t\u0001\t\u0003\tz\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u008d\b\n\n"+
		"\n\f\n\u0090\t\n\u0003\n\u0092\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009a\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00a5\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00ae\b\r\n\r\f\r\u00b1\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00c3\b\u000e\u0001\u000e\u0005\u000e\u00c6\b\u000e"+
		"\n\u000e\f\u000e\u00c9\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00d3"+
		"\b\u000f\n\u000f\f\u000f\u00d6\t\u000f\u0003\u000f\u00d8\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0107\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0111\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u011e\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0126\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0138\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0148\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000"+
		"\u0001\u0001\u0000\u0003\u0004\u0162\u0000/\u0001\u0000\u0000\u0000\u0002"+
		"7\u0001\u0000\u0000\u0000\u0004;\u0001\u0000\u0000\u0000\u0006D\u0001"+
		"\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\n[\u0001\u0000\u0000\u0000"+
		"\f]\u0001\u0000\u0000\u0000\u000eb\u0001\u0000\u0000\u0000\u0010u\u0001"+
		"\u0000\u0000\u0000\u0012w\u0001\u0000\u0000\u0000\u0014\u0086\u0001\u0000"+
		"\u0000\u0000\u0016\u0093\u0001\u0000\u0000\u0000\u0018\u00a4\u0001\u0000"+
		"\u0000\u0000\u001a\u00a6\u0001\u0000\u0000\u0000\u001c\u00b2\u0001\u0000"+
		"\u0000\u0000\u001e\u00ca\u0001\u0000\u0000\u0000 \u0106\u0001\u0000\u0000"+
		"\u0000\"\u0108\u0001\u0000\u0000\u0000$\u0125\u0001\u0000\u0000\u0000"+
		"&\u0127\u0001\u0000\u0000\u0000(\u012e\u0001\u0000\u0000\u0000*\u013f"+
		"\u0001\u0000\u0000\u0000,.\u0003\u0002\u0001\u0000-,\u0001\u0000\u0000"+
		"\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000002\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0006"+
		"\u0000\uffff\uffff\u000034\u0003\u0016\u000b\u000045\u0006\u0000\uffff"+
		"\uffff\u000056\u0005\u0000\u0000\u00016\u0001\u0001\u0000\u0000\u0000"+
		"78\u0005\u0001\u0000\u000089\u0005\u001e\u0000\u00009:\u0005\u0002\u0000"+
		"\u0000:\u0003\u0001\u0000\u0000\u0000;A\u0006\u0002\uffff\uffff\u0000"+
		"<=\u0003\n\u0005\u0000=>\u0006\u0002\uffff\uffff\u0000>@\u0001\u0000\u0000"+
		"\u0000?<\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000B\u0005\u0001\u0000\u0000\u0000"+
		"CA\u0001\u0000\u0000\u0000DE\u0006\u0003\uffff\uffff\u0000EF\u0003\u0004"+
		"\u0002\u0000FG\u0006\u0003\uffff\uffff\u0000GH\u0003\u0018\f\u0000HI\u0006"+
		"\u0003\uffff\uffff\u0000I\u0007\u0001\u0000\u0000\u0000JK\u0006\u0004"+
		"\uffff\uffff\u0000KL\u0003\u0004\u0002\u0000LM\u0006\u0004\uffff\uffff"+
		"\u0000MQ\u0006\u0004\uffff\uffff\u0000NO\u0003\u0018\f\u0000OP\u0006\u0004"+
		"\uffff\uffff\u0000PR\u0001\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0006\u0004\uffff"+
		"\uffff\u0000T\t\u0001\u0000\u0000\u0000UV\u0003\f\u0006\u0000VW\u0006"+
		"\u0005\uffff\uffff\u0000W\\\u0001\u0000\u0000\u0000XY\u0003\u0012\t\u0000"+
		"YZ\u0006\u0005\uffff\uffff\u0000Z\\\u0001\u0000\u0000\u0000[U\u0001\u0000"+
		"\u0000\u0000[X\u0001\u0000\u0000\u0000\\\u000b\u0001\u0000\u0000\u0000"+
		"]^\u0007\u0000\u0000\u0000^_\u0003\u000e\u0007\u0000_`\u0005\u0002\u0000"+
		"\u0000`a\u0006\u0006\uffff\uffff\u0000a\r\u0001\u0000\u0000\u0000bc\u0006"+
		"\u0007\uffff\uffff\u0000cd\u0003\u0010\b\u0000dk\u0006\u0007\uffff\uffff"+
		"\u0000ef\u0005\u0005\u0000\u0000fg\u0003\u0010\b\u0000gh\u0006\u0007\uffff"+
		"\uffff\u0000hj\u0001\u0000\u0000\u0000ie\u0001\u0000\u0000\u0000jm\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000"+
		"l\u000f\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005\u001f"+
		"\u0000\u0000ov\u0006\b\uffff\uffff\u0000pq\u0005\u001f\u0000\u0000qr\u0005"+
		"\u0006\u0000\u0000rs\u0003\u001a\r\u0000st\u0006\b\uffff\uffff\u0000t"+
		"v\u0001\u0000\u0000\u0000un\u0001\u0000\u0000\u0000up\u0001\u0000\u0000"+
		"\u0000v\u0011\u0001\u0000\u0000\u0000wy\u0006\t\uffff\uffff\u0000xz\u0005"+
		"\u0004\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{|\u0005\u0007\u0000\u0000|}\u0005\u001f\u0000"+
		"\u0000}~\u0005\b\u0000\u0000~\u007f\u0003\u0014\n\u0000\u007f\u0080\u0005"+
		"\t\u0000\u0000\u0080\u0081\u0006\t\uffff\uffff\u0000\u0081\u0082\u0005"+
		"\n\u0000\u0000\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0084\u0005\u000b"+
		"\u0000\u0000\u0084\u0085\u0006\t\uffff\uffff\u0000\u0085\u0013\u0001\u0000"+
		"\u0000\u0000\u0086\u0091\u0006\n\uffff\uffff\u0000\u0087\u0088\u0005\u001f"+
		"\u0000\u0000\u0088\u008e\u0006\n\uffff\uffff\u0000\u0089\u008a\u0005\u0005"+
		"\u0000\u0000\u008a\u008b\u0005\u001f\u0000\u0000\u008b\u008d\u0006\n\uffff"+
		"\uffff\u0000\u008c\u0089\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000"+
		"\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000"+
		"\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0091\u0087\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0015\u0001\u0000\u0000\u0000\u0093\u0094\u0003\u0004"+
		"\u0002\u0000\u0094\u0095\u0006\u000b\uffff\uffff\u0000\u0095\u0099\u0006"+
		"\u000b\uffff\uffff\u0000\u0096\u0097\u0003\u0018\f\u0000\u0097\u0098\u0006"+
		"\u000b\uffff\uffff\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0096"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0017"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0003\u001a\r\u0000\u009c\u009d\u0006"+
		"\f\uffff\uffff\u0000\u009d\u00a5\u0001\u0000\u0000\u0000\u009e\u009f\u0003"+
		"\u001a\r\u0000\u009f\u00a0\u0006\f\uffff\uffff\u0000\u00a0\u00a1\u0005"+
		"\u0002\u0000\u0000\u00a1\u00a2\u0003\u0018\f\u0000\u00a2\u00a3\u0006\f"+
		"\uffff\uffff\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u009b\u0001"+
		"\u0000\u0000\u0000\u00a4\u009e\u0001\u0000\u0000\u0000\u00a5\u0019\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0003\u001c\u000e\u0000\u00a7\u00af\u0006"+
		"\r\uffff\uffff\u0000\u00a8\u00a9\u0004\r\u0000\u0001\u00a9\u00aa\u0005"+
		"#\u0000\u0000\u00aa\u00ab\u0003\u001a\r\u0000\u00ab\u00ac\u0006\r\uffff"+
		"\uffff\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00a8\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u001b\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003 \u0010"+
		"\u0000\u00b3\u00c7\u0006\u000e\uffff\uffff\u0000\u00b4\u00b5\u0005\f\u0000"+
		"\u0000\u00b5\u00b6\u0003\u0018\f\u0000\u00b6\u00b7\u0005\r\u0000\u0000"+
		"\u00b7\u00b8\u0006\u000e\uffff\uffff\u0000\u00b8\u00c6\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0003\u001e\u000f\u0000\u00ba\u00bb\u0006\u000e\uffff"+
		"\uffff\u0000\u00bb\u00c6\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u000e"+
		"\u0000\u0000\u00bd\u00be\u0005\u001f\u0000\u0000\u00be\u00c2\u0006\u000e"+
		"\uffff\uffff\u0000\u00bf\u00c0\u0003\u001e\u000f\u0000\u00c0\u00c1\u0006"+
		"\u000e\uffff\uffff\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c6\u0006\u000e\uffff\uffff\u0000\u00c5"+
		"\u00b4\u0001\u0000\u0000\u0000\u00c5\u00b9\u0001\u0000\u0000\u0000\u00c5"+
		"\u00bc\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"\u001d\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0005\b\u0000\u0000\u00cb\u00d7\u0006\u000f\uffff\uffff\u0000\u00cc"+
		"\u00cd\u0003\u0006\u0003\u0000\u00cd\u00d4\u0006\u000f\uffff\uffff\u0000"+
		"\u00ce\u00cf\u0005\u0005\u0000\u0000\u00cf\u00d0\u0003\u0006\u0003\u0000"+
		"\u00d0\u00d1\u0006\u000f\uffff\uffff\u0000\u00d1\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d7\u00cc\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\t\u0000\u0000"+
		"\u00da\u001f\u0001\u0000\u0000\u0000\u00db\u00dc\u0005 \u0000\u0000\u00dc"+
		"\u0107\u0006\u0010\uffff\uffff\u0000\u00dd\u00de\u0005!\u0000\u0000\u00de"+
		"\u0107\u0006\u0010\uffff\uffff\u0000\u00df\u0107\u0005\"\u0000\u0000\u00e0"+
		"\u00e1\u0005\u001f\u0000\u0000\u00e1\u0107\u0006\u0010\uffff\uffff\u0000"+
		"\u00e2\u0107\u0005\u000f\u0000\u0000\u00e3\u0107\u0005\u0010\u0000\u0000"+
		"\u00e4\u00e5\u0005\u0007\u0000\u0000\u00e5\u00e6\u0005\b\u0000\u0000\u00e6"+
		"\u00e7\u0003\u0014\n\u0000\u00e7\u00e8\u0006\u0010\uffff\uffff\u0000\u00e8"+
		"\u00e9\u0005\t\u0000\u0000\u00e9\u00ea\u0005\n\u0000\u0000\u00ea\u00eb"+
		"\u0003\u0016\u000b\u0000\u00eb\u00ec\u0005\u000b\u0000\u0000\u00ec\u00ed"+
		"\u0006\u0010\uffff\uffff\u0000\u00ed\u0107\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0005\u0011\u0000\u0000\u00ef\u0107\u0006\u0010\uffff\uffff\u0000"+
		"\u00f0\u00f1\u0005#\u0000\u0000\u00f1\u00f2\u0005 \u0000\u0000\u00f2\u0107"+
		"\u0006\u0010\uffff\uffff\u0000\u00f3\u00f4\u0005#\u0000\u0000\u00f4\u0107"+
		"\u0003\u001a\r\u0000\u00f5\u00f6\u0005\b\u0000\u0000\u00f6\u00f7\u0003"+
		"\u0006\u0003\u0000\u00f7\u00f8\u0005\t\u0000\u0000\u00f8\u00f9\u0006\u0010"+
		"\uffff\uffff\u0000\u00f9\u0107\u0001\u0000\u0000\u0000\u00fa\u00fb\u0003"+
		"\"\u0011\u0000\u00fb\u00fc\u0006\u0010\uffff\uffff\u0000\u00fc\u0107\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0003&\u0013\u0000\u00fe\u00ff\u0006\u0010"+
		"\uffff\uffff\u0000\u00ff\u0107\u0001\u0000\u0000\u0000\u0100\u0101\u0003"+
		"(\u0014\u0000\u0101\u0102\u0006\u0010\uffff\uffff\u0000\u0102\u0107\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0003*\u0015\u0000\u0104\u0105\u0006\u0010"+
		"\uffff\uffff\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u00db\u0001"+
		"\u0000\u0000\u0000\u0106\u00dd\u0001\u0000\u0000\u0000\u0106\u00df\u0001"+
		"\u0000\u0000\u0000\u0106\u00e0\u0001\u0000\u0000\u0000\u0106\u00e2\u0001"+
		"\u0000\u0000\u0000\u0106\u00e3\u0001\u0000\u0000\u0000\u0106\u00e4\u0001"+
		"\u0000\u0000\u0000\u0106\u00ee\u0001\u0000\u0000\u0000\u0106\u00f0\u0001"+
		"\u0000\u0000\u0000\u0106\u00f3\u0001\u0000\u0000\u0000\u0106\u00f5\u0001"+
		"\u0000\u0000\u0000\u0106\u00fa\u0001\u0000\u0000\u0000\u0106\u00fd\u0001"+
		"\u0000\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000\u0106\u0103\u0001"+
		"\u0000\u0000\u0000\u0107!\u0001\u0000\u0000\u0000\u0108\u0109\u0006\u0011"+
		"\uffff\uffff\u0000\u0109\u010a\u0005\u0012\u0000\u0000\u010a\u010b\u0003"+
		"\u0018\f\u0000\u010b\u010c\u0005\u0013\u0000\u0000\u010c\u0110\u0003\u0006"+
		"\u0003\u0000\u010d\u010e\u0003$\u0012\u0000\u010e\u010f\u0006\u0011\uffff"+
		"\uffff\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110\u010d\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0006\u0011\uffff\uffff\u0000\u0113\u0114\u0005"+
		"\u0014\u0000\u0000\u0114#\u0001\u0000\u0000\u0000\u0115\u0116\u0006\u0012"+
		"\uffff\uffff\u0000\u0116\u0117\u0005\u0015\u0000\u0000\u0117\u0118\u0003"+
		"\u0018\f\u0000\u0118\u0119\u0005\u0013\u0000\u0000\u0119\u011d\u0003\u0006"+
		"\u0003\u0000\u011a\u011b\u0003$\u0012\u0000\u011b\u011c\u0006\u0012\uffff"+
		"\uffff\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011a\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0006\u0012\uffff\uffff\u0000\u0120\u0126\u0001"+
		"\u0000\u0000\u0000\u0121\u0122\u0005\u0016\u0000\u0000\u0122\u0123\u0003"+
		"\u0006\u0003\u0000\u0123\u0124\u0006\u0012\uffff\uffff\u0000\u0124\u0126"+
		"\u0001\u0000\u0000\u0000\u0125\u0115\u0001\u0000\u0000\u0000\u0125\u0121"+
		"\u0001\u0000\u0000\u0000\u0126%\u0001\u0000\u0000\u0000\u0127\u0128\u0005"+
		"\u0017\u0000\u0000\u0128\u0129\u0003\u0018\f\u0000\u0129\u012a\u0005\u0018"+
		"\u0000\u0000\u012a\u012b\u0003\u0006\u0003\u0000\u012b\u012c\u0006\u0013"+
		"\uffff\uffff\u0000\u012c\u012d\u0005\u0019\u0000\u0000\u012d\'\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0005\u0018\u0000\u0000\u012f\u0130\u0006\u0014"+
		"\uffff\uffff\u0000\u0130\u0131\u0003\u0004\u0002\u0000\u0131\u0132\u0006"+
		"\u0014\uffff\uffff\u0000\u0132\u0133\u0006\u0014\uffff\uffff\u0000\u0133"+
		"\u0137\u0006\u0014\uffff\uffff\u0000\u0134\u0135\u0003\u0018\f\u0000\u0135"+
		"\u0136\u0006\u0014\uffff\uffff\u0000\u0136\u0138\u0001\u0000\u0000\u0000"+
		"\u0137\u0134\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000"+
		"\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013a\u0006\u0014\uffff\uffff"+
		"\u0000\u013a\u013b\u0005\u0017\u0000\u0000\u013b\u013c\u0003\u0018\f\u0000"+
		"\u013c\u013d\u0006\u0014\uffff\uffff\u0000\u013d\u013e\u0005\u0019\u0000"+
		"\u0000\u013e)\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u001a\u0000\u0000"+
		"\u0140\u0141\u0006\u0015\uffff\uffff\u0000\u0141\u0142\u0003\u0004\u0002"+
		"\u0000\u0142\u0143\u0006\u0015\uffff\uffff\u0000\u0143\u0147\u0006\u0015"+
		"\uffff\uffff\u0000\u0144\u0145\u0003\u0018\f\u0000\u0145\u0146\u0006\u0015"+
		"\uffff\uffff\u0000\u0146\u0148\u0001\u0000\u0000\u0000\u0147\u0144\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0006\u0015\uffff\uffff\u0000\u014a\u014b"+
		"\u0005\u0005\u0000\u0000\u014b\u014c\u0003\u0018\f\u0000\u014c\u014d\u0005"+
		"\u0005\u0000\u0000\u014d\u014e\u0003\u0018\f\u0000\u014e\u014f\u0005\u0018"+
		"\u0000\u0000\u014f\u0150\u0003\b\u0004\u0000\u0150\u0151\u0006\u0015\uffff"+
		"\uffff\u0000\u0151\u0152\u0005\u0019\u0000\u0000\u0152+\u0001\u0000\u0000"+
		"\u0000\u0017/AQ[kuy\u008e\u0091\u0099\u00a4\u00af\u00c2\u00c5\u00c7\u00d4"+
		"\u00d7\u0106\u0110\u011d\u0125\u0137\u0147";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}