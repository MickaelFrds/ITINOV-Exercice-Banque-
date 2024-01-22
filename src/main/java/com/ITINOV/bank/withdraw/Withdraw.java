package com.ITINOV.bank.withdraw;

import com.ITINOV.bank.account.Account;
import jakarta.persistence.*;

@Entity
@Table (name = "withdraw")
public class Withdraw {

    @Id
    @SequenceGenerator(
            name = "account_seq",
            sequenceName = "account_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_seq"
    )
    private Long id;
    private Integer amount;
    @ManyToOne
    private Account toAccount;

    public Withdraw(){}

    public Withdraw(Integer amount, Account toAccount) {
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
