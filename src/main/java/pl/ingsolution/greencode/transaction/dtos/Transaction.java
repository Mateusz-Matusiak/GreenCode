package pl.ingsolution.greencode.transaction.dtos;

public record Transaction(
        String debitAccount,
        String creditAccount,
        double amount
) {
}
