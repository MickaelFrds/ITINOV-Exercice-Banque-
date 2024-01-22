package com.ITINOV.bank.account;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService (AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> findAllAccount(){
       return accountRepository.findAll();
    }
}
