package zinoviy23.simpledb4java.dbinfo;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Class for testing DBInformation class
 * @author zinoviy23@gmail.com
 */
public class DBInformationTest {

    /**
     * Tests createDB method
     */
    @Test
    public void dbCreatingTest() {
        class MyDb {
            private String name;
            private int tableCount;
        }

        final MyDb db = new MyDb();

        DBInformation.getInstance().setDbName("My name");
        DBInformation.getInstance().put("Users", null);
        DBInformation.getInstance().put("Animals", null);

        DBInformation.getInstance().createDB(info -> {
            db.name = info.getDbName();
            db.tableCount = info.size();
        });

        assertEquals("My name", db.name);
        assertEquals(2, db.tableCount);

        DBInformation.getInstance().clear();
    }

    /**
     * Tests createDBSqlite method
     */
    @Test
    public void sqlitedbCreatingFileExistingTest() {
        DBInformation.getInstance().setDbName("My name");
        DBInformation.getInstance().put("Users", null);
        DBInformation.getInstance().put("Animals", null);

        try {
            DBInformation.getInstance().createDBSQLite("jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java/mydb.sqlite",
                    "org.sqlite.JDBC");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            fail("can't create db");
        }

        File file = new File("mydb.sqlite");
        assertTrue(file.exists());
        assertTrue(file.delete());
        DBInformation.getInstance().clear();
    }
}