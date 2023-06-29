package com.jperez.banking.adapters.driven.jpa.postgres.adapter;

import com.jperez.banking.adapters.driven.jpa.postgres.mappers.UserEntityMapper;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.UserRepository;
import com.jperez.banking.domain.models.UserModel;
import com.jperez.banking.domain.spi.UserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
public class UserPostgresAdapter implements UserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserModel insertUser(UserModel userModel) {
        return userEntityMapper.toModel(
                userRepository.save(
                        userEntityMapper.toEntity(userModel)
                )
        );
    }

    @Override
    public UserModel getUser(Long userId) {
        return userEntityMapper.toModel(
                userRepository.findById(userId).orElse(null)
        );
    }

    @Override
    public List<UserModel> listUsers() {
        return userEntityMapper.toModelList(
                userRepository.findAll()
        );
    }

    @Override
    public String encryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isDocumentNumberAlreadyExist(String documentNumber) {
        return userRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        return userRepository.existsByEmail(email);
    }
}
