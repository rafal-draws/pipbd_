package pipbd.bapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pipbd.bapp.models.A2ATransaction;
import pipbd.bapp.models.Account;
import pipbd.bapp.models.dto.A2ATransactionDTO;
import pipbd.bapp.repositories.A2ATransactionRepository;

import java.math.BigDecimal;
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

    public String createA2ATransaction(A2ATransactionDTO a2ATransactionDTO){


        Account senderAcc = accountService.getAccountById(a2ATransactionDTO.getSenderacc());
        Account getterAcc = accountService.getAccountById(a2ATransactionDTO.getGetteracc());

        A2ATransaction currentTransaction = a2ATransactionRepository.save(new A2ATransaction(
                EMPTY_ID,
                senderAcc.getClientId().getId(),
                getterAcc.getClientId().getId(),
                a2ATransactionDTO.getAmount(),
                false,
                Timestamp.from(Instant.now())
        ));

        long currentTransactionId = currentTransaction.getId();
        boolean transactionFlag = a2ATransactionRepository.findById(currentTransactionId).orElseThrow().isFinished();


        if ((senderAcc.getBalance().compareTo((a2ATransactionDTO.getAmount()))) < 0) {

            return "INCORRECT TRANSACTION - REASON: INSUFFICIENT FUNDS";

        } else {

            if (!transactionFlag) {

                getterAcc.setBalance(getterAcc.getBalance().add(a2ATransactionDTO.getAmount()));

                // added validation
                if (getterAcc.getBalance().equals(getterAcc.getBalance().add(a2ATransactionDTO.getAmount()))) {
                    senderAcc.setBalance(senderAcc.getBalance().subtract(a2ATransactionDTO.getAmount()));
                } else {
                    return "There was a network error, couldn't finish the transaction. No funds have been lost";
                }

                currentTransaction.setFinished(true);

                return "You've successfully sent " + a2ATransactionDTO.getAmount() + "PLN to " +
                        getterAcc.getClientId().getFirstName() + " " +
                        getterAcc.getClientId().getLastName() + ".";
            } else {
                return "There has been an error";
            }
        }
    }
}
