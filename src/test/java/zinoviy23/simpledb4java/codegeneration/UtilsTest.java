package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing Util class
 */
public class UtilsTest {

    /**
     * Test for capital latter method
     */
    @Test
    public void getStringWithCapitalFirstCharTest() {
        assertEquals("Name", Utils.getStringWithCapitalFirstChar("name"));
        assertEquals("Name", Utils.getStringWithCapitalFirstChar("Name"));
        assertEquals("_a", Utils.getStringWithCapitalFirstChar("_a"));
    }

    /**
     * Test wrapping method
     */
    @Test
    public void getWrappingTypeNameTest() {
        assertEquals("Integer", Utils.getWrappingTypeName("int"));
        assertEquals("Long", Utils.getWrappingTypeName("long"));
        assertEquals("Float", Utils.getWrappingTypeName("float"));
        assertEquals("String", Utils.getWrappingTypeName("String"));
    }

    /**
     * Test method, which gets name of method get*
     */
    @Test
    public void getMethodNameByTypeTest() {
        assertEquals("Int", Utils.getMethodNameByType("int"));
        assertEquals("Long", Utils.getMethodNameByType("long"));
        assertEquals("Float", Utils.getMethodNameByType("float"));
        assertEquals("String", Utils.getMethodNameByType("String"));
    }
}