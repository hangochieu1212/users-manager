package com.example.lab1.controller.response;

import com.example.lab1.constant.UserErrorCode;
import com.example.lab1.model.dto.BaseModelDto;
import com.example.lab1.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse {
    @JsonProperty(value = "user")
    private BaseModelDto userDto;
    public UserResponse(UserErrorCode errorCode, BaseModelDto userDto) {
        super(errorCode);
        this.userDto = userDto;
    }
}
