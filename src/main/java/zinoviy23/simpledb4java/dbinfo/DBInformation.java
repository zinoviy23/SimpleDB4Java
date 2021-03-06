package zinoviy23.simpledb4java.dbinfo;

import org.jetbrains.annotations.Nullable;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Singleton class for db information. It contains information only about users tables.
 */
public class DBInformation {
    /**
     * Main object
     */
    private static DBInformation instance;

    /**
     * Db name
     */
    private String dbName;

    /**
     * Map for tables and theirs names
     */
    private Map<String, TableInformation> tableInfos = new HashMap<>();

    /**
     * Set of array tables.
     */
    private List<DBArrayTableInfo> arrayTableInfos = new ArrayList<>();

    /**
     * Tables names
     */
    private Set<String> tableNames = new HashSet<>();

    /**
     * Gets singleton object or create it if it isn't exist
     * @return singleton object
     */
    public static DBInformation getInstance() {
        if (instance == null)
            instance = new DBInformation();
        return instance;
    }

    /**
     * Gets table by name
     * @param key table name
     * @return table, that has this name
     */
    public TableInformation getTable(Object key) {
        return tableInfos.get(key);
    }

    /**
     * Puts table in db
     * @param key table name
     * @param value table
     * @return recently added table
     */
    public TableInformation putTable(String key, TableInformation value) {
        tableNames.add(key);
        return tableInfos.put(key, value);
    }

    /**
     * Puts array table in db
     * @param dbArrayTableInfo new table
     * @return added table
     */
    public boolean addArrayTable(DBArrayTableInfo dbArrayTableInfo) {
        return arrayTableInfos.add(dbArrayTableInfo);
    }

    /**
     * Gets all array tables
     * @return unmodifiable list of array tables
     */
    public List<DBArrayTableInfo> getArrayTables() {
        return Collections.unmodifiableList(arrayTableInfos);
    }

    /**
     * Private constructor for singleton
     */
    private DBInformation() {

    }

    /**
     * Gets dbName
     * @return dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Sets db name
     * @param dbName new db name
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * Creates db using database creator.
     * @param dbCreator lambda or something, that implements DBCreator
     */
    public void createDB(DBCreator dbCreator) {
        dbCreator.createDB(this);
    }

    /**
     * executor for connection
     */
    private DBExecutor executor;

    /**
     * Gets executor
     * @return executor
     */
    @Nullable
    public DBExecutor getExecutor() {
        return executor;
    }

    /**
     * Creates sqlite db
     * @param folderUrl db folder url
     * @param driver sqlite driver
     * @throws ClassNotFoundException nothing driver
     * @throws IllegalAccessException illegal access
     * @throws InstantiationException can't create driver instance
     */
    public void createDBSQLite(String folderUrl, String driver) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        try {
            DriverManager.registerDriver((Driver) Class.forName(driver).newInstance());
            executor = new DBExecutor(DriverManager.getConnection(folderUrl + "/" + dbName));
            createDB(info -> {
                for (String name : tableNames) {
                    TableInformation information = getTable(name);
                    if (information != null)
                        executor.executeUpdate(information.toString());
                }
                for (DBArrayTableInfo arrayTable : arrayTableInfos) {
                    executor.executeUpdate(arrayTable.toString());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (executor != null) {
                try {
                    executor.close();
                    //executor = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets user tables count
     * @return tables count
     */
    public int size() {
        return tableInfos.size();
    }

    /**
     * Clears db information
     */
    public void clear() {
        dbName = null;
        tableNames.clear();
        tableInfos.clear();
        arrayTableInfos.clear();
    }
}
