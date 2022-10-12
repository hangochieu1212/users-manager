package com.example.lab1.service;

import com.example.lab1.model.entity.User;
import com.example.lab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MailServiceImpl implements MailService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void sendMail(String email) {
        User user = userRepository
    }
}
