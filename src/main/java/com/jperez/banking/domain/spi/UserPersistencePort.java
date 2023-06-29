package com.jperez.banking.domain.spi;

import com.jperez.banking.domain.models.UserModel;

import java.util.List;

public interface UserPersistencePort {

    UserModel insertUser(UserModel userModel);
    UserModel getUser(Long userId);
    List<UserModel> listUsers();

}
