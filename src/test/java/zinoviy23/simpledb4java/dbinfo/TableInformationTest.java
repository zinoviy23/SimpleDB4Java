package zinoviy23.simpledb4java.dbinfo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Class for testing TableInformation
 * @author zinoviy23@gmail.com
 */
public class TableInformationTest {

    /**
     * Tests toString method
     */
    @Test
    public void toStringTest() {
        TableInformation ti = new TableInformation("Users", Arrays.asList(
                new TableInformation.ColumnInfo("ID", TableInformation.ColumnType.ID),
                new TableInformation.ColumnInfo("NAME", TableInformation.ColumnType.STRING),
                new TableInformation.ColumnInfo("AGE", TableInformation.ColumnType.INT)));

        assertEquals("CREATE TABLE Users (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(255), AGE INT)",
                ti.toString());
    }
}