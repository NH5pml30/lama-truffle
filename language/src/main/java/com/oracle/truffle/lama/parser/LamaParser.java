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
		T__38=39, T__39=40, T__40=41, WS=42, COMMENT=43, LINE_COMMENT=44, UIDENT=45, 
		LIDENT=46, DECIMAL=47, STRING=48, CHAR=49, OP=50;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeDefinitions = 2, 
		RULE_scopeExpression = 3, RULE_scopeExpression0 = 4, RULE_definition = 5, 
		RULE_variableDefinition = 6, RULE_variableDefinitionSequence = 7, RULE_variableDefinitionItem = 8, 
		RULE_functionDefinition = 9, RULE_functionArgumentsAndBody = 10, RULE_functionArguments = 11, 
		RULE_functionPatArguments = 12, RULE_functionBody = 13, RULE_infixDefinition = 14, 
		RULE_infixity = 15, RULE_level = 16, RULE_expression = 17, RULE_basicExpression = 18, 
		RULE_primaryExpression = 19, RULE_functionParams = 20, RULE_primary = 21, 
		RULE_ifExpression = 22, RULE_elsePart = 23, RULE_whileDoExpression = 24, 
		RULE_doWhileExpression = 25, RULE_forExpression = 26, RULE_arrayExpression = 27, 
		RULE_sExpression = 28, RULE_listExpression = 29, RULE_caseExpression = 30, 
		RULE_caseBranches = 31, RULE_caseBranch = 32, RULE_pattern = 33, RULE_simplePattern = 34, 
		RULE_consPattern = 35, RULE_listPattern = 36, RULE_wildcardPattern = 37, 
		RULE_sExpPattern = 38, RULE_arrayPattern = 39, RULE_etaExpression = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeDefinitions", "scopeExpression", 
			"scopeExpression0", "definition", "variableDefinition", "variableDefinitionSequence", 
			"variableDefinitionItem", "functionDefinition", "functionArgumentsAndBody", 
			"functionArguments", "functionPatArguments", "functionBody", "infixDefinition", 
			"infixity", "level", "expression", "basicExpression", "primaryExpression", 
			"functionParams", "primary", "ifExpression", "elsePart", "whileDoExpression", 
			"doWhileExpression", "forExpression", "arrayExpression", "sExpression", 
			"listExpression", "caseExpression", "caseBranches", "caseBranch", "pattern", 
			"simplePattern", "consPattern", "listPattern", "wildcardPattern", "sExpPattern", 
			"arrayPattern", "etaExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "';'", "'var'", "'public'", "','", "'='", "'fun'", 
			"'('", "')'", "'{'", "'}'", "'infix'", "'infixl'", "'infixr'", "'at'", 
			"'before'", "'after'", "'['", "']'", "'.'", "'skip'", "'if'", "'then'", 
			"'fi'", "'elif'", "'else'", "'while'", "'do'", "'od'", "'for'", "'case'", 
			"'of'", "'esac'", "'|'", "'->'", "'@'", "'#fun'", "'#val'", "'#str'", 
			"'_'", "'eta'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(82);
				importStt();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(89);
			((CompilationUnitContext)_localctx).functionBody = functionBody();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).functionBody.result, _input.LT(1)); 
			setState(91);
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
			setState(93);
			match(T__0);
			setState(94);
			match(UIDENT);
			setState(95);
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
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					definition();
					}
					} 
				}
				setState(102);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
			setState(104);
			scopeDefinitions();
			setState(105);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
			setState(109);
			scopeDefinitions();
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> gen = GenInterfaces.of(); 
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095289728L) != 0)) {
				{
				setState(111);
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
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
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
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(124);
			variableDefinitionSequence();
			setState(125);
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
			setState(127);
			((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
			 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(129);
				match(T__4);
				setState(130);
				((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
				 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
				}
				}
				setState(137);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> value;
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
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT; ((VariableDefinitionItemContext)_localctx).value =  factory.createSkip(((VariableDefinitionItemContext)_localctx).LIDENT); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(141);
				match(T__5);
				setState(142);
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
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(147);
				match(T__3);
				}
			}

			setState(150);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(151);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(152);
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
		public FunctionPatArgumentsContext functionPatArguments;
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionPatArgumentsContext functionPatArguments() {
			return getRuleContext(FunctionPatArgumentsContext.class,0);
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
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(155);
				match(T__7);
				setState(156);
				((FunctionArgumentsAndBodyContext)_localctx).functionArguments = functionArguments();
				setState(157);
				match(T__8);
				 factory.startFunction(((FunctionArgumentsAndBodyContext)_localctx).functionArguments.result, _localctx.name); 
				setState(159);
				match(T__9);
				setState(160);
				((FunctionArgumentsAndBodyContext)_localctx).functionBody = functionBody();
				setState(161);
				match(T__10);
				 ((FunctionArgumentsAndBodyContext)_localctx).result =  factory.finishFunction(((FunctionArgumentsAndBodyContext)_localctx).functionBody.result); 
				}
				break;
			case 2:
				{
				setState(164);
				match(T__7);
				setState(165);
				((FunctionArgumentsAndBodyContext)_localctx).functionPatArguments = functionPatArguments();
				setState(166);
				match(T__8);
				 var c = factory.startFunctionPat(((FunctionArgumentsAndBodyContext)_localctx).functionPatArguments.result, _localctx.name, _localctx.t); 
				setState(168);
				match(T__9);
				setState(169);
				((FunctionArgumentsAndBodyContext)_localctx).functionBody = functionBody();
				setState(170);
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
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(176);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT.getText()); 
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(178);
					match(T__4);
					setState(179);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT.getText()); 
					}
					}
					setState(185);
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
	public static class FunctionPatArgumentsContext extends ParserRuleContext {
		public List<PatGen> result;
		public PatternContext pattern;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public FunctionPatArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPatArguments; }
	}

	public final FunctionPatArgumentsContext functionPatArguments() throws RecognitionException {
		FunctionPatArgumentsContext _localctx = new FunctionPatArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionPatArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionPatArgumentsContext)_localctx).result =  new ArrayList<>(); 
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1655727072740608L) != 0)) {
				{
				setState(189);
				((FunctionPatArgumentsContext)_localctx).pattern = pattern();
				 _localctx.result.add(((FunctionPatArgumentsContext)_localctx).pattern.result); 
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(191);
					match(T__4);
					setState(192);
					((FunctionPatArgumentsContext)_localctx).pattern = pattern();
					 _localctx.result.add(((FunctionPatArgumentsContext)_localctx).pattern.result); 
					}
					}
					setState(199);
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
		public GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 26, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			scopeDefinitions();
			 ((FunctionBodyContext)_localctx).result =  GenInterfaces.of(); 
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095289728L) != 0)) {
				{
				setState(204);
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
		enterRule(_localctx, 28, RULE_infixDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(209);
				match(T__3);
				}
			}

			setState(212);
			((InfixDefinitionContext)_localctx).infixity = infixity();
			setState(213);
			((InfixDefinitionContext)_localctx).name = match(OP);
			setState(214);
			((InfixDefinitionContext)_localctx).level = level();
			setState(215);
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
		enterRule(_localctx, 30, RULE_infixity);
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__11);
				 ((InfixityContext)_localctx).result =  OpType.InfixNone; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(T__12);
				 ((InfixityContext)_localctx).result =  OpType.InfixLeft; 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
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
		enterRule(_localctx, 32, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(227);
				match(T__14);
				 ((LevelContext)_localctx).rel =  0; 
				}
				break;
			case T__15:
				{
				setState(229);
				match(T__15);
				 ((LevelContext)_localctx).rel =  -1; 
				}
				break;
			case T__16:
				{
				setState(231);
				match(T__16);
				 ((LevelContext)_localctx).rel =  1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(235);
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
		public GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 34, RULE_expression);
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  GenInterfaces.of(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  GenInterfaces.of(((ExpressionContext)_localctx).basicExpression.result); 
				setState(243);
				match(T__1);
				setState(244);
				((ExpressionContext)_localctx).expression = expression();
				 ((ExpressionContext)_localctx).result =  GenInterfaces.concat(GenInterface.konst(_localctx.result, ValueCategory.Val), ((ExpressionContext)_localctx).expression.result); 
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 36, RULE_basicExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; 
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					if (!(factory.getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "factory.getPrecedence(_input.LT(1)) >= $_p");
					setState(252);
					((BasicExpressionContext)_localctx).op = match(OP);
					setState(253);
					((BasicExpressionContext)_localctx).rhs = basicExpression(factory.getNextPrecedence(((BasicExpressionContext)_localctx).op));
					 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, _localctx.result, ((BasicExpressionContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 38, RULE_primaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(280);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__17:
						{
						setState(263);
						match(T__17);
						setState(264);
						((PrimaryExpressionContext)_localctx).expression = expression();
						setState(265);
						match(T__18);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createElement(_localctx.result, factory.finishSeq(((PrimaryExpressionContext)_localctx).expression.result)); 
						}
						break;
					case T__7:
						{
						setState(268);
						((PrimaryExpressionContext)_localctx).functionParams = functionParams();
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, ((PrimaryExpressionContext)_localctx).functionParams.args, ((PrimaryExpressionContext)_localctx).functionParams.t); 
						}
						break;
					case T__19:
						{
						setState(271);
						((PrimaryExpressionContext)_localctx).t = match(T__19);
						setState(272);
						((PrimaryExpressionContext)_localctx).LIDENT = match(LIDENT);
						 List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> args = new ArrayList<>(); args.add(_localctx.result); 
						setState(277);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
						case 1:
							{
							setState(274);
							((PrimaryExpressionContext)_localctx).functionParams = functionParams();
							 args.addAll(((PrimaryExpressionContext)_localctx).functionParams.args); 
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
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		public List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> args;
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
		enterRule(_localctx, 40, RULE_functionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			((FunctionParamsContext)_localctx).tt = match(T__7);
			 ((FunctionParamsContext)_localctx).args =  new ArrayList<>(); ((FunctionParamsContext)_localctx).t =  ((FunctionParamsContext)_localctx).tt; 
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095314328L) != 0)) {
				{
				setState(287);
				((FunctionParamsContext)_localctx).scopeExpression = scopeExpression();
				 _localctx.args.add(((FunctionParamsContext)_localctx).scopeExpression.result); 
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(289);
					match(T__4);
					setState(290);
					((FunctionParamsContext)_localctx).scopeExpression = scopeExpression();
					 _localctx.args.add(((FunctionParamsContext)_localctx).scopeExpression.result); 
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(300);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
		public Token d;
		public Token s;
		public Token c;
		public Token i;
		public Token OP;
		public Token t;
		public FunctionArgumentsAndBodyContext functionArgumentsAndBody;
		public Token op;
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
		enterRule(_localctx, 42, RULE_primary);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				((PrimaryContext)_localctx).s = match(STRING);
				 ((PrimaryContext)_localctx).result =  factory.createStringLiteral(((PrimaryContext)_localctx).s); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				((PrimaryContext)_localctx).c = match(CHAR);
				 ((PrimaryContext)_localctx).result =  factory.createCharLiteral(((PrimaryContext)_localctx).c); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(T__11);
				setState(311);
				((PrimaryContext)_localctx).OP = match(OP);
				 ((PrimaryContext)_localctx).result =  factory.createInfix(((PrimaryContext)_localctx).OP); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(313);
				((PrimaryContext)_localctx).t = match(T__6);
				setState(314);
				((PrimaryContext)_localctx).functionArgumentsAndBody = functionArgumentsAndBody("<lambda>", ((PrimaryContext)_localctx).t);
				 ((PrimaryContext)_localctx).result =  factory.genValue(((PrimaryContext)_localctx).functionArgumentsAndBody.result.instantiate(), ((PrimaryContext)_localctx).t); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(317);
				((PrimaryContext)_localctx).t = match(T__20);
				 ((PrimaryContext)_localctx).result =  factory.createSkip(((PrimaryContext)_localctx).t); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(319);
				((PrimaryContext)_localctx).op = match(OP);
				setState(320);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).op, ((PrimaryContext)_localctx).d); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(322);
				match(OP);
				setState(323);
				basicExpression(0);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(324);
				match(T__7);
				setState(325);
				((PrimaryContext)_localctx).scopeExpression = scopeExpression();
				setState(326);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).scopeExpression.result; 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(329);
				((PrimaryContext)_localctx).listExpression = listExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).listExpression.result; 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(332);
				((PrimaryContext)_localctx).arrayExpression = arrayExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).arrayExpression.result; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(335);
				((PrimaryContext)_localctx).sExpression = sExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).sExpression.result; 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(338);
				((PrimaryContext)_localctx).ifExpression = ifExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).ifExpression.result; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(341);
				((PrimaryContext)_localctx).whileDoExpression = whileDoExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).whileDoExpression.result; 
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(344);
				((PrimaryContext)_localctx).doWhileExpression = doWhileExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).doWhileExpression.result; 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(347);
				((PrimaryContext)_localctx).forExpression = forExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).forExpression.result; 
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(350);
				((PrimaryContext)_localctx).caseExpression = caseExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).caseExpression.result; 
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(353);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 44, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; 
			setState(359);
			((IfExpressionContext)_localctx).t = match(T__21);
			setState(360);
			((IfExpressionContext)_localctx).expression = expression();
			setState(361);
			match(T__22);
			setState(362);
			((IfExpressionContext)_localctx).scopeExpression = scopeExpression();
			 falsePart = factory.createSkip(((IfExpressionContext)_localctx).t); 
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__24 || _la==T__25) {
				{
				setState(364);
				((IfExpressionContext)_localctx).elsePart = elsePart();
				 falsePart = ((IfExpressionContext)_localctx).elsePart.result; 
				}
			}

			 ((IfExpressionContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((IfExpressionContext)_localctx).expression.result), ((IfExpressionContext)_localctx).scopeExpression.result, falsePart); 
			setState(370);
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
	public static class ElsePartContext extends ParserRuleContext {
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 46, RULE_elsePart);
		int _la;
		try {
			setState(389);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; 
				setState(373);
				((ElsePartContext)_localctx).t = match(T__24);
				setState(374);
				((ElsePartContext)_localctx).expression = expression();
				setState(375);
				match(T__22);
				setState(376);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				 falsePart = factory.createSkip(((ElsePartContext)_localctx).t); 
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24 || _la==T__25) {
					{
					setState(378);
					((ElsePartContext)_localctx).elsePart = elsePart();
					 falsePart = ((ElsePartContext)_localctx).elsePart.result; 
					}
				}

				 ((ElsePartContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((ElsePartContext)_localctx).expression.result), ((ElsePartContext)_localctx).scopeExpression.result, falsePart); 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				match(T__25);
				setState(386);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 48, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			((WhileDoExpressionContext)_localctx).t = match(T__26);
			setState(392);
			((WhileDoExpressionContext)_localctx).expression = expression();
			setState(393);
			match(T__27);
			setState(394);
			((WhileDoExpressionContext)_localctx).scopeExpression = scopeExpression();
			 ((WhileDoExpressionContext)_localctx).result =  factory.createWhileDo(factory.finishSeq(((WhileDoExpressionContext)_localctx).expression.result), ((WhileDoExpressionContext)_localctx).scopeExpression.result, ((WhileDoExpressionContext)_localctx).t); 
			setState(396);
			match(T__28);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 50, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			((DoWhileExpressionContext)_localctx).t = match(T__27);
			 var scope = factory.startBlock(); 
			setState(400);
			((DoWhileExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.startBlock(); factory.pullLocalValues(scope); 
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body = GenInterfaces.of(); 
			setState(406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(403);
				((DoWhileExpressionContext)_localctx).expression = expression();
				 body = ((DoWhileExpressionContext)_localctx).expression.result; 
				}
				break;
			}
			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> bodyNode = factory.finishBlock(body); 
			setState(409);
			match(T__26);
			setState(410);
			((DoWhileExpressionContext)_localctx).cond = ((DoWhileExpressionContext)_localctx).expression = expression();
			 ((DoWhileExpressionContext)_localctx).result =  factory.finishBlock(GenInterfaces.of(
			              factory.createDoWhile(bodyNode, factory.finishSeq(((DoWhileExpressionContext)_localctx).cond.result), ((DoWhileExpressionContext)_localctx).t)
			      )); 
			setState(412);
			match(T__28);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 52, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			((ForExpressionContext)_localctx).t = match(T__29);
			 factory.startBlock(); 
			setState(416);
			((ForExpressionContext)_localctx).defs = scopeDefinitions();
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> init = GenInterfaces.of(); 
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095289728L) != 0)) {
				{
				setState(418);
				((ForExpressionContext)_localctx).expression = expression();
				 init = ((ForExpressionContext)_localctx).expression.result; 
				}
			}

			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> initNode = factory.finishSeq(init); 
			setState(424);
			match(T__4);
			setState(425);
			((ForExpressionContext)_localctx).cond = ((ForExpressionContext)_localctx).expression = expression();
			setState(426);
			match(T__4);
			setState(427);
			((ForExpressionContext)_localctx).step = ((ForExpressionContext)_localctx).expression = expression();
			setState(428);
			match(T__27);
			setState(429);
			((ForExpressionContext)_localctx).scopeExpression0 = scopeExpression0();
			 ((ForExpressionContext)_localctx).result =  factory.finishBlock(GenInterfaces.of(
			              factory.createForLoop(initNode, factory.finishSeq(((ForExpressionContext)_localctx).cond.result), factory.finishSeq(((ForExpressionContext)_localctx).step.result), ((ForExpressionContext)_localctx).scopeExpression0.result, ((ForExpressionContext)_localctx).t)
			      )); 
			setState(431);
			match(T__28);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
		public Token t;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpression; }
	}

	public final ArrayExpressionContext arrayExpression() throws RecognitionException {
		ArrayExpressionContext _localctx = new ArrayExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			((ArrayExpressionContext)_localctx).t = match(T__17);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095289728L) != 0)) {
				{
				setState(435);
				((ArrayExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ArrayExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(437);
					match(T__4);
					setState(438);
					((ArrayExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ArrayExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(445);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(448);
			match(T__18);
			 ((ArrayExpressionContext)_localctx).result =  factory.createArray(vals, ((ArrayExpressionContext)_localctx).t); 
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
		public Token t;
		public ExpressionContext expression;
		public TerminalNode UIDENT() { return getToken(LamaParser.UIDENT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExpression; }
	}

	public final SExpressionContext sExpression() throws RecognitionException {
		SExpressionContext _localctx = new SExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			((SExpressionContext)_localctx).t = match(UIDENT);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(453);
				match(T__7);
				setState(454);
				((SExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((SExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(456);
					match(T__4);
					setState(457);
					((SExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((SExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(465);
				match(T__8);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
		public Token t;
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpression; }
	}

	public final ListExpressionContext listExpression() throws RecognitionException {
		ListExpressionContext _localctx = new ListExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_listExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			((ListExpressionContext)_localctx).t = match(T__9);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2218818095289728L) != 0)) {
				{
				setState(473);
				((ListExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ListExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(475);
					match(T__4);
					setState(476);
					((ListExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ListExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(483);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(486);
			match(T__10);
			 ((ListExpressionContext)_localctx).result =  factory.createList(vals, ((ListExpressionContext)_localctx).t); 
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
			setState(489);
			match(T__30);
			setState(490);
			((CaseExpressionContext)_localctx).expression = expression();
			setState(491);
			match(T__31);
			setState(492);
			((CaseExpressionContext)_localctx).caseBranches = caseBranches();
			setState(493);
			match(T__32);
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
		public List<Pair<PatGen, GenInterface<ValueCategory, GenInterface<Void, LamaNode>>>> result;
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
			setState(497);
			((CaseBranchesContext)_localctx).caseBranch = caseBranch();
			 _localctx.result.add(Pair.create(((CaseBranchesContext)_localctx).caseBranch.pat, ((CaseBranchesContext)_localctx).caseBranch.returns)); 
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__33) {
				{
				{
				setState(499);
				match(T__33);
				setState(500);
				((CaseBranchesContext)_localctx).caseBranch = caseBranch();
				 _localctx.result.add(Pair.create(((CaseBranchesContext)_localctx).caseBranch.pat, ((CaseBranchesContext)_localctx).caseBranch.returns)); 
				}
				}
				setState(507);
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> returns;
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
			setState(509);
			((CaseBranchContext)_localctx).pattern = pattern();
			 ((CaseBranchContext)_localctx).pat =  ((CaseBranchContext)_localctx).pattern.result; 
			setState(511);
			match(T__34);
			setState(512);
			((CaseBranchContext)_localctx).scopeExpression = scopeExpression();
			 ((CaseBranchContext)_localctx).returns =  factory.finishBlock(GenInterfaces.of(((CaseBranchContext)_localctx).scopeExpression.result)); 
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
			setState(521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(515);
				((PatternContext)_localctx).simplePattern = simplePattern();
				 ((PatternContext)_localctx).result =  ((PatternContext)_localctx).simplePattern.result; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
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
			setState(562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(523);
				((SimplePatternContext)_localctx).wildcardPattern = wildcardPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).wildcardPattern.result; 
				}
				break;
			case UIDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(526);
				((SimplePatternContext)_localctx).sExpPattern = sExpPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).sExpPattern.result; 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(529);
				((SimplePatternContext)_localctx).arrayPattern = arrayPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).arrayPattern.result; 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(532);
				((SimplePatternContext)_localctx).listPattern = listPattern();
				 ((SimplePatternContext)_localctx).result =  ((SimplePatternContext)_localctx).listPattern.result; 
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(535);
				((SimplePatternContext)_localctx).name = match(LIDENT);
				 factory.tryAddLocal(((SimplePatternContext)_localctx).name, factory.createSkip(((SimplePatternContext)_localctx).name)); PatGen bind = factory.createWildcardPattern(); 
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(537);
					match(T__35);
					setState(538);
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
				setState(544);
				((SimplePatternContext)_localctx).d = match(DECIMAL);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern(((SimplePatternContext)_localctx).d.getText()); 
				}
				break;
			case OP:
				enterOuterAlt(_localctx, 7);
				{
				setState(546);
				((SimplePatternContext)_localctx).op = match(OP);
				setState(547);
				((SimplePatternContext)_localctx).d = match(DECIMAL);
				 ((SimplePatternContext)_localctx).result =  factory.createIntValPattern(((SimplePatternContext)_localctx).op.getText() + ((SimplePatternContext)_localctx).d.getText()); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(549);
				((SimplePatternContext)_localctx).s = match(STRING);
				 ((SimplePatternContext)_localctx).result =  factory.createStrValPattern(((SimplePatternContext)_localctx).s.getText()); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 9);
				{
				setState(551);
				match(T__36);
				 ((SimplePatternContext)_localctx).result =  factory.createFunPattern(); 
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 10);
				{
				setState(553);
				match(T__37);
				 ((SimplePatternContext)_localctx).result =  factory.createValPattern(); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 11);
				{
				setState(555);
				match(T__38);
				 ((SimplePatternContext)_localctx).result =  factory.createStrPattern(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 12);
				{
				setState(557);
				match(T__7);
				setState(558);
				((SimplePatternContext)_localctx).pattern = pattern();
				setState(559);
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
			setState(564);
			((ConsPatternContext)_localctx).simplePattern = simplePattern();
			setState(565);
			((ConsPatternContext)_localctx).OP = match(OP);
			setState(566);
			if (!(((ConsPatternContext)_localctx).OP.getText().equals(":"))) throw new FailedPredicateException(this, "$OP.getText().equals(\":\")");
			setState(567);
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
	public static class ListPatternContext extends ParserRuleContext {
		public PatGen result;
		public PatternContext pattern;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public ListPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPattern; }
	}

	public final ListPatternContext listPattern() throws RecognitionException {
		ListPatternContext _localctx = new ListPatternContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_listPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(T__9);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(583);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1655727072740608L) != 0)) {
				{
				setState(572);
				((ListPatternContext)_localctx).pattern = pattern();
				 pats.add(((ListPatternContext)_localctx).pattern.result); 
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(574);
					match(T__4);
					setState(575);
					((ListPatternContext)_localctx).pattern = pattern();
					 pats.add(((ListPatternContext)_localctx).pattern.result); 
					}
					}
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(585);
			match(T__10);
			 ((ListPatternContext)_localctx).result =  factory.createListPattern(pats); 
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
		enterRule(_localctx, 74, RULE_wildcardPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(T__39);
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
		public PatternContext pattern;
		public TerminalNode UIDENT() { return getToken(LamaParser.UIDENT, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public SExpPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExpPattern; }
	}

	public final SExpPatternContext sExpPattern() throws RecognitionException {
		SExpPatternContext _localctx = new SExpPatternContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_sExpPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			((SExpPatternContext)_localctx).t = match(UIDENT);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(593);
				match(T__7);
				setState(594);
				((SExpPatternContext)_localctx).pattern = pattern();
				 pats.add(((SExpPatternContext)_localctx).pattern.result); 
				setState(602);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(596);
					match(T__4);
					setState(597);
					((SExpPatternContext)_localctx).pattern = pattern();
					 pats.add(((SExpPatternContext)_localctx).pattern.result); 
					}
					}
					setState(604);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(605);
				match(T__8);
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
		public PatternContext pattern;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public ArrayPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayPattern; }
	}

	public final ArrayPatternContext arrayPattern() throws RecognitionException {
		ArrayPatternContext _localctx = new ArrayPatternContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			match(T__17);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1655727072740608L) != 0)) {
				{
				setState(613);
				((ArrayPatternContext)_localctx).pattern = pattern();
				 pats.add(((ArrayPatternContext)_localctx).pattern.result); 
				setState(621);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(615);
					match(T__4);
					setState(616);
					((ArrayPatternContext)_localctx).pattern = pattern();
					 pats.add(((ArrayPatternContext)_localctx).pattern.result); 
					}
					}
					setState(623);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(626);
			match(T__18);
			 ((ArrayPatternContext)_localctx).result =  factory.createArrayPattern(pats); 
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
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 80, RULE_etaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			((EtaExpressionContext)_localctx).t = match(T__40);
			 String synthName = factory.freshName(); factory.startFunction(List.of(synthName), "<eta>"); 
			setState(631);
			((EtaExpressionContext)_localctx).basicExpression = basicExpression(0);

			      var params = List.of(factory.createRead(synthName, ((EtaExpressionContext)_localctx).t));
			      var func = ((EtaExpressionContext)_localctx).basicExpression.result;
			      var fun = factory.finishFunction(GenInterfaces.of(factory.createCall(func, params, ((EtaExpressionContext)_localctx).t))).instantiate();
			      ((EtaExpressionContext)_localctx).result =  factory.genValue(fun, ((EtaExpressionContext)_localctx).t);
			    
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
		case 18:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		case 35:
			return consPattern_sempred((ConsPatternContext)_localctx, predIndex);
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
	private boolean consPattern_sempred(ConsPatternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return ((ConsPatternContext)_localctx).OP.getText().equals(":");
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u027b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0001\u0000\u0005\u0000T\b\u0000\n\u0000\f\u0000W\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002c\b\u0002\n\u0002"+
		"\f\u0002f\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004s\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005z\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0086\b\u0007\n\u0007\f\u0007\u0089\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0092"+
		"\b\b\u0001\t\u0003\t\u0095\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00ae\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00b6\b\u000b\n\u000b\f\u000b\u00b9\t\u000b"+
		"\u0003\u000b\u00bb\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u00c4\b\f\n\f\f\f\u00c7\t\f\u0003\f\u00c9\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d0\b\r\u0001\u000e\u0003"+
		"\u000e\u00d3\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e2\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ea"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00f8\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0101\b\u0012\n"+
		"\u0012\f\u0012\u0104\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0116\b\u0013\u0001\u0013\u0005\u0013\u0119\b\u0013"+
		"\n\u0013\f\u0013\u011c\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0126"+
		"\b\u0014\n\u0014\f\u0014\u0129\t\u0014\u0003\u0014\u012b\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u0165\b\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0170\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u017e\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0186"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0197\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u01a6\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01ba\b\u001b\n\u001b\f\u001b"+
		"\u01bd\t\u001b\u0003\u001b\u01bf\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u01cd\b\u001c\n"+
		"\u001c\f\u001c\u01d0\t\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01d4"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01e0"+
		"\b\u001d\n\u001d\f\u001d\u01e3\t\u001d\u0003\u001d\u01e5\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01f8"+
		"\b\u001f\n\u001f\f\u001f\u01fb\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u020a"+
		"\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u021e\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0003\"\u0233\b\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0005$\u0243\b$\n$\f$\u0246\t$\u0003$\u0248\b$\u0001$\u0001$\u0001$"+
		"\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0005&\u0259\b&\n&\f&\u025c\t&\u0001&\u0001&\u0003&\u0260"+
		"\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0005\'\u026c\b\'\n\'\f\'\u026f\t\'\u0003\'\u0271\b\'\u0001"+
		"\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0000\u0000"+
		")\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNP\u0000\u0001\u0001\u0000\u0003\u0004"+
		"\u029d\u0000U\u0001\u0000\u0000\u0000\u0002]\u0001\u0000\u0000\u0000\u0004"+
		"d\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000\bl\u0001\u0000"+
		"\u0000\u0000\ny\u0001\u0000\u0000\u0000\f{\u0001\u0000\u0000\u0000\u000e"+
		"\u007f\u0001\u0000\u0000\u0000\u0010\u0091\u0001\u0000\u0000\u0000\u0012"+
		"\u0094\u0001\u0000\u0000\u0000\u0014\u00ad\u0001\u0000\u0000\u0000\u0016"+
		"\u00af\u0001\u0000\u0000\u0000\u0018\u00bc\u0001\u0000\u0000\u0000\u001a"+
		"\u00ca\u0001\u0000\u0000\u0000\u001c\u00d2\u0001\u0000\u0000\u0000\u001e"+
		"\u00e1\u0001\u0000\u0000\u0000 \u00e9\u0001\u0000\u0000\u0000\"\u00f7"+
		"\u0001\u0000\u0000\u0000$\u00f9\u0001\u0000\u0000\u0000&\u0105\u0001\u0000"+
		"\u0000\u0000(\u011d\u0001\u0000\u0000\u0000*\u0164\u0001\u0000\u0000\u0000"+
		",\u0166\u0001\u0000\u0000\u0000.\u0185\u0001\u0000\u0000\u00000\u0187"+
		"\u0001\u0000\u0000\u00002\u018e\u0001\u0000\u0000\u00004\u019e\u0001\u0000"+
		"\u0000\u00006\u01b1\u0001\u0000\u0000\u00008\u01c3\u0001\u0000\u0000\u0000"+
		":\u01d7\u0001\u0000\u0000\u0000<\u01e9\u0001\u0000\u0000\u0000>\u01f0"+
		"\u0001\u0000\u0000\u0000@\u01fc\u0001\u0000\u0000\u0000B\u0209\u0001\u0000"+
		"\u0000\u0000D\u0232\u0001\u0000\u0000\u0000F\u0234\u0001\u0000\u0000\u0000"+
		"H\u023a\u0001\u0000\u0000\u0000J\u024c\u0001\u0000\u0000\u0000L\u024f"+
		"\u0001\u0000\u0000\u0000N\u0263\u0001\u0000\u0000\u0000P\u0275\u0001\u0000"+
		"\u0000\u0000RT\u0003\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000TW\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0006\u0000\uffff"+
		"\uffff\u0000YZ\u0003\u001a\r\u0000Z[\u0006\u0000\uffff\uffff\u0000[\\"+
		"\u0005\u0000\u0000\u0001\\\u0001\u0001\u0000\u0000\u0000]^\u0005\u0001"+
		"\u0000\u0000^_\u0005-\u0000\u0000_`\u0005\u0002\u0000\u0000`\u0003\u0001"+
		"\u0000\u0000\u0000ac\u0003\n\u0005\u0000ba\u0001\u0000\u0000\u0000cf\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"e\u0005\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0006\u0003"+
		"\uffff\uffff\u0000hi\u0003\u0004\u0002\u0000ij\u0003\"\u0011\u0000jk\u0006"+
		"\u0003\uffff\uffff\u0000k\u0007\u0001\u0000\u0000\u0000lm\u0006\u0004"+
		"\uffff\uffff\u0000mn\u0003\u0004\u0002\u0000nr\u0006\u0004\uffff\uffff"+
		"\u0000op\u0003\"\u0011\u0000pq\u0006\u0004\uffff\uffff\u0000qs\u0001\u0000"+
		"\u0000\u0000ro\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000u\t\u0001\u0000\u0000"+
		"\u0000vz\u0003\f\u0006\u0000wz\u0003\u0012\t\u0000xz\u0003\u001c\u000e"+
		"\u0000yv\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000"+
		"\u0000\u0000z\u000b\u0001\u0000\u0000\u0000{|\u0007\u0000\u0000\u0000"+
		"|}\u0003\u000e\u0007\u0000}~\u0005\u0002\u0000\u0000~\r\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0003\u0010\b\u0000\u0080\u0087\u0006\u0007\uffff\uffff"+
		"\u0000\u0081\u0082\u0005\u0005\u0000\u0000\u0082\u0083\u0003\u0010\b\u0000"+
		"\u0083\u0084\u0006\u0007\uffff\uffff\u0000\u0084\u0086\u0001\u0000\u0000"+
		"\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u000f\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005.\u0000\u0000\u008b\u0092\u0006\b\uffff\uffff"+
		"\u0000\u008c\u008d\u0005.\u0000\u0000\u008d\u008e\u0005\u0006\u0000\u0000"+
		"\u008e\u008f\u0003$\u0012\u0000\u008f\u0090\u0006\b\uffff\uffff\u0000"+
		"\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008a\u0001\u0000\u0000\u0000"+
		"\u0091\u008c\u0001\u0000\u0000\u0000\u0092\u0011\u0001\u0000\u0000\u0000"+
		"\u0093\u0095\u0005\u0004\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0005\u0007\u0000\u0000\u0097\u0098\u0005.\u0000\u0000\u0098"+
		"\u0099\u0003\u0014\n\u0000\u0099\u009a\u0006\t\uffff\uffff\u0000\u009a"+
		"\u0013\u0001\u0000\u0000\u0000\u009b\u009c\u0005\b\u0000\u0000\u009c\u009d"+
		"\u0003\u0016\u000b\u0000\u009d\u009e\u0005\t\u0000\u0000\u009e\u009f\u0006"+
		"\n\uffff\uffff\u0000\u009f\u00a0\u0005\n\u0000\u0000\u00a0\u00a1\u0003"+
		"\u001a\r\u0000\u00a1\u00a2\u0005\u000b\u0000\u0000\u00a2\u00a3\u0006\n"+
		"\uffff\uffff\u0000\u00a3\u00ae\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"\b\u0000\u0000\u00a5\u00a6\u0003\u0018\f\u0000\u00a6\u00a7\u0005\t\u0000"+
		"\u0000\u00a7\u00a8\u0006\n\uffff\uffff\u0000\u00a8\u00a9\u0005\n\u0000"+
		"\u0000\u00a9\u00aa\u0003\u001a\r\u0000\u00aa\u00ab\u0005\u000b\u0000\u0000"+
		"\u00ab\u00ac\u0006\n\uffff\uffff\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ad\u009b\u0001\u0000\u0000\u0000\u00ad\u00a4\u0001\u0000\u0000\u0000"+
		"\u00ae\u0015\u0001\u0000\u0000\u0000\u00af\u00ba\u0006\u000b\uffff\uffff"+
		"\u0000\u00b0\u00b1\u0005.\u0000\u0000\u00b1\u00b7\u0006\u000b\uffff\uffff"+
		"\u0000\u00b2\u00b3\u0005\u0005\u0000\u0000\u00b3\u00b4\u0005.\u0000\u0000"+
		"\u00b4\u00b6\u0006\u000b\uffff\uffff\u0000\u00b5\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00b0\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u0017\u0001\u0000\u0000"+
		"\u0000\u00bc\u00c8\u0006\f\uffff\uffff\u0000\u00bd\u00be\u0003B!\u0000"+
		"\u00be\u00c5\u0006\f\uffff\uffff\u0000\u00bf\u00c0\u0005\u0005\u0000\u0000"+
		"\u00c0\u00c1\u0003B!\u0000\u00c1\u00c2\u0006\f\uffff\uffff\u0000\u00c2"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00bd\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u0019\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0003\u0004\u0002\u0000\u00cb\u00cf\u0006\r\uffff\uffff\u0000\u00cc"+
		"\u00cd\u0003\"\u0011\u0000\u00cd\u00ce\u0006\r\uffff\uffff\u0000\u00ce"+
		"\u00d0\u0001\u0000\u0000\u0000\u00cf\u00cc\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u001b\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d3\u0005\u0004\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d5\u0003\u001e\u000f\u0000\u00d5\u00d6\u00052\u0000\u0000\u00d6\u00d7"+
		"\u0003 \u0010\u0000\u00d7\u00d8\u0003\u0014\n\u0000\u00d8\u00d9\u0006"+
		"\u000e\uffff\uffff\u0000\u00d9\u00da\u0006\u000e\uffff\uffff\u0000\u00da"+
		"\u001d\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\f\u0000\u0000\u00dc\u00e2"+
		"\u0006\u000f\uffff\uffff\u0000\u00dd\u00de\u0005\r\u0000\u0000\u00de\u00e2"+
		"\u0006\u000f\uffff\uffff\u0000\u00df\u00e0\u0005\u000e\u0000\u0000\u00e0"+
		"\u00e2\u0006\u000f\uffff\uffff\u0000\u00e1\u00db\u0001\u0000\u0000\u0000"+
		"\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000"+
		"\u00e2\u001f\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u000f\u0000\u0000"+
		"\u00e4\u00ea\u0006\u0010\uffff\uffff\u0000\u00e5\u00e6\u0005\u0010\u0000"+
		"\u0000\u00e6\u00ea\u0006\u0010\uffff\uffff\u0000\u00e7\u00e8\u0005\u0011"+
		"\u0000\u0000\u00e8\u00ea\u0006\u0010\uffff\uffff\u0000\u00e9\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e5\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005"+
		"2\u0000\u0000\u00ec\u00ed\u0006\u0010\uffff\uffff\u0000\u00ed!\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ef\u0003$\u0012\u0000\u00ef\u00f0\u0006\u0011\uffff"+
		"\uffff\u0000\u00f0\u00f8\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003$\u0012"+
		"\u0000\u00f2\u00f3\u0006\u0011\uffff\uffff\u0000\u00f3\u00f4\u0005\u0002"+
		"\u0000\u0000\u00f4\u00f5\u0003\"\u0011\u0000\u00f5\u00f6\u0006\u0011\uffff"+
		"\uffff\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f1\u0001\u0000\u0000\u0000\u00f8#\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0003&\u0013\u0000\u00fa\u0102\u0006\u0012\uffff\uffff"+
		"\u0000\u00fb\u00fc\u0004\u0012\u0000\u0001\u00fc\u00fd\u00052\u0000\u0000"+
		"\u00fd\u00fe\u0003$\u0012\u0000\u00fe\u00ff\u0006\u0012\uffff\uffff\u0000"+
		"\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fb\u0001\u0000\u0000\u0000"+
		"\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0001\u0000\u0000\u0000\u0103%\u0001\u0000\u0000\u0000\u0104"+
		"\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0003*\u0015\u0000\u0106\u011a"+
		"\u0006\u0013\uffff\uffff\u0000\u0107\u0108\u0005\u0012\u0000\u0000\u0108"+
		"\u0109\u0003\"\u0011\u0000\u0109\u010a\u0005\u0013\u0000\u0000\u010a\u010b"+
		"\u0006\u0013\uffff\uffff\u0000\u010b\u0119\u0001\u0000\u0000\u0000\u010c"+
		"\u010d\u0003(\u0014\u0000\u010d\u010e\u0006\u0013\uffff\uffff\u0000\u010e"+
		"\u0119\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u0014\u0000\u0000\u0110"+
		"\u0111\u0005.\u0000\u0000\u0111\u0115\u0006\u0013\uffff\uffff\u0000\u0112"+
		"\u0113\u0003(\u0014\u0000\u0113\u0114\u0006\u0013\uffff\uffff\u0000\u0114"+
		"\u0116\u0001\u0000\u0000\u0000\u0115\u0112\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"+
		"\u0119\u0006\u0013\uffff\uffff\u0000\u0118\u0107\u0001\u0000\u0000\u0000"+
		"\u0118\u010c\u0001\u0000\u0000\u0000\u0118\u010f\u0001\u0000\u0000\u0000"+
		"\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\'\u0001\u0000\u0000\u0000\u011c"+
		"\u011a\u0001\u0000\u0000\u0000\u011d\u011e\u0005\b\u0000\u0000\u011e\u012a"+
		"\u0006\u0014\uffff\uffff\u0000\u011f\u0120\u0003\u0006\u0003\u0000\u0120"+
		"\u0127\u0006\u0014\uffff\uffff\u0000\u0121\u0122\u0005\u0005\u0000\u0000"+
		"\u0122\u0123\u0003\u0006\u0003\u0000\u0123\u0124\u0006\u0014\uffff\uffff"+
		"\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0121\u0001\u0000\u0000"+
		"\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000\u0000"+
		"\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u011f\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\u0005\t\u0000\u0000\u012d)\u0001\u0000\u0000\u0000"+
		"\u012e\u012f\u0005/\u0000\u0000\u012f\u0165\u0006\u0015\uffff\uffff\u0000"+
		"\u0130\u0131\u00050\u0000\u0000\u0131\u0165\u0006\u0015\uffff\uffff\u0000"+
		"\u0132\u0133\u00051\u0000\u0000\u0133\u0165\u0006\u0015\uffff\uffff\u0000"+
		"\u0134\u0135\u0005.\u0000\u0000\u0135\u0165\u0006\u0015\uffff\uffff\u0000"+
		"\u0136\u0137\u0005\f\u0000\u0000\u0137\u0138\u00052\u0000\u0000\u0138"+
		"\u0165\u0006\u0015\uffff\uffff\u0000\u0139\u013a\u0005\u0007\u0000\u0000"+
		"\u013a\u013b\u0003\u0014\n\u0000\u013b\u013c\u0006\u0015\uffff\uffff\u0000"+
		"\u013c\u0165\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0015\u0000\u0000"+
		"\u013e\u0165\u0006\u0015\uffff\uffff\u0000\u013f\u0140\u00052\u0000\u0000"+
		"\u0140\u0141\u0005/\u0000\u0000\u0141\u0165\u0006\u0015\uffff\uffff\u0000"+
		"\u0142\u0143\u00052\u0000\u0000\u0143\u0165\u0003$\u0012\u0000\u0144\u0145"+
		"\u0005\b\u0000\u0000\u0145\u0146\u0003\u0006\u0003\u0000\u0146\u0147\u0005"+
		"\t\u0000\u0000\u0147\u0148\u0006\u0015\uffff\uffff\u0000\u0148\u0165\u0001"+
		"\u0000\u0000\u0000\u0149\u014a\u0003:\u001d\u0000\u014a\u014b\u0006\u0015"+
		"\uffff\uffff\u0000\u014b\u0165\u0001\u0000\u0000\u0000\u014c\u014d\u0003"+
		"6\u001b\u0000\u014d\u014e\u0006\u0015\uffff\uffff\u0000\u014e\u0165\u0001"+
		"\u0000\u0000\u0000\u014f\u0150\u00038\u001c\u0000\u0150\u0151\u0006\u0015"+
		"\uffff\uffff\u0000\u0151\u0165\u0001\u0000\u0000\u0000\u0152\u0153\u0003"+
		",\u0016\u0000\u0153\u0154\u0006\u0015\uffff\uffff\u0000\u0154\u0165\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u00030\u0018\u0000\u0156\u0157\u0006\u0015"+
		"\uffff\uffff\u0000\u0157\u0165\u0001\u0000\u0000\u0000\u0158\u0159\u0003"+
		"2\u0019\u0000\u0159\u015a\u0006\u0015\uffff\uffff\u0000\u015a\u0165\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u00034\u001a\u0000\u015c\u015d\u0006\u0015"+
		"\uffff\uffff\u0000\u015d\u0165\u0001\u0000\u0000\u0000\u015e\u015f\u0003"+
		"<\u001e\u0000\u015f\u0160\u0006\u0015\uffff\uffff\u0000\u0160\u0165\u0001"+
		"\u0000\u0000\u0000\u0161\u0162\u0003P(\u0000\u0162\u0163\u0006\u0015\uffff"+
		"\uffff\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u012e\u0001\u0000"+
		"\u0000\u0000\u0164\u0130\u0001\u0000\u0000\u0000\u0164\u0132\u0001\u0000"+
		"\u0000\u0000\u0164\u0134\u0001\u0000\u0000\u0000\u0164\u0136\u0001\u0000"+
		"\u0000\u0000\u0164\u0139\u0001\u0000\u0000\u0000\u0164\u013d\u0001\u0000"+
		"\u0000\u0000\u0164\u013f\u0001\u0000\u0000\u0000\u0164\u0142\u0001\u0000"+
		"\u0000\u0000\u0164\u0144\u0001\u0000\u0000\u0000\u0164\u0149\u0001\u0000"+
		"\u0000\u0000\u0164\u014c\u0001\u0000\u0000\u0000\u0164\u014f\u0001\u0000"+
		"\u0000\u0000\u0164\u0152\u0001\u0000\u0000\u0000\u0164\u0155\u0001\u0000"+
		"\u0000\u0000\u0164\u0158\u0001\u0000\u0000\u0000\u0164\u015b\u0001\u0000"+
		"\u0000\u0000\u0164\u015e\u0001\u0000\u0000\u0000\u0164\u0161\u0001\u0000"+
		"\u0000\u0000\u0165+\u0001\u0000\u0000\u0000\u0166\u0167\u0006\u0016\uffff"+
		"\uffff\u0000\u0167\u0168\u0005\u0016\u0000\u0000\u0168\u0169\u0003\"\u0011"+
		"\u0000\u0169\u016a\u0005\u0017\u0000\u0000\u016a\u016b\u0003\u0006\u0003"+
		"\u0000\u016b\u016f\u0006\u0016\uffff\uffff\u0000\u016c\u016d\u0003.\u0017"+
		"\u0000\u016d\u016e\u0006\u0016\uffff\uffff\u0000\u016e\u0170\u0001\u0000"+
		"\u0000\u0000\u016f\u016c\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0172\u0006\u0016"+
		"\uffff\uffff\u0000\u0172\u0173\u0005\u0018\u0000\u0000\u0173-\u0001\u0000"+
		"\u0000\u0000\u0174\u0175\u0006\u0017\uffff\uffff\u0000\u0175\u0176\u0005"+
		"\u0019\u0000\u0000\u0176\u0177\u0003\"\u0011\u0000\u0177\u0178\u0005\u0017"+
		"\u0000\u0000\u0178\u0179\u0003\u0006\u0003\u0000\u0179\u017d\u0006\u0017"+
		"\uffff\uffff\u0000\u017a\u017b\u0003.\u0017\u0000\u017b\u017c\u0006\u0017"+
		"\uffff\uffff\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017a\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u0006\u0017\uffff\uffff\u0000\u0180\u0186"+
		"\u0001\u0000\u0000\u0000\u0181\u0182\u0005\u001a\u0000\u0000\u0182\u0183"+
		"\u0003\u0006\u0003\u0000\u0183\u0184\u0006\u0017\uffff\uffff\u0000\u0184"+
		"\u0186\u0001\u0000\u0000\u0000\u0185\u0174\u0001\u0000\u0000\u0000\u0185"+
		"\u0181\u0001\u0000\u0000\u0000\u0186/\u0001\u0000\u0000\u0000\u0187\u0188"+
		"\u0005\u001b\u0000\u0000\u0188\u0189\u0003\"\u0011\u0000\u0189\u018a\u0005"+
		"\u001c\u0000\u0000\u018a\u018b\u0003\u0006\u0003\u0000\u018b\u018c\u0006"+
		"\u0018\uffff\uffff\u0000\u018c\u018d\u0005\u001d\u0000\u0000\u018d1\u0001"+
		"\u0000\u0000\u0000\u018e\u018f\u0005\u001c\u0000\u0000\u018f\u0190\u0006"+
		"\u0019\uffff\uffff\u0000\u0190\u0191\u0003\u0004\u0002\u0000\u0191\u0192"+
		"\u0006\u0019\uffff\uffff\u0000\u0192\u0196\u0006\u0019\uffff\uffff\u0000"+
		"\u0193\u0194\u0003\"\u0011\u0000\u0194\u0195\u0006\u0019\uffff\uffff\u0000"+
		"\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0193\u0001\u0000\u0000\u0000"+
		"\u0196\u0197\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000"+
		"\u0198\u0199\u0006\u0019\uffff\uffff\u0000\u0199\u019a\u0005\u001b\u0000"+
		"\u0000\u019a\u019b\u0003\"\u0011\u0000\u019b\u019c\u0006\u0019\uffff\uffff"+
		"\u0000\u019c\u019d\u0005\u001d\u0000\u0000\u019d3\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0005\u001e\u0000\u0000\u019f\u01a0\u0006\u001a\uffff\uffff"+
		"\u0000\u01a0\u01a1\u0003\u0004\u0002\u0000\u01a1\u01a5\u0006\u001a\uffff"+
		"\uffff\u0000\u01a2\u01a3\u0003\"\u0011\u0000\u01a3\u01a4\u0006\u001a\uffff"+
		"\uffff\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a8\u0006\u001a\uffff\uffff\u0000\u01a8\u01a9\u0005"+
		"\u0005\u0000\u0000\u01a9\u01aa\u0003\"\u0011\u0000\u01aa\u01ab\u0005\u0005"+
		"\u0000\u0000\u01ab\u01ac\u0003\"\u0011\u0000\u01ac\u01ad\u0005\u001c\u0000"+
		"\u0000\u01ad\u01ae\u0003\b\u0004\u0000\u01ae\u01af\u0006\u001a\uffff\uffff"+
		"\u0000\u01af\u01b0\u0005\u001d\u0000\u0000\u01b05\u0001\u0000\u0000\u0000"+
		"\u01b1\u01b2\u0005\u0012\u0000\u0000\u01b2\u01be\u0006\u001b\uffff\uffff"+
		"\u0000\u01b3\u01b4\u0003\"\u0011\u0000\u01b4\u01bb\u0006\u001b\uffff\uffff"+
		"\u0000\u01b5\u01b6\u0005\u0005\u0000\u0000\u01b6\u01b7\u0003\"\u0011\u0000"+
		"\u01b7\u01b8\u0006\u001b\uffff\uffff\u0000\u01b8\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000"+
		"\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000"+
		"\u0000\u01be\u01b3\u0001\u0000\u0000\u0000\u01be\u01bf\u0001\u0000\u0000"+
		"\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005\u0013\u0000"+
		"\u0000\u01c1\u01c2\u0006\u001b\uffff\uffff\u0000\u01c27\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0005-\u0000\u0000\u01c4\u01d3\u0006\u001c\uffff\uffff"+
		"\u0000\u01c5\u01c6\u0005\b\u0000\u0000\u01c6\u01c7\u0003\"\u0011\u0000"+
		"\u01c7\u01ce\u0006\u001c\uffff\uffff\u0000\u01c8\u01c9\u0005\u0005\u0000"+
		"\u0000\u01c9\u01ca\u0003\"\u0011\u0000\u01ca\u01cb\u0006\u001c\uffff\uffff"+
		"\u0000\u01cb\u01cd\u0001\u0000\u0000\u0000\u01cc\u01c8\u0001\u0000\u0000"+
		"\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000"+
		"\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005\t\u0000\u0000"+
		"\u01d2\u01d4\u0001\u0000\u0000\u0000\u01d3\u01c5\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000"+
		"\u01d5\u01d6\u0006\u001c\uffff\uffff\u0000\u01d69\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d8\u0005\n\u0000\u0000\u01d8\u01e4\u0006\u001d\uffff\uffff\u0000"+
		"\u01d9\u01da\u0003\"\u0011\u0000\u01da\u01e1\u0006\u001d\uffff\uffff\u0000"+
		"\u01db\u01dc\u0005\u0005\u0000\u0000\u01dc\u01dd\u0003\"\u0011\u0000\u01dd"+
		"\u01de\u0006\u001d\uffff\uffff\u0000\u01de\u01e0\u0001\u0000\u0000\u0000"+
		"\u01df\u01db\u0001\u0000\u0000\u0000\u01e0\u01e3\u0001\u0000\u0000\u0000"+
		"\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e2\u01e5\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000"+
		"\u01e4\u01d9\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005\u000b\u0000\u0000"+
		"\u01e7\u01e8\u0006\u001d\uffff\uffff\u0000\u01e8;\u0001\u0000\u0000\u0000"+
		"\u01e9\u01ea\u0005\u001f\u0000\u0000\u01ea\u01eb\u0003\"\u0011\u0000\u01eb"+
		"\u01ec\u0005 \u0000\u0000\u01ec\u01ed\u0003>\u001f\u0000\u01ed\u01ee\u0005"+
		"!\u0000\u0000\u01ee\u01ef\u0006\u001e\uffff\uffff\u0000\u01ef=\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f1\u0006\u001f\uffff\uffff\u0000\u01f1\u01f2\u0003"+
		"@ \u0000\u01f2\u01f9\u0006\u001f\uffff\uffff\u0000\u01f3\u01f4\u0005\""+
		"\u0000\u0000\u01f4\u01f5\u0003@ \u0000\u01f5\u01f6\u0006\u001f\uffff\uffff"+
		"\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f8\u01fb\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa?\u0001\u0000\u0000\u0000"+
		"\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01fd\u0006 \uffff\uffff\u0000"+
		"\u01fd\u01fe\u0003B!\u0000\u01fe\u01ff\u0006 \uffff\uffff\u0000\u01ff"+
		"\u0200\u0005#\u0000\u0000\u0200\u0201\u0003\u0006\u0003\u0000\u0201\u0202"+
		"\u0006 \uffff\uffff\u0000\u0202A\u0001\u0000\u0000\u0000\u0203\u0204\u0003"+
		"D\"\u0000\u0204\u0205\u0006!\uffff\uffff\u0000\u0205\u020a\u0001\u0000"+
		"\u0000\u0000\u0206\u0207\u0003F#\u0000\u0207\u0208\u0006!\uffff\uffff"+
		"\u0000\u0208\u020a\u0001\u0000\u0000\u0000\u0209\u0203\u0001\u0000\u0000"+
		"\u0000\u0209\u0206\u0001\u0000\u0000\u0000\u020aC\u0001\u0000\u0000\u0000"+
		"\u020b\u020c\u0003J%\u0000\u020c\u020d\u0006\"\uffff\uffff\u0000\u020d"+
		"\u0233\u0001\u0000\u0000\u0000\u020e\u020f\u0003L&\u0000\u020f\u0210\u0006"+
		"\"\uffff\uffff\u0000\u0210\u0233\u0001\u0000\u0000\u0000\u0211\u0212\u0003"+
		"N\'\u0000\u0212\u0213\u0006\"\uffff\uffff\u0000\u0213\u0233\u0001\u0000"+
		"\u0000\u0000\u0214\u0215\u0003H$\u0000\u0215\u0216\u0006\"\uffff\uffff"+
		"\u0000\u0216\u0233\u0001\u0000\u0000\u0000\u0217\u0218\u0005.\u0000\u0000"+
		"\u0218\u021d\u0006\"\uffff\uffff\u0000\u0219\u021a\u0005$\u0000\u0000"+
		"\u021a\u021b\u0003B!\u0000\u021b\u021c\u0006\"\uffff\uffff\u0000\u021c"+
		"\u021e\u0001\u0000\u0000\u0000\u021d\u0219\u0001\u0000\u0000\u0000\u021d"+
		"\u021e\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f"+
		"\u0233\u0006\"\uffff\uffff\u0000\u0220\u0221\u0005/\u0000\u0000\u0221"+
		"\u0233\u0006\"\uffff\uffff\u0000\u0222\u0223\u00052\u0000\u0000\u0223"+
		"\u0224\u0005/\u0000\u0000\u0224\u0233\u0006\"\uffff\uffff\u0000\u0225"+
		"\u0226\u00050\u0000\u0000\u0226\u0233\u0006\"\uffff\uffff\u0000\u0227"+
		"\u0228\u0005%\u0000\u0000\u0228\u0233\u0006\"\uffff\uffff\u0000\u0229"+
		"\u022a\u0005&\u0000\u0000\u022a\u0233\u0006\"\uffff\uffff\u0000\u022b"+
		"\u022c\u0005\'\u0000\u0000\u022c\u0233\u0006\"\uffff\uffff\u0000\u022d"+
		"\u022e\u0005\b\u0000\u0000\u022e\u022f\u0003B!\u0000\u022f\u0230\u0005"+
		"\t\u0000\u0000\u0230\u0231\u0006\"\uffff\uffff\u0000\u0231\u0233\u0001"+
		"\u0000\u0000\u0000\u0232\u020b\u0001\u0000\u0000\u0000\u0232\u020e\u0001"+
		"\u0000\u0000\u0000\u0232\u0211\u0001\u0000\u0000\u0000\u0232\u0214\u0001"+
		"\u0000\u0000\u0000\u0232\u0217\u0001\u0000\u0000\u0000\u0232\u0220\u0001"+
		"\u0000\u0000\u0000\u0232\u0222\u0001\u0000\u0000\u0000\u0232\u0225\u0001"+
		"\u0000\u0000\u0000\u0232\u0227\u0001\u0000\u0000\u0000\u0232\u0229\u0001"+
		"\u0000\u0000\u0000\u0232\u022b\u0001\u0000\u0000\u0000\u0232\u022d\u0001"+
		"\u0000\u0000\u0000\u0233E\u0001\u0000\u0000\u0000\u0234\u0235\u0003D\""+
		"\u0000\u0235\u0236\u00052\u0000\u0000\u0236\u0237\u0004#\u0001\u0001\u0237"+
		"\u0238\u0003B!\u0000\u0238\u0239\u0006#\uffff\uffff\u0000\u0239G\u0001"+
		"\u0000\u0000\u0000\u023a\u023b\u0005\n\u0000\u0000\u023b\u0247\u0006$"+
		"\uffff\uffff\u0000\u023c\u023d\u0003B!\u0000\u023d\u0244\u0006$\uffff"+
		"\uffff\u0000\u023e\u023f\u0005\u0005\u0000\u0000\u023f\u0240\u0003B!\u0000"+
		"\u0240\u0241\u0006$\uffff\uffff\u0000\u0241\u0243\u0001\u0000\u0000\u0000"+
		"\u0242\u023e\u0001\u0000\u0000\u0000\u0243\u0246\u0001\u0000\u0000\u0000"+
		"\u0244\u0242\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000"+
		"\u0245\u0248\u0001\u0000\u0000\u0000\u0246\u0244\u0001\u0000\u0000\u0000"+
		"\u0247\u023c\u0001\u0000\u0000\u0000\u0247\u0248\u0001\u0000\u0000\u0000"+
		"\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u024a\u0005\u000b\u0000\u0000"+
		"\u024a\u024b\u0006$\uffff\uffff\u0000\u024bI\u0001\u0000\u0000\u0000\u024c"+
		"\u024d\u0005(\u0000\u0000\u024d\u024e\u0006%\uffff\uffff\u0000\u024eK"+
		"\u0001\u0000\u0000\u0000\u024f\u0250\u0005-\u0000\u0000\u0250\u025f\u0006"+
		"&\uffff\uffff\u0000\u0251\u0252\u0005\b\u0000\u0000\u0252\u0253\u0003"+
		"B!\u0000\u0253\u025a\u0006&\uffff\uffff\u0000\u0254\u0255\u0005\u0005"+
		"\u0000\u0000\u0255\u0256\u0003B!\u0000\u0256\u0257\u0006&\uffff\uffff"+
		"\u0000\u0257\u0259\u0001\u0000\u0000\u0000\u0258\u0254\u0001\u0000\u0000"+
		"\u0000\u0259\u025c\u0001\u0000\u0000\u0000\u025a\u0258\u0001\u0000\u0000"+
		"\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025d\u0001\u0000\u0000"+
		"\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u025e\u0005\t\u0000\u0000"+
		"\u025e\u0260\u0001\u0000\u0000\u0000\u025f\u0251\u0001\u0000\u0000\u0000"+
		"\u025f\u0260\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000"+
		"\u0261\u0262\u0006&\uffff\uffff\u0000\u0262M\u0001\u0000\u0000\u0000\u0263"+
		"\u0264\u0005\u0012\u0000\u0000\u0264\u0270\u0006\'\uffff\uffff\u0000\u0265"+
		"\u0266\u0003B!\u0000\u0266\u026d\u0006\'\uffff\uffff\u0000\u0267\u0268"+
		"\u0005\u0005\u0000\u0000\u0268\u0269\u0003B!\u0000\u0269\u026a\u0006\'"+
		"\uffff\uffff\u0000\u026a\u026c\u0001\u0000\u0000\u0000\u026b\u0267\u0001"+
		"\u0000\u0000\u0000\u026c\u026f\u0001\u0000\u0000\u0000\u026d\u026b\u0001"+
		"\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000\u026e\u0271\u0001"+
		"\u0000\u0000\u0000\u026f\u026d\u0001\u0000\u0000\u0000\u0270\u0265\u0001"+
		"\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000\u0271\u0272\u0001"+
		"\u0000\u0000\u0000\u0272\u0273\u0005\u0013\u0000\u0000\u0273\u0274\u0006"+
		"\'\uffff\uffff\u0000\u0274O\u0001\u0000\u0000\u0000\u0275\u0276\u0005"+
		")\u0000\u0000\u0276\u0277\u0006(\uffff\uffff\u0000\u0277\u0278\u0003$"+
		"\u0012\u0000\u0278\u0279\u0006(\uffff\uffff\u0000\u0279Q\u0001\u0000\u0000"+
		"\u0000-Udry\u0087\u0091\u0094\u00ad\u00b7\u00ba\u00c5\u00c8\u00cf\u00d2"+
		"\u00e1\u00e9\u00f7\u0102\u0115\u0118\u011a\u0127\u012a\u0164\u016f\u017d"+
		"\u0185\u0196\u01a5\u01bb\u01be\u01ce\u01d3\u01e1\u01e4\u01f9\u0209\u021d"+
		"\u0232\u0244\u0247\u025a\u025f\u026d\u0270";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}