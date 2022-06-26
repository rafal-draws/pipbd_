package pipbd.bapp.controllers;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pipbd.bapp.models.A2ATransaction;
import pipbd.bapp.models.dto.A2ATransactionDTO;
import pipbd.bapp.services.A2ATransactionsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class A2ATransactionsController {

    private final A2ATransactionsService a2ATransactionsService;

    @GetMapping("/transactions")
    public List<A2ATransaction> getAllA2ATransactions(){
        return a2ATransactionsService.getAllA2ATransactions();
    }

    @GetMapping("/transactions/{id}")
    public A2ATransaction getA2ATransactionById(@PathVariable long id){
        return a2ATransactionsService.getA2ATransactionById(id);
    }

    @PostMapping("/transactions/new")
    public String createNewA2ATransaction(@RequestBody A2ATransactionDTO a2ATransactionDTO) throws Exception {
        return a2ATransactionsService.createA2ATransaction(a2ATransactionDTO);
    }

}
