package com.jperez.banking.adapters.driven.jpa.postgres.adapter;

import com.jperez.banking.adapters.driven.jpa.postgres.mappers.RoleEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.RoleRepository;
import com.jperez.banking.domain.models.RoleModel;
import com.jperez.banking.domain.spi.RolePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class RolePostgresAdapter implements RolePersistencePort {

    private final RoleRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public RoleModel findRoleByName(String name) {
        return roleEntityMapper.toModel(
                roleRepository.findRoleEntityByName(name).orElse(null)
        );
    }
}
