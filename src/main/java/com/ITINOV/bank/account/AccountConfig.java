package com.ITINOV.bank.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner (
            AccountRepository accountRepository
    ){
        return args -> {
            Account accountA =  new Account(
                    "A",
                    1000
            );
            Account accountB = new Account(
                    "B",
                    1500
            );
            accountRepository.saveAll(
                    List.of(accountA,accountB)
            );
        };
    }
}
