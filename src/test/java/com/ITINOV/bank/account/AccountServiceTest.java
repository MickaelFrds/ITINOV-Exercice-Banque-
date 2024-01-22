package com.ITINOV.bank.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {


    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testFindAllAccount (){

        Account accountA = new Account("A", 1000);
        Account accountB = new Account("B", 1500);
        List<Account> mockAccounts = List.of(accountA, accountB);
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        List<Account> listAccount = accountService.findAllAccount();

        Account account1 = listAccount.get(0);
        assertEquals("A",account1.getName());
        assertEquals(1000,account1.getSold());

        Account account2 = listAccount.get(1);
        assertEquals("B",account2.getName());
        assertEquals(1500,account2.getSold());
    }
}
