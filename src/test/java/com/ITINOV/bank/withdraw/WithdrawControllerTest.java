package com.ITINOV.bank.withdraw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

public class WithdrawControllerTest {


    @Mock
    private WithdrawService withdrawService;

    @InjectMocks
    private WithdrawController withdrawController;

    @Test
    public void testWithdrawMoneyToAccount() {

        WithdrawRequest withdrawRequest = new WithdrawRequest(1L, 100);

        withdrawController.withdrawMoneyToAccount(withdrawRequest);

        verify(withdrawService).createWithdraw(withdrawRequest);
        verify(withdrawService).withdrawMoney(withdrawRequest);
    }
}
