package com.ITINOV.bank.deposit;

public record DepositRequest(
        Long toAccountId,
        Integer amount
) {
}
