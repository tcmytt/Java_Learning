package vn.LearningSpring.HelloWorld.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmailService implements MessageService {
    public EmailService() {
        System.out.println("EmailService constructor"+getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Email sending ...";
    }
}
