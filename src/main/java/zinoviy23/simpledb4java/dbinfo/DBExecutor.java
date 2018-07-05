package zinoviy23.simpledb4java.dbinfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBExecutor {
    final private Connection connection;

    public DBExecutor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> T executeQuery(String query, ResultHandler<T> handler) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
            try (ResultSet resultSet = statement.getResultSet()) {
                return handler.handle(resultSet);
            }
        }
    }

    public void close() throws SQLException {
        connection.close();
    }
}
