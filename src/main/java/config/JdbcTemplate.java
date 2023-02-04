package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {

    private final String connectUrl = "jdbc:postgresql://localhost:5431/geor";
    private final String user = "geor";
    private final String password = "geor";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(connectUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(connectUrl, user, password);
        conn.setAutoCommit(false);
        return conn;
    }
}
