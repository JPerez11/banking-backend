package com.jperez.banking.domain.usecases;

import com.jperez.banking.domain.api.UserServicePort;
import com.jperez.banking.domain.exceptions.DocumentNumberAlreadyExistsException;
import com.jperez.banking.domain.exceptions.EmailAlreadyExistsException;
import com.jperez.banking.domain.exceptions.PasswordNoMatchException;
import com.jperez.banking.domain.exceptions.UserNotFoundException;
import com.jperez.banking.domain.models.UserModel;
import com.jperez.banking.domain.spi.RolePersistencePort;
import com.jperez.banking.domain.spi.UserPersistencePort;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistencePort userPersistencePort;
    private final RolePersistencePort rolePersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort, RolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public UserModel insertUser(UserModel userModel) {
        if (userModel == null) {
            throw new NullPointerException();
        }
        if (userPersistencePort.isDocumentNumberAlreadyExist(userModel.getDocumentNumber())) {
            throw new DocumentNumberAlreadyExistsException();
        }
        if (userPersistencePort.isEmailAlreadyExist(userModel.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        if (!passwordMatch(userModel.getPassword(), userModel.getConfirmPassword())) {
            throw new PasswordNoMatchException();
        }

        userModel.setRole(rolePersistencePort.findRoleByName(userModel.getRole().getName()));
        userModel.setPassword(userPersistencePort.encryptedPassword(userModel.getPassword()));

        return userPersistencePort.insertUser(userModel);
    }

    @Override
    public UserModel getUser(Long userId) {
        UserModel user = userPersistencePort.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public List<UserModel> listUsers() {
        List<UserModel> users = userPersistencePort.listUsers();
        if (users.isEmpty()) {
            throw new UserNotFoundException();
        }
        return users;
    }

    // Method to validate

    // Method to confirm password
    private boolean passwordMatch(String password1, String password2) {
        return password1.equals(password2);
    }
}
