package com.example.lab1.middleware;

import com.example.lab1.controller.request.AddUserRequest;
import com.example.lab1.controller.request.ForgotPasswordRequest;
import com.example.lab1.controller.request.LoginRequest;
import com.example.lab1.controller.request.UpdateUserRequest;

public interface UserVerifyRequestService {
    void verifyAddUser(AddUserRequest request);
    void verifyUpdateUser(UpdateUserRequest request);
    void verifyLoginUser(LoginRequest request);
    void verifyForgotPasswordUser(ForgotPasswordRequest request);
}
