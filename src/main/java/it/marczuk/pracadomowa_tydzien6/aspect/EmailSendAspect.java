package it.marczuk.pracadomowa_tydzien6.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class EmailSendAspect {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSendAspect(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @After("@annotation(EmailSendAnn)")
    private void sendEmail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("example@gmail.com");
        simpleMailMessage.setTo("example@gmail.com");
        simpleMailMessage.setSubject("Powiadomienie Post");
        simpleMailMessage.setText("Twój film został dodany do bazy");
        javaMailSender.send(simpleMailMessage);
    }
}
