package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    /**
     * It returns a connection to the database
     * 
     * @return A connection to the database.
     */
    public static Connection getConecction() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /**
     * Close the ResultSet, but if it fails, print the stack trace to the console.
     * 
     * @param rs The ResultSet object to close.
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * It closes a PreparedStatement
     * 
     * @param smtm The PreparedStatement object to be closed.
     */
    public static void close(PreparedStatement smtm) {
        try {
            smtm.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * It closes a connection to a database
     * 
     * @param conn The connection to the database.
     */
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
