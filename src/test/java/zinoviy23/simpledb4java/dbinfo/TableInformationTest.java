package zinoviy23.simpledb4java.dbinfo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Class for testing TableInformation
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

    @Test
    public void fromStringTest() {
        assertEquals(TableInformation.ColumnType.INT, TableInformation.ColumnType.fromString("int"));
        assertEquals(TableInformation.ColumnType.STRING, TableInformation.ColumnType.fromString("String"));
        assertEquals(TableInformation.ColumnType.FLOAT, TableInformation.ColumnType.fromString("float"));
        assertEquals(TableInformation.ColumnType.OTHER_ID, TableInformation.ColumnType.fromString("aaaaaa"));
    }
}