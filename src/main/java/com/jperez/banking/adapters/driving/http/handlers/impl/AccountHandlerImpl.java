package com.jperez.banking.adapters.driving.http.handlers.impl;

import com.jperez.banking.adapters.driving.http.dto.request.CreateAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.request.OperationAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.AccountResponseDto;
import com.jperez.banking.adapters.driving.http.handlers.AccountHandler;
import com.jperez.banking.adapters.driving.http.mappers.AccountRequestMapper;
import com.jperez.banking.adapters.driving.http.mappers.AccountResponseMapper;
import com.jperez.banking.domain.api.AccountServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountHandlerImpl implements AccountHandler {

    private final AccountServicePort accountServicePort;
    private final AccountRequestMapper accountRequestMapper;
    private final AccountResponseMapper accountResponseMapper;

    @Override
    public AccountResponseDto createAccount(CreateAccountRequestDto createAccountRequest) {
        return accountResponseMapper.toResponse(
                accountServicePort.createAccount(
                        accountRequestMapper.toModel(createAccountRequest)
                )
        );
    }

    @Override
    public AccountResponseDto getAccountByAccountNumber(String accountNumber) {
        return accountResponseMapper.toResponse(
                accountServicePort.getAccountByAccountNumber(accountNumber)
        );
    }

    @Override
    public AccountResponseDto operationAccount(OperationAccountRequestDto operationAccountRequest,
                                               String accountNumber) {
        return accountResponseMapper.toResponse(
                accountServicePort.operateAccount(
                        operationAccountRequest.getMoney(),
                        operationAccountRequest.getOperationType(),
                        accountNumber)
        );
    }

}
