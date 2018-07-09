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
        generatedClass.addSimpleField(new SimpleFieldWithSimpleType("int", "a"));
        generatedClass.addSimpleField(new SimpleFieldWithSimpleType("String", "B"));

        assertEquals(
                "class A {\n    private long id;\n\n    public long getId() {\n        return id;\n    }\n\n" +
                "    private int a;\n\n    public int getA() {\n        return a;\n    }\n\n" +
                "    public void setA(int a) {\n        this.a = a;\n        update();\n    }\n\n" +
                "    private String B;\n\n    public String getB() {\n        return B;\n    }\n\n" +
                "    public void setB(String B) {\n        this.B = B;\n        update();\n    }\n\n}",
                generatedClass.toString());
    }
}