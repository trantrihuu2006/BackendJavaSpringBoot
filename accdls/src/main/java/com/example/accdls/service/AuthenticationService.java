package com.example.accdls.service;

import com.example.accdls.dto.request.AuthenticationRequest;
import com.example.accdls.exception.AppException;
import com.example.accdls.exception.ErrorCode;
import com.example.accdls.respository.UserRespository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    UserRespository userRespository;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRespository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(20);

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
