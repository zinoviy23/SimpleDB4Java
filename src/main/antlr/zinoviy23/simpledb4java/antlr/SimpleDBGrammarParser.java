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
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(ID);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(44);
				match(LSQBR);
				setState(45);
				match(RSQBR);
				}
			}

			setState(48);
			match(ID);
			setState(49);
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
			setState(51);
			match(CLASSKW);
			setState(52);
			match(ID);
			setState(53);
			match(LBRACE);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==QUERYKW || _la==ID) {
				{
				setState(56);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(54);
					fieldDef();
					}
					break;
				case QUERYKW:
					{
					setState(55);
					queryDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
			setState(63);
			match(ID);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					match(DOT);
					setState(65);
					match(ID);
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				{
				setState(72);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(73);
				expression(13);
				}
				break;
			case ID:
				{
				setState(74);
				dottedId();
				}
				break;
			case CONSTANT:
				{
				setState(75);
				match(CONSTANT);
				}
				break;
			case LBRACE:
				{
				setState(76);
				array();
				}
				break;
			case LPAR:
				{
				setState(77);
				match(LPAR);
				setState(78);
				expression(0);
				setState(79);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(84);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(86);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(87);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(88);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(90);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(93);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(95);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(96);
						match(LPAR);
						setState(97);
						callArgList();
						setState(98);
						match(RPAR);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(101);
						match(LSQBR);
						setState(102);
						arrIndexList();
						setState(103);
						match(RSQBR);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(106);
						match(DOT);
						setState(107);
						match(ID);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(109);
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
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			setState(115);
			expression(0);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(116);
				match(COMMA);
				setState(117);
				expression(0);
				}
				}
				setState(122);
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
			setState(132);
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
				setState(124);
				expression(0);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(125);
					match(COMMA);
					setState(126);
					expression(0);
					}
					}
					setState(131);
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
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(RETURNKW);
				setState(135);
				expression(0);
				setState(136);
				match(CMDEND);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(ID);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQBR) {
					{
					setState(139);
					match(LSQBR);
					setState(140);
					match(RSQBR);
					}
				}

				setState(143);
				match(ID);
				setState(144);
				match(T__12);
				setState(145);
				expression(0);
				setState(146);
				match(CMDEND);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(ID);
				setState(149);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(150);
				expression(0);
				setState(151);
				match(CMDEND);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				expression(0);
				setState(154);
				match(CMDEND);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				forCycle();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
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
			setState(160);
			match(QUERYKW);
			setState(161);
			match(ID);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(162);
				match(LSQBR);
				setState(163);
				match(RSQBR);
				}
			}

			setState(166);
			match(ID);
			setState(167);
			match(LPAR);
			setState(168);
			funcArgList();
			setState(169);
			match(RPAR);
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLEDOT:
				{
				setState(170);
				match(DOUBLEDOT);
				setState(171);
				expression(0);
				setState(172);
				match(CMDEND);
				}
				break;
			case LBRACE:
				{
				setState(174);
				match(LBRACE);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << LBRACE) | (1L << LPAR) | (1L << CONSTANT) | (1L << ID))) != 0)) {
					{
					{
					setState(175);
					simpleCommand();
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
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
			setState(195);
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
				setState(185);
				match(ID);
				setState(186);
				match(ID);
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(187);
					match(COMMA);
					setState(188);
					match(ID);
					setState(189);
					match(ID);
					}
					}
					setState(194);
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
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				simpleCommand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(LBRACE);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << LBRACE) | (1L << LPAR) | (1L << CONSTANT) | (1L << ID))) != 0)) {
					{
					{
					setState(199);
					simpleCommand();
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
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
			setState(208);
			match(FORKW);
			setState(209);
			match(LPAR);
			setState(210);
			match(ID);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(211);
				match(LSQBR);
				setState(212);
				match(RSQBR);
				}
			}

			setState(215);
			match(ID);
			setState(216);
			match(DOUBLEDOT);
			setState(217);
			expression(0);
			setState(218);
			match(RPAR);
			setState(219);
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
			setState(221);
			match(IFKW);
			setState(222);
			match(LPAR);
			setState(223);
			expression(0);
			setState(224);
			match(RPAR);
			setState(225);
			block();
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(226);
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
			setState(229);
			match(ELSEKW);
			setState(230);
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
			setState(232);
			match(LBRACE);
			setState(233);
			arrIndexList();
			setState(234);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00ef\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\7"+
		"\2%\n\2\f\2\16\2(\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\7\5;\n\5\f\5\16\5>\13\5\3\5\3\5\3\6\3\6\3\6\7"+
		"\6E\n\6\f\6\16\6H\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7T\n"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16\7t\13\7\3\b\3"+
		"\b\3\b\7\by\n\b\f\b\16\b|\13\b\3\t\3\t\3\t\3\t\7\t\u0082\n\t\f\t\16\t"+
		"\u0085\13\t\5\t\u0087\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0090\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a1\n"+
		"\n\3\13\3\13\3\13\3\13\5\13\u00a7\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\7\13\u00b3\n\13\f\13\16\13\u00b6\13\13\3\13\5\13\u00b9"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c1\n\f\f\f\16\f\u00c4\13\f\5\f\u00c6"+
		"\n\f\3\r\3\r\3\r\7\r\u00cb\n\r\f\r\16\r\u00ce\13\r\3\r\5\r\u00d1\n\r\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00d8\n\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e6\n\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\2\3\f\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\t\3"+
		"\2\3\6\3\2\7\b\3\2\3\4\3\2\t\f\3\2\r\16\3\2\5\6\3\2\17\21\2\u0101\2\""+
		"\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b\65\3\2\2\2\nA\3\2\2\2\fS\3\2\2\2\16u"+
		"\3\2\2\2\20\u0086\3\2\2\2\22\u00a0\3\2\2\2\24\u00a2\3\2\2\2\26\u00c5\3"+
		"\2\2\2\30\u00d0\3\2\2\2\32\u00d2\3\2\2\2\34\u00df\3\2\2\2\36\u00e7\3\2"+
		"\2\2 \u00ea\3\2\2\2\"&\5\4\3\2#%\5\b\5\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2"+
		"&\'\3\2\2\2\'\3\3\2\2\2(&\3\2\2\2)*\7\24\2\2*+\7$\2\2+,\7\22\2\2,\5\3"+
		"\2\2\2-\60\7$\2\2./\7\36\2\2/\61\7\37\2\2\60.\3\2\2\2\60\61\3\2\2\2\61"+
		"\62\3\2\2\2\62\63\7$\2\2\63\64\7\22\2\2\64\7\3\2\2\2\65\66\7\25\2\2\66"+
		"\67\7$\2\2\67<\7\32\2\28;\5\6\4\29;\5\24\13\2:8\3\2\2\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\33\2\2@\t\3\2\2\2A"+
		"F\7$\2\2BC\7 \2\2CE\7$\2\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\13"+
		"\3\2\2\2HF\3\2\2\2IJ\b\7\1\2JK\t\2\2\2KT\5\f\7\17LT\5\n\6\2MT\7#\2\2N"+
		"T\5 \21\2OP\7\34\2\2PQ\5\f\7\2QR\7\35\2\2RT\3\2\2\2SI\3\2\2\2SL\3\2\2"+
		"\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2Tr\3\2\2\2UV\f\n\2\2VW\t\3\2\2Wq\5\f\7"+
		"\13XY\f\t\2\2YZ\t\4\2\2Zq\5\f\7\n[\\\f\b\2\2\\]\t\5\2\2]q\5\f\7\t^_\f"+
		"\7\2\2_`\t\6\2\2`q\5\f\7\bab\f\16\2\2bc\7\34\2\2cd\5\20\t\2de\7\35\2\2"+
		"eq\3\2\2\2fg\f\r\2\2gh\7\36\2\2hi\5\16\b\2ij\7\37\2\2jq\3\2\2\2kl\f\f"+
		"\2\2lm\7 \2\2mq\7$\2\2no\f\13\2\2oq\t\7\2\2pU\3\2\2\2pX\3\2\2\2p[\3\2"+
		"\2\2p^\3\2\2\2pa\3\2\2\2pf\3\2\2\2pk\3\2\2\2pn\3\2\2\2qt\3\2\2\2rp\3\2"+
		"\2\2rs\3\2\2\2s\r\3\2\2\2tr\3\2\2\2uz\5\f\7\2vw\7!\2\2wy\5\f\7\2xv\3\2"+
		"\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\17\3\2\2\2|z\3\2\2\2}\u0087\3\2\2"+
		"\2~\u0083\5\f\7\2\177\u0080\7!\2\2\u0080\u0082\5\f\7\2\u0081\177\3\2\2"+
		"\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086}\3\2\2\2\u0086~\3\2\2\2\u0087\21\3"+
		"\2\2\2\u0088\u0089\7\26\2\2\u0089\u008a\5\f\7\2\u008a\u008b\7\22\2\2\u008b"+
		"\u00a1\3\2\2\2\u008c\u008f\7$\2\2\u008d\u008e\7\36\2\2\u008e\u0090\7\37"+
		"\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\7$\2\2\u0092\u0093\7\17\2\2\u0093\u0094\5\f\7\2\u0094\u0095\7\22"+
		"\2\2\u0095\u00a1\3\2\2\2\u0096\u0097\7$\2\2\u0097\u0098\t\b\2\2\u0098"+
		"\u0099\5\f\7\2\u0099\u009a\7\22\2\2\u009a\u00a1\3\2\2\2\u009b\u009c\5"+
		"\f\7\2\u009c\u009d\7\22\2\2\u009d\u00a1\3\2\2\2\u009e\u00a1\5\32\16\2"+
		"\u009f\u00a1\5\34\17\2\u00a0\u0088\3\2\2\2\u00a0\u008c\3\2\2\2\u00a0\u0096"+
		"\3\2\2\2\u00a0\u009b\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\23\3\2\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00a6\7$\2\2\u00a4\u00a5\7\36\2"+
		"\2\u00a5\u00a7\7\37\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\7$\2\2\u00a9\u00aa\7\34\2\2\u00aa\u00ab\5\26"+
		"\f\2\u00ab\u00b8\7\35\2\2\u00ac\u00ad\7\"\2\2\u00ad\u00ae\5\f\7\2\u00ae"+
		"\u00af\7\22\2\2\u00af\u00b9\3\2\2\2\u00b0\u00b4\7\32\2\2\u00b1\u00b3\5"+
		"\22\n\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\7\33"+
		"\2\2\u00b8\u00ac\3\2\2\2\u00b8\u00b0\3\2\2\2\u00b9\25\3\2\2\2\u00ba\u00c6"+
		"\3\2\2\2\u00bb\u00bc\7$\2\2\u00bc\u00c2\7$\2\2\u00bd\u00be\7!\2\2\u00be"+
		"\u00bf\7$\2\2\u00bf\u00c1\7$\2\2\u00c0\u00bd\3\2\2\2\u00c1\u00c4\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00ba\3\2\2\2\u00c5\u00bb\3\2\2\2\u00c6\27\3\2\2\2\u00c7"+
		"\u00d1\5\22\n\2\u00c8\u00cc\7\32\2\2\u00c9\u00cb\5\22\n\2\u00ca\u00c9"+
		"\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\7\33\2\2\u00d0\u00c7\3"+
		"\2\2\2\u00d0\u00c8\3\2\2\2\u00d1\31\3\2\2\2\u00d2\u00d3\7\27\2\2\u00d3"+
		"\u00d4\7\34\2\2\u00d4\u00d7\7$\2\2\u00d5\u00d6\7\36\2\2\u00d6\u00d8\7"+
		"\37\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\7$\2\2\u00da\u00db\7\"\2\2\u00db\u00dc\5\f\7\2\u00dc\u00dd\7\35"+
		"\2\2\u00dd\u00de\5\30\r\2\u00de\33\3\2\2\2\u00df\u00e0\7\30\2\2\u00e0"+
		"\u00e1\7\34\2\2\u00e1\u00e2\5\f\7\2\u00e2\u00e3\7\35\2\2\u00e3\u00e5\5"+
		"\30\r\2\u00e4\u00e6\5\36\20\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2"+
		"\u00e6\35\3\2\2\2\u00e7\u00e8\7\31\2\2\u00e8\u00e9\5\30\r\2\u00e9\37\3"+
		"\2\2\2\u00ea\u00eb\7\32\2\2\u00eb\u00ec\5\16\b\2\u00ec\u00ed\7\33\2\2"+
		"\u00ed!\3\2\2\2\30&\60:<FSprz\u0083\u0086\u008f\u00a0\u00a6\u00b4\u00b8"+
		"\u00c2\u00c5\u00cc\u00d0\u00d7\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}