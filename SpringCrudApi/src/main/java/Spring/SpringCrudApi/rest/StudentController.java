package Spring.SpringCrudApi.rest;

import Spring.SpringCrudApi.dao.StudentDAO;
import Spring.SpringCrudApi.entity.Student;
import Spring.SpringCrudApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiTaoBangTay/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(student);
        }
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId(0);
        student = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student exis = studentService.getStudentById(id);
        if (exis == null) {
            return ResponseEntity.notFound().build();
        }
        exis.setFirstName(student.getFirstName());
        exis.setLastName(student.getLastName());
        exis.setEmail(student.getEmail());
        studentService.updateStudent(exis);
        return ResponseEntity.ok(exis);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/not-first-name/{name}")
    public List<Student> getAllStudentsNotFirstName(@PathVariable String name) {
        return this.studentService.getAllStudentsNotFirstName(name);
    }
}
