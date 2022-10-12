package com.example.lab1.service;

import com.example.lab1.model.dto.MailDto;
import com.example.lab1.model.entity.User;
import com.example.lab1.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.MessagingException;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@Log4j2
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    SpringTemplateEngine templateEngine;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendMail(MailDto dataMail, String templateName) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Context context = new Context();
            context.setVariables(dataMail.getProps());
            String html = templateEngine.process(templateName, context);
            mimeMessageHelper.setSubject(dataMail.getSubject());
            mimeMessageHelper.setFrom(new InternetAddress(dataMail.getFrom(), "Admin"));
            mimeMessageHelper.setTo(dataMail.getTo());
            mimeMessageHelper.setText(html, true);
            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
