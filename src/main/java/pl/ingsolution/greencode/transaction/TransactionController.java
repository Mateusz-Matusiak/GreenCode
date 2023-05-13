package pl.ingsolution.greencode.transaction;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.transaction.dtos.Account;
import pl.ingsolution.greencode.transaction.dtos.Transaction;

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
        for (int i = 0; i < 100_000; i++) {
            result.add(new Transaction(faker.pokemon().name(), faker.pokemon().name(), faker.number().randomDouble(2, 10, 2000)));
        }
        return result;
    }

    @PostMapping("/transactions/report")
    public List<Account> processAllTransactions(
            @RequestBody final List<Transaction> transactions
    ) {
        return transactionService.processTransactions(transactions);
    }
}
