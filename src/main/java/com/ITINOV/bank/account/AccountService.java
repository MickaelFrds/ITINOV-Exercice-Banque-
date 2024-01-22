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

    public  Account findAccountById (Long accountId) {
        return  accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void updateSoldAccount (Account account, Integer newSold) {
        account.setSold(newSold);
        accountRepository.save(account);
    }
}
