import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTableTest {

    private GameTable gameTable;

    @Before
    public void before() {
        gameTable = new GameTable();
    }


    @Test
    public void canGetGameTableSizeAtZero() {
        assertEquals(0, gameTable.getPlayersSize());
    }
}
