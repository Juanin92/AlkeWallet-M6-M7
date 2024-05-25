package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    public User findByUser(String email,String password);
    public User findByUserId(int id);
    public User findByEmail(String email);
}
