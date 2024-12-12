package spring.server.il.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

@Component
@RequiredArgsConstructor
public class MailerUtils {

    @Value("${spring.mail.username}")
    private String appMailAdress;

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
}