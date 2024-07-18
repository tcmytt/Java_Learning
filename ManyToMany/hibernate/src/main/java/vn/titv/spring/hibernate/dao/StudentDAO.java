package vn.titv.spring.hibernate.dao;

import vn.titv.spring.hibernate.entity.Student;

public interface StudentDAO {

    public void save(Student student);

    public Student findStudentById(int id);

    public Student findStudentAndCourseByStudentId(int id);
}
