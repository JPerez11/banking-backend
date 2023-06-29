package com.jperez.banking.adapters.driven.jpa.sqlserver.repositories;

import com.jperez.banking.adapters.driven.jpa.sqlserver.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByEmail(String email);

}
