package com.chobang.error.domain;

import com.chobang.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCode {
    PASSWORD_CONFIRMATION_MISMATCH(HttpStatus.CONFLICT.value(), "비밀번호와 비밀번호 확인 값이 일치하지 않습니다."),

    DUPLICATE_EMAIL(HttpStatus.CONFLICT.value(), "중복된 이메일이 있습니다."),

    ;
    private final int code;
    private final String message;


}
