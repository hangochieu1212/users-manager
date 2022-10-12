package com.example.lab1.business;

import com.example.lab1.constant.AuthErrorCode;
import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.controller.request.AddUserRequest;
import com.example.lab1.controller.request.ForgotPasswordRequest;
import com.example.lab1.controller.request.LoginRequest;
import com.example.lab1.controller.request.UpdateUserRequest;
import com.example.lab1.exception.UserRestApiException;
import com.example.lab1.middleware.UserVerifyRequestService;
import com.example.lab1.model.dto.UserDto;
import com.example.lab1.model.entity.User;
import com.example.lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness {
    @Autowired
    private UserService userService;
    @Autowired
    private UserVerifyRequestService userVerifyRequestService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto convertUserToUserDto(User user) {
        if(user == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        try {
            return modelMapper.map(user, UserDto.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDto getUser(int id) {
        User user = userService.findUserById(id);
        return convertUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto updateUser(int id, UpdateUserRequest request) {
        userVerifyRequestService.verifyUpdateUser(request);
        User user = userService.findUserById(id);
        if(user != null) {
            user.setFullname(request.getFullname());
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            userService.saveUser(user);
            return convertUserToUserDto(user);
        }
        throw new UserRestApiException(UserErrorCode.USER_NOT_EXIST);
    }

    @Override
    public UserDto loginUser(LoginRequest request) {
        userVerifyRequestService.verifyLoginUser(request);
        User user = userService.findUserByUsername(request.getUsername());
        if(user != null) {
            if(user.getPassword().equals(request.getPassword())) {
                user.setLastLogin(new Date());
                userService.saveUser(user);
                return convertUserToUserDto(user);
            }
            throw new UserRestApiException(AuthErrorCode.USERNAME_PASSWORD_INVALID);
        }
        throw new UserRestApiException(AuthErrorCode.USERNAME_PASSWORD_INVALID);
    }
    @Override
    public UserDto forgotPassword(ForgotPasswordRequest request) {
        userVerifyRequestService.verifyForgotPasswordUser(request);
        User user = userService.findUserByEmail(request.getEmail());
        if(user != null) {
            return convertUserToUserDto(user);
        }
        throw new UserRestApiException(UserErrorCode.EMAIL_NOT_EXIST);
    }

    @Override
    public UserDto addUser(AddUserRequest request) {
        userVerifyRequestService.verifyAddUser(request);
        User user = userService.existUsername(request.getUsername());

        User newUser = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFullname(request.getFullname());
        userService.saveUser(user);
        return convertUserToUserDto(user);
    }
}
