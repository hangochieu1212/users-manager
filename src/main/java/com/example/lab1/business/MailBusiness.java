package com.example.lab1.business;

public interface MailBusiness {
    boolean sendForgotPasswordMail(String username, String email, String password, String lastName);
}
