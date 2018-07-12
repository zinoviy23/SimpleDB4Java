package db;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DBService {
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DATA_BASE_URL = "jdbc:sqlite:%s";
    private static final String JAR_LOCATION = "sqlite-jdbc-3.23.1.jar";

    private static DBService instance;

    private Executor executor;

    public static DBService getInstance() {
        if (instance == null)
            instance = new DBService();
        return instance;
    }

    private DBService() {
        try {
            initDriver();
            executor = new Executor(DriverManager.getConnection(DATA_BASE_URL));
        } catch (InstantiationException | SQLException | IllegalAccessException | MalformedURLException
                | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error to connect to database!!!");
        }
    }

    private void initDriver() throws MalformedURLException, SQLException, ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        File file = new File(JAR_LOCATION);
        ClassLoader current = Thread.currentThread().getContextClassLoader();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {file.toURI().toURL()}, current);
        Thread.currentThread().setContextClassLoader(urlClassLoader);

        Driver driver = (Driver) Class.forName(JDBC_DRIVER, true, Thread.currentThread().getContextClassLoader())
                .newInstance();
        DriverManager.registerDriver(new DriverShim(driver));
    }

    public Executor getExecutor() {
        return executor;
    }

    public void close() {
        if (executor != null)
            executor.close();
    }

    private static class DriverShim implements Driver {
        private Driver driver;
        DriverShim(Driver d) {
            this.driver = d;
        }
        public boolean acceptsURL(String u) throws SQLException {
            return this.driver.acceptsURL(u);
        }
        public Connection connect(String u, Properties p) throws SQLException {
            return this.driver.connect(u, p);
        }
        public int getMajorVersion() {
            return this.driver.getMajorVersion();
        }
        public int getMinorVersion() {
            return this.driver.getMinorVersion();
        }
        public DriverPropertyInfo[] getPropertyInfo(String u, Properties p) throws SQLException {
            return this.driver.getPropertyInfo(u, p);
        }
        public boolean jdbcCompliant() {
            return this.driver.jdbcCompliant();
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }
}
