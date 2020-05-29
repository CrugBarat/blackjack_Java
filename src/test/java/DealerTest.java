import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player;
    private Deck deck;
    private Card card;

    @Before
    public void before() {
        dealer = new Dealer("Jane Doe");
        player = new Player("Maverick");
        deck = new Deck();
        deck.addCards();
        deck.shuffleCards();
        card = new Card(CardSuit.SPADES, CardValue.FOUR);
    }

    @Test
    public void canGetName() {
        assertEquals("Jane Doe", dealer.getName());
    }

    @Test
    public void canDealCardToPlayer() {
        dealer.dealToPlayer(player, deck);
        assertEquals(51, deck.getDeckSize());
        assertEquals(1, player.getCardsSize());
    }

    @Test
    public void cardsSizeStartAtZero() {
        assertEquals(0, dealer.getCardsSize());
    }

    @Test
    public void canDealCardToSelf() {
        dealer.dealToSelf(deck);
        assertEquals(51, deck.getDeckSize());
        assertEquals(1, dealer.getCardsSize());
    }

    @Test
    public void canGetHandTotalSelf() {
        dealer.addCard(card);
        assertEquals(4, dealer.handTotal());
    }

    @Test
    public void canGetHandTotalPlayer() {
        player.addCard(card);
        assertEquals(4, player.handTotal());
    }

}
