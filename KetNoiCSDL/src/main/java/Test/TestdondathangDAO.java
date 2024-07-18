package Test;

import model.dondathang;
import dao.dondathangDAO;

import java.util.ArrayList;

public class TestdondathangDAO {
    public static void main(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        // Chuyển đổi java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//        dondathang don1 = new dondathang(8, 1, 10, sqlDate, sqlDate);
//        dondathangDAO.getInstance().insert(don1);

//        ArrayList<dondathang> a = dondathangDAO.getInstance().selectAll();
//        for (dondathang i : a){
//            System.out.println(i);
//        }

//        dondathang don2 = new dondathang();
//        don2.setMaDon(3);
//        don2 = dondathangDAO.getInstance().selectOne(don2);
//        System.out.println(don2);

//        dondathang don3 = new dondathang(8, 1, 5,  sqlDate, sqlDate);
//        dondathangDAO.getInstance().update(don3);

//        dondathang don4 = new dondathang(7, 1, 5, sqlDate, sqlDate);
//        dondathangDAO.getInstance().delete(don4);

        ArrayList<dondathang> b = dondathangDAO.getInstance().selectByCondition("MaDon = 1");
        for (dondathang i : b){
            System.out.println(i);
        }
    }

}
