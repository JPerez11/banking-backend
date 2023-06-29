package com.jperez.banking.configuration;

import com.jperez.banking.adapters.driven.jpa.postgres.adapter.RolePostgresAdapter;
import com.jperez.banking.adapters.driven.jpa.postgres.adapter.UserPostgresAdapter;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.RoleEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.UserEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.RoleRepository;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.UserRepository;
import com.jperez.banking.domain.api.UserServicePort;
import com.jperez.banking.domain.spi.RolePersistencePort;
import com.jperez.banking.domain.spi.UserPersistencePort;
import com.jperez.banking.domain.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final UserEntityMapper userEntityMapper;
    private final RoleEntityMapper roleEntityMapper;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPostgresAdapter(userRepository, userEntityMapper, passwordEncoder);
    }
    @Bean
    public RolePersistencePort rolePersistencePort() {
        return new RolePostgresAdapter(roleRepository, roleEntityMapper);
    }
    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), rolePersistencePort());
    }

}
