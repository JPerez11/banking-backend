package com.jperez.banking.adapters.driven.jpa.postgres.repositories;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findBankEntityByAccountNumber(String accountNumber);

    @Modifying
    @Query(value = "UPDATE AccountEntity a SET a.balance = :balance WHERE a.accountNumber = :accountNumber")
    void updateBalanceInAccount(@Param("balance") double balance,
                                @Param("accountNumber") String accountNumber);
    boolean existsByAccountNumber(String accountNumber);
    boolean existsByUserId(Long userId);

}
