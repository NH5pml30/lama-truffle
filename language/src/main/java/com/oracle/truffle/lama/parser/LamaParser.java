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
		T__38=39, T__39=40, T__40=41, T__41=42, WS=43, COMMENT=44, LINE_COMMENT=45, 
		UIDENT=46, LIDENT=47, DECIMAL=48, STRING=49, CHAR=50, OP=51;
	public static final int
		RULE_compilationUnit = 0, RULE_importStt = 1, RULE_scopeDefinitions = 2, 
		RULE_scopeExpression = 3, RULE_scopeExpression0 = 4, RULE_definition = 5, 
		RULE_variableDefinition = 6, RULE_variableDefinitionSequence = 7, RULE_variableDefinitionItem = 8, 
		RULE_functionDefinition = 9, RULE_functionArguments = 10, RULE_functionBody = 11, 
		RULE_infixDefinition = 12, RULE_infixity = 13, RULE_level = 14, RULE_expression = 15, 
		RULE_basicExpression = 16, RULE_primaryExpression = 17, RULE_functionArgs = 18, 
		RULE_primary = 19, RULE_ifExpression = 20, RULE_elsePart = 21, RULE_whileDoExpression = 22, 
		RULE_doWhileExpression = 23, RULE_forExpression = 24, RULE_arrayExpression = 25, 
		RULE_sExpression = 26, RULE_listExpression = 27, RULE_caseExpression = 28, 
		RULE_caseBranches = 29, RULE_caseBranch = 30, RULE_pattern = 31, RULE_simplePattern = 32, 
		RULE_consPattern = 33, RULE_listPattern = 34, RULE_wildcardPattern = 35, 
		RULE_sExpPattern = 36, RULE_arrayPattern = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "importStt", "scopeDefinitions", "scopeExpression", 
			"scopeExpression0", "definition", "variableDefinition", "variableDefinitionSequence", 
			"variableDefinitionItem", "functionDefinition", "functionArguments", 
			"functionBody", "infixDefinition", "infixity", "level", "expression", 
			"basicExpression", "primaryExpression", "functionArgs", "primary", "ifExpression", 
			"elsePart", "whileDoExpression", "doWhileExpression", "forExpression", 
			"arrayExpression", "sExpression", "listExpression", "caseExpression", 
			"caseBranches", "caseBranch", "pattern", "simplePattern", "consPattern", 
			"listPattern", "wildcardPattern", "sExpPattern", "arrayPattern"
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
			"'#val'", "'#str'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(76);
				importStt();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 factory.startMain(); 
			setState(83);
			((CompilationUnitContext)_localctx).functionBody = functionBody();
			 ((CompilationUnitContext)_localctx).result =  factory.finishMain(((CompilationUnitContext)_localctx).functionBody.result, _input.LT(1)); 
			setState(85);
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
			setState(87);
			match(T__0);
			setState(88);
			match(UIDENT);
			setState(89);
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
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					definition();
					}
					} 
				}
				setState(96);
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
			setState(98);
			scopeDefinitions();
			setState(99);
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
			setState(103);
			scopeDefinitions();
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> gen = GenInterfaces.of(); 
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410432384L) != 0)) {
				{
				setState(105);
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				variableDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				functionDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
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
			setState(117);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(118);
			variableDefinitionSequence();
			setState(119);
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
			setState(121);
			((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
			 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(123);
				match(T__4);
				setState(124);
				((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem = variableDefinitionItem();
				 factory.addLocal(((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.name, ((VariableDefinitionSequenceContext)_localctx).variableDefinitionItem.value); 
				}
				}
				setState(131);
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
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				 ((VariableDefinitionItemContext)_localctx).name =  ((VariableDefinitionItemContext)_localctx).LIDENT; ((VariableDefinitionItemContext)_localctx).value =  factory.createSkip(((VariableDefinitionItemContext)_localctx).LIDENT); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((VariableDefinitionItemContext)_localctx).LIDENT = match(LIDENT);
				setState(135);
				match(T__5);
				setState(136);
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
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(141);
				match(T__3);
				}
			}

			setState(144);
			((FunctionDefinitionContext)_localctx).t = match(T__6);
			setState(145);
			((FunctionDefinitionContext)_localctx).name = match(LIDENT);
			setState(146);
			match(T__7);
			setState(147);
			((FunctionDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(148);
			match(T__8);
			 factory.startFunction(((FunctionDefinitionContext)_localctx).functionArguments.result, ((FunctionDefinitionContext)_localctx).name.getText()); 
			setState(150);
			match(T__9);
			setState(151);
			((FunctionDefinitionContext)_localctx).functionBody = functionBody();
			setState(152);
			match(T__10);
			 factory.addFun(((FunctionDefinitionContext)_localctx).name.getText(), factory.finishFunction(((FunctionDefinitionContext)_localctx).functionBody.result)); 
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
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIDENT) {
				{
				setState(156);
				((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
				 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(158);
					match(T__4);
					setState(159);
					((FunctionArgumentsContext)_localctx).LIDENT = match(LIDENT);
					 _localctx.result.add(((FunctionArgumentsContext)_localctx).LIDENT); 
					}
					}
					setState(165);
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
		enterRule(_localctx, 22, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			scopeDefinitions();
			 ((FunctionBodyContext)_localctx).result =  GenInterfaces.of(); 
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410432384L) != 0)) {
				{
				setState(170);
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
		public FunctionArgumentsContext functionArguments;
		public FunctionBodyContext functionBody;
		public InfixityContext infixity() {
			return getRuleContext(InfixityContext.class,0);
		}
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public InfixDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infixDefinition; }
	}

	public final InfixDefinitionContext infixDefinition() throws RecognitionException {
		InfixDefinitionContext _localctx = new InfixDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_infixDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(175);
				match(T__3);
				}
			}

			setState(178);
			((InfixDefinitionContext)_localctx).infixity = infixity();
			setState(179);
			((InfixDefinitionContext)_localctx).name = match(OP);
			setState(180);
			((InfixDefinitionContext)_localctx).level = level();
			setState(181);
			match(T__7);
			setState(182);
			((InfixDefinitionContext)_localctx).functionArguments = functionArguments();
			setState(183);
			match(T__8);
			 factory.startFunction(((InfixDefinitionContext)_localctx).functionArguments.result, ((InfixDefinitionContext)_localctx).name.getText()); 
			setState(185);
			match(T__9);
			setState(186);
			((InfixDefinitionContext)_localctx).functionBody = functionBody();
			setState(187);
			match(T__10);
			 factory.addFun(((InfixDefinitionContext)_localctx).name.getText(), factory.finishFunction(((InfixDefinitionContext)_localctx).functionBody.result)); 
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
		enterRule(_localctx, 26, RULE_infixity);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(T__11);
				 ((InfixityContext)_localctx).result =  OpType.InfixNone; 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__12);
				 ((InfixityContext)_localctx).result =  OpType.InfixLeft; 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
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
		enterRule(_localctx, 28, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				{
				setState(199);
				match(T__14);
				 ((LevelContext)_localctx).rel =  0; 
				}
				break;
			case T__15:
				{
				setState(201);
				match(T__15);
				 ((LevelContext)_localctx).rel =  -1; 
				}
				break;
			case T__16:
				{
				setState(203);
				match(T__16);
				 ((LevelContext)_localctx).rel =  1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
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
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  GenInterfaces.of(((ExpressionContext)_localctx).basicExpression.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				((ExpressionContext)_localctx).basicExpression = basicExpression(0);
				 ((ExpressionContext)_localctx).result =  GenInterfaces.of(((ExpressionContext)_localctx).basicExpression.result); 
				setState(215);
				match(T__1);
				setState(216);
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
		enterRule(_localctx, 32, RULE_basicExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((BasicExpressionContext)_localctx).primaryExpression = primaryExpression();
			 ((BasicExpressionContext)_localctx).result =  ((BasicExpressionContext)_localctx).primaryExpression.result; 
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					if (!(factory.getPrecedence(_input.LT(1)) >= _localctx._p)) throw new FailedPredicateException(this, "factory.getPrecedence(_input.LT(1)) >= $_p");
					setState(224);
					((BasicExpressionContext)_localctx).op = match(OP);
					setState(225);
					((BasicExpressionContext)_localctx).rhs = basicExpression(factory.getNextPrecedence(((BasicExpressionContext)_localctx).op));
					 ((BasicExpressionContext)_localctx).result =  factory.createBinary(((BasicExpressionContext)_localctx).op, _localctx.result, ((BasicExpressionContext)_localctx).rhs.result); 
					}
					} 
				}
				setState(232);
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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public GenInterface<ValueCategory, GenInterface<Void, LamaNode>> result;
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
		enterRule(_localctx, 34, RULE_primaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			((PrimaryExpressionContext)_localctx).primary = primary();
			 ((PrimaryExpressionContext)_localctx).result =  ((PrimaryExpressionContext)_localctx).primary.result; 
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(252);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__17:
						{
						setState(235);
						match(T__17);
						setState(236);
						((PrimaryExpressionContext)_localctx).expression = expression();
						setState(237);
						match(T__18);
						 ((PrimaryExpressionContext)_localctx).result =  factory.createElement(_localctx.result, factory.finishSeq(((PrimaryExpressionContext)_localctx).expression.result)); 
						}
						break;
					case T__7:
						{
						setState(240);
						((PrimaryExpressionContext)_localctx).functionArgs = functionArgs();
						 ((PrimaryExpressionContext)_localctx).result =  factory.createCall(_localctx.result, ((PrimaryExpressionContext)_localctx).functionArgs.args, ((PrimaryExpressionContext)_localctx).functionArgs.t); 
						}
						break;
					case T__19:
						{
						setState(243);
						((PrimaryExpressionContext)_localctx).t = match(T__19);
						setState(244);
						((PrimaryExpressionContext)_localctx).LIDENT = match(LIDENT);
						 List<GenInterface<ValueCategory, GenInterface<Void, LamaNode>>> args = new ArrayList<>(); args.add(_localctx.result); 
						setState(249);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
						case 1:
							{
							setState(246);
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
				setState(256);
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
	public static class FunctionArgsContext extends ParserRuleContext {
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
		public FunctionArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgs; }
	}

	public final FunctionArgsContext functionArgs() throws RecognitionException {
		FunctionArgsContext _localctx = new FunctionArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			((FunctionArgsContext)_localctx).tt = match(T__7);
			 ((FunctionArgsContext)_localctx).args =  new ArrayList<>(); ((FunctionArgsContext)_localctx).t =  ((FunctionArgsContext)_localctx).tt; 
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410456984L) != 0)) {
				{
				setState(259);
				((FunctionArgsContext)_localctx).scopeExpression = scopeExpression();
				 _localctx.args.add(((FunctionArgsContext)_localctx).scopeExpression.result); 
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(261);
					match(T__4);
					setState(262);
					((FunctionArgsContext)_localctx).scopeExpression = scopeExpression();
					 _localctx.args.add(((FunctionArgsContext)_localctx).scopeExpression.result); 
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(272);
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
		public FunctionArgumentsContext functionArguments;
		public FunctionBodyContext functionBody;
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
		public TerminalNode DECIMAL() { return getToken(LamaParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(LamaParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(LamaParser.CHAR, 0); }
		public TerminalNode LIDENT() { return getToken(LamaParser.LIDENT, 0); }
		public TerminalNode OP() { return getToken(LamaParser.OP, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
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
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primary);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).d); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				((PrimaryContext)_localctx).s = match(STRING);
				 ((PrimaryContext)_localctx).result =  factory.createStringLiteral(((PrimaryContext)_localctx).s); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				((PrimaryContext)_localctx).c = match(CHAR);
				 ((PrimaryContext)_localctx).result =  factory.createCharLiteral(((PrimaryContext)_localctx).c); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(280);
				((PrimaryContext)_localctx).i = match(LIDENT);
				 ((PrimaryContext)_localctx).result =  factory.createRead(((PrimaryContext)_localctx).i); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
				match(T__20);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(283);
				match(T__21);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(284);
				match(T__11);
				setState(285);
				((PrimaryContext)_localctx).OP = match(OP);
				 ((PrimaryContext)_localctx).result =  factory.createInfix(((PrimaryContext)_localctx).OP); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(287);
				((PrimaryContext)_localctx).t = match(T__6);
				setState(288);
				match(T__7);
				setState(289);
				((PrimaryContext)_localctx).functionArguments = functionArguments();
				 factory.startFunction(((PrimaryContext)_localctx).functionArguments.result, "<lambda>"); 
				setState(291);
				match(T__8);
				setState(292);
				match(T__9);
				setState(293);
				((PrimaryContext)_localctx).functionBody = functionBody();
				setState(294);
				match(T__10);
				 ((PrimaryContext)_localctx).result =  factory.genValue(factory.finishFunction(((PrimaryContext)_localctx).functionBody.result).instantiate(), ((PrimaryContext)_localctx).t); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(297);
				((PrimaryContext)_localctx).t = match(T__22);
				 ((PrimaryContext)_localctx).result =  factory.createSkip(((PrimaryContext)_localctx).t); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(299);
				((PrimaryContext)_localctx).op = match(OP);
				setState(300);
				((PrimaryContext)_localctx).d = match(DECIMAL);
				 ((PrimaryContext)_localctx).result =  factory.createIntLiteral(((PrimaryContext)_localctx).op, ((PrimaryContext)_localctx).d); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(302);
				match(OP);
				setState(303);
				basicExpression(0);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(304);
				match(T__7);
				setState(305);
				((PrimaryContext)_localctx).scopeExpression = scopeExpression();
				setState(306);
				match(T__8);
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).scopeExpression.result; 
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(309);
				((PrimaryContext)_localctx).listExpression = listExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).listExpression.result; 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(312);
				((PrimaryContext)_localctx).arrayExpression = arrayExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).arrayExpression.result; 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(315);
				((PrimaryContext)_localctx).sExpression = sExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).sExpression.result; 
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(318);
				((PrimaryContext)_localctx).ifExpression = ifExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).ifExpression.result; 
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(321);
				((PrimaryContext)_localctx).whileDoExpression = whileDoExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).whileDoExpression.result; 
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(324);
				((PrimaryContext)_localctx).doWhileExpression = doWhileExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).doWhileExpression.result; 
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(327);
				((PrimaryContext)_localctx).forExpression = forExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).forExpression.result; 
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(330);
				((PrimaryContext)_localctx).caseExpression = caseExpression();
				 ((PrimaryContext)_localctx).result =  ((PrimaryContext)_localctx).caseExpression.result; 
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
		enterRule(_localctx, 40, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; 
			setState(336);
			((IfExpressionContext)_localctx).t = match(T__23);
			setState(337);
			((IfExpressionContext)_localctx).expression = expression();
			setState(338);
			match(T__24);
			setState(339);
			((IfExpressionContext)_localctx).scopeExpression = scopeExpression();
			 falsePart = factory.createSkip(((IfExpressionContext)_localctx).t); 
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26 || _la==T__27) {
				{
				setState(341);
				((IfExpressionContext)_localctx).elsePart = elsePart();
				 falsePart = ((IfExpressionContext)_localctx).elsePart.result; 
				}
			}

			 ((IfExpressionContext)_localctx).result =  factory.createIfThenElse(factory.finishSeq(((IfExpressionContext)_localctx).expression.result), ((IfExpressionContext)_localctx).scopeExpression.result, falsePart); 
			setState(347);
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
		enterRule(_localctx, 42, RULE_elsePart);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> falsePart; 
				setState(350);
				((ElsePartContext)_localctx).t = match(T__26);
				setState(351);
				((ElsePartContext)_localctx).expression = expression();
				setState(352);
				match(T__24);
				setState(353);
				((ElsePartContext)_localctx).scopeExpression = scopeExpression();
				 falsePart = factory.createSkip(((ElsePartContext)_localctx).t); 
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__26 || _la==T__27) {
					{
					setState(355);
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
				setState(362);
				match(T__27);
				setState(363);
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
		enterRule(_localctx, 44, RULE_whileDoExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			((WhileDoExpressionContext)_localctx).t = match(T__28);
			setState(369);
			((WhileDoExpressionContext)_localctx).expression = expression();
			setState(370);
			match(T__29);
			setState(371);
			((WhileDoExpressionContext)_localctx).scopeExpression = scopeExpression();
			 ((WhileDoExpressionContext)_localctx).result =  factory.createWhileDo(factory.finishSeq(((WhileDoExpressionContext)_localctx).expression.result), ((WhileDoExpressionContext)_localctx).scopeExpression.result, ((WhileDoExpressionContext)_localctx).t); 
			setState(373);
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
		enterRule(_localctx, 46, RULE_doWhileExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			((DoWhileExpressionContext)_localctx).t = match(T__29);
			 var scope = factory.startBlock(); 
			setState(377);
			((DoWhileExpressionContext)_localctx).defs = scopeDefinitions();
			 factory.startBlock(); factory.pullLocalValues(scope); 
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> body = GenInterfaces.of(); 
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(380);
				((DoWhileExpressionContext)_localctx).expression = expression();
				 body = ((DoWhileExpressionContext)_localctx).expression.result; 
				}
				break;
			}
			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> bodyNode = factory.finishBlock(body); 
			setState(386);
			match(T__28);
			setState(387);
			((DoWhileExpressionContext)_localctx).cond = ((DoWhileExpressionContext)_localctx).expression = expression();
			 ((DoWhileExpressionContext)_localctx).result =  factory.finishBlock(GenInterfaces.of(
			              factory.createDoWhile(bodyNode, factory.finishSeq(((DoWhileExpressionContext)_localctx).cond.result), ((DoWhileExpressionContext)_localctx).t)
			      )); 
			setState(389);
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
		enterRule(_localctx, 48, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			((ForExpressionContext)_localctx).t = match(T__31);
			 factory.startBlock(); 
			setState(393);
			((ForExpressionContext)_localctx).defs = scopeDefinitions();
			 GenInterfaces<ValueCategory, GenInterface<Void, LamaNode>> init = GenInterfaces.of(); 
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410432384L) != 0)) {
				{
				setState(395);
				((ForExpressionContext)_localctx).expression = expression();
				 init = ((ForExpressionContext)_localctx).expression.result; 
				}
			}

			 GenInterface<ValueCategory, GenInterface<Void, LamaNode>> initNode = factory.finishSeq(init); 
			setState(401);
			match(T__4);
			setState(402);
			((ForExpressionContext)_localctx).cond = ((ForExpressionContext)_localctx).expression = expression();
			setState(403);
			match(T__4);
			setState(404);
			((ForExpressionContext)_localctx).step = ((ForExpressionContext)_localctx).expression = expression();
			setState(405);
			match(T__29);
			setState(406);
			((ForExpressionContext)_localctx).scopeExpression0 = scopeExpression0();
			 ((ForExpressionContext)_localctx).result =  factory.finishBlock(GenInterfaces.of(
			              factory.createForLoop(initNode, factory.finishSeq(((ForExpressionContext)_localctx).cond.result), factory.finishSeq(((ForExpressionContext)_localctx).step.result), ((ForExpressionContext)_localctx).scopeExpression0.result, ((ForExpressionContext)_localctx).t)
			      )); 
			setState(408);
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
		enterRule(_localctx, 50, RULE_arrayExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			((ArrayExpressionContext)_localctx).t = match(T__17);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410432384L) != 0)) {
				{
				setState(412);
				((ArrayExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ArrayExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(414);
					match(T__4);
					setState(415);
					((ArrayExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ArrayExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(422);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(425);
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
		enterRule(_localctx, 52, RULE_sExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			((SExpressionContext)_localctx).t = match(UIDENT);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(430);
				match(T__7);
				setState(431);
				((SExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((SExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(433);
					match(T__4);
					setState(434);
					((SExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((SExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(441);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(442);
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
		enterRule(_localctx, 54, RULE_listExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			((ListExpressionContext)_localctx).t = match(T__9);
			 GenInterfaces<Void, GenInterface<Void, LamaNode>> vals = GenInterfaces.of(); 
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4433245410432384L) != 0)) {
				{
				setState(450);
				((ListExpressionContext)_localctx).expression = expression();
				 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ListExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(452);
					match(T__4);
					setState(453);
					((ListExpressionContext)_localctx).expression = expression();
					 vals = GenInterfaces.add(vals, GenInterface.konst(factory.finishSeq(((ListExpressionContext)_localctx).expression.result), ValueCategory.Val)); 
					}
					}
					setState(460);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(463);
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
		enterRule(_localctx, 56, RULE_caseExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(T__32);
			setState(467);
			((CaseExpressionContext)_localctx).expression = expression();
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
		enterRule(_localctx, 58, RULE_caseBranches);
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
		enterRule(_localctx, 60, RULE_caseBranch);
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
		enterRule(_localctx, 62, RULE_pattern);
		try {
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
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
		enterRule(_localctx, 64, RULE_simplePattern);
		int _la;
		try {
			setState(539);
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
			case STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(526);
				((SimplePatternContext)_localctx).s = match(STRING);
				 ((SimplePatternContext)_localctx).result =  factory.createStrValPattern(((SimplePatternContext)_localctx).s.getText()); 
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 9);
				{
				setState(528);
				match(T__38);
				 ((SimplePatternContext)_localctx).result =  factory.createFunPattern(); 
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 10);
				{
				setState(530);
				match(T__39);
				 ((SimplePatternContext)_localctx).result =  factory.createValPattern(); 
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 11);
				{
				setState(532);
				match(T__40);
				 ((SimplePatternContext)_localctx).result =  factory.createStrPattern(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 12);
				{
				setState(534);
				match(T__7);
				setState(535);
				((SimplePatternContext)_localctx).pattern = pattern();
				setState(536);
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
		enterRule(_localctx, 66, RULE_consPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			((ConsPatternContext)_localctx).simplePattern = simplePattern();
			setState(542);
			((ConsPatternContext)_localctx).OP = match(OP);
			setState(543);
			if (!(((ConsPatternContext)_localctx).OP.getText().equals(":"))) throw new FailedPredicateException(this, "$OP.getText().equals(\":\")");
			setState(544);
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
		enterRule(_localctx, 68, RULE_listPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(T__9);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3315577313821952L) != 0)) {
				{
				setState(549);
				((ListPatternContext)_localctx).pattern = pattern();
				 pats.add(((ListPatternContext)_localctx).pattern.result); 
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(551);
					match(T__4);
					setState(552);
					((ListPatternContext)_localctx).pattern = pattern();
					 pats.add(((ListPatternContext)_localctx).pattern.result); 
					}
					}
					setState(559);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(562);
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
		enterRule(_localctx, 70, RULE_wildcardPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
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
		enterRule(_localctx, 72, RULE_sExpPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			((SExpPatternContext)_localctx).t = match(UIDENT);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(570);
				match(T__7);
				setState(571);
				((SExpPatternContext)_localctx).pattern = pattern();
				 pats.add(((SExpPatternContext)_localctx).pattern.result); 
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(573);
					match(T__4);
					setState(574);
					((SExpPatternContext)_localctx).pattern = pattern();
					 pats.add(((SExpPatternContext)_localctx).pattern.result); 
					}
					}
					setState(581);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(582);
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
		enterRule(_localctx, 74, RULE_arrayPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			match(T__17);
			 List<PatGen> pats = new ArrayList<>(); 
			setState(601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3315577313821952L) != 0)) {
				{
				setState(590);
				((ArrayPatternContext)_localctx).pattern = pattern();
				 pats.add(((ArrayPatternContext)_localctx).pattern.result); 
				setState(598);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(592);
					match(T__4);
					setState(593);
					((ArrayPatternContext)_localctx).pattern = pattern();
					 pats.add(((ArrayPatternContext)_localctx).pattern.result); 
					}
					}
					setState(600);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(603);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		case 33:
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
		"\u0004\u00013\u025f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0005\u0000N\b\u0000"+
		"\n\u0000\f\u0000Q\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0005\u0002]\b\u0002\n\u0002\f\u0002`\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004m\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005t\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0080\b\u0007"+
		"\n\u0007\f\u0007\u0083\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u008c\b\b\u0001\t\u0003\t\u008f\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a2\b\n\n"+
		"\n\f\n\u00a5\t\n\u0003\n\u00a7\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00ae\b\u000b\u0001\f\u0003\f\u00b1"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00c6\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ce\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00dc"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00e5\b\u0010\n\u0010\f\u0010\u00e8\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00fa\b\u0011"+
		"\u0001\u0011\u0005\u0011\u00fd\b\u0011\n\u0011\f\u0011\u0100\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u010a\b\u0012\n\u0012\f\u0012\u010d\t\u0012"+
		"\u0003\u0012\u010f\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u014e\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u0159\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0167\b\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u016f\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u0180\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u018f\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u01a3\b\u0019"+
		"\n\u0019\f\u0019\u01a6\t\u0019\u0003\u0019\u01a8\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01b6"+
		"\b\u001a\n\u001a\f\u001a\u01b9\t\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u01bd\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u01c9\b\u001b\n\u001b\f\u001b\u01cc\t\u001b\u0003\u001b\u01ce\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u01e1\b\u001d\n\u001d\f\u001d\u01e4\t\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01f3"+
		"\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003"+
		" \u0207\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u021c\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u022c\b\"\n"+
		"\"\f\"\u022f\t\"\u0003\"\u0231\b\"\u0001\"\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0005$\u0242\b$\n$\f$\u0245\t$\u0001$\u0001$\u0003$\u0249\b$\u0001$"+
		"\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005"+
		"%\u0255\b%\n%\f%\u0258\t%\u0003%\u025a\b%\u0001%\u0001%\u0001%\u0001%"+
		"\u0000\u0000&\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJ\u0000\u0001\u0001\u0000"+
		"\u0003\u0004\u0282\u0000O\u0001\u0000\u0000\u0000\u0002W\u0001\u0000\u0000"+
		"\u0000\u0004^\u0001\u0000\u0000\u0000\u0006a\u0001\u0000\u0000\u0000\b"+
		"f\u0001\u0000\u0000\u0000\ns\u0001\u0000\u0000\u0000\fu\u0001\u0000\u0000"+
		"\u0000\u000ey\u0001\u0000\u0000\u0000\u0010\u008b\u0001\u0000\u0000\u0000"+
		"\u0012\u008e\u0001\u0000\u0000\u0000\u0014\u009b\u0001\u0000\u0000\u0000"+
		"\u0016\u00a8\u0001\u0000\u0000\u0000\u0018\u00b0\u0001\u0000\u0000\u0000"+
		"\u001a\u00c5\u0001\u0000\u0000\u0000\u001c\u00cd\u0001\u0000\u0000\u0000"+
		"\u001e\u00db\u0001\u0000\u0000\u0000 \u00dd\u0001\u0000\u0000\u0000\""+
		"\u00e9\u0001\u0000\u0000\u0000$\u0101\u0001\u0000\u0000\u0000&\u014d\u0001"+
		"\u0000\u0000\u0000(\u014f\u0001\u0000\u0000\u0000*\u016e\u0001\u0000\u0000"+
		"\u0000,\u0170\u0001\u0000\u0000\u0000.\u0177\u0001\u0000\u0000\u00000"+
		"\u0187\u0001\u0000\u0000\u00002\u019a\u0001\u0000\u0000\u00004\u01ac\u0001"+
		"\u0000\u0000\u00006\u01c0\u0001\u0000\u0000\u00008\u01d2\u0001\u0000\u0000"+
		"\u0000:\u01d9\u0001\u0000\u0000\u0000<\u01e5\u0001\u0000\u0000\u0000>"+
		"\u01f2\u0001\u0000\u0000\u0000@\u021b\u0001\u0000\u0000\u0000B\u021d\u0001"+
		"\u0000\u0000\u0000D\u0223\u0001\u0000\u0000\u0000F\u0235\u0001\u0000\u0000"+
		"\u0000H\u0238\u0001\u0000\u0000\u0000J\u024c\u0001\u0000\u0000\u0000L"+
		"N\u0003\u0002\u0001\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RS\u0006\u0000\uffff\uffff\u0000"+
		"ST\u0003\u0016\u000b\u0000TU\u0006\u0000\uffff\uffff\u0000UV\u0005\u0000"+
		"\u0000\u0001V\u0001\u0001\u0000\u0000\u0000WX\u0005\u0001\u0000\u0000"+
		"XY\u0005.\u0000\u0000YZ\u0005\u0002\u0000\u0000Z\u0003\u0001\u0000\u0000"+
		"\u0000[]\u0003\n\u0005\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0005"+
		"\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0006\u0003\uffff"+
		"\uffff\u0000bc\u0003\u0004\u0002\u0000cd\u0003\u001e\u000f\u0000de\u0006"+
		"\u0003\uffff\uffff\u0000e\u0007\u0001\u0000\u0000\u0000fg\u0006\u0004"+
		"\uffff\uffff\u0000gh\u0003\u0004\u0002\u0000hl\u0006\u0004\uffff\uffff"+
		"\u0000ij\u0003\u001e\u000f\u0000jk\u0006\u0004\uffff\uffff\u0000km\u0001"+
		"\u0000\u0000\u0000li\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000no\u0006\u0004\uffff\uffff\u0000o\t\u0001\u0000"+
		"\u0000\u0000pt\u0003\f\u0006\u0000qt\u0003\u0012\t\u0000rt\u0003\u0018"+
		"\f\u0000sp\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000"+
		"\u0000\u0000t\u000b\u0001\u0000\u0000\u0000uv\u0007\u0000\u0000\u0000"+
		"vw\u0003\u000e\u0007\u0000wx\u0005\u0002\u0000\u0000x\r\u0001\u0000\u0000"+
		"\u0000yz\u0003\u0010\b\u0000z\u0081\u0006\u0007\uffff\uffff\u0000{|\u0005"+
		"\u0005\u0000\u0000|}\u0003\u0010\b\u0000}~\u0006\u0007\uffff\uffff\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007f{\u0001\u0000\u0000\u0000\u0080\u0083"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u000f\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005/\u0000\u0000\u0085\u008c\u0006"+
		"\b\uffff\uffff\u0000\u0086\u0087\u0005/\u0000\u0000\u0087\u0088\u0005"+
		"\u0006\u0000\u0000\u0088\u0089\u0003 \u0010\u0000\u0089\u008a\u0006\b"+
		"\uffff\uffff\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u0084\u0001"+
		"\u0000\u0000\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008c\u0011\u0001"+
		"\u0000\u0000\u0000\u008d\u008f\u0005\u0004\u0000\u0000\u008e\u008d\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0005\u0007\u0000\u0000\u0091\u0092\u0005"+
		"/\u0000\u0000\u0092\u0093\u0005\b\u0000\u0000\u0093\u0094\u0003\u0014"+
		"\n\u0000\u0094\u0095\u0005\t\u0000\u0000\u0095\u0096\u0006\t\uffff\uffff"+
		"\u0000\u0096\u0097\u0005\n\u0000\u0000\u0097\u0098\u0003\u0016\u000b\u0000"+
		"\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a\u0006\t\uffff\uffff\u0000"+
		"\u009a\u0013\u0001\u0000\u0000\u0000\u009b\u00a6\u0006\n\uffff\uffff\u0000"+
		"\u009c\u009d\u0005/\u0000\u0000\u009d\u00a3\u0006\n\uffff\uffff\u0000"+
		"\u009e\u009f\u0005\u0005\u0000\u0000\u009f\u00a0\u0005/\u0000\u0000\u00a0"+
		"\u00a2\u0006\n\uffff\uffff\u0000\u00a1\u009e\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a6\u009c\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a7\u0015\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0003\u0004\u0002\u0000\u00a9\u00ad\u0006\u000b\uffff\uffff\u0000"+
		"\u00aa\u00ab\u0003\u001e\u000f\u0000\u00ab\u00ac\u0006\u000b\uffff\uffff"+
		"\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u0017\u0001\u0000\u0000"+
		"\u0000\u00af\u00b1\u0005\u0004\u0000\u0000\u00b0\u00af\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0003\u001a\r\u0000\u00b3\u00b4\u00053\u0000\u0000"+
		"\u00b4\u00b5\u0003\u001c\u000e\u0000\u00b5\u00b6\u0005\b\u0000\u0000\u00b6"+
		"\u00b7\u0003\u0014\n\u0000\u00b7\u00b8\u0005\t\u0000\u0000\u00b8\u00b9"+
		"\u0006\f\uffff\uffff\u0000\u00b9\u00ba\u0005\n\u0000\u0000\u00ba\u00bb"+
		"\u0003\u0016\u000b\u0000\u00bb\u00bc\u0005\u000b\u0000\u0000\u00bc\u00bd"+
		"\u0006\f\uffff\uffff\u0000\u00bd\u00be\u0006\f\uffff\uffff\u0000\u00be"+
		"\u0019\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\f\u0000\u0000\u00c0\u00c6"+
		"\u0006\r\uffff\uffff\u0000\u00c1\u00c2\u0005\r\u0000\u0000\u00c2\u00c6"+
		"\u0006\r\uffff\uffff\u0000\u00c3\u00c4\u0005\u000e\u0000\u0000\u00c4\u00c6"+
		"\u0006\r\uffff\uffff\u0000\u00c5\u00bf\u0001\u0000\u0000\u0000\u00c5\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u001b"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u000f\u0000\u0000\u00c8\u00ce"+
		"\u0006\u000e\uffff\uffff\u0000\u00c9\u00ca\u0005\u0010\u0000\u0000\u00ca"+
		"\u00ce\u0006\u000e\uffff\uffff\u0000\u00cb\u00cc\u0005\u0011\u0000\u0000"+
		"\u00cc\u00ce\u0006\u000e\uffff\uffff\u0000\u00cd\u00c7\u0001\u0000\u0000"+
		"\u0000\u00cd\u00c9\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u00053\u0000\u0000"+
		"\u00d0\u00d1\u0006\u000e\uffff\uffff\u0000\u00d1\u001d\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0003 \u0010\u0000\u00d3\u00d4\u0006\u000f\uffff\uffff"+
		"\u0000\u00d4\u00dc\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003 \u0010\u0000"+
		"\u00d6\u00d7\u0006\u000f\uffff\uffff\u0000\u00d7\u00d8\u0005\u0002\u0000"+
		"\u0000\u00d8\u00d9\u0003\u001e\u000f\u0000\u00d9\u00da\u0006\u000f\uffff"+
		"\uffff\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d2\u0001\u0000"+
		"\u0000\u0000\u00db\u00d5\u0001\u0000\u0000\u0000\u00dc\u001f\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0003\"\u0011\u0000\u00de\u00e6\u0006\u0010\uffff"+
		"\uffff\u0000\u00df\u00e0\u0004\u0010\u0000\u0001\u00e0\u00e1\u00053\u0000"+
		"\u0000\u00e1\u00e2\u0003 \u0010\u0000\u00e2\u00e3\u0006\u0010\uffff\uffff"+
		"\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000\u00e4\u00df\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7!\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003&\u0013\u0000\u00ea"+
		"\u00fe\u0006\u0011\uffff\uffff\u0000\u00eb\u00ec\u0005\u0012\u0000\u0000"+
		"\u00ec\u00ed\u0003\u001e\u000f\u0000\u00ed\u00ee\u0005\u0013\u0000\u0000"+
		"\u00ee\u00ef\u0006\u0011\uffff\uffff\u0000\u00ef\u00fd\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0003$\u0012\u0000\u00f1\u00f2\u0006\u0011\uffff\uffff"+
		"\u0000\u00f2\u00fd\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u0014\u0000"+
		"\u0000\u00f4\u00f5\u0005/\u0000\u0000\u00f5\u00f9\u0006\u0011\uffff\uffff"+
		"\u0000\u00f6\u00f7\u0003$\u0012\u0000\u00f7\u00f8\u0006\u0011\uffff\uffff"+
		"\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fd\u0006\u0011\uffff\uffff\u0000\u00fc\u00eb\u0001\u0000"+
		"\u0000\u0000\u00fc\u00f0\u0001\u0000\u0000\u0000\u00fc\u00f3\u0001\u0000"+
		"\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff#\u0001\u0000\u0000"+
		"\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0102\u0005\b\u0000\u0000"+
		"\u0102\u010e\u0006\u0012\uffff\uffff\u0000\u0103\u0104\u0003\u0006\u0003"+
		"\u0000\u0104\u010b\u0006\u0012\uffff\uffff\u0000\u0105\u0106\u0005\u0005"+
		"\u0000\u0000\u0106\u0107\u0003\u0006\u0003\u0000\u0107\u0108\u0006\u0012"+
		"\uffff\uffff\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u0105\u0001"+
		"\u0000\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010f\u0001"+
		"\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0103\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0005\t\u0000\u0000\u0111%\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u00050\u0000\u0000\u0113\u014e\u0006\u0013\uffff"+
		"\uffff\u0000\u0114\u0115\u00051\u0000\u0000\u0115\u014e\u0006\u0013\uffff"+
		"\uffff\u0000\u0116\u0117\u00052\u0000\u0000\u0117\u014e\u0006\u0013\uffff"+
		"\uffff\u0000\u0118\u0119\u0005/\u0000\u0000\u0119\u014e\u0006\u0013\uffff"+
		"\uffff\u0000\u011a\u014e\u0005\u0015\u0000\u0000\u011b\u014e\u0005\u0016"+
		"\u0000\u0000\u011c\u011d\u0005\f\u0000\u0000\u011d\u011e\u00053\u0000"+
		"\u0000\u011e\u014e\u0006\u0013\uffff\uffff\u0000\u011f\u0120\u0005\u0007"+
		"\u0000\u0000\u0120\u0121\u0005\b\u0000\u0000\u0121\u0122\u0003\u0014\n"+
		"\u0000\u0122\u0123\u0006\u0013\uffff\uffff\u0000\u0123\u0124\u0005\t\u0000"+
		"\u0000\u0124\u0125\u0005\n\u0000\u0000\u0125\u0126\u0003\u0016\u000b\u0000"+
		"\u0126\u0127\u0005\u000b\u0000\u0000\u0127\u0128\u0006\u0013\uffff\uffff"+
		"\u0000\u0128\u014e\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0017\u0000"+
		"\u0000\u012a\u014e\u0006\u0013\uffff\uffff\u0000\u012b\u012c\u00053\u0000"+
		"\u0000\u012c\u012d\u00050\u0000\u0000\u012d\u014e\u0006\u0013\uffff\uffff"+
		"\u0000\u012e\u012f\u00053\u0000\u0000\u012f\u014e\u0003 \u0010\u0000\u0130"+
		"\u0131\u0005\b\u0000\u0000\u0131\u0132\u0003\u0006\u0003\u0000\u0132\u0133"+
		"\u0005\t\u0000\u0000\u0133\u0134\u0006\u0013\uffff\uffff\u0000\u0134\u014e"+
		"\u0001\u0000\u0000\u0000\u0135\u0136\u00036\u001b\u0000\u0136\u0137\u0006"+
		"\u0013\uffff\uffff\u0000\u0137\u014e\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u00032\u0019\u0000\u0139\u013a\u0006\u0013\uffff\uffff\u0000\u013a\u014e"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u00034\u001a\u0000\u013c\u013d\u0006"+
		"\u0013\uffff\uffff\u0000\u013d\u014e\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0003(\u0014\u0000\u013f\u0140\u0006\u0013\uffff\uffff\u0000\u0140\u014e"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0003,\u0016\u0000\u0142\u0143\u0006"+
		"\u0013\uffff\uffff\u0000\u0143\u014e\u0001\u0000\u0000\u0000\u0144\u0145"+
		"\u0003.\u0017\u0000\u0145\u0146\u0006\u0013\uffff\uffff\u0000\u0146\u014e"+
		"\u0001\u0000\u0000\u0000\u0147\u0148\u00030\u0018\u0000\u0148\u0149\u0006"+
		"\u0013\uffff\uffff\u0000\u0149\u014e\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u00038\u001c\u0000\u014b\u014c\u0006\u0013\uffff\uffff\u0000\u014c\u014e"+
		"\u0001\u0000\u0000\u0000\u014d\u0112\u0001\u0000\u0000\u0000\u014d\u0114"+
		"\u0001\u0000\u0000\u0000\u014d\u0116\u0001\u0000\u0000\u0000\u014d\u0118"+
		"\u0001\u0000\u0000\u0000\u014d\u011a\u0001\u0000\u0000\u0000\u014d\u011b"+
		"\u0001\u0000\u0000\u0000\u014d\u011c\u0001\u0000\u0000\u0000\u014d\u011f"+
		"\u0001\u0000\u0000\u0000\u014d\u0129\u0001\u0000\u0000\u0000\u014d\u012b"+
		"\u0001\u0000\u0000\u0000\u014d\u012e\u0001\u0000\u0000\u0000\u014d\u0130"+
		"\u0001\u0000\u0000\u0000\u014d\u0135\u0001\u0000\u0000\u0000\u014d\u0138"+
		"\u0001\u0000\u0000\u0000\u014d\u013b\u0001\u0000\u0000\u0000\u014d\u013e"+
		"\u0001\u0000\u0000\u0000\u014d\u0141\u0001\u0000\u0000\u0000\u014d\u0144"+
		"\u0001\u0000\u0000\u0000\u014d\u0147\u0001\u0000\u0000\u0000\u014d\u014a"+
		"\u0001\u0000\u0000\u0000\u014e\'\u0001\u0000\u0000\u0000\u014f\u0150\u0006"+
		"\u0014\uffff\uffff\u0000\u0150\u0151\u0005\u0018\u0000\u0000\u0151\u0152"+
		"\u0003\u001e\u000f\u0000\u0152\u0153\u0005\u0019\u0000\u0000\u0153\u0154"+
		"\u0003\u0006\u0003\u0000\u0154\u0158\u0006\u0014\uffff\uffff\u0000\u0155"+
		"\u0156\u0003*\u0015\u0000\u0156\u0157\u0006\u0014\uffff\uffff\u0000\u0157"+
		"\u0159\u0001\u0000\u0000\u0000\u0158\u0155\u0001\u0000\u0000\u0000\u0158"+
		"\u0159\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a"+
		"\u015b\u0006\u0014\uffff\uffff\u0000\u015b\u015c\u0005\u001a\u0000\u0000"+
		"\u015c)\u0001\u0000\u0000\u0000\u015d\u015e\u0006\u0015\uffff\uffff\u0000"+
		"\u015e\u015f\u0005\u001b\u0000\u0000\u015f\u0160\u0003\u001e\u000f\u0000"+
		"\u0160\u0161\u0005\u0019\u0000\u0000\u0161\u0162\u0003\u0006\u0003\u0000"+
		"\u0162\u0166\u0006\u0015\uffff\uffff\u0000\u0163\u0164\u0003*\u0015\u0000"+
		"\u0164\u0165\u0006\u0015\uffff\uffff\u0000\u0165\u0167\u0001\u0000\u0000"+
		"\u0000\u0166\u0163\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169\u0006\u0015\uffff"+
		"\uffff\u0000\u0169\u016f\u0001\u0000\u0000\u0000\u016a\u016b\u0005\u001c"+
		"\u0000\u0000\u016b\u016c\u0003\u0006\u0003\u0000\u016c\u016d\u0006\u0015"+
		"\uffff\uffff\u0000\u016d\u016f\u0001\u0000\u0000\u0000\u016e\u015d\u0001"+
		"\u0000\u0000\u0000\u016e\u016a\u0001\u0000\u0000\u0000\u016f+\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0005\u001d\u0000\u0000\u0171\u0172\u0003\u001e"+
		"\u000f\u0000\u0172\u0173\u0005\u001e\u0000\u0000\u0173\u0174\u0003\u0006"+
		"\u0003\u0000\u0174\u0175\u0006\u0016\uffff\uffff\u0000\u0175\u0176\u0005"+
		"\u001f\u0000\u0000\u0176-\u0001\u0000\u0000\u0000\u0177\u0178\u0005\u001e"+
		"\u0000\u0000\u0178\u0179\u0006\u0017\uffff\uffff\u0000\u0179\u017a\u0003"+
		"\u0004\u0002\u0000\u017a\u017b\u0006\u0017\uffff\uffff\u0000\u017b\u017f"+
		"\u0006\u0017\uffff\uffff\u0000\u017c\u017d\u0003\u001e\u000f\u0000\u017d"+
		"\u017e\u0006\u0017\uffff\uffff\u0000\u017e\u0180\u0001\u0000\u0000\u0000"+
		"\u017f\u017c\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000"+
		"\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u0006\u0017\uffff\uffff"+
		"\u0000\u0182\u0183\u0005\u001d\u0000\u0000\u0183\u0184\u0003\u001e\u000f"+
		"\u0000\u0184\u0185\u0006\u0017\uffff\uffff\u0000\u0185\u0186\u0005\u001f"+
		"\u0000\u0000\u0186/\u0001\u0000\u0000\u0000\u0187\u0188\u0005 \u0000\u0000"+
		"\u0188\u0189\u0006\u0018\uffff\uffff\u0000\u0189\u018a\u0003\u0004\u0002"+
		"\u0000\u018a\u018e\u0006\u0018\uffff\uffff\u0000\u018b\u018c\u0003\u001e"+
		"\u000f\u0000\u018c\u018d\u0006\u0018\uffff\uffff\u0000\u018d\u018f\u0001"+
		"\u0000\u0000\u0000\u018e\u018b\u0001\u0000\u0000\u0000\u018e\u018f\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0006"+
		"\u0018\uffff\uffff\u0000\u0191\u0192\u0005\u0005\u0000\u0000\u0192\u0193"+
		"\u0003\u001e\u000f\u0000\u0193\u0194\u0005\u0005\u0000\u0000\u0194\u0195"+
		"\u0003\u001e\u000f\u0000\u0195\u0196\u0005\u001e\u0000\u0000\u0196\u0197"+
		"\u0003\b\u0004\u0000\u0197\u0198\u0006\u0018\uffff\uffff\u0000\u0198\u0199"+
		"\u0005\u001f\u0000\u0000\u01991\u0001\u0000\u0000\u0000\u019a\u019b\u0005"+
		"\u0012\u0000\u0000\u019b\u01a7\u0006\u0019\uffff\uffff\u0000\u019c\u019d"+
		"\u0003\u001e\u000f\u0000\u019d\u01a4\u0006\u0019\uffff\uffff\u0000\u019e"+
		"\u019f\u0005\u0005\u0000\u0000\u019f\u01a0\u0003\u001e\u000f\u0000\u01a0"+
		"\u01a1\u0006\u0019\uffff\uffff\u0000\u01a1\u01a3\u0001\u0000\u0000\u0000"+
		"\u01a2\u019e\u0001\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000"+
		"\u01a7\u019c\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9\u01aa\u0005\u0013\u0000\u0000"+
		"\u01aa\u01ab\u0006\u0019\uffff\uffff\u0000\u01ab3\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ad\u0005.\u0000\u0000\u01ad\u01bc\u0006\u001a\uffff\uffff\u0000"+
		"\u01ae\u01af\u0005\b\u0000\u0000\u01af\u01b0\u0003\u001e\u000f\u0000\u01b0"+
		"\u01b7\u0006\u001a\uffff\uffff\u0000\u01b1\u01b2\u0005\u0005\u0000\u0000"+
		"\u01b2\u01b3\u0003\u001e\u000f\u0000\u01b3\u01b4\u0006\u001a\uffff\uffff"+
		"\u0000\u01b4\u01b6\u0001\u0000\u0000\u0000\u01b5\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000\u01b8\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005\t\u0000\u0000"+
		"\u01bb\u01bd\u0001\u0000\u0000\u0000\u01bc\u01ae\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000"+
		"\u01be\u01bf\u0006\u001a\uffff\uffff\u0000\u01bf5\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\u0005\n\u0000\u0000\u01c1\u01cd\u0006\u001b\uffff\uffff\u0000"+
		"\u01c2\u01c3\u0003\u001e\u000f\u0000\u01c3\u01ca\u0006\u001b\uffff\uffff"+
		"\u0000\u01c4\u01c5\u0005\u0005\u0000\u0000\u01c5\u01c6\u0003\u001e\u000f"+
		"\u0000\u01c6\u01c7\u0006\u001b\uffff\uffff\u0000\u01c7\u01c9\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c4\u0001\u0000\u0000\u0000\u01c9\u01cc\u0001\u0000"+
		"\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001\u0000"+
		"\u0000\u0000\u01cd\u01c2\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005\u000b"+
		"\u0000\u0000\u01d0\u01d1\u0006\u001b\uffff\uffff\u0000\u01d17\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d3\u0005!\u0000\u0000\u01d3\u01d4\u0003\u001e\u000f"+
		"\u0000\u01d4\u01d5\u0005\"\u0000\u0000\u01d5\u01d6\u0003:\u001d\u0000"+
		"\u01d6\u01d7\u0005#\u0000\u0000\u01d7\u01d8\u0006\u001c\uffff\uffff\u0000"+
		"\u01d89\u0001\u0000\u0000\u0000\u01d9\u01da\u0006\u001d\uffff\uffff\u0000"+
		"\u01da\u01db\u0003<\u001e\u0000\u01db\u01e2\u0006\u001d\uffff\uffff\u0000"+
		"\u01dc\u01dd\u0005$\u0000\u0000\u01dd\u01de\u0003<\u001e\u0000\u01de\u01df"+
		"\u0006\u001d\uffff\uffff\u0000\u01df\u01e1\u0001\u0000\u0000\u0000\u01e0"+
		"\u01dc\u0001\u0000\u0000\u0000\u01e1\u01e4\u0001\u0000\u0000\u0000\u01e2"+
		"\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000\u0000\u01e3"+
		";\u0001\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e5\u01e6"+
		"\u0006\u001e\uffff\uffff\u0000\u01e6\u01e7\u0003>\u001f\u0000\u01e7\u01e8"+
		"\u0006\u001e\uffff\uffff\u0000\u01e8\u01e9\u0005%\u0000\u0000\u01e9\u01ea"+
		"\u0003\u0006\u0003\u0000\u01ea\u01eb\u0006\u001e\uffff\uffff\u0000\u01eb"+
		"=\u0001\u0000\u0000\u0000\u01ec\u01ed\u0003@ \u0000\u01ed\u01ee\u0006"+
		"\u001f\uffff\uffff\u0000\u01ee\u01f3\u0001\u0000\u0000\u0000\u01ef\u01f0"+
		"\u0003B!\u0000\u01f0\u01f1\u0006\u001f\uffff\uffff\u0000\u01f1\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f2\u01ec\u0001\u0000\u0000\u0000\u01f2\u01ef\u0001"+
		"\u0000\u0000\u0000\u01f3?\u0001\u0000\u0000\u0000\u01f4\u01f5\u0003F#"+
		"\u0000\u01f5\u01f6\u0006 \uffff\uffff\u0000\u01f6\u021c\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f8\u0003H$\u0000\u01f8\u01f9\u0006 \uffff\uffff\u0000"+
		"\u01f9\u021c\u0001\u0000\u0000\u0000\u01fa\u01fb\u0003J%\u0000\u01fb\u01fc"+
		"\u0006 \uffff\uffff\u0000\u01fc\u021c\u0001\u0000\u0000\u0000\u01fd\u01fe"+
		"\u0003D\"\u0000\u01fe\u01ff\u0006 \uffff\uffff\u0000\u01ff\u021c\u0001"+
		"\u0000\u0000\u0000\u0200\u0201\u0005/\u0000\u0000\u0201\u0206\u0006 \uffff"+
		"\uffff\u0000\u0202\u0203\u0005&\u0000\u0000\u0203\u0204\u0003>\u001f\u0000"+
		"\u0204\u0205\u0006 \uffff\uffff\u0000\u0205\u0207\u0001\u0000\u0000\u0000"+
		"\u0206\u0202\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000"+
		"\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u021c\u0006 \uffff\uffff\u0000"+
		"\u0209\u020a\u00050\u0000\u0000\u020a\u021c\u0006 \uffff\uffff\u0000\u020b"+
		"\u020c\u00053\u0000\u0000\u020c\u020d\u00050\u0000\u0000\u020d\u021c\u0006"+
		" \uffff\uffff\u0000\u020e\u020f\u00051\u0000\u0000\u020f\u021c\u0006 "+
		"\uffff\uffff\u0000\u0210\u0211\u0005\'\u0000\u0000\u0211\u021c\u0006 "+
		"\uffff\uffff\u0000\u0212\u0213\u0005(\u0000\u0000\u0213\u021c\u0006 \uffff"+
		"\uffff\u0000\u0214\u0215\u0005)\u0000\u0000\u0215\u021c\u0006 \uffff\uffff"+
		"\u0000\u0216\u0217\u0005\b\u0000\u0000\u0217\u0218\u0003>\u001f\u0000"+
		"\u0218\u0219\u0005\t\u0000\u0000\u0219\u021a\u0006 \uffff\uffff\u0000"+
		"\u021a\u021c\u0001\u0000\u0000\u0000\u021b\u01f4\u0001\u0000\u0000\u0000"+
		"\u021b\u01f7\u0001\u0000\u0000\u0000\u021b\u01fa\u0001\u0000\u0000\u0000"+
		"\u021b\u01fd\u0001\u0000\u0000\u0000\u021b\u0200\u0001\u0000\u0000\u0000"+
		"\u021b\u0209\u0001\u0000\u0000\u0000\u021b\u020b\u0001\u0000\u0000\u0000"+
		"\u021b\u020e\u0001\u0000\u0000\u0000\u021b\u0210\u0001\u0000\u0000\u0000"+
		"\u021b\u0212\u0001\u0000\u0000\u0000\u021b\u0214\u0001\u0000\u0000\u0000"+
		"\u021b\u0216\u0001\u0000\u0000\u0000\u021cA\u0001\u0000\u0000\u0000\u021d"+
		"\u021e\u0003@ \u0000\u021e\u021f\u00053\u0000\u0000\u021f\u0220\u0004"+
		"!\u0001\u0001\u0220\u0221\u0003>\u001f\u0000\u0221\u0222\u0006!\uffff"+
		"\uffff\u0000\u0222C\u0001\u0000\u0000\u0000\u0223\u0224\u0005\n\u0000"+
		"\u0000\u0224\u0230\u0006\"\uffff\uffff\u0000\u0225\u0226\u0003>\u001f"+
		"\u0000\u0226\u022d\u0006\"\uffff\uffff\u0000\u0227\u0228\u0005\u0005\u0000"+
		"\u0000\u0228\u0229\u0003>\u001f\u0000\u0229\u022a\u0006\"\uffff\uffff"+
		"\u0000\u022a\u022c\u0001\u0000\u0000\u0000\u022b\u0227\u0001\u0000\u0000"+
		"\u0000\u022c\u022f\u0001\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u0231\u0001\u0000\u0000"+
		"\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u0230\u0225\u0001\u0000\u0000"+
		"\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0232\u0001\u0000\u0000"+
		"\u0000\u0232\u0233\u0005\u000b\u0000\u0000\u0233\u0234\u0006\"\uffff\uffff"+
		"\u0000\u0234E\u0001\u0000\u0000\u0000\u0235\u0236\u0005*\u0000\u0000\u0236"+
		"\u0237\u0006#\uffff\uffff\u0000\u0237G\u0001\u0000\u0000\u0000\u0238\u0239"+
		"\u0005.\u0000\u0000\u0239\u0248\u0006$\uffff\uffff\u0000\u023a\u023b\u0005"+
		"\b\u0000\u0000\u023b\u023c\u0003>\u001f\u0000\u023c\u0243\u0006$\uffff"+
		"\uffff\u0000\u023d\u023e\u0005\u0005\u0000\u0000\u023e\u023f\u0003>\u001f"+
		"\u0000\u023f\u0240\u0006$\uffff\uffff\u0000\u0240\u0242\u0001\u0000\u0000"+
		"\u0000\u0241\u023d\u0001\u0000\u0000\u0000\u0242\u0245\u0001\u0000\u0000"+
		"\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000"+
		"\u0000\u0244\u0246\u0001\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000"+
		"\u0000\u0246\u0247\u0005\t\u0000\u0000\u0247\u0249\u0001\u0000\u0000\u0000"+
		"\u0248\u023a\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000"+
		"\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0006$\uffff\uffff\u0000"+
		"\u024bI\u0001\u0000\u0000\u0000\u024c\u024d\u0005\u0012\u0000\u0000\u024d"+
		"\u0259\u0006%\uffff\uffff\u0000\u024e\u024f\u0003>\u001f\u0000\u024f\u0256"+
		"\u0006%\uffff\uffff\u0000\u0250\u0251\u0005\u0005\u0000\u0000\u0251\u0252"+
		"\u0003>\u001f\u0000\u0252\u0253\u0006%\uffff\uffff\u0000\u0253\u0255\u0001"+
		"\u0000\u0000\u0000\u0254\u0250\u0001\u0000\u0000\u0000\u0255\u0258\u0001"+
		"\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000\u0256\u0257\u0001"+
		"\u0000\u0000\u0000\u0257\u025a\u0001\u0000\u0000\u0000\u0258\u0256\u0001"+
		"\u0000\u0000\u0000\u0259\u024e\u0001\u0000\u0000\u0000\u0259\u025a\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u025c\u0005"+
		"\u0013\u0000\u0000\u025c\u025d\u0006%\uffff\uffff\u0000\u025dK\u0001\u0000"+
		"\u0000\u0000*O^ls\u0081\u008b\u008e\u00a3\u00a6\u00ad\u00b0\u00c5\u00cd"+
		"\u00db\u00e6\u00f9\u00fc\u00fe\u010b\u010e\u014d\u0158\u0166\u016e\u017f"+
		"\u018e\u01a4\u01a7\u01b7\u01bc\u01ca\u01cd\u01e2\u01f2\u0206\u021b\u022d"+
		"\u0230\u0243\u0248\u0256\u0259";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}