package com.example.lab1.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String fullname;
    private String username;
    private String password;
    private String email;
}
