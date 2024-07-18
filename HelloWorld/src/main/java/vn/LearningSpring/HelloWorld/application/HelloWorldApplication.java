package vn.LearningSpring.HelloWorld.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"vn.LearningSpring.HelloWorld.rest", "vn.LearningSpring.HelloWorld.service"}
)
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
