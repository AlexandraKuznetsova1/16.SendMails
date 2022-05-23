package com.itis.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
public class MailsUtil {
    private final JavaMailSender mailSender;
    private String from;
    private final Configuration freemarkerConfiguration;

    public MailsUtil(JavaMailSender mailSender,
                     @Qualifier("templateConfiguration") Configuration freemarkerConfiguration,
                     @Value("${spring.mail.username}") String from) {
        this.mailSender = mailSender;
        this.freemarkerConfiguration = freemarkerConfiguration;
        this.from = from;
    }


    public void sendMail(String to, String subject, String templateName, Map<String, Object> data) {
        final StringWriter writer = new StringWriter();
        try {
            Template template = freemarkerConfiguration.getTemplate(templateName);
            template.process(data, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
            MimeMessagePreparator preparator = mimeMessage -> {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
                helper.setSubject(subject);
                helper.setTo(to);
                helper.setFrom(from);
                helper.setText(writer.toString(), true);
            };
            mailSender.send(preparator);
        }
    }
