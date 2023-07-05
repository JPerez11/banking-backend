package com.jperez.banking.adapters.driving.http.controllers;

import com.jperez.banking.adapters.driving.http.dto.request.CreateAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.request.OperationAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.AccountResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.AccountHandler;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountHandler accountHandler;

    @SecurityRequirement(name = "jwt")
    @PostMapping("/")
    public ResponseEntity<AccountResponseDto> createAccount(@Valid @RequestBody
                                                                CreateAccountRequestDto createAccountRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountHandler.createAccount(createAccountRequest));
    }

    @SecurityRequirement(name = "jwt")
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDto> getAccountByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountHandler.getAccountByAccountNumber(accountNumber));
    }

    @SecurityRequirement(name = "jwt")
    @PatchMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDto> operationAccount(@Valid @RequestBody
                                                               OperationAccountRequestDto operationAccountRequest,
                                                               @PathVariable String accountNumber) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountHandler.operationAccount(operationAccountRequest, accountNumber));
    }


}
