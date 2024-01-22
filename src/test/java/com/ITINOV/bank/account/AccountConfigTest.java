package com.ITINOV.bank.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.CommandLineRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountConfigTest {

    @Mock
    private AccountRepository accountRepository;

    @Captor
    private ArgumentCaptor<List<Account>> accountListCaptor;

    @InjectMocks
    private AccountConfig accountConfig;

    @Test
    public void testAccountConfig () throws Exception {

        CommandLineRunner commandLineRunner = accountConfig.commandLineRunner(accountRepository);
        commandLineRunner.run();

        verify(accountRepository, times(1)).saveAll(accountListCaptor.capture());

        List<Account> savedAccounts = accountListCaptor.getValue();
        assertEquals(2, savedAccounts.size());

        Account savedAccountA = savedAccounts.get(0);
        assertEquals("A", savedAccountA.getName());
        assertEquals(1000, savedAccountA.getSold());
        assertEquals(100, savedAccountA.getOverdraft());

        Account savedAccountB = savedAccounts.get(1);
        assertEquals("B", savedAccountB.getName());
        assertEquals(1500, savedAccountB.getSold());
        assertEquals(200, savedAccountB.getOverdraft());

    }

}
