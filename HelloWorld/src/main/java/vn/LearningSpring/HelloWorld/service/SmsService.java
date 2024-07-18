package vn.LearningSpring.HelloWorld.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Override
    public String sendMessage() {
        return "Sms sending ...";
    }

    @PostConstruct
    public void init(){
        System.out.println("SmsService init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("SmsService destroy");
    }
}
