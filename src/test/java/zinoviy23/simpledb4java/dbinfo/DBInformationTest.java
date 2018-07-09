package zinoviy23.simpledb4java.dbinfo;

import org.junit.Test;

import java.io.File;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Class for testing DBInformation class
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
        DBInformation.getInstance().putTable("Users", null);
        DBInformation.getInstance().putTable("Animals", null);

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
        DBInformation.getInstance().setDbName("mydb.sqlite");
        DBInformation.getInstance().putTable("Users", null);
        DBInformation.getInstance().putTable("Animals", null);

        try {
            DBInformation.getInstance().createDBSQLite("jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java",
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

    /**
     * Check information about created db
     */
    @Test
    public void sqlitedbCreatingTest() {
        DBInformation.getInstance().setDbName("UsersDB.sqlite");
        DBInformation.getInstance().putTable("Users", new TableInformation("Users", Arrays.asList(
            new TableInformation.ColumnInfo("ID", TableInformation.ColumnType.ID),
            new TableInformation.ColumnInfo("AGE", TableInformation.ColumnType.INT),
            new TableInformation.ColumnInfo("NAME", TableInformation.ColumnType.STRING),
            new TableInformation.ColumnInfo("HEIGHT", TableInformation.ColumnType.FLOAT)
        )));

        try {
            DBInformation.getInstance().createDBSQLite("jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java",
                    "org.sqlite.JDBC");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("can't create db");
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("unknown error");
        }

        DBExecutor executor = null;
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.sqlite.JDBC").newInstance());
            executor = new DBExecutor(DriverManager.getConnection(
                    "jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java/UsersDB.sqlite"));
            ArrayList<String> info = executor.executeQuery("PRAGMA table_info(Users)", set -> {
                ArrayList<String> res = new ArrayList<>();
                while (set.next()) {
                    res.add(set.getString(2));
                }
                return res;
            });

            assertEquals(4, info.size());
            assertEquals("ID", info.get(0));
            assertEquals("AGE", info.get(1));
            assertEquals("NAME", info.get(2));
            assertEquals("HEIGHT", info.get(3));
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("can't read db");
        }
        finally {
            if (executor != null) {
                try {
                    executor.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    fail("can't close db");
                }
            }

            File file = new File("UsersDB.sqlite");
            assertTrue(file.delete());
            DBInformation.getInstance().clear();
        }
    }

    /**
     * Checks array table
     */
    @Test
    public void dbArrayCreatingTest() {
        DBInformation.getInstance().setDbName("UsersDB.sqlite");
        DBInformation.getInstance().addArrayTable(new DBArrayTableInfo("User", "Animal", "usersAnimal"));

        try {
            DBInformation.getInstance().createDBSQLite("jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java",
                    "org.sqlite.JDBC");
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("can't create db!");
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("unknown error");
        }

        DBExecutor executor = null;
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.sqlite.JDBC").newInstance());
            executor = new DBExecutor(DriverManager.getConnection(
                    "jdbc:sqlite:/home/sanusha/Proga/SimpleDB4Java/UsersDB.sqlite"));
            ArrayList<String> info = executor.executeQuery("PRAGMA table_info(User_Animal_usersAnimal)", set -> {
                ArrayList<String> res = new ArrayList<>();
                while (set.next()) {
                    res.add(set.getString(2));
                }
                return res;
            });

            assertEquals(2, info.size());
            assertEquals("first", info.get(0));
            assertEquals("second", info.get(1));
        } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("can't read db");
        }
        finally {
            if (executor != null) {
                try {
                    executor.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    fail("troubles in closing");
                }
            }

            File file = new File("UsersDB.sqlite");
            assertTrue(file.delete());
            DBInformation.getInstance().clear();
        }
    }
}