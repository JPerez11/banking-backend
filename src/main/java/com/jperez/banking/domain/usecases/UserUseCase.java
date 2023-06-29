package com.jperez.banking.domain.usecases;

import com.jperez.banking.domain.api.UserServicePort;
import com.jperez.banking.domain.models.UserModel;
import com.jperez.banking.domain.spi.UserPersistencePort;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserModel insertUser(UserModel userModel) {
        return userPersistencePort.insertUser(userModel);
    }

    @Override
    public UserModel getUser(Long userId) {
        return userPersistencePort.getUser(userId);
    }

    @Override
    public List<UserModel> listUsers() {
        return userPersistencePort.listUsers();
    }
}
