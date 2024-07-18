package model;

import java.sql.Date;

public class dondathang {
    private int MaDon;
    private int MaNL;
    private int SoLuong;
    private Date NgayDatHang;
    private Date ThoiDiemNhanHang;

    public dondathang() {
    }

    public dondathang(int maDon, int maNL, int soLuong, Date ngayDatHang, Date thoiDiemNhanHang) {
        MaNL = maNL;
        MaDon = maDon;
        SoLuong = soLuong;
        NgayDatHang = ngayDatHang;
        ThoiDiemNhanHang = thoiDiemNhanHang;
    }

    @Override
    public String toString() {
        return "dondathang{" +
                "MaDon=" + MaDon +
                ", MaNL=" + MaNL +
                ", SoLuong=" + SoLuong +
                ", NgayDatHang=" + NgayDatHang +
                ", ThoiDiemNhanHang=" + ThoiDiemNhanHang +
                '}';
    }

    public int getMaDon() {
        return MaDon;
    }

    public void setMaDon(int maDon) {
        MaDon = maDon;
    }

    public int getMaNL() {
        return MaNL;
    }

    public void setMaNL(int maNL) {
        MaNL = maNL;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        NgayDatHang = ngayDatHang;
    }

    public Date getThoiDiemNhanHang() {
        return ThoiDiemNhanHang;
    }

    public void setThoiDiemNhanHang(Date thoiDiemNhanHang) {
        ThoiDiemNhanHang = thoiDiemNhanHang;
    }
}
