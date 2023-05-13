package pl.ingsolution.greencode.transaction;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.transaction.dtos.Account;
import pl.ingsolution.greencode.transaction.dtos.Transaction;

import java.util.List;

@RestController
public record TransactionController(
        TransactionService transactionService
) {

    @PostMapping("/transactions/report")
    public List<Account> processAllTransactions(
            @RequestBody final List<Transaction> transactions
    ) {
        return transactionService.processTransactions(transactions);
    }
}
