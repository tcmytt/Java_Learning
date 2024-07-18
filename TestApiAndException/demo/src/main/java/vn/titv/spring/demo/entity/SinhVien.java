package vn.titv.spring.demo.entity;

public class SinhVien {
      private int id;
      private String hoVanTen;
      private int tuoi;
      private String nganhHoc;
      private double diemTB;

      public SinhVien() {
      }

      public SinhVien(int id, String hoVanTen, int tuoi, String nganhHoc, double diemTB) {
            this.id = id;
            this.hoVanTen = hoVanTen;
            this.tuoi = tuoi;
            this.nganhHoc = nganhHoc;
            this.diemTB = diemTB;
      }

      // Jackson

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getHoVanTen() {
            return hoVanTen;
      }

      public void setHoVanTen(String hoVanTen) {
            this.hoVanTen = hoVanTen;
      }

      public int getTuoi() {
            return tuoi;
      }

      public void setTuoi(int tuoi) {
            this.tuoi = tuoi;
      }

      public String getNganhHoc() {
            return nganhHoc;
      }

      public void setNganhHoc(String nganhHoc) {
            this.nganhHoc = nganhHoc;
      }

      public double getDiemTB() {
            return diemTB;
      }

      public void setDiemTB(double diemTB) {
            this.diemTB = diemTB;
      }
}
