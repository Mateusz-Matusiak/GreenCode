package pl.ingsolution.greencode.transaction.dtos;

public record TransactionInput(
        String debitAccount,
        String creditAccount,
        double amount
) {
}
