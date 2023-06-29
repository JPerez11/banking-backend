package com.jperez.banking.domain.spi;

import com.jperez.banking.domain.models.UserModel;

import java.util.List;

public interface UserPersistencePort {

    // Principal methods
    UserModel insertUser(UserModel userModel);
    UserModel getUser(Long userId);
    List<UserModel> listUsers();

    // Methods to get something
    String encryptedPassword(String password);

    // Methods to validate
    boolean isDocumentNumberAlreadyExist(String documentNumber);
    boolean isEmailAlreadyExist(String email);

}
