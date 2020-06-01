import java.util.ArrayList;

public class GameTable {

    private ArrayList<Player> players;

    public GameTable() {
        this.players = new ArrayList<Player>();
    }

    public int getPlayersSize() {
        return this.players.size();
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
}
