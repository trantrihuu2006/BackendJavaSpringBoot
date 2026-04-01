package com.example.accdls.service;

import com.example.accdls.dto.request.UserCreationRequest;
import com.example.accdls.dto.request.UserUpdateRequest;
import com.example.accdls.dto.response.UserResponse;
import com.example.accdls.entity.User;
import com.example.accdls.exception.AppException;
import com.example.accdls.exception.ErrorCode;
import com.example.accdls.mapper.UserMapper;
import com.example.accdls.respository.UserRespository;
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

    UserRespository userRespository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if (userRespository.existsUsersByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXITED);

        User user = userMapper.toUser(request);
        
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        return userMapper.toUserResponse(userRespository.save(user));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRespository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user, request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRespository.save(user));
    }

    public void deleteUser(String userId) {
        userRespository.deleteById(userId);
    }

    public List<User> getUser() {
        return userRespository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRespository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }
}
