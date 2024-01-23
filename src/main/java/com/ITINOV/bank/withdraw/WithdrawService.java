package com.ITINOV.bank.withdraw;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.account.AccountService;
import com.ITINOV.bank.security.SecurityTransaction;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {

    private final WithdrawRepository withdrawRepository;

    private final AccountService accountService;

    public WithdrawService(WithdrawRepository withdrawRepository, AccountService accountService) {
        this.withdrawRepository = withdrawRepository;
        this.accountService = accountService;
    }

    public void createWithdraw (WithdrawRequest withdrawRequest){
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(withdrawRequest.amount());
        Account accountToWithdrawMoney = accountService.findAccountById(withdrawRequest.fromAccountId());
        withdraw.setFromAccount(accountToWithdrawMoney);
        withdrawRepository.save(withdraw);
    }


    public boolean withdrawMoney (WithdrawRequest withdrawRequest){
        Account accountToWithdrawMoney = accountService.findAccountById(withdrawRequest.fromAccountId());
        Integer newSold =  accountToWithdrawMoney.getSold() - withdrawRequest.amount();
        if (!SecurityTransaction.isOverdraftReached(accountToWithdrawMoney, newSold)){
            accountService.updateSoldAccount(accountToWithdrawMoney, newSold);
            return true;
        }else {
            return false;
        }
    }
}
