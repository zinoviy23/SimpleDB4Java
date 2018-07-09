package zinoviy23.simpledb4java.dbinfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for execution queries for database
 */
public class DBExecutor {
    /**
     * Connection to database
     */
    final private Connection connection;

    /**
     * Constructor, which is gets connection to database
     * @param connection connection to database
     */
    public DBExecutor(Connection connection) {
        this.connection = connection;
    }

    /**
     * Executes simple update query
     * @param query sql query
     */
    public void executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Executes query, that returns something
     * @param query sql query
     * @param handler handler, for getting data from ResultSet
     * @param <T> type of return data
     * @return data from database
     * @throws SQLException sql troubles
     */
    public <T> T executeQuery(String query, ResultHandler<T> handler) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            try (ResultSet resultSet = statement.getResultSet()) {
                return handler.handle(resultSet);
            }
        }
    }

    /**
     * Closes connection
     * @throws SQLException sql troubles
     */
    public void close() throws SQLException {
        connection.close();
    }
}
