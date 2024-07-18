package vn.LearningSpring.HelloWorld.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ZaloService implements MessageService{
    @Override
    public String sendMessage() {
        return "Zalo sending ...";
    }
}
