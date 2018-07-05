package zinoviy23.simpledb4java.dbinfo;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultHandler<T> {
    T handle(ResultSet set) throws SQLException;
}
