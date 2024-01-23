package com.ITINOV.bank.security;

import com.ITINOV.bank.account.Account;

public class SecurityTransaction {

    private SecurityTransaction(){
    }

    public static boolean isOverdraftReached (Account account, Integer newSold) {
        Integer overdraft = account.getOverdraft();
        return newSold < overdraft;
    }
}
