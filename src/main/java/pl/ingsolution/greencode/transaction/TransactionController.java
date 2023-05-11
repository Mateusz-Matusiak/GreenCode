package pl.ingsolution.greencode.transaction;

import com.github.javafaker.Faker;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.transaction.dtos.Account;
import pl.ingsolution.greencode.transaction.dtos.Transaction;
import pl.ingsolution.greencode.transaction.dtos.Transactions;

import java.util.ArrayList;
import java.util.List;

@RestController
public record TransactionController(
        TransactionService transactionService
) {

    @GetMapping("/transactions")
    public List<Transaction> generateTransactions() {
        Faker faker = new Faker();
        ArrayList<Transaction> result = new ArrayList<>();
        for (int i = 0; i < 70_000; i++) {
            result.add(new Transaction(faker.business().creditCardNumber(), faker.business().creditCardNumber(), faker.number().randomDouble(2, 10, 2000)));
        }
        return result;
    }

    @PostMapping("/transactions/report")
    public List<Account> processAllTransactions(
            @RequestBody @Valid @NotNull final Transactions transactions
    ) {
        return transactionService.processTransactions(transactions.transactions());
    }
}
