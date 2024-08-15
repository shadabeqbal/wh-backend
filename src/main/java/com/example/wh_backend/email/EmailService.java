package com.example.wh_backend.email;

import com.example.wh_backend.config.EmailConfiguration;
import com.example.wh_backend.models.request.UserRegisterInput;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailConfiguration emailConfiguration;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailTemplate emailTemplate;

    public void sendEmailOnUserRegistration(UserRegisterInput userRegisterInput) throws Exception {
        String to = userRegisterInput.getEmail();
        String from = emailConfiguration.getAdminEmail();
        String subject = "Email Testing "+ userRegisterInput.getEmail();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setText(emailTemplate.composeUserRegisterTemplate(userRegisterInput), true);
        helper.setSubject(subject);
        helper.setFrom(from);

        mailSender.send(message);

    }
}
