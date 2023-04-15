package com.odkhang.spring_jdbc.services;

import com.odkhang.spring_jdbc.models.user.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    String hello();

    int createUser(UserModel user);

    Optional<UserModel> getUserByName(String name);

    void deleteUser(String name);

    List<UserModel> getAllUser();
}