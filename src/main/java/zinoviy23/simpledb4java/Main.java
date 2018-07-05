package zinoviy23.simpledb4java;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarLexer;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.parsing.SimpleDBGrammarListenerImpl;

import java.io.IOException;

/**
 * Main class of application
 * @author zinoviy23@gmail.com
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
            ParseTree syntaxTree = parser.file();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new SimpleDBGrammarListenerImpl(), syntaxTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
