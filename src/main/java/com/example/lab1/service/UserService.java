package com.example.lab1.service;

import com.example.lab1.model.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(int id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    boolean existUsername(String username);
    boolean existEmail(String email);
    User saveUser(User user);
    User updatePassword(User user);
    boolean deleteUser(User user);
    List<User> getAllUser();
}
