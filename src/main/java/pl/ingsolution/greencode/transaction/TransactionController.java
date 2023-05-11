package pl.ingsolution.greencode.transaction;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.transaction.dtos.TransactionInput;
import pl.ingsolution.greencode.transaction.dtos.TransactionOutput;

import java.util.ArrayList;
import java.util.List;

@RestController
public record TransactionController(
        TransactionService transactionService
) {

    @GetMapping("/transactions")
    public List<TransactionInput> generateTransactions() {
        Faker faker = new Faker();
        ArrayList<TransactionInput> result = new ArrayList<>();
        for (int i = 0; i < 70_000; i++) {
            result.add(new TransactionInput(faker.business().creditCardNumber(), faker.business().creditCardNumber(), faker.number().randomDouble(2, 10, 2000)));
        }
        return result;
    }

    @PostMapping("/transactions")
    public List<TransactionOutput> processAllTransactions(@RequestBody final List<TransactionInput> transactions) {
        return transactionService.processTransactions(transactions);
    }
}
