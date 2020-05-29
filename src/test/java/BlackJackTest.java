import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    private BlackJack blackjack;
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private Card card1, card2;


    @Before
    public void before() {
        player =  new Player("Maverick");
        dealer = new Dealer("Jane Doe");
        deck = new Deck();
        blackjack = new BlackJack(player, dealer, deck);
        card1 = new Card(CardSuit.HEARTS, CardValue.FIVE);
        card2 = new Card(CardSuit.CLUBS, CardValue.ACE);
    }

    @Test
    public void canGetPlayer() {
        assertEquals(player, blackjack.getPlayer());
    }

    @Test
    public void canGetDealer() {
        assertEquals(dealer, blackjack.getDealer());
    }

    public void canGetDeck() {
        assertEquals(deck, blackjack.getDeck());
    }

    @Test
    public void canDealCards() {
        blackjack.deal();
        assertEquals(2, player.getCardsSize());
        assertEquals(2, dealer.getCardsSize());
    }

    @Test
    public void canCompareTotalsPlayerWins() {
        dealer.addCard(card1);
        player.addCard(card2);
        assertEquals(player, blackjack.compareTotals(dealer, player));
    }

    @Test
    public void canCompareTotalsDealerWins() {
        dealer.addCard(card2);
        player.addCard(card1);
        assertEquals(dealer, blackjack.compareTotals(dealer, player));
    }

    @Test
    public void canCompareTotalsHouseWinsOnDraw() {
        dealer.addCard(card1);
        player.addCard(card1);
        assertEquals(dealer, blackjack.compareTotals(dealer, player));
    }

}
