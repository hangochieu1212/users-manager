package com.example.lab1.controller.response;

import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListResponse extends BaseResponse {
    @JsonProperty(value = "users")
    private List<UserDto> userDtos;
    public UserListResponse(UserErrorCode errorCode, List<UserDto> userDtos) {
        super(errorCode);
        this.userDtos = userDtos;
    }

}
