package com.jperez.banking.domain.spi;

import com.jperez.banking.domain.models.AccountModel;
import com.jperez.banking.domain.models.UserModel;

public interface AccountPersistencePort {

    AccountModel createAccount(AccountModel account);
    AccountModel getAccountByAccountNumber(String accountNumber);
    AccountModel operateAccount(double balance, String accountNumber);
    // Methods to operate
    String generateAccountNumber();
    UserModel getUserByAuthentication();
    // Methods to validate
    boolean isUserHasAccount(Long userId);

}
