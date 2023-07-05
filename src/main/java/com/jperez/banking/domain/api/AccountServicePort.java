package com.jperez.banking.domain.api;

import com.jperez.banking.domain.models.AccountModel;

public interface AccountServicePort {

    AccountModel createAccount(AccountModel account);
    AccountModel getAccountByAccountNumber(String accountNumber);
    AccountModel operateAccount(double money, String transactionType, String accountNumber);

}
