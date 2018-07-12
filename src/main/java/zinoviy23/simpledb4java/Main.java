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

import java.io.File;
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
            if (args.length < 1)
                throw new RuntimeException("Needs path to file!");

            String fileName = System.getProperty("user.dir") +"/" + args[0];

            SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(CharStreams.fromFileName(fileName));
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

            String pathToDB = System.getProperty("user.dir") + "/" + DBInformation.getInstance().getDbName();
            FileUtils.createDirectory("db");
            String dbPath = System.getProperty("user.dir") + "/db/";

            File mainPath;
            if (args.length <= 1 || !args[1].equals("-in-idea")) {
                mainPath = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParentFile();
                FileUtils.copyFiles(  mainPath.getAbsolutePath() + "/res/Executor.java",
                        dbPath + "Executor.java");
                FileUtils.copyFiles( mainPath.getAbsolutePath() + "/res/ResultHandler.java",
                        dbPath + "ResultHandler.java");
                FileUtils.copyFormat(mainPath.getAbsolutePath() + "/res/DBService.java",
                        dbPath + "DBService.java", pathToDB);



                if (args.length <= 1 || !args[1].equals("-no-db")) {
                    FileUtils.copyFiles(  mainPath.getAbsolutePath() + "/res/sqlite-jdbc-3.23.1.jar",
                            System.getProperty("user.dir") + "/sqlite-jdbc-3.23.1.jar");

                    DBInformation.getInstance().createDBSQLite("jdbc:sqlite:" + System.getProperty("user.dir"), "org.sqlite.JDBC");
                }

            } else {
                FileUtils.copyFiles(  "res/Executor.java", dbPath + "Executor.java");
                FileUtils.copyFiles( "res/ResultHandler.java",
                        dbPath + "ResultHandler.java");
                FileUtils.copyFormat("res/DBService.java", dbPath + "DBService.java", pathToDB);
            }

            for (GeneratedClass cl: classes) {
                FileUtils.writeToFile(dbPath + cl.getName() + ".java", cl.getGenereatedCode());
            }
        } catch (IOException | RuntimeException e) {
            System.err.println("Error!");
            if (e.getMessage() != null)
                System.err.println(e.getMessage());
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
