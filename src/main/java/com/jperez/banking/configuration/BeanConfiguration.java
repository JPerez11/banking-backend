package com.jperez.banking.configuration;

import com.jperez.banking.adapters.driven.jpa.postgres.adapter.AccountPostgresAdapter;
import com.jperez.banking.adapters.driven.jpa.postgres.adapter.RolePostgresAdapter;
import com.jperez.banking.adapters.driven.jpa.postgres.adapter.UserPostgresAdapter;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.AccountEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.RoleEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.mappers.UserEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.AccountRepository;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.RoleRepository;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.UserRepository;
import com.jperez.banking.domain.api.AccountServicePort;
import com.jperez.banking.domain.api.UserServicePort;
import com.jperez.banking.domain.spi.AccountPersistencePort;
import com.jperez.banking.domain.spi.RolePersistencePort;
import com.jperez.banking.domain.spi.UserPersistencePort;
import com.jperez.banking.domain.usecases.AccountUseCase;
import com.jperez.banking.domain.usecases.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    // Repositories
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    // Mappers
    private final UserEntityMapper userEntityMapper;
    private final RoleEntityMapper roleEntityMapper;
    private final AccountEntityMapper accountEntityMapper;

    private final PasswordEncoder passwordEncoder;

    // Persistence
    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPostgresAdapter(userRepository, userEntityMapper, passwordEncoder);
    }
    @Bean
    public RolePersistencePort rolePersistencePort() {
        return new RolePostgresAdapter(roleRepository, roleEntityMapper);
    }
    @Bean
    public AccountPersistencePort accountPersistencePort() {
        return new AccountPostgresAdapter(accountRepository, userRepository, accountEntityMapper, userEntityMapper);
    }

    // Services
    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), rolePersistencePort());
    }
    @Bean
    AccountServicePort accountServicePort() {
        return new AccountUseCase(accountPersistencePort());
    }

}
