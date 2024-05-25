package com.service;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserId(int id){
        return userRepository.findByUserId(id);
    }

    public User findByUser(String email,String password){
        return userRepository.findByUser(email,password);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        User log = userRepository.findByEmail(user.getEmail());

        if (log == null){
            userRepository.save(user);
        }else{
            throw new IllegalArgumentException("El usuario ya existe");
        }
    }
}
