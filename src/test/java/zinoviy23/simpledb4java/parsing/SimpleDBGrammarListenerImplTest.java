package zinoviy23.simpledb4java.parsing;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarLexer;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.dbinfo.TableInformation;

import static org.junit.Assert.*;

/**
 * Class for testing parsing in SimpleDBGrammarListenerImpl class
 * @author zinoviy23@gmail.com
 */
public class SimpleDBGrammarListenerImplTest {

    /**
     * Check dbInformation initialization by tree parsing
     */
    @Test
    public void dbInitializationTest() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString("database MyDB; class A{int age; float height; String name;}" +
                        " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SimpleDBGrammarListenerImpl(), syntaxTree);

        assertEquals(2, DBInformation.getInstance().size());
        assertEquals(1, DBInformation.getInstance().getArrayTables().length);
        assertEquals("MyDB", DBInformation.getInstance().getDbName());
        assertEquals(3, DBInformation.getInstance().getTable("A").size());
        assertEquals(TableInformation.ColumnType.INT , DBInformation.getInstance().getTable("B").get(0).getType());
        assertEquals("B_A_as", DBInformation.getInstance().getArrayTables()[0].getTableName());

        DBInformation.getInstance().clear();
    }
}