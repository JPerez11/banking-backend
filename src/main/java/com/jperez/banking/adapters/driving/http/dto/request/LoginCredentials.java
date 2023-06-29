package com.jperez.banking.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginCredentials {

    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email field cannot be empty")
    private String email;
    @NotBlank(message = "Password field cannot be empty")
    private String password;

}
