package pl.ingsolution.greencode.onlinegame;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.onlinegame.dtos.Clan;
import pl.ingsolution.greencode.onlinegame.dtos.Players;

import java.util.List;

@RestController
public record GameController(
        GameService gameService
) {

    @PostMapping("/onlinegame/calculate")
    public List<List<Clan>> onlineGameCalculate(@RequestBody final Players players) {
        return gameService.calculate(players.getClans(), players.getGroupCount());
    }
}
