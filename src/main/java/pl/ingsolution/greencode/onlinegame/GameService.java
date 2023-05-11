package pl.ingsolution.greencode.onlinegame;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ingsolution.greencode.onlinegame.dtos.Clan;
import pl.ingsolution.greencode.onlinegame.dtos.Group;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GameService {

    public List<List<Clan>> calculate(final List<Clan> clans, final int groupsCount) {
        sortClansByPointsAndNumberOfPlayers(clans);
        final List<Group> assignedGroups = new ArrayList<>();

        clans.forEach(clan -> assignedGroups.stream()
                .filter(group -> groupsCount >= clan.numberOfPlayers() + group.getPlayersCount())
                .findFirst()
                .ifPresentOrElse(
                        group -> {
                            group.getClans().add(clan);
                            group.setPlayersCount(group.getPlayersCount() + clan.numberOfPlayers());
                            },
                        () -> assignedGroups.add(new Group(clan.numberOfPlayers(), new ArrayList<>(List.copyOf(List.of(clan)))))));

        return assignedGroups.stream().map(Group::getClans).toList();
    }

    private void sortClansByPointsAndNumberOfPlayers(final List<Clan> clans) {
        clans.sort((o1, o2) -> {
            int pointComparison = Integer.compare(o1.points(), o2.points());
            if (pointComparison == 0) {
                return Integer.compare(o1.numberOfPlayers(), o2.numberOfPlayers());
            }
            return -pointComparison;
        });
    }
}
