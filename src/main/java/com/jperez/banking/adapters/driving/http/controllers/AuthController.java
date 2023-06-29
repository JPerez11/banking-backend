package com.jperez.banking.adapters.driving.http.controllers;

import com.jperez.banking.adapters.driving.http.dto.request.LoginCredentials;
import com.jperez.banking.adapters.driving.http.dto.response.JwtResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.AuthHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthHandler authHandler;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody LoginCredentials loginCredentials) {
        return ResponseEntity.ok(authHandler.login(loginCredentials));
    }

}
