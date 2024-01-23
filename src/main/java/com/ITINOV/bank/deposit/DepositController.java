package com.ITINOV.bank.deposit;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deposit")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService){
        this.depositService = depositService;
    }

    @PostMapping
    public void depositMoneyToAccount(@RequestBody DepositRequest depositRequest){
        depositService.createDeposit(depositRequest);
        depositService.depositMoney(depositRequest);
    }

}
