package com.ITINOV.bank.transaction;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "transaction")
public class Transaction {

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
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public Transaction(){}

    public Transaction(Integer amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
