package pl.ingsolution.greencode.transaction.dtos;

import java.math.BigDecimal;

public record Transaction(
        String debitAccount,
        String creditAccount,
        BigDecimal amount
) {
}
