package com.ITINOV.bank.deposit;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.transaction.Transaction;
import com.ITINOV.bank.transaction.TransactionType;
import jakarta.persistence.*;

@Entity
@Table (name = "deposit")
public class Deposit extends Transaction {

    @ManyToOne
    private Account toAccount;

    public Deposit(){
        this.setType(TransactionType.DEPOSIT);
    }


    public Deposit(Integer amount, Account toAccount) {
        super(amount);
        this.setType(TransactionType.DEPOSIT);
        this.toAccount = toAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }
}
