package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing field
 */
public class SimpleFieldTest {

    /**
     * Test of code generation for field
     */
    @Test
    public void toStringTest() {
        SimpleField simpleField = new SimpleField("int", "a");
        SimpleField simpleField1 = new SimpleField("String", "B");

        assertEquals("    private int a;\n\n    public int getA() {\n        return a;\n    }\n\n",
                simpleField.toString());
        assertEquals("    private String B;\n\n    public String getB() {\n        return B;\n    }\n\n",
                simpleField1.toString());
    }
}