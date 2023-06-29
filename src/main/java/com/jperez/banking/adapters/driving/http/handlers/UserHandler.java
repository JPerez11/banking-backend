package com.jperez.banking.adapters.driving.http.handlers;

import com.jperez.banking.adapters.driving.http.dto.request.UserRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.UserResponseDto;

import java.util.List;

public interface UserHandler {

    UserResponseDto insertUser(UserRequestDto userRequest);
    UserResponseDto getUser(Long id);
    List<UserResponseDto> listUsers();

}
