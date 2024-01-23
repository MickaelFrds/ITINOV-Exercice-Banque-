package com.ITINOV.bank.deposit;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.account.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepositServiceTest {

    @Mock
    private DepositRepository depositRepository;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private DepositService depositService;

    @Test
    public void testCreateDeposit() {
        // Arrange
        DepositRequest depositRequest = new DepositRequest(1L, 100);

        Account testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setName("TestAccount");
        testAccount.setSold(1000);
        testAccount.setOverdraft(100);

        when(accountService.findAccountById(1L)).thenReturn(testAccount);

        Deposit createdDeposit = depositService.createDeposit(depositRequest);

        verify(accountService).findAccountById(1L);
        verify(depositRepository).save(any(Deposit.class));

        assertEquals(100, createdDeposit.getAmount());
        assertEquals(testAccount, createdDeposit.getToAccount());
    }

    @Test
    public void testDepositMoney() {
        DepositRequest depositRequest = new DepositRequest(1L, 100);

        Account testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setName("TestAccount");
        testAccount.setSold(1000);
        testAccount.setOverdraft(100);

        when(accountService.findAccountById(1L)).thenReturn(testAccount);

        doNothing().when(accountService).updateSoldAccount(testAccount, 1100);

        depositService.depositMoney(depositRequest);

        verify(accountService).findAccountById(1L);
        verify(accountService).updateSoldAccount(testAccount, 1100);
    }
}
