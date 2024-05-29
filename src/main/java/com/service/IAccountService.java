package com.service;

import com.model.Account;

import java.util.Optional;

public interface IAccountService {

    Optional<Account> findByUserId(int userId);
    void deposit(int userId,double amount);
    void withdraw(int userId,double amount);
    void transfer(int senderUserid,int receiverUserId,double amount);
}
