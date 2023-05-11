package pl.ingsolution.greencode.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ingsolution.greencode.transaction.dtos.Transaction;
import pl.ingsolution.greencode.transaction.dtos.Account;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class TransactionService {

    public List<Account> processTransactions(List<Transaction> transactions) {
        log.debug("Starting to processing transactions");
        final Map<String, Account> accounts = prepareAccountsSummary(transactions);
        transactions.forEach(transaction -> {
            accounts.computeIfPresent(transaction.debitAccount(), (k, value) -> {
                value.setBalance(value.getBalance() - transaction.amount());
                value.setDebitCount(value.getDebitCount() + 1);
                return value;
            });

            accounts.computeIfPresent(transaction.creditAccount(), (k, value) -> {
                value.setBalance(value.getBalance() + transaction.amount());
                value.setCreditCount(value.getCreditCount() + 1);
                return value;
            });
        });
        log.debug("Transactions processed");
        return accounts.values().stream().sorted(Comparator.comparing(Account::getAccount)).toList();
    }

    private Map<String, Account> prepareAccountsSummary(List<Transaction> transactions) {
        log.debug("Preparing accounts map");
        return transactions.stream().flatMap(t -> Stream.of(t.debitAccount(), t.creditAccount()))
                .distinct()
                .map(t -> new Account(t, 0, 0, 0))
                .collect(Collectors.toMap(Account::getAccount, Function.identity()));
    }
}
