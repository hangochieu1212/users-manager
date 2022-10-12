package com.example.lab1.exception;

import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.controller.response.BaseResponse;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
@Service
public class ExceptionHandle {
    @ExceptionHandler(UserRestApiException.class)
    public ResponseEntity<BaseResponse> handleCommonEx(UserRestApiException ex) {
        return new ResponseEntity<>(new BaseResponse(ex.getCode(), ex.getResponseMessage()), HttpStatus.OK);
    }
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<BaseResponse> handleCommonEx(AuthException ex) {
        return new ResponseEntity<>(new BaseResponse(ex.getCode(), ex.getResponseMessage()), HttpStatus.OK);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<BaseResponse> handleIOException(IOException ex) {
        return new ResponseEntity<>(new BaseResponse(UserErrorCode.INTERNAL_ERROR), HttpStatus.BAD_REQUEST);
    }
}
