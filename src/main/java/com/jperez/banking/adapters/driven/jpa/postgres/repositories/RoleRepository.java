package com.jperez.banking.adapters.driven.jpa.postgres.repositories;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findRoleEntityByName(String name);

}
