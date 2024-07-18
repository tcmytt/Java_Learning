package vn.LearningSpring.HelloWorld.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.LearningSpring.HelloWorld.application.Caculator;

@Configuration
public class MyUtil {

    @Bean
    public Caculator getCaculator() {
        return new Caculator();
    }
}
