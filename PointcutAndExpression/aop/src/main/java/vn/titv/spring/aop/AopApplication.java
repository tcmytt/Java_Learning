package vn.titv.spring.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.titv.spring.aop.service.CalculatorService;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CalculatorService calculator){
		return runner -> {
			// before
			double resultAdd = calculator.add(5,10);
			// after


			double x =calculator.divide(5, 0);
		};
	}
}
