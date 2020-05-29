import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card, card2;

    @Before
    public void before() {
        player = new Player("Jim Bean");
        card = new Card(CardSuit.SPADES, CardValue.FOUR);
    }

    @Test
    public void canGetName() {
        assertEquals("Jim Bean", player.getName());
    }

    @Test
    public void canCardsSizeToStartAtZero() {
        assertEquals(0, player.getCardsSize());
    }

    @Test
    public void canAddACard() {
        player.addCard(card);
        assertEquals(1, player.getCardsSize());
    }

    @Test
    public void canGetHandTotal() {
        player.addCard(card);
        assertEquals(4, player.handTotal());
    }

}

