package pl.ingsolution.greencode.atm.service.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record ATM(
        @Min(0) @Max(9999) int region,
        @Min(0) @Max(9999) int atmId
) {
}
