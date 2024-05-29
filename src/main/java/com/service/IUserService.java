package com.service;

import com.model.UserEntity;

import java.util.Optional;

public interface IUserService {

    Optional<UserEntity> findByUserId(int id);
    UserEntity findByUser(String email, String password);
    UserEntity findByEmail(String email);
    UserEntity saveUser(UserEntity userEntity);
}
