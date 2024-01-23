package com.ITINOV.bank.withdraw;

public record WithdrawRequest(
        Long fromAccountId,
        Integer amount
) {
}
