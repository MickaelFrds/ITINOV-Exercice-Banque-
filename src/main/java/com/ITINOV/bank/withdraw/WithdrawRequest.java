package com.ITINOV.bank.withdraw;

public record WithdrawRequest(
        Long toAccountId,
        Integer amount
) {
}
