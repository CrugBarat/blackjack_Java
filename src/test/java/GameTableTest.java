import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTableTest {

    private GameTable gameTable;
    private Player player;
    private Dealer dealer;

    @Before
    public void before() {
        gameTable = new GameTable();
        player = new Player("Maverick");
        dealer = new Dealer("Jim Bean");
    }

    @Test
    public void canGetGameTableSizeAtZero() {
        assertEquals(0, gameTable.getPlayersSize());
    }

    @Test
    public void canAddPlayer() {
        gameTable.addPlayer(player);
        assertEquals(1, gameTable.getPlayersSize());
    }

    @Test
    public void canRemovePlayer() {
        gameTable.addPlayer(player);
        gameTable.removePlayer(player);
        assertEquals(0, gameTable.getPlayersSize());
    }

    @Test
    public void canAddDealer() {
        gameTable.addPlayer(dealer);
        assertEquals(1, gameTable.getPlayersSize());
    }

    @Test
    public void canAddMultiplePlayers() {
        gameTable.addPlayer(dealer);
        gameTable.addPlayer(player);
        assertEquals(2, gameTable.getPlayersSize());
    }
}
