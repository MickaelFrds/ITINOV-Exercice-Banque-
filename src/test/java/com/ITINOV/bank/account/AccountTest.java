package com.ITINOV.bank.account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountTest {

    @Test
    public void testAccountCreation() {
        Account account = new Account("test", 1000);
        assertEquals("test", account.getName());
        assertEquals(1000, account.getSold());
        assertNull(account.getId());
    }

    @Test
    public void testAccountSetters() {
        Account account = new Account();
        account.setName("test");
        account.setSold(2000);
        assertEquals("test", account.getName());
        assertEquals(2000, account.getSold());
    }
}