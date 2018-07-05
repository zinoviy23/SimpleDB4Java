package zinoviy23.simpledb4java.dbinfo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for testing DBArrayTableInfo.
 * @author zinoviy23@gmail.com
 */
public class DBArrayTableInfoTest {

    /**
     * Checks toString method
     */
    @Test
    public void toStringTest() {
        DBArrayTableInfo tableInfo = new DBArrayTableInfo("User", "Animal", "animals");
        DBArrayTableInfo tableInfo1 = new DBArrayTableInfo("Animal", "float", "legLength");

        assertEquals("CREATE TABLE User_Animal_animals(first INTEGER, second INTEGER)", tableInfo.toString());
        assertEquals("CREATE TABLE Animal_float_legLength(first INTEGER, second FLOAT)", tableInfo1.toString());
    }
}