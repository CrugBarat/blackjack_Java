import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player;
    private Deck deck;

    @Before
    public void before() {
        dealer = new Dealer("Jane Doe");
        player = new Player("Maverick");
        deck = new Deck();
        deck.addCards();
        deck.shuffleCards();
    }

    @Test
    public void canGetName() {
        assertEquals("Jane Doe", dealer.getName());
    }

    @Test
    public void canDealCard() {
        dealer.deal(player, deck);
        assertEquals(51, deck.getDeckSize());
        assertEquals(1, player.getCardsSize());
    }

}
