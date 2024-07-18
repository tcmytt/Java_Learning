package vn.titv.spring.demo.dao;

import vn.titv.spring.demo.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);


    public SinhVien getById(int id);


    public List<SinhVien> getAll();


    public List<SinhVien> getByTen(String ten);

    public SinhVien update(SinhVien sinhVien);

    public int updateAllTen(String ten);

    public void delete(Long id);


    public void deleteByTen(String ten);
}
