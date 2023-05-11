package pl.ingsolution.greencode.transaction.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record Transaction(
        @Size(min = 26, max = 26) String debitAccount,
        @Size(min = 26, max = 26) String creditAccount,
        @Min(0) double amount
) {
}
