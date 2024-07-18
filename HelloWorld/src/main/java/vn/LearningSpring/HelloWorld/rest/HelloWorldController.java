package vn.LearningSpring.HelloWorld.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${course.name}")
    private String  TenKH;
    @Value("${course.author}")
    private String  TenTG;
    @Value("${course.description}")
    private String  MoTa;

    @GetMapping("/")
    public String index() {
        return "Hello World <br/>"+TenKH+" <br/>"+TenTG+" <br/>"+MoTa;
    }

    @GetMapping("/h2")
    public String index2() {
        return "Xin chao";
    }
}
