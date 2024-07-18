package Spring.SpringCrudApi.dao;

import Spring.SpringCrudApi.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();
    public Student getById(int id);
    //add
    public Student save(Student Student);
    //update
    public Student saveAndFlush(Student Student);
    public void deleteById(int id);
}
