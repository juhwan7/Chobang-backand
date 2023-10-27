package com.chobang.dto.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpUserRequest {
    private String email;
    private String address;
    private String detailAddress;
    private String phoneNumber;
    private String password;
    private String passwordCheck;
}
