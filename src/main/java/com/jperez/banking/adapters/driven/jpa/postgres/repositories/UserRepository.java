package com.jperez.banking.adapters.driven.jpa.postgres.repositories;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByEmail(String email);
    boolean existsByDocumentNumber(String documentNumber);
    boolean existsByEmail(String email);

}
