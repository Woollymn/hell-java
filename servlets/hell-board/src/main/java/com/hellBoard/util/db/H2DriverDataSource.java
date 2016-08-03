package main.java.com.hellBoard.util.db;

import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by woollymn on 16. 8. 2.
 */
public class H2DriverDataSource implements DataSource {
    private static H2DriverDataSource INSTANCE;

    final private String URL = "jdbc:h2:~/test";
    final private String USERNAME = "sa";
    final private String PASSWORD = "";

    private H2DriverDataSource () {}

    public static H2DriverDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new H2DriverDataSource();
        }

        return INSTANCE;
    }

    @Override
    public Connection getConnection() throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create(URL, USERNAME, PASSWORD);

        return cp.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        JdbcConnectionPool cp = JdbcConnectionPool.create(URL, username, password);

        return cp.getConnection();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
