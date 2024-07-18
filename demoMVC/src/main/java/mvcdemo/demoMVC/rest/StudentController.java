package mvcdemo.demoMVC.rest;

import mvcdemo.demoMVC.entity.Student;
import mvcdemo.demoMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student/students";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        // redirect sẽ không mang dữ liệu theo
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/students-form";
    }

    @GetMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

}
