package com.chobang.controller;

import com.chobang.dto.user.request.SignUpUserRequest;
import com.chobang.dto.vo.Response;
import com.chobang.service.UserService;
import com.chobang.utils.ApiUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Api(tags = "로그인, 회원가입")
public class UserController {

    private UserService userService;

    @ApiOperation(value = "유저 회원가입")
    @PostMapping(value = "/signup")
    public Response<String> signupUser(@RequestBody SignUpUserRequest signUpUserRequest) {
        return ApiUtils.success(HttpStatus.OK, "회원가입 성공", userService.signupUser(signUpUserRequest));
    }


}
