package com.repository;

import com.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    public Account findByUserId(int userId);
    public void deposit(int userId,double amount);
    public void withdraw(int userId,double amount);
    public void transfer(int senderUserid,int receiverUserId,double amount);
}
