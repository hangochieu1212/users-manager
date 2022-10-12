package com.example.lab1.service;

import com.example.lab1.controller.request.ForgotPasswordRequest;

public interface MailService {
    void sendMail(String email);
}
