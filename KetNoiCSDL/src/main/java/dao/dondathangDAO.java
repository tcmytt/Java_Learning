package dao;
import database.JDBCUtil;
import model.dondathang;
import model.nhanvien;

import java.sql.*;
import java.util.ArrayList;

public class dondathangDAO implements DAOInterface<dondathang> {

    public static dondathangDAO getInstance() {
        return new dondathangDAO();
    }

    @Override
    public int insert(dondathang dondathang) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Thuc thi
            String sql = "insert into dondathang(MaDon,MaNL,SoLuong,NgayDatHang,ThoiDiemNhanHang) " +
                    "values (?,?,?,?,?)";
            //Tao statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, dondathang.getMaDon());
            pst.setInt(2, dondathang.getMaNL());
            pst.setInt(3, dondathang.getSoLuong());
            pst.setDate(4, dondathang.getNgayDatHang());
            pst.setDate(5, dondathang.getThoiDiemNhanHang());

            int ketqua = pst.executeUpdate();
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(dondathang dondathang) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Thuc thi
            String sql = "update dondathang set MaNL = ?, SoLuong = ?, NgayDatHang = ?, ThoiDiemNhanHang = ? " +
                    "where MaDon = ?";
            //Tao statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, dondathang.getMaNL());
            pst.setInt(2, dondathang.getSoLuong());
            pst.setDate(3, dondathang.getNgayDatHang());
            pst.setDate(4, dondathang.getThoiDiemNhanHang());
            pst.setInt(5, dondathang.getMaDon());

            int ketqua = pst.executeUpdate();
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(dondathang dondathang) {
        try {
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Thuc thi
            String sql = "delete from dondathang where MaDon = ?";
            //Tao statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, dondathang.getMaDon());

            int ketqua = pst.executeUpdate();
            System.out.println("Có "+ ketqua + " dòng được thực thi");
            JDBCUtil.close(con);
            return ketqua;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<dondathang> selectAll() {
        try {
            ArrayList<dondathang> ans = new ArrayList<dondathang>();
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            String sql = "Select * from dondathang";
            PreparedStatement stmt = con.prepareStatement(sql);
            //Thuc thi
            ResultSet ketqua = stmt.executeQuery();
            // Loc du lieu
            while (ketqua.next()){
                int MaDon = ketqua.getInt("MaDon");
                int MaNL = ketqua.getInt("MaNL");
                int SoLuong = ketqua.getInt("SoLuong");
                Date NgayDatHang = ketqua.getDate("NgayDatHang");
                Date ThoiDiemNhanHang = ketqua.getDate("ThoiDiemNhanHang");
                dondathang don = new dondathang(MaDon, MaNL, SoLuong, NgayDatHang, ThoiDiemNhanHang);
                ans.add(don);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public dondathang selectOne(dondathang dondathang) {
        try {
            dondathang ans = null;
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            String sql = "Select * from dondathang where MaDon = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, dondathang.getMaDon());
            //Thuc thi
            ResultSet ketqua = stmt.executeQuery();
            // Loc du lieu
            while (ketqua.next()){
                int MaDon = ketqua.getInt("MaDon");
                int MaNL = ketqua.getInt("MaNL");
                int SoLuong = ketqua.getInt("SoLuong");
                Date NgayDatHang = ketqua.getDate("NgayDatHang");
                Date ThoiDiemNhanHang = ketqua.getDate("ThoiDiemNhanHang");
                ans = new dondathang(MaDon, MaNL, SoLuong, NgayDatHang, ThoiDiemNhanHang);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<dondathang> selectByCondition(String condition) {
        try {
            ArrayList<dondathang> ans = new ArrayList<dondathang>();
            //Ket noi
            Connection con = JDBCUtil.getConnection();
            //Tao statement
            String sql = "Select * from dondathang where " + condition ;
            Statement stmt = con.createStatement();
            //Thuc thi
            ResultSet ketqua = stmt.executeQuery(sql);
            // Loc du lieu
            while (ketqua.next()){
                int MaDon = ketqua.getInt("MaDon");
                int MaNL = ketqua.getInt("MaNL");
                int SoLuong = ketqua.getInt("SoLuong");
                Date NgayDatHang = ketqua.getDate("NgayDatHang");
                Date ThoiDiemNhanHang = ketqua.getDate("ThoiDiemNhanHang");
                dondathang don = new dondathang(MaDon, MaNL, SoLuong, NgayDatHang, ThoiDiemNhanHang);
                ans.add(don);
            }
            JDBCUtil.close(con);
            return ans;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
