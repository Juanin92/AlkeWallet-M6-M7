package com.service;

import com.model.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findByUserId(int id){
        return userRepository.findById(id);
    }

    @Override
    public UserEntity findByUser(String email, String password){
        return userRepository.findByUser(email,password);
    }

    @Override
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity){
        UserEntity log = userRepository.findByEmail(userEntity.getEmail());

        if (log == null){
            userRepository.save(userEntity);
        }else{
            throw new IllegalArgumentException("El usuario ya existe");
        }
        return log;
    }
}
