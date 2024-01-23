package com.ITINOV.bank.withdraw;


import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.transaction.Transaction;
import com.ITINOV.bank.transaction.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "withdraw")
public class Withdraw  extends Transaction {

    @ManyToOne
    private Account fromAccount;

    public Withdraw(){
        this.setType(TransactionType.WITHDRAW);
    }

    public Withdraw(Integer amount, Account fromAccount) {
        super(amount);
        this.setType(TransactionType.WITHDRAW);
        this.fromAccount = fromAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }
}
