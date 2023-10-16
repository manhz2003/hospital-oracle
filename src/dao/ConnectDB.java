package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static Connection getConnection() {
        Connection c = null;
        try {
            // URL kết nối Oracle
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String username = "manhz2003";
            String password = "Manhz2003";
            // Đăng ký driver Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
