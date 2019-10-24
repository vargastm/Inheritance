package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tiago Martins Vargas
 *
 */
public class ConnectionFactory {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Inheritance", "root", "");
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
        close(conn, ps, null);
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        close(conn, ps, rs);
    }

    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqlE) {
            System.out.println("Erro ao fechar conexão " + sqlE.getMessage());
        }
    }
}
