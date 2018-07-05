package zinoviy23.simpledb4java.dbinfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handler for getting information from ResultSet
 * @param <T> type of data
 * @author zinoviy23@gmail.com
 */
@FunctionalInterface
public interface ResultHandler<T> {
    /**
     * Gets data from ResultSet
     * @param set ResultSet, which is gotten from query
     * @return return data from ResultSet
     * @throws SQLException sql troubles
     */
    T handle(ResultSet set) throws SQLException;
}
