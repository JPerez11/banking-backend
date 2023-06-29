package com.jperez.banking.domain.api;

import com.jperez.banking.domain.models.UserModel;

import java.util.List;

public interface UserServicePort {

    UserModel insertUser(UserModel userModel);
    UserModel getUser(Long userId);
    List<UserModel> listUsers();

}
