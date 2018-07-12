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
		CMDEND=1, DATABASEKW=2, CLASSKW=3, RETURNKW=4, FORKW=5, IFKW=6, ELSEKW=7, 
		LBRACE=8, RBRACE=9, LPAR=10, RPAR=11, LSQBR=12, RSQBR=13, DOT=14, PLUS=15, 
		PLUSPLUS=16, MINUS=17, MINUSMINUS=18, MULT=19, DIV=20, LS=21, GR=22, LE=23, 
		GE=24, EQ=25, NOTEQ=26, ASSIGN=27, PLUSASSIGN=28, MINUSASSIGM=29, OR=30, 
		AND=31, COMMA=32, DOUBLEDOT=33, LEFTARROW=34, BOOLEAN=35, NULL=36, INT=37, 
		FLOAT=38, STRING=39, ID=40, SKIP_=41;
	public static final int
		RULE_file = 0, RULE_fileHeader = 1, RULE_typeId = 2, RULE_fieldDef = 3, 
		RULE_classDef = 4, RULE_unaryExpr = 5, RULE_dottedId = 6, RULE_arrayElementGetting = 7, 
		RULE_expression = 8, RULE_arrIndexList = 9, RULE_unaryOp = 10, RULE_callArgList = 11, 
		RULE_simpleCommand = 12, RULE_queryDef = 13, RULE_funcArgList = 14, RULE_block = 15, 
		RULE_forCycle = 16, RULE_ifStatement = 17, RULE_elseBlock = 18, RULE_array = 19, 
		RULE_constant = 20;
	public static final String[] ruleNames = {
		"file", "fileHeader", "typeId", "fieldDef", "classDef", "unaryExpr", "dottedId", 
		"arrayElementGetting", "expression", "arrIndexList", "unaryOp", "callArgList", 
		"simpleCommand", "queryDef", "funcArgList", "block", "forCycle", "ifStatement", 
		"elseBlock", "array", "constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'database'", "'class'", "'return'", "'for'", "'if'", "'else'", 
		"'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'+'", "'++'", "'-'", 
		"'--'", "'*'", "'/'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'='", 
		"'+='", "'-='", "'||'", "'&&'", "','", "':'", "'->'", null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CMDEND", "DATABASEKW", "CLASSKW", "RETURNKW", "FORKW", "IFKW", 
		"ELSEKW", "LBRACE", "RBRACE", "LPAR", "RPAR", "LSQBR", "RSQBR", "DOT", 
		"PLUS", "PLUSPLUS", "MINUS", "MINUSMINUS", "MULT", "DIV", "LS", "GR", 
		"LE", "GE", "EQ", "NOTEQ", "ASSIGN", "PLUSASSIGN", "MINUSASSIGM", "OR", 
		"AND", "COMMA", "DOUBLEDOT", "LEFTARROW", "BOOLEAN", "NULL", "INT", "FLOAT", 
		"STRING", "ID", "SKIP_"
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


	// table for classes
	public static final java.util.Set<String> classesSymbolTable = new java.util.HashSet<>();

	// table for fields
	public static final java.util.Map<String, java.util.Map<String, String>> fieldsSymbolTable = new java.util.HashMap<>();

	// table for fields name with first lower case latter
	public static final java.util.Map<String, java.util.Set<String>> lowerCaseFieldsSymbolTable = new java.util.HashMap<>();

	public static String firstLatterToLowerCase(String str) {
	    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
	}

	// class for methods
	public static class MethodInfo {
	    public final String type;

	    public final String name;

	    public final boolean isStatic;

	    public final java.util.LinkedHashMap<String, String> arguments;

	    public MethodInfo(String type, String name, boolean isStatic, java.util.LinkedHashMap<String, String> arguments) {
	        this.name = name;
	        this.type = type;
	        this.arguments = arguments;
	        this.isStatic = isStatic;
	    }

	    @Override
	    public String toString() {
	        return "{type=" + type + ", name=" + name + ", isStatic=" + isStatic + ", arguments=" + arguments +"}";
	    }
	}

	// table for methods
	public static final java.util.Map<String, java.util.Map<String, MethodInfo>> methodsSymbolTable = new java.util.HashMap<>();

	// clears tables
	public static void clearSymbolTables() {
	    classesSymbolTable.clear();
	    fieldsSymbolTable.clear();
	    lowerCaseFieldsSymbolTable.clear();
	    methodsSymbolTable.clear();
	}

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
			setState(42);
			fileHeader();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASSKW) {
				{
				{
				setState(43);
				classDef();
				}
				}
				setState(48);
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
			setState(49);
			match(DATABASEKW);
			setState(50);
			match(ID);
			setState(51);
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

	public static class TypeIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public TypeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitTypeId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdContext typeId() throws RecognitionException {
		TypeIdContext _localctx = new TypeIdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(ID);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQBR) {
				{
				setState(54);
				match(LSQBR);
				setState(55);
				match(RSQBR);
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

	public static class FieldDefContext extends ParserRuleContext {
		public String className;
		public TypeIdContext typeId;
		public Token a;
		public TypeIdContext typeId() {
			return getRuleContext(TypeIdContext.class,0);
		}
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public FieldDefContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FieldDefContext(ParserRuleContext parent, int invokingState, String className) {
			super(parent, invokingState);
			this.className = className;
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

	public final FieldDefContext fieldDef(String className) throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState(), className);
		enterRule(_localctx, 6, RULE_fieldDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			((FieldDefContext)_localctx).typeId = typeId();
			setState(59);
			((FieldDefContext)_localctx).a = match(ID);
			setState(60);
			match(CMDEND);

			if (!fieldsSymbolTable.containsKey(_localctx.className))
			    fieldsSymbolTable.put(_localctx.className, new java.util.LinkedHashMap<>());
			if (fieldsSymbolTable.get(_localctx.className).containsKey((((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null))) {
			    throw new RuntimeException(String.format("Two fields with same inditificators (%s) in class %s. Line %d",
			        (((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null), _localctx.className, (((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getLine():0)));
			}
			fieldsSymbolTable.get(_localctx.className).put((((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null), (((FieldDefContext)_localctx).typeId!=null?_input.getText(((FieldDefContext)_localctx).typeId.start,((FieldDefContext)_localctx).typeId.stop):null));

			if (!lowerCaseFieldsSymbolTable.containsKey(_localctx.className))
			    lowerCaseFieldsSymbolTable.put(_localctx.className, new java.util.LinkedHashSet<>());

			if (lowerCaseFieldsSymbolTable.get(_localctx.className).contains(firstLatterToLowerCase((((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null)))) {
			    throw new RuntimeException(String.format("Two fields with same inditificators with first latter in lower case (%s) in class %s. Line %d",
			            firstLatterToLowerCase((((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null)), _localctx.className, (((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getLine():0)));
			}
			lowerCaseFieldsSymbolTable.get(_localctx.className).add(firstLatterToLowerCase((((FieldDefContext)_localctx).a!=null?((FieldDefContext)_localctx).a.getText():null)));

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
		public Token ID;
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
		enterRule(_localctx, 8, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(CLASSKW);
			setState(64);
			((ClassDefContext)_localctx).ID = match(ID);
			setState(65);
			match(LBRACE);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(66);
					fieldDef((((ClassDefContext)_localctx).ID!=null?((ClassDefContext)_localctx).ID.getText():null));
					}
					break;
				case 2:
					{
					setState(67);
					queryDef((((ClassDefContext)_localctx).ID!=null?((ClassDefContext)_localctx).ID.getText():null));
					}
					break;
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(RBRACE);
			classesSymbolTable.add((((ClassDefContext)_localctx).ID!=null?((ClassDefContext)_localctx).ID.getText():null));
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

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unaryExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			unaryOp();
			setState(77);
			expression(0);
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
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public CallArgListContext callArgList() {
			return getRuleContext(CallArgListContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public TerminalNode DOT() { return getToken(SimpleDBGrammarParser.DOT, 0); }
		public DottedIdContext dottedId() {
			return getRuleContext(DottedIdContext.class,0);
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
		enterRule(_localctx, 12, RULE_dottedId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(80);
				match(LPAR);
				setState(81);
				callArgList();
				setState(82);
				match(RPAR);
				}
				break;
			}
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(86);
				match(DOT);
				setState(87);
				dottedId();
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

	public static class ArrayElementGettingContext extends ParserRuleContext {
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public DottedIdContext dottedId() {
			return getRuleContext(DottedIdContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayElementGettingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElementGetting; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterArrayElementGetting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitArrayElementGetting(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitArrayElementGetting(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElementGettingContext arrayElementGetting() throws RecognitionException {
		ArrayElementGettingContext _localctx = new ArrayElementGettingContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayElementGetting);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(90);
				dottedId();
				}
				break;
			case LBRACE:
				{
				setState(91);
				array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(94);
			match(LSQBR);
			setState(95);
			expression(0);
			setState(96);
			match(RSQBR);
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
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public ArrayElementGettingContext arrayElementGetting() {
			return getRuleContext(ArrayElementGettingContext.class,0);
		}
		public DottedIdContext dottedId() {
			return getRuleContext(DottedIdContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public TerminalNode MULT() { return getToken(SimpleDBGrammarParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SimpleDBGrammarParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SimpleDBGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SimpleDBGrammarParser.MINUS, 0); }
		public TerminalNode LS() { return getToken(SimpleDBGrammarParser.LS, 0); }
		public TerminalNode GR() { return getToken(SimpleDBGrammarParser.GR, 0); }
		public TerminalNode LE() { return getToken(SimpleDBGrammarParser.LE, 0); }
		public TerminalNode GE() { return getToken(SimpleDBGrammarParser.GE, 0); }
		public TerminalNode EQ() { return getToken(SimpleDBGrammarParser.EQ, 0); }
		public TerminalNode NOTEQ() { return getToken(SimpleDBGrammarParser.NOTEQ, 0); }
		public TerminalNode AND() { return getToken(SimpleDBGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(SimpleDBGrammarParser.OR, 0); }
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(99);
				unaryExpr();
				}
				break;
			case 2:
				{
				setState(100);
				arrayElementGetting();
				}
				break;
			case 3:
				{
				setState(101);
				dottedId();
				}
				break;
			case 4:
				{
				setState(102);
				constant();
				}
				break;
			case 5:
				{
				setState(103);
				array();
				}
				break;
			case 6:
				{
				setState(104);
				match(LPAR);
				setState(105);
				expression(0);
				setState(106);
				match(RPAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(128);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(111);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(114);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(115);
						expression(10);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(117);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LS) | (1L << GR) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(120);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NOTEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(123);
						match(AND);
						setState(124);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(126);
						match(OR);
						setState(127);
						expression(6);
						}
						break;
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 18, RULE_arrIndexList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			expression(0);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(134);
				match(COMMA);
				setState(135);
				expression(0);
				}
				}
				setState(140);
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

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SimpleDBGrammarParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SimpleDBGrammarParser.PLUS, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		enterRule(_localctx, 22, RULE_callArgList);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case LBRACE:
			case LPAR:
			case PLUS:
			case MINUS:
			case BOOLEAN:
			case NULL:
			case INT:
			case FLOAT:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				expression(0);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(145);
					match(COMMA);
					setState(146);
					expression(0);
					}
					}
					setState(151);
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
		public TerminalNode ASSIGN() { return getToken(SimpleDBGrammarParser.ASSIGN, 0); }
		public TerminalNode LSQBR() { return getToken(SimpleDBGrammarParser.LSQBR, 0); }
		public TerminalNode RSQBR() { return getToken(SimpleDBGrammarParser.RSQBR, 0); }
		public TerminalNode PLUSASSIGN() { return getToken(SimpleDBGrammarParser.PLUSASSIGN, 0); }
		public TerminalNode MINUSASSIGM() { return getToken(SimpleDBGrammarParser.MINUSASSIGM, 0); }
		public DottedIdContext dottedId() {
			return getRuleContext(DottedIdContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_simpleCommand);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(RETURNKW);
				setState(155);
				expression(0);
				setState(156);
				match(CMDEND);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(ID);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQBR) {
					{
					setState(159);
					match(LSQBR);
					setState(160);
					match(RSQBR);
					}
				}

				setState(163);
				match(ID);
				setState(164);
				match(ASSIGN);
				setState(165);
				expression(0);
				setState(166);
				match(CMDEND);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(ID);
				setState(169);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGN) | (1L << PLUSASSIGN) | (1L << MINUSASSIGM))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				expression(0);
				setState(171);
				match(CMDEND);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				dottedId();
				setState(174);
				match(CMDEND);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				forCycle();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
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
		public String className;
		public TypeIdContext typeId;
		public Token ID;
		public FuncArgListContext funcArgList;
		public TypeIdContext typeId() {
			return getRuleContext(TypeIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public FuncArgListContext funcArgList() {
			return getRuleContext(FuncArgListContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public TerminalNode LEFTARROW() { return getToken(SimpleDBGrammarParser.LEFTARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CMDEND() { return getToken(SimpleDBGrammarParser.CMDEND, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleDBGrammarParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleDBGrammarParser.RBRACE, 0); }
		public List<SimpleCommandContext> simpleCommand() {
			return getRuleContexts(SimpleCommandContext.class);
		}
		public SimpleCommandContext simpleCommand(int i) {
			return getRuleContext(SimpleCommandContext.class,i);
		}
		public QueryDefContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public QueryDefContext(ParserRuleContext parent, int invokingState, String className) {
			super(parent, invokingState);
			this.className = className;
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

	public final QueryDefContext queryDef(String className) throws RecognitionException {
		QueryDefContext _localctx = new QueryDefContext(_ctx, getState(), className);
		enterRule(_localctx, 26, RULE_queryDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			((QueryDefContext)_localctx).typeId = typeId();
			setState(181);
			((QueryDefContext)_localctx).ID = match(ID);
			setState(182);
			match(LPAR);
			setState(183);
			((QueryDefContext)_localctx).funcArgList = funcArgList();
			setState(184);
			match(RPAR);
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFTARROW:
				{
				setState(185);
				match(LEFTARROW);
				setState(186);
				expression(0);
				setState(187);
				match(CMDEND);
				}
				break;
			case LBRACE:
				{
				setState(189);
				match(LBRACE);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << ID))) != 0)) {
					{
					{
					setState(190);
					simpleCommand();
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			java.util.LinkedHashMap<String, String> arguments = new java.util.LinkedHashMap<>();
			for (int i = 0; i < ((QueryDefContext)_localctx).funcArgList.ID().size(); i++) {
			    if (arguments.containsKey(((QueryDefContext)_localctx).funcArgList.ID(i).getText()))
			        throw new RuntimeException(String.format("Two arguments with same inditificators (%s) in class %s in method %s. Line %d",
			                ((QueryDefContext)_localctx).funcArgList.ID(i).getText(), _localctx.className, (((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getText():null), (((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getLine():0)));

			    arguments.put(((QueryDefContext)_localctx).funcArgList.ID(i).getText(), ((QueryDefContext)_localctx).funcArgList.typeId(i).getText());
			}

			if (!methodsSymbolTable.containsKey(_localctx.className))
			    methodsSymbolTable.put(_localctx.className, new java.util.HashMap<>());

			if (methodsSymbolTable.get(_localctx.className).containsKey((((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getText():null)))
			    throw new RuntimeException(String.format("Two methods with same inditificators (%s) in class %s. Line %d",
			                    (((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getText():null), _localctx.className, (((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getLine():0)));

			methodsSymbolTable.get(_localctx.className).put((((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getText():null), new MethodInfo((((QueryDefContext)_localctx).typeId!=null?_input.getText(((QueryDefContext)_localctx).typeId.start,((QueryDefContext)_localctx).typeId.stop):null), (((QueryDefContext)_localctx).ID!=null?((QueryDefContext)_localctx).ID.getText():null), true, arguments));

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
		public List<TypeIdContext> typeId() {
			return getRuleContexts(TypeIdContext.class);
		}
		public TypeIdContext typeId(int i) {
			return getRuleContext(TypeIdContext.class,i);
		}
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
		enterRule(_localctx, 28, RULE_funcArgList);
		int _la;
		try {
			setState(213);
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
				setState(202);
				typeId();
				setState(203);
				match(ID);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(204);
					match(COMMA);
					setState(205);
					typeId();
					setState(206);
					match(ID);
					}
					}
					setState(212);
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
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURNKW:
			case FORKW:
			case IFKW:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				simpleCommand();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(LBRACE);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURNKW) | (1L << FORKW) | (1L << IFKW) | (1L << ID))) != 0)) {
					{
					{
					setState(217);
					simpleCommand();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223);
				match(RBRACE);
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

	public static class ForCycleContext extends ParserRuleContext {
		public TerminalNode FORKW() { return getToken(SimpleDBGrammarParser.FORKW, 0); }
		public TerminalNode LPAR() { return getToken(SimpleDBGrammarParser.LPAR, 0); }
		public TypeIdContext typeId() {
			return getRuleContext(TypeIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleDBGrammarParser.ID, 0); }
		public TerminalNode DOUBLEDOT() { return getToken(SimpleDBGrammarParser.DOUBLEDOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleDBGrammarParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_forCycle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(FORKW);
			setState(227);
			match(LPAR);
			setState(228);
			typeId();
			setState(229);
			match(ID);
			setState(230);
			match(DOUBLEDOT);
			setState(231);
			expression(0);
			setState(232);
			match(RPAR);
			setState(233);
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
		enterRule(_localctx, 34, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(IFKW);
			setState(236);
			match(LPAR);
			setState(237);
			expression(0);
			setState(238);
			match(RPAR);
			setState(239);
			block();
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(240);
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
		enterRule(_localctx, 36, RULE_elseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(ELSEKW);
			setState(244);
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
		enterRule(_localctx, 38, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(LBRACE);
			setState(247);
			arrIndexList();
			setState(248);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(SimpleDBGrammarParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(SimpleDBGrammarParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SimpleDBGrammarParser.FLOAT, 0); }
		public TerminalNode STRING() { return getToken(SimpleDBGrammarParser.STRING, 0); }
		public TerminalNode NULL() { return getToken(SimpleDBGrammarParser.NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleDBGrammarListener ) ((SimpleDBGrammarListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleDBGrammarVisitor ) return ((SimpleDBGrammarVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << NULL) | (1L << INT) | (1L << FLOAT) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00ff\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\7\2/\n\2\f\2\16\2\62"+
		"\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\5\bW\n\b\3\b\3\b\5\b[\n\b\3\t\3\t\5\t_\n\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\no\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0083\n\n\f\n"+
		"\16\n\u0086\13\n\3\13\3\13\3\13\7\13\u008b\n\13\f\13\16\13\u008e\13\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\5\r\u009b\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a4\n\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b5"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00c2"+
		"\n\17\f\17\16\17\u00c5\13\17\3\17\5\17\u00c8\n\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00d3\n\20\f\20\16\20\u00d6\13\20\5\20"+
		"\u00d8\n\20\3\21\3\21\3\21\7\21\u00dd\n\21\f\21\16\21\u00e0\13\21\3\21"+
		"\5\21\u00e3\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00f4\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\2\3\22\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*\2\b\3\2\25\26\4\2\21\21\23\23\3\2\27\32\3\2\33\34\3\2\35\37\3\2%)\2"+
		"\u010b\2,\3\2\2\2\4\63\3\2\2\2\6\67\3\2\2\2\b<\3\2\2\2\nA\3\2\2\2\fN\3"+
		"\2\2\2\16Q\3\2\2\2\20^\3\2\2\2\22n\3\2\2\2\24\u0087\3\2\2\2\26\u008f\3"+
		"\2\2\2\30\u009a\3\2\2\2\32\u00b4\3\2\2\2\34\u00b6\3\2\2\2\36\u00d7\3\2"+
		"\2\2 \u00e2\3\2\2\2\"\u00e4\3\2\2\2$\u00ed\3\2\2\2&\u00f5\3\2\2\2(\u00f8"+
		"\3\2\2\2*\u00fc\3\2\2\2,\60\5\4\3\2-/\5\n\6\2.-\3\2\2\2/\62\3\2\2\2\60"+
		".\3\2\2\2\60\61\3\2\2\2\61\3\3\2\2\2\62\60\3\2\2\2\63\64\7\4\2\2\64\65"+
		"\7*\2\2\65\66\7\3\2\2\66\5\3\2\2\2\67:\7*\2\289\7\16\2\29;\7\17\2\2:8"+
		"\3\2\2\2:;\3\2\2\2;\7\3\2\2\2<=\5\6\4\2=>\7*\2\2>?\7\3\2\2?@\b\5\1\2@"+
		"\t\3\2\2\2AB\7\5\2\2BC\7*\2\2CH\7\n\2\2DG\5\b\5\2EG\5\34\17\2FD\3\2\2"+
		"\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\13"+
		"\2\2LM\b\6\1\2M\13\3\2\2\2NO\5\26\f\2OP\5\22\n\2P\r\3\2\2\2QV\7*\2\2R"+
		"S\7\f\2\2ST\5\30\r\2TU\7\r\2\2UW\3\2\2\2VR\3\2\2\2VW\3\2\2\2WZ\3\2\2\2"+
		"XY\7\20\2\2Y[\5\16\b\2ZX\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\_\5\16\b\2]_\5"+
		"(\25\2^\\\3\2\2\2^]\3\2\2\2_`\3\2\2\2`a\7\16\2\2ab\5\22\n\2bc\7\17\2\2"+
		"c\21\3\2\2\2de\b\n\1\2eo\5\f\7\2fo\5\20\t\2go\5\16\b\2ho\5*\26\2io\5("+
		"\25\2jk\7\f\2\2kl\5\22\n\2lm\7\r\2\2mo\3\2\2\2nd\3\2\2\2nf\3\2\2\2ng\3"+
		"\2\2\2nh\3\2\2\2ni\3\2\2\2nj\3\2\2\2o\u0084\3\2\2\2pq\f\f\2\2qr\t\2\2"+
		"\2r\u0083\5\22\n\rst\f\13\2\2tu\t\3\2\2u\u0083\5\22\n\fvw\f\n\2\2wx\t"+
		"\4\2\2x\u0083\5\22\n\13yz\f\t\2\2z{\t\5\2\2{\u0083\5\22\n\n|}\f\b\2\2"+
		"}~\7!\2\2~\u0083\5\22\n\t\177\u0080\f\7\2\2\u0080\u0081\7 \2\2\u0081\u0083"+
		"\5\22\n\b\u0082p\3\2\2\2\u0082s\3\2\2\2\u0082v\3\2\2\2\u0082y\3\2\2\2"+
		"\u0082|\3\2\2\2\u0082\177\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\23\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008c"+
		"\5\22\n\2\u0088\u0089\7\"\2\2\u0089\u008b\5\22\n\2\u008a\u0088\3\2\2\2"+
		"\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\25"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\t\3\2\2\u0090\27\3\2\2\2\u0091"+
		"\u009b\3\2\2\2\u0092\u0097\5\22\n\2\u0093\u0094\7\"\2\2\u0094\u0096\5"+
		"\22\n\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u0091\3\2"+
		"\2\2\u009a\u0092\3\2\2\2\u009b\31\3\2\2\2\u009c\u009d\7\6\2\2\u009d\u009e"+
		"\5\22\n\2\u009e\u009f\7\3\2\2\u009f\u00b5\3\2\2\2\u00a0\u00a3\7*\2\2\u00a1"+
		"\u00a2\7\16\2\2\u00a2\u00a4\7\17\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6\u00a7\7\35\2\2\u00a7"+
		"\u00a8\5\22\n\2\u00a8\u00a9\7\3\2\2\u00a9\u00b5\3\2\2\2\u00aa\u00ab\7"+
		"*\2\2\u00ab\u00ac\t\6\2\2\u00ac\u00ad\5\22\n\2\u00ad\u00ae\7\3\2\2\u00ae"+
		"\u00b5\3\2\2\2\u00af\u00b0\5\16\b\2\u00b0\u00b1\7\3\2\2\u00b1\u00b5\3"+
		"\2\2\2\u00b2\u00b5\5\"\22\2\u00b3\u00b5\5$\23\2\u00b4\u009c\3\2\2\2\u00b4"+
		"\u00a0\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b3\3\2\2\2\u00b5\33\3\2\2\2\u00b6\u00b7\5\6\4\2\u00b7\u00b8"+
		"\7*\2\2\u00b8\u00b9\7\f\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00c7\7\r\2\2"+
		"\u00bb\u00bc\7$\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00be\7\3\2\2\u00be\u00c8"+
		"\3\2\2\2\u00bf\u00c3\7\n\2\2\u00c0\u00c2\5\32\16\2\u00c1\u00c0\3\2\2\2"+
		"\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\7\13\2\2\u00c7\u00bb\3\2\2\2"+
		"\u00c7\u00bf\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\17\1\2\u00ca\35"+
		"\3\2\2\2\u00cb\u00d8\3\2\2\2\u00cc\u00cd\5\6\4\2\u00cd\u00d4\7*\2\2\u00ce"+
		"\u00cf\7\"\2\2\u00cf\u00d0\5\6\4\2\u00d0\u00d1\7*\2\2\u00d1\u00d3\3\2"+
		"\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00cb\3\2"+
		"\2\2\u00d7\u00cc\3\2\2\2\u00d8\37\3\2\2\2\u00d9\u00e3\5\32\16\2\u00da"+
		"\u00de\7\n\2\2\u00db\u00dd\5\32\16\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e3\7\13\2\2\u00e2\u00d9\3\2\2\2\u00e2\u00da\3"+
		"\2\2\2\u00e3!\3\2\2\2\u00e4\u00e5\7\7\2\2\u00e5\u00e6\7\f\2\2\u00e6\u00e7"+
		"\5\6\4\2\u00e7\u00e8\7*\2\2\u00e8\u00e9\7#\2\2\u00e9\u00ea\5\22\n\2\u00ea"+
		"\u00eb\7\r\2\2\u00eb\u00ec\5 \21\2\u00ec#\3\2\2\2\u00ed\u00ee\7\b\2\2"+
		"\u00ee\u00ef\7\f\2\2\u00ef\u00f0\5\22\n\2\u00f0\u00f1\7\r\2\2\u00f1\u00f3"+
		"\5 \21\2\u00f2\u00f4\5&\24\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"%\3\2\2\2\u00f5\u00f6\7\t\2\2\u00f6\u00f7\5 \21\2\u00f7\'\3\2\2\2\u00f8"+
		"\u00f9\7\n\2\2\u00f9\u00fa\5\24\13\2\u00fa\u00fb\7\13\2\2\u00fb)\3\2\2"+
		"\2\u00fc\u00fd\t\7\2\2\u00fd+\3\2\2\2\30\60:FHVZ^n\u0082\u0084\u008c\u0097"+
		"\u009a\u00a3\u00b4\u00c3\u00c7\u00d4\u00d7\u00de\u00e2\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}