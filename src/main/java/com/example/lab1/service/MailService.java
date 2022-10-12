package com.example.lab1.service;

import com.example.lab1.model.dto.MailDto;

public interface MailService {
    void sendMail(MailDto dataMail, String templateName);
}
