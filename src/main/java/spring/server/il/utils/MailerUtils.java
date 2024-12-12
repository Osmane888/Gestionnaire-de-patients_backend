package spring.server.il.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

@Component
@RequiredArgsConstructor
public class MailerUtils {

    private String appMailAdress = "clinicease4@gmail.com";

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
}