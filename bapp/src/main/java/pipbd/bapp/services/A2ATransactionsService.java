package pipbd.bapp.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pipbd.bapp.models.A2ATransaction;
import pipbd.bapp.models.Account;
import pipbd.bapp.models.dto.A2ATransactionDTO;
import pipbd.bapp.repositories.A2ATransactionRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class A2ATransactionsService {

    private static final Long EMPTY_ID = null;
    private final A2ATransactionRepository a2ATransactionRepository;
    private final AccountService accountService;
    public A2ATransaction getA2ATransactionById(long id) {
        return a2ATransactionRepository.findById(id).orElseThrow();
    }

    public List<A2ATransaction> getAllA2ATransactions() {
        return a2ATransactionRepository.findAll();
    }

    public String createA2ATransaction(A2ATransactionDTO a2ATransactionDTO) throws Exception{



        Account senderAcc = accountService.getAccountById(a2ATransactionDTO.getSenderacc());
        Account getterAcc = accountService.getAccountById(a2ATransactionDTO.getGetteracc());


        //changes to bank accounts based on balances numbers are valid

        if ((senderAcc.getBalance().compareTo((a2ATransactionDTO.getAmount()))) < 0){

            a2ATransactionRepository.save(new A2ATransaction(
                    EMPTY_ID,
                    senderAcc.getClientId(),
                    getterAcc.getClientId(),
                    a2ATransactionDTO.getAmount(),
                    Timestamp.from(Instant.now())
            ));
            return "INCORRECT TRANSACTION - REASON: INSUFFICIENT FUNDS";

        } else {

            getterAcc.setBalance(senderAcc.getBalance().add(a2ATransactionDTO.getAmount()));
            senderAcc.setBalance(senderAcc.getBalance().subtract(a2ATransactionDTO.getAmount()));

            a2ATransactionRepository.save(new A2ATransaction(
                    EMPTY_ID,
                    senderAcc.getClientId(),
                    getterAcc.getClientId(),
                    a2ATransactionDTO.getAmount(),
                    Timestamp.from(Instant.now())
            ));

            return "You've successfully sent " + a2ATransactionDTO.getAmount() + "PLN to " +
                    getterAcc.getClientId().getFirstName() +
                    getterAcc.getClientId().getLastName() + ".";

        }


    }
}
