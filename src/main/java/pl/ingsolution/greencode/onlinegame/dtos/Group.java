package pl.ingsolution.greencode.onlinegame.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @JsonIgnore
    private int playersCount;
    @NotNull
    private List<Clan> clans;
}
