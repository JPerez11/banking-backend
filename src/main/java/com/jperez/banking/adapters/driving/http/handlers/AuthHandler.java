package com.jperez.banking.adapters.driving.http.handlers;

import com.jperez.banking.adapters.driving.http.dto.request.LoginCredentials;
import com.jperez.banking.adapters.driving.http.dto.response.JwtResponseDto;

public interface AuthHandler {

    JwtResponseDto login(LoginCredentials loginCredentials);

}
