package com.jperez.banking.adapters.driving.http.handlers;

import com.jperez.banking.adapters.driving.http.dto.request.CreateAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.request.OperationAccountRequestDto;
import com.jperez.banking.adapters.driving.http.dto.response.AccountResponseDto;

public interface AccountHandler {

    AccountResponseDto createAccount(CreateAccountRequestDto createAccountRequest);
    AccountResponseDto getAccountByAccountNumber(String accountNumber);
    AccountResponseDto operationAccount(OperationAccountRequestDto operationAccountRequest, String accountNumber);

}
