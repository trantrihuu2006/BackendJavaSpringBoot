package com.example.accdls.controller;

import com.example.accdls.dto.request.ApiResponse;
import com.example.accdls.dto.request.AuthenticationRequest;
import com.example.accdls.dto.response.AuthenticationResponse;
import com.example.accdls.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean results = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .results(AuthenticationResponse.builder()
                        .authenticatied(results)
                        .build())
                .build();
    }
}
