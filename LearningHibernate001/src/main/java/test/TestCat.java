package test;

import Util.HibernateUtil;
import dao.CatDAO;
import model.Cat;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

public class TestCat {
    public static void main(String[] args) {
        CatDAO catDAO = new CatDAO();
        List<Cat> cats = catDAO.selectAll();
        for(Cat cat: cats) {
            System.out.println(cat);
        }

        Cat cat = new Cat();
        cat.setId(1);
        System.out.println("Tim kiem theo id ");
        cat = catDAO.selectById(cat);
        System.out.println(cat);
    }
}
