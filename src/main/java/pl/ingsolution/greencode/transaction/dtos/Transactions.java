package pl.ingsolution.greencode.transaction.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record Transactions(
        @Size(max = 10_000) List<@Valid Transaction> transactions
) {
}
