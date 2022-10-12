package com.example.lab1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseModelDto {
    private String username;
    private String password;
    private Date lastLogin;
    private String email;
    private String fullname;
}
