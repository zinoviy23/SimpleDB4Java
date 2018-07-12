package zinoviy23.simpledb4java;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarLexer;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.GeneratedClass;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.parsing.SimpleDBGrammarListenerImpl;

import java.io.IOException;
import java.util.BitSet;
import java.util.LinkedList;

/**
 * Main class of application
 */
public class Main {
    /**
     * Enter point of application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(CharStreams.fromFileName("examples/tmp.java"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);

            parser.addErrorListener(new ANTLRErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                    throw new RuntimeException();
                }

                @Override
                public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

                }

                @Override
                public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

                }

                @Override
                public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

                }
            });

            ParseTree syntaxTree = parser.file();
            ParseTreeWalker walker = new ParseTreeWalker();
            LinkedList<GeneratedClass> classes = new LinkedList<>();
            walker.walk(new SimpleDBGrammarListenerImpl(classes), syntaxTree);

            //DBInformation.getInstance().createDBSQLite("jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java",
                   // "org.sqlite.JDBC");
            for (GeneratedClass cl: classes) {
                System.out.println(cl.getGenereatedCode());
                System.out.println(cl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
