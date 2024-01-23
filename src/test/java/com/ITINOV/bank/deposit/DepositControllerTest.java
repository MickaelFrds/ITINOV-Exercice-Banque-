package com.ITINOV.bank.deposit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

public class DepositControllerTest {


    @Mock
    private DepositService depositService;

    @InjectMocks
    private DepositController depositController;

    @Test
    public void testDepositMoneyToAccount() {

        DepositRequest depositRequest = new DepositRequest(1L, 100);

        depositController.depositMoneyToAccount(depositRequest);

        verify(depositService).createDeposit(depositRequest);
        verify(depositService).depositMoney(depositRequest);
    }
}
