package com.ITINOV.bank.account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AccountTest {

    @Test
    public void testAccountCreation() {
        Account account = new Account("test", 1000,100);
        assertEquals("test", account.getName());
        assertEquals(1000, account.getSold());
        assertEquals(100, account.getOverdraft());
        assertNull(account.getId());
    }

    @Test
    public void testAccountSetters() {
        Account account = new Account();
        account.setId(1L);
        account.setName("test");
        account.setSold(2000);
        account.setOverdraft(200);
        assertEquals(1L, account.getId());
        assertEquals("test", account.getName());
        assertEquals(2000, account.getSold());
        assertEquals(200, account.getOverdraft());
    }
}