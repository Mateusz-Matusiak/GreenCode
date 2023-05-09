package pl.ingsolution.greencode.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ingsolution.greencode.transaction.dtos.TransactionInput;
import pl.ingsolution.greencode.transaction.dtos.TransactionOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class TransactionService {

    public List<TransactionOutput> processTransactions(List<TransactionInput> transactions) {
        Map<String, TransactionOutput> resultMap = prepareAccountsSummary(transactions);
        transactions.forEach(transaction -> {
            resultMap.computeIfPresent(transaction.debitAccount(), (k, value) -> {
                value.setBalance(value.getBalance() - transaction.amount());
                value.setDebitCount(value.getDebitCount() + 1);
                return value;
            });

            resultMap.computeIfPresent(transaction.creditAccount(), (k, value) -> {
                value.setBalance(value.getBalance() + transaction.amount());
                value.setCreditCount(value.getCreditCount() + 1);
                return value;
            });
        });
        return resultMap.values().stream().sorted(Comparator.comparing(TransactionOutput::getAccount)).toList();
    }

    private Map<String, TransactionOutput> prepareAccountsSummary(List<TransactionInput> transactions) {
        return transactions.stream().flatMap(t -> Stream.of(t.debitAccount(), t.creditAccount()))
                .distinct()
                .map(t -> new TransactionOutput(t, 0, 0, 0))
                .collect(Collectors.toMap(TransactionOutput::getAccount, Function.identity()));
    }
}
