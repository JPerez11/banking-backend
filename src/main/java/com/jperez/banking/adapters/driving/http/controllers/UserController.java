package com.jperez.banking.adapters.driving.http.controllers;

import com.jperez.banking.adapters.driving.http.dto.request.UserRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.UserResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.UserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserHandler userHandler;

    @PostMapping("/insert")
    public ResponseEntity<UserResponseDto> insertUser(@Valid @RequestBody UserRequestDto userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userHandler.insertUser(userRequest));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userHandler.getUser(id));
    }

    @GetMapping("/get/")
    public ResponseEntity<List<UserResponseDto>> listUser() {
        return ResponseEntity.ok(userHandler.listUsers());
    }

}
