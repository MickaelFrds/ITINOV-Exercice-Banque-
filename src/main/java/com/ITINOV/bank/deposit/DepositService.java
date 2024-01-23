package com.ITINOV.bank.deposit;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.account.AccountService;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    private final DepositRepository depositRepository;

    private final AccountService accountService;

    public DepositService(DepositRepository depositRepository, AccountService accountService){
        this.depositRepository = depositRepository;
        this.accountService = accountService;
    }

    public Deposit createDeposit(DepositRequest depositRequest) {
        Deposit deposit = new Deposit();
        deposit.setAmount(depositRequest.amount());
        deposit.setToAccount(accountService.findAccountById(depositRequest.toAccountId()));
        depositRepository.save(deposit);
        return deposit;
    }

    public void depositMoney(DepositRequest depositRequest){
        Account accountToDepositMoney = accountService.findAccountById(depositRequest.toAccountId());
        Integer newSold =  accountToDepositMoney.getSold() + depositRequest.amount();
        accountService.updateSoldAccount(accountToDepositMoney, newSold);
    }

}
