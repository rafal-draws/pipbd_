package pipbd.bapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pipbd.bapp.models.Account;
import pipbd.bapp.services.AccountService;
import pipbd.bapp.services.WithdrawalDepositService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final WithdrawalDepositService withdrawalDepositService;
    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/accounts/{id}/balance")
    public float getAccountBalanceById(@PathVariable Long id){
        return accountService.getBalanceById(id);
    }


    @PutMapping("/accounts/{id}/deposit/{amount}")
    public String depositAmountForAccount(@PathVariable Long id, @PathVariable Float amount){
        return accountService.depositWithdrawAmount(id, amount);
    }
}
