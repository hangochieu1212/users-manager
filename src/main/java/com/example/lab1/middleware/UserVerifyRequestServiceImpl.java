package com.example.lab1.middleware;

import com.example.lab1.constant.AuthErrorCode;
import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.controller.request.AddUserRequest;
import com.example.lab1.controller.request.ForgotPasswordRequest;
import com.example.lab1.controller.request.LoginRequest;
import com.example.lab1.controller.request.UpdateUserRequest;
import com.example.lab1.exception.UserRestApiException;
import com.example.lab1.util.ValidateField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVerifyRequestServiceImpl implements UserVerifyRequestService {
    @Autowired
    private ValidateField validateField;

    @Override
    public void verifyAddUser(AddUserRequest request) {
        String fullname = request.getFullname();
        String username = request.getUsername();
        String password = request.getPassword();
        String email = request.getEmail();
        if(fullname == null || fullname.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_FULLNAME_FIELD);
        }
        if(username == null || username.trim().isEmpty()) {
            throw  new UserRestApiException(AuthErrorCode.MISSING_USERNAME_FIELD);
        }
        if(password == null || password.trim().isEmpty()) {
            throw new UserRestApiException(AuthErrorCode.MISSING_PASSWORD_FIELD);
        }
        if(email == null || email.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_EMAIL_FIELD);
        }
        if(!validateField.validFullname(fullname)) {
            throw new UserRestApiException(UserErrorCode.FULLNAME_INVALID);
        }
        if(!validateField.validUsername(username)) {
            throw new UserRestApiException(AuthErrorCode.USERNAME_INVALID);
        }
        if(!validateField.validPassword(password)) {
            throw new UserRestApiException(AuthErrorCode.PASSWORD_INVALID);
        }
        if(!validateField.validEmail(email)) {
            throw new UserRestApiException(UserErrorCode.EMAIL_INVALID);
        }
    }

    @Override
    public void verifyUpdateUser(UpdateUserRequest request) {
        String fullname = request.getFullname();
        String password = request.getPassword();
        String email = request.getEmail();
        String username = request.getUsername();
        if(fullname == null || fullname.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_FULLNAME_FIELD);
        }
        if(username == null || username.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_USERNAME_FIELD);
        }
        if(password == null || password.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_PASSWORD_FIELD);
        }
        if(email == null || email.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_EMAIL_FIELD);
        }
        if(validateField.validFullname(fullname)) {
            throw new UserRestApiException(UserErrorCode.FULLNAME_INVALID);
        }
        if(validateField.validUsername(username)) {
            throw new UserRestApiException(AuthErrorCode.USERNAME_INVALID);
        }
        if(validateField.validEmail(email)) {
            throw new UserRestApiException(UserErrorCode.EMAIL_INVALID);
        }
        if(validateField.validPassword(password)) {
            throw new UserRestApiException(AuthErrorCode.PASSWORD_INVALID);
        }
    }

    @Override
    public void verifyLoginUser(LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        if(username == null || username.trim().isEmpty()) {
            throw new UserRestApiException(AuthErrorCode.MISSING_USERNAME_FIELD);
        }
        if (password == null || password.trim().isEmpty()) {
            throw new UserRestApiException(AuthErrorCode.MISSING_PASSWORD_FIELD);
        }
        if(!validateField.validUsername(username)) {
            throw new UserRestApiException(AuthErrorCode.USERNAME_INVALID);
        }
        if(!validateField.validPassword(password)) {
            throw new UserRestApiException(AuthErrorCode.PASSWORD_INVALID);
        }
    }

    @Override
    public void verifyForgotPasswordUser(ForgotPasswordRequest request) {
        String email = request.getEmail();
        if(email == null || email.trim().isEmpty()) {
            throw new UserRestApiException(UserErrorCode.MISSING_EMAIL_FIELD);
        }
        if(!validateField.validEmail(email)) {
            throw new UserRestApiException(UserErrorCode.EMAIL_INVALID);
        }
    }
}
