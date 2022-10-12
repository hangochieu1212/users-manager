package com.example.lab1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Objects;
import java.util.Properties;

@Configuration
public class MailConfig {
    @Autowired
    private Environment env;
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("config.mail.host"));
        mailSender.setUsername(env.getProperty("config.mail.username"));
        mailSender.setPassword(env.getProperty("config.mail.password"));
        mailSender.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("config.mail.port"))));
        Properties javaMailProperties = mailSender.getJavaMailProperties();
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.from", env.getProperty("config.mail.username"));
        javaMailProperties.put("mail.debug", env.getProperty("config.mail.debug"));
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}
