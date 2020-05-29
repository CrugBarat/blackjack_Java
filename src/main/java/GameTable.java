import java.util.ArrayList;

public class GameTable {

    private ArrayList<Player> players;

    public GameTable() {
        this.players = new ArrayList<Player>();
    }

    public int getPlayersSize() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
