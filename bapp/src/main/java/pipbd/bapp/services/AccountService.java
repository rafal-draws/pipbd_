package pipbd.bapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pipbd.bapp.models.Account;
import pipbd.bapp.models.Client;
import pipbd.bapp.repositories.AccountRepository;
import pipbd.bapp.repositories.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public float getBalanceById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        return account.getBalance();
    }

    public String depositWithdrawAmount(Long id, Float amount){
        Account account = accountRepository.findById(id).orElseThrow();
        Client client = account.getClientId();
        if(amount < 0){
            accountRepository.save(new Account(
                    id,
                    account.getClientId(),
                    account.getBalance() + amount,
                    account.getPercentage(),
                    account.getPercentagespan(),
                    account.getPercentagedate()
            ));
            return "You've successfully withdrawn " + Float.toString(amount * -1) + " from " + client.getFirstName() + "'s account";
        } else if (amount.equals(null)) {
            return "Amount cannot be null!";
        } else {
            accountRepository.save(new Account(
                    id,
                    account.getClientId(),
                    account.getBalance() + amount,
                    account.getPercentage(),
                    account.getPercentagespan(),
                    account.getPercentagedate()
            ));
            return "You've successfully deposited " + Float.toString(amount) + " from " + client.getFirstName() + "'s account";
        }
    }


}
