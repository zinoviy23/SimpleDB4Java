// Generated from /home/sanusha/Proga/SimpleDB4Java/src/main/antlr/SimpleDBGrammar.g4 by ANTLR 4.7
package zinoviy23.simpledb4java.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleDBGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, CMDEND=16, 
		QUERYKW=17, DATABASEKW=18, CLASSKW=19, RETURNKW=20, FORKW=21, IFKW=22, 
		ELSEKW=23, LBRACE=24, RBRACE=25, LPAR=26, RPAR=27, LSQBR=28, RSQBR=29, 
		DOT=30, COMMA=31, DOUBLEDOT=32, CONSTANT=33, ID=34, SKIP_=35;
	public static final int
		RULE_file = 0, RULE_fileHeader = 1, RULE_fieldDef = 2, RULE_classDef = 3, 
		RULE_dottedId = 4, RULE_expression = 5, RULE_arrIndexList = 6, RULE_callArgList = 7, 
		RULE_simpleCommand = 8, RULE_queryDef = 9, RULE_funcArgList = 10, RULE_block = 11, 
		RULE_forCycle = 12, RULE_ifStatement = 13, RULE_elseBlock = 14, RULE_array = 15;
	public static final String[] ruleNames = {
		"file", "fileHeader", "fieldDef", "classDef", "dottedId", "expression", 
		"arrIndexList", "callArgList", "simpleCommand", "queryDef", "funcArgList", 
		"block", "forCycle", "ifStatement", "elseBlock", "array"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'+'", "'++'", "'--'", "'*'", "'/'", "'<'", "'>'", "'<='", 
		"'>='", "'=='", "'!='", "'='", "'+='", "'-='", "';'", "'query'", "'database'", 
		"'class'", "'return'", "'for'", "'if'", "'else'", "'{'", "'}'", "'('", 
		"')'", "'['", "']'", "'.'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "CMDEND", "QUERYKW", "DATABASEKW", "CLASSKW", 
		"RETURNKW", "FORKW", "IFKW", "ELSEKW", "LBRACE", "RBRACE", "LPAR", "RPAR", 
		"LSQBR", "RSQBR", "DOT", "COMMA", "DOUBLEDOT", "CONSTANT", "ID", "SKIP_"
	};
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
	public String getGrammarFileName() { return "SimpleDBGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleDBGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public FileHeaderContext fileHeader() {
			return getRuleContext(FileHeaderContext.class,0);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			fileHeader();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSKW) {
				{
				{
				setState(33);
				classDef();
				}
				}
				setState(38);
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

	public static class FileHeaderContext extends ParserRuleContext {
		public TerminalNode DATABASEKW() { return getToken(SimpleDBGrammarParser.DATABASEKW, 0); }
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public FileHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterFileHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitFileHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitFileHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileHeaderContext fileHeader() throws RecognitionException {
		FileHeaderContext _localctx = new FileHeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_fileHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(DATABASEKW);
			setState(40);
			match(ID);
			setState(41);
			match(CMDEND);
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

	public static class FieldDefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterFieldDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitFieldDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitFieldDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fieldDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(ID);
			setState(44);
			match(ID);
			setState(45);
			match(CMDEND);
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

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode CLASSKW() { return getToken(SimpleDBGrammarParser.CLASSKW, 0); }
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleDBGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleDBGrammarParser.RBRACE, 0); }
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public List<QueryDefContext> queryDef() {
			return getRuleContexts(QueryDefContext.class);
		}
		public QueryDefContext queryDef(int i) {
			return getRuleContext(QueryDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(CLASSKW);
			setState(48);
			match(ID);
			setState(49);
			match(LBRACE);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUERYKW || _la==ID) {
				{
				setState(52);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(50);
					fieldDef();
					}
					break;
				case QUERYKW:
					{
					setState(51);
					queryDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(RBRACE);
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

	public static class DottedIdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SimpleDBGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleDBGrammarParser.DOT, i);
		}
		public DottedIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dottedId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterDottedId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitDottedId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitDottedId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DottedIdContext dottedId() throws RecognitionException {
		DottedIdContext _localctx = new DottedIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dottedId);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					match(DOT);
					setState(61);
					match(ID);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DottedIdContext dottedId() {
			return getRuleContext(DottedIdContext.class,0);
		}
		public TerminalNode CONSTANT() { return getToken(SimpleDBGrammarParser.CONSTANT, 0); }
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public CallArgListContext callArgList() {
			return getRuleContext(CallArgListContext.class,0);
		}
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public ArrIndexListContext arrIndexList() {
			return getRuleContext(ArrIndexListContext.class,0);
		}
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public TerminalNode DOT() { return getToken(SimpleDBGrammarParser.DOT, 0); }
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				{
				setState(68);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(69);
				expression(13);
				}
				break;
			case ID:
				{
				setState(70);
				dottedId();
				}
				break;
			case CONSTANT:
				{
				setState(71);
				match(CONSTANT);
				}
				break;
			case LBRACE:
				{
				setState(72);
				array();
				}
				break;
			case LPAR:
				{
				setState(73);
				match(LPAR);
				setState(74);
				expression(0);
				setState(75);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(79);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(80);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(81);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(82);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(83);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(84);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(85);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(86);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(87);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(89);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(91);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(92);
						match(LPAR);
						setState(93);
						callArgList();
						setState(94);
						match(RPAR);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(97);
						match(LSQBR);
						setState(98);
						arrIndexList();
						setState(99);
						match(RSQBR);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(102);
						match(DOT);
						setState(103);
						match(ID);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ArrIndexListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleDBGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleDBGrammarParser.COMMA, i);
		}
		public ArrIndexListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrIndexList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterArrIndexList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitArrIndexList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitArrIndexList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrIndexListContext arrIndexList() throws RecognitionException {
		ArrIndexListContext _localctx = new ArrIndexListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrIndexList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expression(0);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(113);
				expression(0);
				}
				}
				setState(118);
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

	public static class CallArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleDBGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleDBGrammarParser.COMMA, i);
		}
		public CallArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterCallArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitCallArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitCallArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallArgListContext callArgList() throws RecognitionException {
		CallArgListContext _localctx = new CallArgListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_callArgList);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case LBRACE:
			case LPAR:
			case CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				expression(0);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(121);
					match(COMMA);
					setState(122);
					expression(0);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class SimpleCommandContext extends ParserRuleContext {
		public TerminalNode RETURNKW() { return getToken(SimpleDBGrammarParser.RETURNKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public ForCycleContext forCycle() {
			return getRuleContext(ForCycleContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public SimpleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterSimpleCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitSimpleCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitSimpleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleCommandContext simpleCommand() throws RecognitionException {
		SimpleCommandContext _localctx = new SimpleCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simpleCommand);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(RETURNKW);
				setState(131);
				expression(0);
				setState(132);
				match(CMDEND);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(ID);
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQBR) {
					{
					setState(135);
					match(LSQBR);
					setState(136);
					match(RSQBR);
					}
				}

				setState(139);
				match(ID);
				setState(140);
				match(T__12);
				setState(141);
				expression(0);
				setState(142);
				match(CMDEND);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(ID);
				setState(145);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				expression(0);
				setState(147);
				match(CMDEND);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				expression(0);
				setState(150);
				match(CMDEND);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				forCycle();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				ifStatement();
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

	public static class QueryDefContext extends ParserRuleContext {
		public TerminalNode QUERYKW() { return getToken(SimpleDBGrammarParser.QUERYKW, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public FuncArgListContext funcArgList() {
			return getRuleContext(FuncArgListContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public TerminalNode DOUBLEDOT() { return getToken(SimpleDBGrammarParser.DOUBLEDOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleDBGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleDBGrammarParser.RBRACE, 0); }
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public List<SimpleCommandContext> simpleCommand() {
			return getRuleContexts(SimpleCommandContext.class);
		}
		public SimpleCommandContext simpleCommand(int i) {
			return getRuleContext(SimpleCommandContext.class,i);
		}
		public QueryDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterQueryDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitQueryDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitQueryDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryDefContext queryDef() throws RecognitionException {
		QueryDefContext _localctx = new QueryDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_queryDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(QUERYKW);
			setState(157);
			match(ID);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(158);
				match(LSQBR);
				setState(159);
				match(RSQBR);
				}
			}

			setState(162);
			match(ID);
			setState(163);
			match(LPAR);
			setState(164);
			funcArgList();
			setState(165);
			match(RPAR);
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLEDOT:
				{
				setState(166);
				match(DOUBLEDOT);
				setState(167);
				expression(0);
				setState(168);
				match(CMDEND);
				}
				break;
			case LBRACE:
				{
				setState(170);
				match(LBRACE);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << LBRACE) | (1L << LPAR) | (1L << CONSTANT) | (1L << ID))) != 0)) {
					{
					{
					setState(171);
					simpleCommand();
					}
					}
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(177);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class FuncArgListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleDBGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleDBGrammarParser.COMMA, i);
		}
		public FuncArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterFuncArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitFuncArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitFuncArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgListContext funcArgList() throws RecognitionException {
		FuncArgListContext _localctx = new FuncArgListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcArgList);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(ID);
				setState(182);
				match(ID);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(183);
					match(COMMA);
					setState(184);
					match(ID);
					setState(185);
					match(ID);
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class BlockContext extends ParserRuleContext {
		public List<SimpleCommandContext> simpleCommand() {
			return getRuleContexts(SimpleCommandContext.class);
		}
		public SimpleCommandContext simpleCommand(int i) {
			return getRuleContext(SimpleCommandContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(SimpleDBGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleDBGrammarParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				simpleCommand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(LBRACE);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << LBRACE) | (1L << LPAR) | (1L << CONSTANT) | (1L << ID))) != 0)) {
					{
					{
					setState(195);
					simpleCommand();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(RBRACE);
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

	public static class ForCycleContext extends ParserRuleContext {
		public TerminalNode FORKW() { return getToken(SimpleDBGrammarParser.FORKW, 0); }
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleDBGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleDBGrammarParser.ID, i);
		}
		public TerminalNode DOUBLEDOT() { return getToken(SimpleDBGrammarParser.DOUBLEDOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public ForCycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterForCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitForCycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitForCycle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForCycleContext forCycle() throws RecognitionException {
		ForCycleContext _localctx = new ForCycleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forCycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(FORKW);
			setState(205);
			match(LPAR);
			setState(206);
			match(ID);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(207);
				match(LSQBR);
				setState(208);
				match(RSQBR);
				}
			}

			setState(211);
			match(ID);
			setState(212);
			match(DOUBLEDOT);
			setState(213);
			expression(0);
			setState(214);
			match(RPAR);
			setState(215);
			block();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IFKW() { return getToken(SimpleDBGrammarParser.IFKW, 0); }
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(IFKW);
			setState(218);
			match(LPAR);
			setState(219);
			expression(0);
			setState(220);
			match(RPAR);
			setState(221);
			block();
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(222);
				elseBlock();
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

	public static class ElseBlockContext extends ParserRuleContext {
		public TerminalNode ELSEKW() { return getToken(SimpleDBGrammarParser.ELSEKW, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ELSEKW);
			setState(226);
			block();
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(SimpleDBGrammarParser.LBRACE, 0); }
		public ArrIndexListContext arrIndexList() {
			return getRuleContext(ArrIndexListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(SimpleDBGrammarParser.RBRACE, 0); }
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LBRACE);
			setState(229);
			arrIndexList();
			setState(230);
			match(RBRACE);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\5\3\5\3\6\3\6\3\6\7\6A\n\6\f\6\16\6D"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7P\n\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\b\3\b\3\b\7\bu\n\b\f"+
		"\b\16\bx\13\b\3\t\3\t\3\t\3\t\7\t~\n\t\f\t\16\t\u0081\13\t\5\t\u0083\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009d\n\n\3\13\3\13\3\13\3\13\5"+
		"\13\u00a3\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00af\n\13\f\13\16\13\u00b2\13\13\3\13\5\13\u00b5\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u00bd\n\f\f\f\16\f\u00c0\13\f\5\f\u00c2\n\f\3\r\3\r\3\r"+
		"\7\r\u00c7\n\r\f\r\16\r\u00ca\13\r\3\r\5\r\u00cd\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00d4\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00e2\n\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\2\3\f\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\t\3\2\3\6\3\2\7\b"+
		"\3\2\3\4\3\2\t\f\3\2\r\16\3\2\5\6\3\2\17\21\2\u00fc\2\"\3\2\2\2\4)\3\2"+
		"\2\2\6-\3\2\2\2\b\61\3\2\2\2\n=\3\2\2\2\fO\3\2\2\2\16q\3\2\2\2\20\u0082"+
		"\3\2\2\2\22\u009c\3\2\2\2\24\u009e\3\2\2\2\26\u00c1\3\2\2\2\30\u00cc\3"+
		"\2\2\2\32\u00ce\3\2\2\2\34\u00db\3\2\2\2\36\u00e3\3\2\2\2 \u00e6\3\2\2"+
		"\2\"&\5\4\3\2#%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\3\3"+
		"\2\2\2(&\3\2\2\2)*\7\24\2\2*+\7$\2\2+,\7\22\2\2,\5\3\2\2\2-.\7$\2\2./"+
		"\7$\2\2/\60\7\22\2\2\60\7\3\2\2\2\61\62\7\25\2\2\62\63\7$\2\2\638\7\32"+
		"\2\2\64\67\5\6\4\2\65\67\5\24\13\2\66\64\3\2\2\2\66\65\3\2\2\2\67:\3\2"+
		"\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\33\2\2<\t\3\2\2\2="+
		"B\7$\2\2>?\7 \2\2?A\7$\2\2@>\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\13"+
		"\3\2\2\2DB\3\2\2\2EF\b\7\1\2FG\t\2\2\2GP\5\f\7\17HP\5\n\6\2IP\7#\2\2J"+
		"P\5 \21\2KL\7\34\2\2LM\5\f\7\2MN\7\35\2\2NP\3\2\2\2OE\3\2\2\2OH\3\2\2"+
		"\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2Pn\3\2\2\2QR\f\n\2\2RS\t\3\2\2Sm\5\f\7"+
		"\13TU\f\t\2\2UV\t\4\2\2Vm\5\f\7\nWX\f\b\2\2XY\t\5\2\2Ym\5\f\7\tZ[\f\7"+
		"\2\2[\\\t\6\2\2\\m\5\f\7\b]^\f\16\2\2^_\7\34\2\2_`\5\20\t\2`a\7\35\2\2"+
		"am\3\2\2\2bc\f\r\2\2cd\7\36\2\2de\5\16\b\2ef\7\37\2\2fm\3\2\2\2gh\f\f"+
		"\2\2hi\7 \2\2im\7$\2\2jk\f\13\2\2km\t\7\2\2lQ\3\2\2\2lT\3\2\2\2lW\3\2"+
		"\2\2lZ\3\2\2\2l]\3\2\2\2lb\3\2\2\2lg\3\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2o\r\3\2\2\2pn\3\2\2\2qv\5\f\7\2rs\7!\2\2su\5\f\7\2tr\3\2"+
		"\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\17\3\2\2\2xv\3\2\2\2y\u0083\3\2\2"+
		"\2z\177\5\f\7\2{|\7!\2\2|~\5\f\7\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082y\3\2"+
		"\2\2\u0082z\3\2\2\2\u0083\21\3\2\2\2\u0084\u0085\7\26\2\2\u0085\u0086"+
		"\5\f\7\2\u0086\u0087\7\22\2\2\u0087\u009d\3\2\2\2\u0088\u008b\7$\2\2\u0089"+
		"\u008a\7\36\2\2\u008a\u008c\7\37\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7$\2\2\u008e\u008f\7\17\2\2\u008f"+
		"\u0090\5\f\7\2\u0090\u0091\7\22\2\2\u0091\u009d\3\2\2\2\u0092\u0093\7"+
		"$\2\2\u0093\u0094\t\b\2\2\u0094\u0095\5\f\7\2\u0095\u0096\7\22\2\2\u0096"+
		"\u009d\3\2\2\2\u0097\u0098\5\f\7\2\u0098\u0099\7\22\2\2\u0099\u009d\3"+
		"\2\2\2\u009a\u009d\5\32\16\2\u009b\u009d\5\34\17\2\u009c\u0084\3\2\2\2"+
		"\u009c\u0088\3\2\2\2\u009c\u0092\3\2\2\2\u009c\u0097\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\23\3\2\2\2\u009e\u009f\7\23\2\2\u009f"+
		"\u00a2\7$\2\2\u00a0\u00a1\7\36\2\2\u00a1\u00a3\7\37\2\2\u00a2\u00a0\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7$\2\2\u00a5"+
		"\u00a6\7\34\2\2\u00a6\u00a7\5\26\f\2\u00a7\u00b4\7\35\2\2\u00a8\u00a9"+
		"\7\"\2\2\u00a9\u00aa\5\f\7\2\u00aa\u00ab\7\22\2\2\u00ab\u00b5\3\2\2\2"+
		"\u00ac\u00b0\7\32\2\2\u00ad\u00af\5\22\n\2\u00ae\u00ad\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b5\7\33\2\2\u00b4\u00a8\3\2\2\2\u00b4\u00ac\3"+
		"\2\2\2\u00b5\25\3\2\2\2\u00b6\u00c2\3\2\2\2\u00b7\u00b8\7$\2\2\u00b8\u00be"+
		"\7$\2\2\u00b9\u00ba\7!\2\2\u00ba\u00bb\7$\2\2\u00bb\u00bd\7$\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00b6\3\2\2\2\u00c1"+
		"\u00b7\3\2\2\2\u00c2\27\3\2\2\2\u00c3\u00cd\5\22\n\2\u00c4\u00c8\7\32"+
		"\2\2\u00c5\u00c7\5\22\n\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00cb\u00cd\7\33\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00c4\3\2\2\2\u00cd"+
		"\31\3\2\2\2\u00ce\u00cf\7\27\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d3\7$\2"+
		"\2\u00d1\u00d2\7\36\2\2\u00d2\u00d4\7\37\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6\u00d7\7\""+
		"\2\2\u00d7\u00d8\5\f\7\2\u00d8\u00d9\7\35\2\2\u00d9\u00da\5\30\r\2\u00da"+
		"\33\3\2\2\2\u00db\u00dc\7\30\2\2\u00dc\u00dd\7\34\2\2\u00dd\u00de\5\f"+
		"\7\2\u00de\u00df\7\35\2\2\u00df\u00e1\5\30\r\2\u00e0\u00e2\5\36\20\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\35\3\2\2\2\u00e3\u00e4\7\31\2"+
		"\2\u00e4\u00e5\5\30\r\2\u00e5\37\3\2\2\2\u00e6\u00e7\7\32\2\2\u00e7\u00e8"+
		"\5\16\b\2\u00e8\u00e9\7\33\2\2\u00e9!\3\2\2\2\27&\668BOlnv\177\u0082\u008b"+
		"\u009c\u00a2\u00b0\u00b4\u00be\u00c1\u00c8\u00cc\u00d3\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}