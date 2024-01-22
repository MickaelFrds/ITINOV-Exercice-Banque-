package com.ITINOV.bank.withdraw;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/withdraw")
public class WithdrawController {

    private final WithdrawService withdrawService;

    public WithdrawController (WithdrawService withdrawService){
        this.withdrawService = withdrawService;
    }

    @PostMapping
    public void withdrawMoneyToAccount(@RequestBody WithdrawRequest withdrawRequest){
        withdrawService.createWithdraw(withdrawRequest);
        withdrawService.withdrawMoney(withdrawRequest);
    }

}
