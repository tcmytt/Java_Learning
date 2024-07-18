package vn.LearningSpring.HelloWorld.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.LearningSpring.HelloWorld.service.EmailService;
import vn.LearningSpring.HelloWorld.service.MessageService;

@RestController
public class NotificationController {
    //@Autowired
    private MessageService Service1;
    private MessageService Service2;

    private MessageService EmailService;
    private MessageService SmsService;
    private MessageService ZaloService;

    public NotificationController(@Qualifier("emailService")MessageService emailService,@Qualifier("smsService") MessageService smsService,@Qualifier("zaloService") MessageService zaloService) {
        this.EmailService = emailService;
        this.SmsService = smsService;
        this.ZaloService = zaloService;
    }

//    public void setEmailService(@Qualifier("emailService") MessageService emailService) {
//        EmailService = emailService;
//    }
//
//    public void setSmsService(@Qualifier("smsService") MessageService smsService) {
//        SmsService = smsService;
//    }
//
//    public void setZaloService(@Qualifier("zaloService") MessageService zaloService) {
//        ZaloService = zaloService;
//    }

    @GetMapping("/sendEmail")
    public String sendEmail() {
        return this.EmailService.sendMessage();
    }

    @GetMapping("/sendSms")
    public String sendSms() {
        return this.SmsService.sendMessage();
    }

    @GetMapping("/sendZalo")
    public String sendZalo() {
        return this.ZaloService.sendMessage();
    }

    @Autowired
    public NotificationController(@Qualifier("emailService")MessageService Service1,@Qualifier("emailService")MessageService Service2) {
        this.Service1 = Service1;
        this.Service2 = Service2;
    }


    @GetMapping("/sendMessage")
    public String sendMessage() {
        return this.Service1.sendMessage();
    }

    @GetMapping("/check")
    public String check() {
        return "True la singleton, False la prototype va ket qua la "+ Service1.equals(Service2);
    }
}
