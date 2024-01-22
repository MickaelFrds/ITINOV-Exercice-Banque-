package com.ITINOV.bank.withdraw;

import com.ITINOV.bank.account.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class WithdrawTest {


    @Mock
    private Account accountTest;
    @Test
    public void testWithdrawCreation (){
        Withdraw withdraw = new Withdraw(50,accountTest);
        assertEquals(50,withdraw.getAmount());
        assertEquals(accountTest,withdraw.getToAccount());
    }

    @Test
    public  void  testWithdrawSetters (){
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(60);
        withdraw.setToAccount(accountTest);
        assertEquals(60,withdraw.getAmount());
        assertEquals(accountTest,withdraw.getToAccount());

    }

}
