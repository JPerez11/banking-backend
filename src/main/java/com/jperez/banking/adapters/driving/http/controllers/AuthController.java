package com.jperez.banking.adapters.driving.http.controllers;

import com.jperez.banking.adapters.driving.http.dto.request.LoginCredentials;
import com.jperez.banking.adapters.driving.http.dto.response.JwtResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.AuthHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Session login")
public class AuthController {

    private final AuthHandler authHandler;

    @Operation(summary = "Authenticate user",
            description = "Login to authenticate",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Session started", content = {
                            @Content(schema = @Schema(implementation = JwtResponseDto.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "401", description = "Wrong credentials", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    })
            }
    )
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody LoginCredentials loginCredentials) {
        return ResponseEntity.ok(authHandler.login(loginCredentials));
    }

}
