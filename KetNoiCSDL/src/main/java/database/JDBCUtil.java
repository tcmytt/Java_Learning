package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static String driver = "com.mysql.cj.jdbc.Driver"; // Thay đổi với driver phù hợp
    public static Connection getConnection() {
        Connection con = null;
        // jdk 8 trở lên không cần làm bước thêm vào DriverManager
        try{
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName(driver); // Đăng ký driver
            String url = "jdbc:mySQL://localhost:3306/hbdb";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
    public static void close(Connection con)  {
        try{
            if (con != null) con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
