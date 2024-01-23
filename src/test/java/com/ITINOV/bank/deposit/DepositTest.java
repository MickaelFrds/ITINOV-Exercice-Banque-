package com.ITINOV.bank.deposit;

import com.ITINOV.bank.account.Account;
import com.ITINOV.bank.transaction.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class DepositTest {


    @Mock
    private Account accountTest;
    @Test
    public void testDepositCreation (){
        Deposit deposit = new Deposit(50,accountTest);
        assertEquals(TransactionType.DEPOSIT,deposit.getType());
        assertEquals(50, deposit.getAmount());
        assertEquals(accountTest, deposit.getToAccount());
    }

    @Test
    public  void  testDepositSetters (){
        Deposit deposit = new Deposit();
        deposit.setAmount(60);
        deposit.setToAccount(accountTest);
        assertEquals(accountTest, deposit.getToAccount());
        assertEquals(60, deposit.getAmount());
        assertEquals(accountTest, deposit.getToAccount());

    }

}
