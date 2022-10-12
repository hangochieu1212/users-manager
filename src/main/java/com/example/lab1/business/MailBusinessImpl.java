package com.example.lab1.business;

import com.example.lab1.model.dto.MailDto;
import com.example.lab1.service.MailService;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailBusinessImpl implements MailBusiness {
    @Autowired
    private Environment env;

    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Override
    public boolean sendForgotPasswordMail(String username, String email, String password, String lastName) {
        MailDto mail = new MailDto();
        mail.setFrom(env.getProperty("config.mail.username"));
        mail.setTo(email);
        mail.setSubject("Change password");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", lastName);
        model.put("username", username);
        model.put("password", password);
        mail.setProps(model);
        mailService.sendMail(mail, "forgotPassword-template");
        return true;
    }
}
