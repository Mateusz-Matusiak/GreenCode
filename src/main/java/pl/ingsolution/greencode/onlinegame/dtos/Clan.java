package pl.ingsolution.greencode.onlinegame.dtos;

public record Clan(
        int numberOfPlayers,
        int points
) implements Comparable<Clan> {
    @Override
    public int compareTo(Clan o) {
        if(this.points == o.points)
            return Integer.compare(this.numberOfPlayers, o.numberOfPlayers);
        return Integer.compare(o.points, this.points);
    }
}
