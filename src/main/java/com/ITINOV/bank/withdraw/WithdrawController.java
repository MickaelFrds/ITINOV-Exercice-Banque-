package com.ITINOV.bank.withdraw;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/withdraw")
public class WithdrawController {

    private final WithdrawService withdrawService;

    public WithdrawController (WithdrawService withdrawService){
        this.withdrawService = withdrawService;
    }

    @PostMapping
    public String WithdrawMoneyFromAccount (@RequestBody WithdrawRequest withdrawRequest){
        withdrawService.createWithdraw(withdrawRequest);
        if (withdrawService.withdrawMoney(withdrawRequest)){
            return "Withdrawal was successful";
        }else {
            return "The withdrawal was unsuccessful because the account reached its overdraft limit.";
        }
    }
}
