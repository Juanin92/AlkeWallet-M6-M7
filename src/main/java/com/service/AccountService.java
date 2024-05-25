package com.service;

import com.model.Account;
import com.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;
    private static final double usdValue = 908.79;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByUserId(int userId){
        return accountRepository.findByUserId(userId);
    }

    public void deposit(int userId,double amount){
        Account account = accountRepository.findByUserId(userId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            account.setBalanceForeign(account.getBalance() / usdValue);
            accountRepository.save(account);
        }
    }

    public void withdraw(int userId, double amount) {
        Account account = accountRepository.findByUserId(userId);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.setBalanceForeign(account.getBalance() / usdValue);
            accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente en su cuenta");
        }
    }

    public void transfer(int senderUserId, int receiverUserId, double amount) {
        Account senderAccount = accountRepository.findByUserId(senderUserId);
        Account receiverAccount = accountRepository.findByUserId(receiverUserId);

        if (senderAccount != null && receiverAccount != null) {
            if (senderAccount.getBalance() >= amount){
                senderAccount.setBalance(senderAccount.getBalance() - amount);
                senderAccount.setBalanceForeign(senderAccount.getBalance() / usdValue);
                receiverAccount.setBalance(receiverAccount.getBalance() + amount);
                receiverAccount.setBalanceForeign(receiverAccount.getBalance() / usdValue);

                accountRepository.save(senderAccount);
                accountRepository.save(receiverAccount);
            }else{
                throw new IllegalArgumentException("Saldo insuficiente para transferir dinero a otra cuenta");
            }
        } else {
            throw new IllegalArgumentException("Cuenta de destinatario no es correcta");
        }
    }
}
