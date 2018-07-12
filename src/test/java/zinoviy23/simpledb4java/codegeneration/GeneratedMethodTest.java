package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;
import zinoviy23.simpledb4java.antlr.SimpleDBGrammarParser;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class GeneratedMethodTest {

    @Test
    public void getGeneratedCode() {
        GeneratedMethod generatedMethod = new GeneratedMethod(
                new SimpleDBGrammarParser.MethodInfo("int", "get", true, new LinkedHashMap<>()),
                "{return 0;}");

        assertEquals("public static int get()\n" +
                "{return 0;}\n\n", generatedMethod.getGeneratedCode());

        LinkedHashMap<String, String> args = new LinkedHashMap<>();
        args.put("name", "int");
        args.put("lol", "float");

        generatedMethod = new GeneratedMethod(
                new SimpleDBGrammarParser.MethodInfo("int[]", "get", false, args),
                "{return kek;}"
        );

        assertEquals("public List<Integer> get(int name, float lol)\n{return kek;}\n\n",
                generatedMethod.getGeneratedCode());
    }
}