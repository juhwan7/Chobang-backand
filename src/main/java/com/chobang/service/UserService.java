package com.chobang.service;

import com.chobang.dto.user.request.SignUpUserRequest;
import com.chobang.entitiy.User;
import com.chobang.error.CustomException;
import com.chobang.error.domain.UserErrorCode;
import com.chobang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String signupUser(SignUpUserRequest request) {
        // 등록되어 있는 이메일인지 확인
        checkDuplicateUser(request.getEmail());
        // 비밀번호와 비밀번호 확인 값 비교
        validatePasswordMatch(request.getPassword(), request.getPasswordCheck());
        // 비밀번호 암호화
        String encryptPassword = encryptPassword(request.getPassword());
        // 회원 저장(암호화된 비밀번호 포함)
        User user = userRepository.save(User.toSingUpUserEntity(request, encryptPassword));
        return user.getEmail();
    }


    /* 비밀번호 암호화 */
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /* 이메일 중복 체크 */
    public void checkDuplicateUser(String email) {
        if (Boolean.TRUE.equals(userRepository.existsByEmailAndIsDeletedFalse(email)))
            throw new CustomException(UserErrorCode.DUPLICATE_EMAIL);
    }

    /* 비밀번호, 비밀번호체크 값 비교*/
    public void validatePasswordMatch(String password, String passwordCheck) {
        if (!(Objects.equals(password, passwordCheck))) {
            throw new CustomException(UserErrorCode.PASSWORD_CONFIRMATION_MISMATCH);
        }
    }
}
