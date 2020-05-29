import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    private BlackJack blackjack;
    private Player player;
    private Dealer dealer;
    private Deck deck;


    @Before
    public void before() {
        player =  new Player("Maverick");
        dealer = new Dealer("Jane Doe");
        blackjack = new BlackJack(player, dealer);
        deck = new Deck();
        deck.addCards();
        deck.shuffleCards();
    }

    @Test
    public void canGetPlayer() {
        assertEquals(player, blackjack.getPlayer());
    }

    @Test
    public void canGetDealer() {
        assertEquals(dealer, blackjack.getDealer());
    }

    @Test
    public void canDealCards() {
        blackjack.deal(deck);
        assertEquals(2, player.getCardsSize());
        assertEquals(2, dealer.getCardsSize());
    }
}
