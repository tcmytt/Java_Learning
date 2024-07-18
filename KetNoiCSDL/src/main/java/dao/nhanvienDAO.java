package dao;

import database.JDBCUtil;
import model.nhanvien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class nhanvienDAO implements DAOInterface<nhanvien> {

    public static nhanvienDAO getInstance() {
        return new nhanvienDAO();
    }

    @Override
    public int insert(nhanvien nhanvien) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "insert into nhanvien(MaNV,TenNV,ChucVu,SDT) " +
                    "values ("+nhanvien.getMaNV()+",'"+ nhanvien.getTenNV()+"','" + nhanvien.getChucVu()+"','" + nhanvien.getSDT() +" ')";
            int ketqua = stmt.executeUpdate(sql);
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(nhanvien nhanvien) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "UPDATE nhanvien SET " +
                    "TenNV = '" + nhanvien.getTenNV() + "',ChucVu = '" + nhanvien.getChucVu() + "',SDT = '" + nhanvien.getSDT() + "' " +
                    "WHERE MaNV = " + nhanvien.getMaNV();
            int ketqua = stmt.executeUpdate(sql);
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(nhanvien nhanvien) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "DELETE FROM nhanvien " +
                    "WHERE MaNV = " + nhanvien.getMaNV();
            int ketqua = stmt.executeUpdate(sql);
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<nhanvien> selectAll() {
        try {
            ArrayList<nhanvien> ans = new ArrayList<nhanvien>();
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "Select * from nhanvien";
            ResultSet ketqua = stmt.executeQuery(sql);
            // Loc du lieu
            while (ketqua.next()){
                int MaNV = ketqua.getInt("MaNV");
                String TenNV = ketqua.getString("TenNV");
                String ChucVu = ketqua.getString("ChucVu");
                String SDT = ketqua.getString("SDT");
                nhanvien nv = new nhanvien(MaNV,TenNV,ChucVu,SDT);
                ans.add(nv);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public nhanvien selectOne(nhanvien nhanvien) {
        try {
            nhanvien ans = null;
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "Select * from nhanvien where MaNV = " + nhanvien.getMaNV();
            ResultSet ketqua = stmt.executeQuery(sql);
            // Loc du lieu
            while (ketqua.next()){
                int MaNV = ketqua.getInt("MaNV");
                String TenNV = ketqua.getString("TenNV");
                String ChucVu = ketqua.getString("ChucVu");
                String SDT = ketqua.getString("SDT");
                ans = new nhanvien(MaNV,TenNV,ChucVu,SDT);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<nhanvien> selectByCondition(String condition) {
        try {
            ArrayList<nhanvien> ans = new ArrayList<nhanvien>();
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            Statement stmt = con.createStatement();
            //Thuc thi
            String sql = "Select * from nhanvien where "+ condition;
            ResultSet ketqua = stmt.executeQuery(sql);
            // Loc du lieu
            while (ketqua.next()){
                int MaNV = ketqua.getInt("MaNV");
                String TenNV = ketqua.getString("TenNV");
                String ChucVu = ketqua.getString("ChucVu");
                String SDT = ketqua.getString("SDT");
                nhanvien nv = new nhanvien(MaNV,TenNV,ChucVu,SDT);
                ans.add(nv);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
