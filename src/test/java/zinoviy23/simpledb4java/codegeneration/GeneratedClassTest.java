package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing GeneratedClass class.
 */
public class GeneratedClassTest {

    /**
     * Code generation test
     */
    @Test
    public void toStringTest() {
        GeneratedClass generatedClass = new GeneratedClass("A");
        generatedClass.addSimpleField(new SimpleField("int", "a"));
        generatedClass.addSimpleField(new SimpleField("String", "B"));

        assertEquals("class A {\n    private int a;\n\n    public int getA() {\n        return a;\n    }\n\n" +
                "    private String B;\n\n    public String getB() {\n        return B;\n    }\n\n}", generatedClass.toString());
    }
}