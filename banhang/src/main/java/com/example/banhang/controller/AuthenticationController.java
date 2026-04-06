package com.example.banhang.controller;

import com.example.banhang.dto.request.ApiResponse;
import com.example.banhang.dto.request.AuthenticationRequest;
import com.example.banhang.dto.request.IntrospectRequest;
import com.example.banhang.dto.response.AuthenticationResponse;
import com.example.banhang.dto.response.IntrospectResponse;
import com.example.banhang.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;
    
    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var results = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .results(results)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var results = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .results(results)
                .build();
    }
}
