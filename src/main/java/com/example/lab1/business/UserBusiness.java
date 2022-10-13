package com.example.lab1.business;

import com.example.lab1.controller.request.AddUserRequest;
import com.example.lab1.controller.request.ForgetPasswordRequest;
import com.example.lab1.controller.request.LoginRequest;
import com.example.lab1.controller.request.UpdateUserRequest;
import com.example.lab1.model.dto.UserDto;
import com.example.lab1.model.entity.User;

import java.util.List;

public interface UserBusiness {
    UserDto convertUserToUserDto(User user);
    UserDto getUser(int id);
    List<UserDto> getAllUsers();
    UserDto updateUser(int id, UpdateUserRequest request);
    UserDto loginUser(LoginRequest request);
    String forgotPassword(ForgetPasswordRequest request);
    UserDto addUser(AddUserRequest request);
}
