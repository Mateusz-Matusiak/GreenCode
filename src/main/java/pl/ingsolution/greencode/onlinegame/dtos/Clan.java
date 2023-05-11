package pl.ingsolution.greencode.onlinegame.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record Clan(
        @Min(1) @Max(1000) int numberOfPlayers,
        @Min(1) @Max(1_000_000) int points
) {
}
