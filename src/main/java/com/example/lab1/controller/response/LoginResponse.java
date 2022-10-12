package com.example.lab1.controller.response;

import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.model.dto.BaseModelDto;
import com.example.lab1.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse extends BaseResponse {
    @JsonProperty(value = "user")
    private UserDto userDto;
    public LoginResponse(UserErrorCode errorCode, UserDto userDto) {
        super(errorCode);
        this.userDto = userDto;
    }
}
