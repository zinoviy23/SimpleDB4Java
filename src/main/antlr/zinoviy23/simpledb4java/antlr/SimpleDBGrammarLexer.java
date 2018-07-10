// Generated from /home/sanusha/Proga/SimpleDB4Java/src/main/antlr/SimpleDBGrammar.g4 by ANTLR 4.7
package zinoviy23.simpledb4java.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleDBGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, CMDEND=16, 
		DATABASEKW=17, CLASSKW=18, RETURNKW=19, FORKW=20, IFKW=21, ELSEKW=22, 
		LBRACE=23, RBRACE=24, LPAR=25, RPAR=26, LSQBR=27, RSQBR=28, DOT=29, COMMA=30, 
		DOUBLEDOT=31, LEFTARROW=32, CONSTANT=33, ID=34, SKIP_=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "CMDEND", "DATABASEKW", 
		"CLASSKW", "RETURNKW", "FORKW", "IFKW", "ELSEKW", "LBRACE", "RBRACE", 
		"LPAR", "RPAR", "LSQBR", "RSQBR", "DOT", "COMMA", "DOUBLEDOT", "LEFTARROW", 
		"CONSTANT", "ID", "SKIP_", "BOOLEAN", "NULL", "INT", "FLOAT", "STRING", 
		"COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'+'", "'++'", "'--'", "'*'", "'/'", "'<'", "'>'", "'<='", 
		"'>='", "'=='", "'!='", "'='", "'+='", "'-='", "';'", "'database'", "'class'", 
		"'return'", "'for'", "'if'", "'else'", "'{'", "'}'", "'('", "')'", "'['", 
		"']'", "'.'", "','", "':'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "CMDEND", "DATABASEKW", "CLASSKW", "RETURNKW", 
		"FORKW", "IFKW", "ELSEKW", "LBRACE", "RBRACE", "LPAR", "RPAR", "LSQBR", 
		"RSQBR", "DOT", "COMMA", "DOUBLEDOT", "LEFTARROW", "CONSTANT", "ID", "SKIP_"
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


	public SimpleDBGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleDBGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0111\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\5\"\u00bc\n\"\3#\3#\7#\u00c0\n#\f"+
		"#\16#\u00c3\13#\3$\3$\5$\u00c7\n$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%"+
		"\u00d4\n%\3&\3&\3&\3&\3&\3\'\5\'\u00dc\n\'\3\'\3\'\7\'\u00e0\n\'\f\'\16"+
		"\'\u00e3\13\'\3\'\5\'\u00e6\n\'\3(\5(\u00e9\n(\3(\3(\7(\u00ed\n(\f(\16"+
		"(\u00f0\13(\3(\5(\u00f3\n(\3(\3(\6(\u00f7\n(\r(\16(\u00f8\3)\3)\7)\u00fd"+
		"\n)\f)\16)\u0100\13)\3)\3)\3*\3*\3*\3*\7*\u0108\n*\f*\16*\u010b\13*\3"+
		"+\6+\u010e\n+\r+\16+\u010f\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K\2M\2O\2Q\2S\2U\2\3\2"+
		"\n\5\2C\\aac|\6\2\62;C\\aac|\4\2--//\3\2\63;\3\2\62;\5\2\f\f\17\17$$\4"+
		"\2\f\f\16\17\5\2\13\f\17\17\"\"\2\u011b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7[\3"+
		"\2\2\2\t^\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3"+
		"\2\2\2\25l\3\2\2\2\27o\3\2\2\2\31r\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37"+
		"z\3\2\2\2!}\3\2\2\2#\177\3\2\2\2%\u0088\3\2\2\2\'\u008e\3\2\2\2)\u0095"+
		"\3\2\2\2+\u0099\3\2\2\2-\u009c\3\2\2\2/\u00a1\3\2\2\2\61\u00a3\3\2\2\2"+
		"\63\u00a5\3\2\2\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00ab\3\2\2\2;\u00ad"+
		"\3\2\2\2=\u00af\3\2\2\2?\u00b1\3\2\2\2A\u00b3\3\2\2\2C\u00bb\3\2\2\2E"+
		"\u00bd\3\2\2\2G\u00c6\3\2\2\2I\u00d3\3\2\2\2K\u00d5\3\2\2\2M\u00db\3\2"+
		"\2\2O\u00e8\3\2\2\2Q\u00fa\3\2\2\2S\u0103\3\2\2\2U\u010d\3\2\2\2WX\7/"+
		"\2\2X\4\3\2\2\2YZ\7-\2\2Z\6\3\2\2\2[\\\7-\2\2\\]\7-\2\2]\b\3\2\2\2^_\7"+
		"/\2\2_`\7/\2\2`\n\3\2\2\2ab\7,\2\2b\f\3\2\2\2cd\7\61\2\2d\16\3\2\2\2e"+
		"f\7>\2\2f\20\3\2\2\2gh\7@\2\2h\22\3\2\2\2ij\7>\2\2jk\7?\2\2k\24\3\2\2"+
		"\2lm\7@\2\2mn\7?\2\2n\26\3\2\2\2op\7?\2\2pq\7?\2\2q\30\3\2\2\2rs\7#\2"+
		"\2st\7?\2\2t\32\3\2\2\2uv\7?\2\2v\34\3\2\2\2wx\7-\2\2xy\7?\2\2y\36\3\2"+
		"\2\2z{\7/\2\2{|\7?\2\2| \3\2\2\2}~\7=\2\2~\"\3\2\2\2\177\u0080\7f\2\2"+
		"\u0080\u0081\7c\2\2\u0081\u0082\7v\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7d\2\2\u0084\u0085\7c\2\2\u0085\u0086\7u\2\2\u0086\u0087\7g\2\2\u0087"+
		"$\3\2\2\2\u0088\u0089\7e\2\2\u0089\u008a\7n\2\2\u008a\u008b\7c\2\2\u008b"+
		"\u008c\7u\2\2\u008c\u008d\7u\2\2\u008d&\3\2\2\2\u008e\u008f\7t\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091\u0092\7w\2\2\u0092\u0093\7t\2\2"+
		"\u0093\u0094\7p\2\2\u0094(\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7q\2"+
		"\2\u0097\u0098\7t\2\2\u0098*\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7"+
		"h\2\2\u009b,\3\2\2\2\u009c\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f"+
		"\7u\2\2\u009f\u00a0\7g\2\2\u00a0.\3\2\2\2\u00a1\u00a2\7}\2\2\u00a2\60"+
		"\3\2\2\2\u00a3\u00a4\7\177\2\2\u00a4\62\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6"+
		"\64\3\2\2\2\u00a7\u00a8\7+\2\2\u00a8\66\3\2\2\2\u00a9\u00aa\7]\2\2\u00aa"+
		"8\3\2\2\2\u00ab\u00ac\7_\2\2\u00ac:\3\2\2\2\u00ad\u00ae\7\60\2\2\u00ae"+
		"<\3\2\2\2\u00af\u00b0\7.\2\2\u00b0>\3\2\2\2\u00b1\u00b2\7<\2\2\u00b2@"+
		"\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4\u00b5\7@\2\2\u00b5B\3\2\2\2\u00b6\u00bc"+
		"\5M\'\2\u00b7\u00bc\5O(\2\u00b8\u00bc\5K&\2\u00b9\u00bc\5I%\2\u00ba\u00bc"+
		"\5Q)\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bcD\3\2\2\2\u00bd\u00c1\t\2\2\2"+
		"\u00be\u00c0\t\3\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2F\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c7\5U+\2\u00c5\u00c7\5S*\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b$\2\2\u00c9H\3\2\2\2\u00ca\u00cb\7v"+
		"\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7w\2\2\u00cd\u00d4\7g\2\2\u00ce\u00cf"+
		"\7h\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7u\2\2\u00d2"+
		"\u00d4\7g\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d4J\3\2\2\2\u00d5"+
		"\u00d6\7p\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7n\2\2"+
		"\u00d9L\3\2\2\2\u00da\u00dc\t\4\2\2\u00db\u00da\3\2\2\2\u00db\u00dc\3"+
		"\2\2\2\u00dc\u00e5\3\2\2\2\u00dd\u00e1\t\5\2\2\u00de\u00e0\t\6\2\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e6\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6\7\62\2\2\u00e5"+
		"\u00dd\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6N\3\2\2\2\u00e7\u00e9\t\4\2\2"+
		"\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f2\3\2\2\2\u00ea\u00ee"+
		"\t\5\2\2\u00eb\u00ed\t\6\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f1\u00f3\7\62\2\2\u00f2\u00ea\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\7\60\2\2\u00f5\u00f7\t"+
		"\6\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8"+
		"\u00f9\3\2\2\2\u00f9P\3\2\2\2\u00fa\u00fe\7$\2\2\u00fb\u00fd\n\7\2\2\u00fc"+
		"\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7$\2\2\u0102"+
		"R\3\2\2\2\u0103\u0104\7\61\2\2\u0104\u0105\7\61\2\2\u0105\u0109\3\2\2"+
		"\2\u0106\u0108\n\b\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010aT\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010e\t\t\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u010f\u0110\3\2\2\2\u0110V\3\2\2\2\21\2\u00bb\u00c1\u00c6\u00d3\u00db"+
		"\u00e1\u00e5\u00e8\u00ee\u00f2\u00f8\u00fe\u0109\u010f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}