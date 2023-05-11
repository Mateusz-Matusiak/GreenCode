package pl.ingsolution.greencode.onlinegame.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Players {
    @Min(1) @Max(1000)
    private int groupCount;
    @NotNull @Size(max = 20_000)
    private List<Clan> clans;
}
