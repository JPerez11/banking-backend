package com.jperez.banking.adapters.driving.http.controllers;

import com.jperez.banking.adapters.driving.http.dto.request.UserRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.UserResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@Tag(name = "Users", description = "Users management APIs")
public class UserController {

    private final UserHandler userHandler;

    @Operation(summary = "Create a new user",
            description = "Create a new user. The body of the request requests name, DNI, email, password and role",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User has been created", content = {
                            @Content(schema = @Schema(implementation = UserResponseDto.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "400", description = "Error in request data", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "401", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "409", description = "Conflict with existing data", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE),
                    })
            }
    )
    @PostMapping("/insert")
    public ResponseEntity<UserResponseDto> insertUser(@Valid @RequestBody UserRequestDto userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userHandler.insertUser(userRequest));
    }

    @SecurityRequirement(name = "jwt")
    @Operation(
            summary = "Get a user by id",
            description = "Get a User object by specifying its id. The response is User object with name, DNI, email " +
                    "and role",
//            tags = {"Users", "get"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found", content = {
                            @Content(schema = @Schema(implementation = UserResponseDto.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "401", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "404", description = "User not found", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    })
            }
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@Parameter(description = "User id") @PathVariable Long id) {
        return ResponseEntity.ok(userHandler.getUser(id));
    }

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "List all users",
            description = "All users will be listed",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All users have been listed", content = {
                            @Content(array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "401", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE)
                    }),
                    @ApiResponse(responseCode = "404", description = "No users found", content = {
                            @Content(schema = @Schema(ref = "#/components/schemas/Error"),
                            mediaType = MediaType.APPLICATION_JSON_VALUE)
                    })
            }
    )
    @GetMapping("/get/")
    public ResponseEntity<List<UserResponseDto>> listUser() {
        return ResponseEntity.ok(userHandler.listUsers());
    }

}
