package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing field
 */
public class SimpleFieldWithSimpleTypeTest {

    /**
     * Test of code generation for field
     */
    @Test
    public void toStringTest() {
        SimpleFieldWithSimpleType simpleFieldWithSimpleType = new SimpleFieldWithSimpleType("int", "a");
        SimpleFieldWithSimpleType simpleFieldWithSimpleType1 = new SimpleFieldWithSimpleType("String", "B");

        assertEquals("    private int a;\n\n    public int getA() {\n        return a;\n    }\n\n" +
                        "    public void setA(int a) {\n        this.a = a;\n        update();\n    }\n\n",
                simpleFieldWithSimpleType.getGeneratedCode());
        assertEquals("    private String B;\n\n    public String getB() {\n        return B;\n    }\n\n" +
                        "    public void setB(String B) {\n        this.B = B;\n        update();\n    }\n\n",
                simpleFieldWithSimpleType1.getGeneratedCode());
    }
}