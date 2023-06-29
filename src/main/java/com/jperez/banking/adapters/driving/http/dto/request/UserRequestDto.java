package com.jperez.banking.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Name field cannot be empty")
    private String name;
    @Pattern(regexp = "^\\d{9,14}$", message = "Document number field must only contain numbers")
    @NotBlank(message = "Document number field cannot be empty")
    private String documentNumber;
    @Email(message = "Invalid Email format")
    @NotBlank(message = "Email field cannot be empty")
    private String email;
    @NotBlank(message = "Password field cannot be empty")
    private String password;
    @NotBlank(message = "Password confirmation field cannot be empty")
    private String confirmPassword;
    @NotBlank(message = "Role field cannot be empty")
    private String role;

}
