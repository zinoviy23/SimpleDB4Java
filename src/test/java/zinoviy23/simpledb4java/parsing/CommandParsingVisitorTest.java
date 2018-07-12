package zinoviy23.simpledb4java.parsing;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.Test;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarLexer;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandParsingVisitorTest {

    @Test
    public void visitSimpleCommand() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString(
                        "database MyDB; class A{int age; float height; String name; int b() {int i = 0; i += 2; float c = 0.0;" +
                                "c -= 3;" +
                                "getAge(); return 10;} }" +
                        " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file().classDef(0).queryDef(0);

        String res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(5).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("return 10;", res);

        SimpleDBGrammarListenerImpl.addBlock();

        res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(0).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("int i = 0;", res);

        res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(1).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("i += 2;", res);

        res =((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(2).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("float c = 0.0;", res);

        res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(3).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("c -= 3;", res);

        SimpleDBGrammarParser.methodsSymbolTable.put("A", new HashMap<>());
        SimpleDBGrammarParser.methodsSymbolTable.get("A").put("getAge",
                new SimpleDBGrammarParser.MethodInfo("int", "getAge", false, new LinkedHashMap<>()));

        assertTrue(SimpleDBGrammarParser.methodsSymbolTable.get("A").containsKey("getAge"));

        res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(4).simpleCommand()
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("getAge();", res);
    }

    @After
    public void tearDown() throws Exception {
        SimpleDBGrammarListenerImpl.clear();
        SimpleDBGrammarParser.clearSymbolTables();
    }

    @Test
    public void visitForCycle() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString(
                        "database MyDB; class A{int age; float height; String name; int b() {int[] arr = {1, 2, 3};" +
                                "for (int i : arr)" +
                                "   i += 1;} }" +
                                " class B{A[] as; int b;}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file().classDef(0).queryDef(0);

        SimpleDBGrammarListenerImpl.addBlock();

        String res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(0)
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("List<Integer> arr = java.util.Arrays.asList(1, 2, 3);", res);

        res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(1)
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("for (int i : arr)\n{i += 1;}\n", res);
    }

    @Test
    public void visitIfStatement() {
        SimpleDBGrammarLexer lexer = new SimpleDBGrammarLexer(
                CharStreams.fromString(
                        "database MyDB; class A{int age; float height; String name; int b() {if (1 == 2) return 1;" +
                                "else return 2;" +
                                " }}"));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SimpleDBGrammarParser parser = new SimpleDBGrammarParser(tokenStream);
        ParseTree syntaxTree = parser.file().classDef(0).queryDef(0);

        String res = ((SimpleDBGrammarParser.QueryDefContext) syntaxTree).command(0)
                .accept(new CommandParsingVisitor("A", "int"));

        assertEquals("if (1 == 2)\n{return 1;}\n" +
                "else\n{return 2;}\n", res);
    }
}