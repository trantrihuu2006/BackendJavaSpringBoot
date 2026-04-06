package com.example.banhang.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreatetionRequest {
    String id;
    String username;
    String password;
    String email;
    LocalDate born;
}
