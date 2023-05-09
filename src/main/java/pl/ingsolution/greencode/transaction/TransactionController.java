package pl.ingsolution.greencode.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.transaction.dtos.TransactionInput;
import pl.ingsolution.greencode.transaction.dtos.TransactionOutput;

import java.util.List;

@RestController
public record TransactionController(
        TransactionService transactionService
) {

    @PostMapping("/transactions")
    public List<TransactionOutput> processAllTransactions(@RequestBody List<TransactionInput> transactions) {
        return transactionService.processTransactions(transactions);
    }
}
