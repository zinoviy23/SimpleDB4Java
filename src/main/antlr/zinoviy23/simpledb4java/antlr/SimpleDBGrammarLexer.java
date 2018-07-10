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
		DOUBLEDOT=31, CONSTANT=32, ID=33, SKIP_=34;
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
		"LPAR", "RPAR", "LSQBR", "RSQBR", "DOT", "COMMA", "DOUBLEDOT", "CONSTANT", 
		"ID", "SKIP_", "BOOLEAN", "NULL", "INT", "FLOAT", "STRING", "COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'-'", "'+'", "'++'", "'--'", "'*'", "'/'", "'<'", "'>'", "'<='", 
		"'>='", "'=='", "'!='", "'='", "'+='", "'-='", "';'", "'database'", "'class'", 
		"'return'", "'for'", "'if'", "'else'", "'{'", "'}'", "'('", "')'", "'['", 
		"']'", "'.'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "CMDEND", "DATABASEKW", "CLASSKW", "RETURNKW", 
		"FORKW", "IFKW", "ELSEKW", "LBRACE", "RBRACE", "LPAR", "RPAR", "LSQBR", 
		"RSQBR", "DOT", "COMMA", "DOUBLEDOT", "CONSTANT", "ID", "SKIP_"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u010c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3!\3!\3!\5!\u00b7\n!\3\"\3\"\7\"\u00bb\n\"\f\"\16\"\u00be\13\""+
		"\3#\3#\5#\u00c2\n#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u00cf\n$\3%\3%"+
		"\3%\3%\3%\3&\5&\u00d7\n&\3&\3&\7&\u00db\n&\f&\16&\u00de\13&\3&\5&\u00e1"+
		"\n&\3\'\5\'\u00e4\n\'\3\'\3\'\7\'\u00e8\n\'\f\'\16\'\u00eb\13\'\3\'\5"+
		"\'\u00ee\n\'\3\'\3\'\6\'\u00f2\n\'\r\'\16\'\u00f3\3(\3(\7(\u00f8\n(\f"+
		"(\16(\u00fb\13(\3(\3(\3)\3)\3)\3)\7)\u0103\n)\f)\16)\u0106\13)\3*\6*\u0109"+
		"\n*\r*\16*\u010a\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M\2O\2Q\2S\2\3\2\n\5\2C\\aac|"+
		"\6\2\62;C\\aac|\4\2--//\3\2\63;\3\2\62;\5\2\f\f\17\17$$\4\2\f\f\16\17"+
		"\5\2\13\f\17\17\"\"\2\u0116\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7Y\3\2\2\2\t\\\3\2\2\2\13_\3"+
		"\2\2\2\ra\3\2\2\2\17c\3\2\2\2\21e\3\2\2\2\23g\3\2\2\2\25j\3\2\2\2\27m"+
		"\3\2\2\2\31p\3\2\2\2\33s\3\2\2\2\35u\3\2\2\2\37x\3\2\2\2!{\3\2\2\2#}\3"+
		"\2\2\2%\u0086\3\2\2\2\'\u008c\3\2\2\2)\u0093\3\2\2\2+\u0097\3\2\2\2-\u009a"+
		"\3\2\2\2/\u009f\3\2\2\2\61\u00a1\3\2\2\2\63\u00a3\3\2\2\2\65\u00a5\3\2"+
		"\2\2\67\u00a7\3\2\2\29\u00a9\3\2\2\2;\u00ab\3\2\2\2=\u00ad\3\2\2\2?\u00af"+
		"\3\2\2\2A\u00b6\3\2\2\2C\u00b8\3\2\2\2E\u00c1\3\2\2\2G\u00ce\3\2\2\2I"+
		"\u00d0\3\2\2\2K\u00d6\3\2\2\2M\u00e3\3\2\2\2O\u00f5\3\2\2\2Q\u00fe\3\2"+
		"\2\2S\u0108\3\2\2\2UV\7/\2\2V\4\3\2\2\2WX\7-\2\2X\6\3\2\2\2YZ\7-\2\2Z"+
		"[\7-\2\2[\b\3\2\2\2\\]\7/\2\2]^\7/\2\2^\n\3\2\2\2_`\7,\2\2`\f\3\2\2\2"+
		"ab\7\61\2\2b\16\3\2\2\2cd\7>\2\2d\20\3\2\2\2ef\7@\2\2f\22\3\2\2\2gh\7"+
		">\2\2hi\7?\2\2i\24\3\2\2\2jk\7@\2\2kl\7?\2\2l\26\3\2\2\2mn\7?\2\2no\7"+
		"?\2\2o\30\3\2\2\2pq\7#\2\2qr\7?\2\2r\32\3\2\2\2st\7?\2\2t\34\3\2\2\2u"+
		"v\7-\2\2vw\7?\2\2w\36\3\2\2\2xy\7/\2\2yz\7?\2\2z \3\2\2\2{|\7=\2\2|\""+
		"\3\2\2\2}~\7f\2\2~\177\7c\2\2\177\u0080\7v\2\2\u0080\u0081\7c\2\2\u0081"+
		"\u0082\7d\2\2\u0082\u0083\7c\2\2\u0083\u0084\7u\2\2\u0084\u0085\7g\2\2"+
		"\u0085$\3\2\2\2\u0086\u0087\7e\2\2\u0087\u0088\7n\2\2\u0088\u0089\7c\2"+
		"\2\u0089\u008a\7u\2\2\u008a\u008b\7u\2\2\u008b&\3\2\2\2\u008c\u008d\7"+
		"t\2\2\u008d\u008e\7g\2\2\u008e\u008f\7v\2\2\u008f\u0090\7w\2\2\u0090\u0091"+
		"\7t\2\2\u0091\u0092\7p\2\2\u0092(\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095"+
		"\7q\2\2\u0095\u0096\7t\2\2\u0096*\3\2\2\2\u0097\u0098\7k\2\2\u0098\u0099"+
		"\7h\2\2\u0099,\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7n\2\2\u009c\u009d"+
		"\7u\2\2\u009d\u009e\7g\2\2\u009e.\3\2\2\2\u009f\u00a0\7}\2\2\u00a0\60"+
		"\3\2\2\2\u00a1\u00a2\7\177\2\2\u00a2\62\3\2\2\2\u00a3\u00a4\7*\2\2\u00a4"+
		"\64\3\2\2\2\u00a5\u00a6\7+\2\2\u00a6\66\3\2\2\2\u00a7\u00a8\7]\2\2\u00a8"+
		"8\3\2\2\2\u00a9\u00aa\7_\2\2\u00aa:\3\2\2\2\u00ab\u00ac\7\60\2\2\u00ac"+
		"<\3\2\2\2\u00ad\u00ae\7.\2\2\u00ae>\3\2\2\2\u00af\u00b0\7<\2\2\u00b0@"+
		"\3\2\2\2\u00b1\u00b7\5K&\2\u00b2\u00b7\5M\'\2\u00b3\u00b7\5I%\2\u00b4"+
		"\u00b7\5G$\2\u00b5\u00b7\5O(\2\u00b6\u00b1\3\2\2\2\u00b6\u00b2\3\2\2\2"+
		"\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7B\3"+
		"\2\2\2\u00b8\u00bc\t\2\2\2\u00b9\u00bb\t\3\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bdD\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00bf\u00c2\5S*\2\u00c0\u00c2\5Q)\2\u00c1\u00bf\3"+
		"\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b#\2\2\u00c4"+
		"F\3\2\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7w\2\2\u00c8"+
		"\u00cf\7g\2\2\u00c9\u00ca\7h\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7n\2\2"+
		"\u00cc\u00cd\7u\2\2\u00cd\u00cf\7g\2\2\u00ce\u00c5\3\2\2\2\u00ce\u00c9"+
		"\3\2\2\2\u00cfH\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3"+
		"\7n\2\2\u00d3\u00d4\7n\2\2\u00d4J\3\2\2\2\u00d5\u00d7\t\4\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e0\3\2\2\2\u00d8\u00dc\t\5\2\2\u00d9"+
		"\u00db\t\6\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e1\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e1\7\62\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1L\3\2\2\2"+
		"\u00e2\u00e4\t\4\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00ed"+
		"\3\2\2\2\u00e5\u00e9\t\5\2\2\u00e6\u00e8\t\6\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ee\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\7\62\2\2\u00ed\u00e5\3\2\2\2\u00ed"+
		"\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\7\60"+
		"\2\2\u00f0\u00f2\t\6\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4N\3\2\2\2\u00f5\u00f9\7$\2\2\u00f6"+
		"\u00f8\n\7\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fd\7$\2\2\u00fdP\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ff\u0100\7\61\2\2"+
		"\u0100\u0104\3\2\2\2\u0101\u0103\n\b\2\2\u0102\u0101\3\2\2\2\u0103\u0106"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105R\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0109\t\t\2\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010bT\3\2\2\2\21\2\u00b6"+
		"\u00bc\u00c1\u00ce\u00d6\u00dc\u00e0\u00e3\u00e9\u00ed\u00f3\u00f9\u0104"+
		"\u010a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}