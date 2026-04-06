package com.example.banhang.mapper;

import com.example.banhang.dto.request.UserCreatetionRequest;
import com.example.banhang.dto.request.UserUpdateRequest;
import com.example.banhang.dto.response.UserResponse;
import com.example.banhang.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreatetionRequest request);

    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
