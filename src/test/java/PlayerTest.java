import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card, card2, card3;

    @Before
    public void before() {
        player = new Player("Jim Bean");
        card = new Card(CardSuit.SPADES, CardValue.FOUR);
        card2 = new Card(CardSuit.SPADES, CardValue.TEN);
        card3 = new Card(CardSuit.SPADES, CardValue.QUEEN);
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

    @Test
    public void cancheckHandTotalProceed() {
        player.addCard(card);
        assertEquals(4, player.checkTotal());
    }

    @Test
    public void cancheckHandTotalBust() {
        player.addCard(card);
        player.addCard(card2);
        player.addCard(card3);
        assertEquals(0, player.checkTotal());
    }

}

