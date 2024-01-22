package com.ITINOV.bank.account;
import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

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
    private String name;
    private Integer sold;

    private Integer Overdraft;
    public Account(){}

    public Account(String name, Integer sold, Integer overdraft) {
        this.name = name;
        this.sold = sold;
        this.Overdraft = overdraft;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getOverdraft() {
        return Overdraft;
    }

    public void setOverdraft(Integer overdraft) {
        Overdraft = overdraft;
    }


}
