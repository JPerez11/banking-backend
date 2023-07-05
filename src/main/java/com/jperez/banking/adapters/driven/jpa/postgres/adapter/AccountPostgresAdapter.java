package com.jperez.banking.adapters.driven.jpa.postgres.adapter;

import com.jperez.banking.adapters.driven.jpa.postgres.mappers.AccountEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.UserEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.AccountRepository;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.UserRepository;
import com.jperez.banking.adapters.driven.jpa.postgres.utils.ExtractAuthentication;
import com.jperez.banking.domain.models.AccountModel;
import com.jperez.banking.domain.models.UserModel;
import com.jperez.banking.domain.spi.AccountPersistencePort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class AccountPostgresAdapter implements AccountPersistencePort {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountEntityMapper accountEntityMapper;
    private final UserEntityMapper userEntityMapper;

    @Override
    public AccountModel createAccount(AccountModel account) {
        return accountEntityMapper.toModel(
                accountRepository.save(
                        accountEntityMapper.toEntity(account)
                )
        );
    }

    @Override
    public AccountModel getAccountByAccountNumber(String accountNumber) {
        return accountEntityMapper.toModel(
                accountRepository.findBankEntityByAccountNumber(accountNumber).orElse(null)
        );
    }

    @Override
    public AccountModel operateAccount(double balance, String accountNumber) {
        accountRepository.updateBalanceInAccount(balance, accountNumber);
        return getAccountByAccountNumber(accountNumber);
    }

    @Override
    public String generateAccountNumber() {
        String accountNumber = RandomStringUtils.randomNumeric(10);

        while (accountRepository.existsByAccountNumber(accountNumber)) {
            accountNumber = RandomStringUtils.randomNumeric(10);
        }

        return accountNumber;
    }

    @Override
    public UserModel getUserByAuthentication() {
        String email = ExtractAuthentication.extractEmail();
        return userEntityMapper.toModel(
                userRepository.findUserEntityByEmail(email).orElse(null)
        );
    }

    @Override
    public boolean isUserHasAccount(Long userId) {
        return accountRepository.existsByUserId(userId);
    }
}
