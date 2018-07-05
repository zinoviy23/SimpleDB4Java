package zinoviy23.simpledb4java.dbinfo;

/**
 * Interface for creating database
 */
@FunctionalInterface
public interface DBCreator {
    /**
     * Method, that creates db
     * @param info db information
     */
    void createDB(DBInformation info);
}
