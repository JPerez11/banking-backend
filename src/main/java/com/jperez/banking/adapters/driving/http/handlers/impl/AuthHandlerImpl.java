package com.jperez.banking.adapters.driving.http.handlers.impl;

import com.jperez.banking.adapters.driving.http.dto.request.LoginCredentials;
import com.jperez.banking.adapters.driving.http.dto.response.JwtResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.AuthHandler;
import com.jperez.banking.configuration.security.jwt.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements AuthHandler {

    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;

    @Override
    public JwtResponseDto login(LoginCredentials loginCredentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginCredentials.getEmail(), loginCredentials.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtManager.createJwt(userDetails);

        return new JwtResponseDto(token);
    }
}
