package com.jperez.banking.adapters.driving.http.handlers.impl;

import com.jperez.banking.adapters.driving.http.dto.request.UserRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.UserResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.UserHandler;
import com.jperez.banking.adapters.driving.http.mappers.UserRequestMapper;
import com.jperez.banking.adapters.driving.http.mappers.UserResponseMapper;
import com.jperez.banking.domain.api.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponseDto insertUser(UserRequestDto userRequest) {
        return userResponseMapper.toResponse(
                userServicePort.insertUser(
                        userRequestMapper.toModel(userRequest)
                )
        );
    }

    @Override
    public UserResponseDto getUser(Long id) {
        return userResponseMapper.toResponse(
                userServicePort.getUser(id)
        );
    }

    @Override
    public List<UserResponseDto> listUsers() {
        return userResponseMapper.toResponseList(
                userServicePort.listUsers()
        );
    }
}
