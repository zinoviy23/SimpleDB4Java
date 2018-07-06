package zinoviy23.simpledb4java.codegeneration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing Util class
 * @author zinoviy23@gmail.com
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
}