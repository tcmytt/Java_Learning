package mvcdemo.demoMVC.service;

import mvcdemo.demoMVC.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student getStudentById(long id);
    public Student addStudent(Student Student);
    public Student updateStudent(Student Student);
    public void deleteStudentById(int id);
    public List<Student> getAllStudentsNotFirstName(String Name);
}
