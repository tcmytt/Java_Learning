package mvcdemo.demoMVC.service;

import mvcdemo.demoMVC.dao.StudentRepository;
import mvcdemo.demoMVC.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.getById((int) id);
    }

    @Transactional
    @Override
    public Student addStudent(Student Student) {
        return studentRepository.save(Student);
    }

    @Transactional
    @Override
    public Student updateStudent(Student Student) {
        return studentRepository.saveAndFlush(Student);
    }

    @Transactional
    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName(String Name) {
        return studentRepository.findByFirstNameNot(Name);
    }
}
