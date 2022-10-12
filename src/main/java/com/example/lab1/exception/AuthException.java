package com.example.lab1.exception;

import com.example.lab1.constant.AuthErrorCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthException extends RuntimeException {
    private int code;
    private String message;
    public AuthException(AuthErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public AuthException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getResponseMessage() {
        return this.message;
    }
}
