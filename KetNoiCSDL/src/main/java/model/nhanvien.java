package model;

public class nhanvien {
    private int MaNV;
    private String TenNV;
    private String ChucVu;
    private String SDT;

    public nhanvien() {
    }

    public nhanvien(int maNV, String tenNV, String chucVu, String SDT) {
        MaNV = maNV;
        TenNV = tenNV;
        ChucVu = chucVu;
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "nhanvien{" +
                "MaNV=" + MaNV +
                ", TenNV='" + TenNV + '\'' +
                ", ChucVu='" + ChucVu + '\'' +
                ", SDT='" + SDT + '\'' +
                '}';
    }

    public int getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
