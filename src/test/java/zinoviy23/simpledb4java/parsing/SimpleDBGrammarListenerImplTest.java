package zinoviy23.simpledb4java.parsing;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarLexer;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;
import zinoviy23.simpledb4java.codegeneration.GeneratedClass;
import zinoviy23.simpledb4java.dbinfo.DBInformation;
import zinoviy23.simpledb4java.dbinfo.TableInformation;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Class for testing parsing in SimpleDBGrammarListenerImpl class
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
        assertEquals(1, DBInformation.getInstance().getArrayTables().size());
        assertEquals("MyDB", DBInformation.getInstance().getDbName());
        assertEquals(4, DBInformation.getInstance().getTable("A").size());
        assertEquals(TableInformation.ColumnType.INT , DBInformation.getInstance().getTable("B").get(1).getType());
        assertEquals("age", DBInformation.getInstance().getTable("A").get(1).getName());
        assertEquals("B_A_as", DBInformation.getInstance().getArrayTables().get(0).getTableName());
    }

    /**
     * Check class generation
     */
    @Test
    public void classGenerationTest() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString("database MyDB; class A{int age; float height; String name;}" +
                        " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        SimpleDBGrammarListenerImpl myListener = new SimpleDBGrammarListenerImpl();
        walker.walk(myListener, syntaxTree);

        List<GeneratedClass> arr = myListener.getGeneratedClassesArray();

        assertEquals(2 ,arr.size());
        assertEquals("A", arr.get(0).getName());
        assertEquals(3, arr.get(0).getGeneratedFields().size());
        assertEquals(2, arr.get(1).getGeneratedFields().size());
    }

    /**
     * Checks symbols tables
     */
    @Test
    public void symbolTablesTest() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString("database MyDB; class A{int age; float height; String name;}" +
                        " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        SimpleDBGrammarListenerImpl myListener = new SimpleDBGrammarListenerImpl();
        walker.walk(myListener, syntaxTree);

        assertEquals(2, SimpleDBGrammarParser.classesSymbolTable.size());
        assertTrue(SimpleDBGrammarParser.fieldsSymbolTable.containsKey("A"));
        assertTrue(SimpleDBGrammarParser.fieldsSymbolTable.containsKey("B"));
        assertTrue(SimpleDBGrammarParser.fieldsSymbolTable.get("A").containsKey("age"));
        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.containsKey("A"));
        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.get("A").containsKey("getAge"));
        assertEquals(14, SimpleDBGrammarParser.methodsSymbolTable.get("A").size());
        assertEquals(13, SimpleDBGrammarParser.methodsSymbolTable.get("B").size());
    }

    /**
     * Tests containing of standard methods
     */
    @Test
    public void StandardMethodCheck() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString("database MyDB; class A{int age; float height; String name;}" +
                        " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file();
        ParseTreeWalker walker = new ParseTreeWalker();
        SimpleDBGrammarListenerImpl myListener = new SimpleDBGrammarListenerImpl();
        walker.walk(myListener, syntaxTree);

        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.containsKey("A"));
        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.get("A").containsKey("getById"));
        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.get("A").containsKey("all"));
    }

    /**
     * Clears db and symbols tables
     */
    @After
    public void tearDown() {
        SimpleDBGrammarParser.clearSymbolTables();
        DBInformation.getInstance().clear();
    }
}