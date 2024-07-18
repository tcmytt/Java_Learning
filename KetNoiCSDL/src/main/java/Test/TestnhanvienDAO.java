package Test;

import dao.nhanvienDAO;
import model.nhanvien;
import java.util.ArrayList;

public class TestnhanvienDAO {
    public static void main(String[] args) {
//        nhanvien nv1 = new nhanvien(002,"Nguyen Van B","Nhan Vien", "084134124");
//        nhanvien nv2 = new nhanvien(003,"Nguyen Van C","Trưởng Phòng", "084134124");
//        nhanvien nv1 = new nhanvien(002,"Nguyen Van Bách","Nhan Vien", "084134124");
//        nhanvienDAO.getInstance().insert(nv1);

//        nhanvienDAO.getInstance().update(nv1);
//        nhanvienDAO.getInstance().delete(nv1);

//        ArrayList<nhanvien> a = nhanvienDAO.getInstance().selectAll();
//        for (nhanvien i : a){
//            System.out.println(i);
//        }

//        nhanvien b = new nhanvien();
//        b.setMaNV(5);
//        b = nhanvienDAO.getInstance().selectOne(b) ;
//        System.out.println(b);

        ArrayList<nhanvien> c = nhanvienDAO.getInstance().selectByCondition("ChucVu = 'Bao ve'");
        for (nhanvien i : c){
            System.out.println(i);
        }
//        for (int i = 1; i < 20; i++) {
//            nhanvienDAO.getInstance().insert(new nhanvien(7+i,"Nguyen Van"+i,"Nhan Vien", "084134124"+i));
//        }
    }
}
