package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {

    private static final JdbcTemplate jdbcTemplateInstance = new JdbcTemplate();
    private final String driver = "org.postgresql.Driver";
    private final String connectUrl = "jdbc:postgresql://localhost:5431/crud";
    private final String user = "crud";
    private final String password = "crud";

    private JdbcTemplate() {}

    public static JdbcTemplate getInstance() {
        return jdbcTemplateInstance;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw e;
        }
        Connection conn = DriverManager.getConnection(connectUrl, user, password);
        conn.setAutoCommit(false);
        return conn;
    }
}
