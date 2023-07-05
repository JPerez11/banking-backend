package com.jperez.banking.domain.usecases;

import com.jperez.banking.domain.api.AccountServicePort;
import com.jperez.banking.domain.exceptions.UserAlreadyHasAccountException;
import com.jperez.banking.domain.models.AccountModel;
import com.jperez.banking.domain.models.UserModel;
import com.jperez.banking.domain.spi.AccountPersistencePort;

import java.time.LocalDateTime;

public class AccountUseCase implements AccountServicePort {

    private final AccountPersistencePort accountPersistencePort;

    public AccountUseCase(AccountPersistencePort accountPersistencePort) {
        this.accountPersistencePort = accountPersistencePort;
    }

    @Override
    public AccountModel createAccount(AccountModel account) {
        account.setAccountNumber(accountPersistencePort.generateAccountNumber());
        UserModel user = accountPersistencePort.getUserByAuthentication();
        if (accountPersistencePort.isUserHasAccount(user.getId())) {
            throw new UserAlreadyHasAccountException();
        }
        account.setUser(user);
        account.setOpeningDate(LocalDateTime.now());
        return accountPersistencePort.createAccount(account);
    }

    @Override
    public AccountModel getAccountByAccountNumber(String accountNumber) {
        return accountPersistencePort.getAccountByAccountNumber(accountNumber);
    }

    @Override
    public AccountModel operateAccount(double money, String transactionType, String accountNumber) {
        double balance = getAccountByAccountNumber(accountNumber).getBalance();
        if (transactionType.equalsIgnoreCase("DEPOSIT")) {
            balance += money;
        } else if (transactionType.equalsIgnoreCase("WITHDRAW")) {
            balance -= money;
        }
        return accountPersistencePort.operateAccount(balance, accountNumber);
    }
}
