package com.ITINOV.bank.withdraw;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.account.AccountService;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {

    private final WithdrawRepository withdrawRepository;

    private final AccountService accountService;

    public WithdrawService (WithdrawRepository withdrawRepository, AccountService accountService){
        this.withdrawRepository = withdrawRepository;
        this.accountService = accountService;
    }

    public Withdraw createWithdraw (WithdrawRequest withdrawRequest) {
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(withdrawRequest.amount());
        withdraw.setToAccount(accountService.findAccountById(withdrawRequest.toAccountId()));
        withdrawRepository.save(withdraw);
        return withdraw;
    }

    public void withdrawMoney (WithdrawRequest withdrawRequest){
        Account accountToWithdrawMoney = accountService.findAccountById(withdrawRequest.toAccountId());
        Integer newSold =  accountToWithdrawMoney.getSold() + withdrawRequest.amount();
        accountService.updateSoldAccount(accountToWithdrawMoney, newSold);
    }

}
