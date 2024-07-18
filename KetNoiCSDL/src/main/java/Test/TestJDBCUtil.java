package Test;

import database.JDBCUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) throws SQLException {
        try {
            // Bc1 Tạo kết nối
            Connection conn = JDBCUtil.getConnection();
            System.out.println(conn);

            // Bc2 Tạo đối tượng statement
            Statement stmt = conn.createStatement();

            // Bc3 Thực thi sql
            String sql = "insert into nhanvien(MaNV,TenNV,ChucVu,SDT) values (\"005\",\"Nguyen Van Chien\",\"Bao ve\",\"0947123444\" )";
            int check = stmt.executeUpdate(sql);  //executeUpdate chạy cho insert, update, delete trả về số dòng thay đổi

            // Bc4 Xử lý kết quả
            System.out.println("Số dòng thay đổi "+ check);
            if(check > 0){
                System.out.println("Thêm dữ liệu thành công");
            }

            // Bc5 Đóng kết nối
            JDBCUtil.close(conn);
            System.out.println(conn.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
