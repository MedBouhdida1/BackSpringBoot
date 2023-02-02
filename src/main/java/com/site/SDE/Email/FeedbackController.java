package com.site.SDE.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@CrossOrigin("*")

@RequestMapping("/feedback")
public class FeedbackController {
    EmailCfg emailCfg;

    public FeedbackController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            try {
                throw new ValidationException("feedback not valid");
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());


        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("admin@Jobhunts.com");
        mailMessage.setTo(feedback.getEmail());
        mailMessage.setText(feedback.getFeedback());
        mailMessage.setSubject(feedback.getSubject());

        mailSender.send(mailMessage);


    }
}
