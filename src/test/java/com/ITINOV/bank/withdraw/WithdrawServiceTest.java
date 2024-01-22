package com.ITINOV.bank.withdraw;

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
public class WithdrawServiceTest {

    @Mock
    private WithdrawRepository withdrawRepository;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private WithdrawService withdrawService;

    @Test
    public void testCreateWithdraw() {
        // Arrange
        WithdrawRequest withdrawRequest = new WithdrawRequest(1L, 100);

        Account testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setName("TestAccount");
        testAccount.setSold(1000);
        testAccount.setOverdraft(100);

        when(accountService.findAccountById(1L)).thenReturn(testAccount);

        Withdraw createdWithdraw = withdrawService.createWithdraw(withdrawRequest);

        verify(accountService).findAccountById(1L);
        verify(withdrawRepository).save(any(Withdraw.class));

        assertEquals(100, createdWithdraw.getAmount());
        assertEquals(testAccount, createdWithdraw.getToAccount());
    }

    @Test
    public void testWithdrawMoney() {
        WithdrawRequest withdrawRequest = new WithdrawRequest(1L, 100);

        Account testAccount = new Account();
        testAccount.setId(1L);
        testAccount.setName("TestAccount");
        testAccount.setSold(1000);
        testAccount.setOverdraft(100);

        when(accountService.findAccountById(1L)).thenReturn(testAccount);

        doNothing().when(accountService).updateSoldAccount(testAccount, 1100);

        withdrawService.withdrawMoney(withdrawRequest);

        verify(accountService).findAccountById(1L);
        verify(accountService).updateSoldAccount(testAccount, 1100);
    }
}
