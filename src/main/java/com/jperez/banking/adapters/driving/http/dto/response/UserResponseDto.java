package com.jperez.banking.adapters.driving.http.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private String name;
    private String documentNumber;
    private String email;
    private String role;

}
