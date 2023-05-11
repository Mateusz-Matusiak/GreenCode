package pl.ingsolution.greencode.onlinegame;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ingsolution.greencode.onlinegame.dtos.Clan;
import pl.ingsolution.greencode.onlinegame.dtos.Players;

import java.util.ArrayList;
import java.util.List;

@RestController
public record GameController(
        GameService gameService
) {

    @GetMapping("/game")
    public Players getData() {
        Faker faker = new Faker();
        Players players = new Players();
        players.setGroupCount(faker.number().numberBetween(1, 1000));
        List<Clan> clans = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            clans.add(new Clan(faker.number().numberBetween(1, players.getGroupCount()), faker.number().numberBetween(1, 10000)));
        }
        players.setClans(clans);
        return players;
    }

    @PostMapping("/game")
    public List<List<Clan>> onlineGameCalculate(@RequestBody final Players players) {
        return gameService.calculate(players.getClans(), players.getGroupCount());
    }
}
