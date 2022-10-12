package com.example.lab1.exception;

import com.example.lab1.constant.AuthErrorCode;
import com.example.lab1.constant.UserErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRestApiException extends RuntimeException {
    private int code;
    private String message;

    public UserRestApiException(UserErrorCode userErrorCode) {
        this.code = userErrorCode.getCode();
        this.message = userErrorCode.getMessage();
    }
    public UserRestApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public UserRestApiException(AuthErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public String getResponseMessage() {
        return this.message;
    }
}
