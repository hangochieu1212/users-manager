package com.example.lab1.controller;

import com.example.lab1.business.UserBusiness;
import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.controller.request.AddUserRequest;
import com.example.lab1.controller.request.ForgetPasswordRequest;
import com.example.lab1.controller.request.LoginRequest;
import com.example.lab1.controller.request.UpdateUserRequest;
import com.example.lab1.controller.response.BaseResponse;
import com.example.lab1.controller.response.LoginResponse;
import com.example.lab1.controller.response.UserListResponse;
import com.example.lab1.controller.response.UserResponse;
import com.example.lab1.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {
   @Autowired
    private UserBusiness userBusiness;
   @PostMapping("add")
    public ResponseEntity<BaseResponse> addUser(@RequestBody AddUserRequest request) {
       UserDto userDto = userBusiness.addUser(request);
      return new ResponseEntity<>(new UserResponse(UserErrorCode.SUCCESS, userDto ), HttpStatus.OK);
   }
   @PutMapping("change-pasword/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request) {
       UserDto userDto = userBusiness.updateUser(id, request);
      return new ResponseEntity<>(new UserResponse(UserErrorCode.SUCCESS, userDto), HttpStatus.OK);
   }
   @PostMapping("login")
    public ResponseEntity<BaseResponse> loginUser(@RequestBody LoginRequest request) {
//       logger.error("Có lỗi");
       UserDto userDto = userBusiness.loginUser(request);
       return new ResponseEntity<>(new LoginResponse(UserErrorCode.SUCCESS, userDto), HttpStatus.OK);
   }
   @GetMapping("list")
    public ResponseEntity<BaseResponse> getAllUser() {
       List<UserDto> userDtos = userBusiness.getAllUsers();
       return  new ResponseEntity<>(new UserListResponse(UserErrorCode.SUCCESS, userDtos), HttpStatus.OK);
   }
   @PostMapping("forgot-password")
    public ResponseEntity<BaseResponse> forgotPasswordUser(@RequestBody ForgetPasswordRequest request) {
       String data = userBusiness.forgotPassword(request);
       return new ResponseEntity<>(new BaseResponse(1, data), HttpStatus.OK);
   }
}
