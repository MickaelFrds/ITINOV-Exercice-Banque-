package com.ITINOV.bank.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {


    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testFindAllAccount (){

        Account accountA = new Account("A", 1000,100);
        Account accountB = new Account("B", 1500,200);
        List<Account> mockAccounts = List.of(accountA, accountB);
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        List<Account> listAccount = accountService.findAllAccount();

        Account account1 = listAccount.get(0);
        assertEquals("A",account1.getName());
        assertEquals(1000,account1.getSold());
        assertEquals(100,account1.getOverdraft());

        Account account2 = listAccount.get(1);
        assertEquals("B",account2.getName());
        assertEquals(1500,account2.getSold());
        assertEquals(200,account2.getOverdraft());

    }

    @Test
    public void testFindAccountById(){

        Long accountId = 1L;
        Account testAccount = new Account();
        testAccount.setId(accountId);
        testAccount.setName("TestAccount");
        testAccount.setSold(1000);
        testAccount.setOverdraft(100);
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(testAccount));

        Account result = accountService.findAccountById(accountId);

        assertEquals(accountId, result.getId());
        assertEquals("TestAccount", result.getName());
        assertEquals(1000, result.getSold());
        assertEquals(100, result.getOverdraft());
    }

    @Test
    public  void testUpdateSoldAccount(){
        Account account = new Account();
        account.setId(1L);
        account.setName("TestAccount");
        account.setSold(1000);
        accountRepository.save(account);
        Integer newSold = 1500;
        accountService.updateSoldAccount(account, newSold);
        verify(accountRepository).save(account);
        assertEquals(newSold, account.getSold());
    }
}
