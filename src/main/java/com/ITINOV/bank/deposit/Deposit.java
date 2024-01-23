package com.ITINOV.bank.deposit;

import com.ITINOV.bank.account.Account;
import jakarta.persistence.*;

@Entity
@Table (name = "deposit")
public class Deposit {

    @Id
    @SequenceGenerator(
            name = "deposit_seq",
            sequenceName = "deposit_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "deposit_seq"
    )
    private Long id;
    private Integer amount;
    @ManyToOne
    private Account toAccount;

    public Deposit(){}

    public Deposit(Integer amount, Account toAccount) {
        this.amount = amount;
        this.toAccount = toAccount;
    }

    public Long getId() {
        return id;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }
}
