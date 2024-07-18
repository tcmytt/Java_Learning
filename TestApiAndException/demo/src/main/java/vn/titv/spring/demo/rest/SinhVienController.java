package vn.titv.spring.demo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.demo.entity.ErrorResponse;
import vn.titv.spring.demo.entity.SinhVien;
import vn.titv.spring.demo.exception.SinhVienException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController {

    public List<SinhVien> danhSach;

    @PostConstruct
    public void createDanhSach(){
        danhSach = new ArrayList<SinhVien>();
        danhSach.add(new SinhVien(1, "Nguyen Van A", 18, "Cong nghe Thong tin", 9));
        danhSach.add(new SinhVien(2, "Le Van B", 19, "Cong nghe Thong tin", 8.5));
        danhSach.add(new SinhVien(3, "Nguyen Thi C", 20, "Quan tri kinh doanh", 9));
        danhSach.add(new SinhVien(4, "Tran Anh D", 18, "Ke toan", 6));
        danhSach.add(new SinhVien(5, "Lam Hoang E", 19, "Cong nghe Thong tin", 7));
    }


    @GetMapping("/")
    public List<SinhVien> getDanhSach(){
        return danhSach;
    }

    @GetMapping("/{id}")
    public SinhVien getSinhVienById (@PathVariable int id) {
        SinhVien result = null;
            for (SinhVien sv : danhSach) {
                if (sv.getId() == id) {
                    return sv;
                }
            }
            if(result == null){
                throw new SinhVienException("Khong tim thay sinh vien co id = " + id);
            }
        return null;
    }

    @GetMapping("/index/{index}")
    public SinhVien getSinhVien (@PathVariable int index)   {
        try{
            return danhSach.get(index);
        }catch (Exception e){
            throw new SinhVienException("Khong tim thay sinh vien co index = " + index);
        }
    }

}
