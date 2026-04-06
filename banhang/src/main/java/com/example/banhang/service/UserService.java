package com.example.banhang.service;

import com.example.banhang.dto.request.UserUpdateRequest;
import com.example.banhang.dto.response.UserResponse;
import com.example.banhang.entity.User;
import com.example.banhang.exception.AppException;
import com.example.banhang.exception.ErrorCode;
import com.example.banhang.mapper.UserMapper;

import com.example.banhang.dto.request.UserCreatetionRequest;
import com.example.banhang.responsitory.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRespository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreatetionRequest request) {
        if (userRespository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXITED);

        User user = userMapper.toUser(request);

        PasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toUserResponse(userRespository.save(user));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = (User) userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("user not found"));

        userMapper.updateUser(user, request);

        PasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toUserResponse(userRespository.save(user));
    }

    public UserResponse getUser(String id) {

        User user = userRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String userId) {
        userRespository.deleteById(userId);
    }

    public List<User> getUser() {
        return userRespository.findAll();
    }
}
