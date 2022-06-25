package pipbd.bapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pipbd.bapp.models.Account;
import pipbd.bapp.repositories.AccountRepository;

@Service
@RequiredArgsConstructor
public class WithdrawalDepositService {

    public final AccountRepository accountRepository;

    public Account depositAmountById(Account account){
        return accountRepository.save(account);
    }

}
