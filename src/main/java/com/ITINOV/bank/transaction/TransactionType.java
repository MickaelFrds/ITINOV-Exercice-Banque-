package com.ITINOV.bank.transaction;

public enum TransactionType {
    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw"),
    TRANSFER("Transfer");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
