package com.ITINOV.bank.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        this.mockMvc = standaloneSetup(accountController).build();
    }

    @Test
    public void testGetAllAccounts() throws Exception {

        Account accountA = new Account("A", 1000);
        Account accountB = new Account("B", 1500);
        List<Account> mockAccounts = List.of(accountA, accountB);
        when(accountService.findAllAccount()).thenReturn(mockAccounts);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/account"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sold").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("B"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].sold").value(1500));
    }
}
