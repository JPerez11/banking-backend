package com.jperez.banking.adapters.driven.jpa.sqlserver.repositories;

import com.jperez.banking.adapters.driven.jpa.sqlserver.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
