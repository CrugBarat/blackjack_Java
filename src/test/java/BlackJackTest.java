import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    private BlackJack blackjack;
    private Player player1, player2, player3, player4;
    private Dealer dealer;
    private Deck deck;
    private Card card1, card2, card3, card4;
    private GameTable gameTable;

    @Before
    public void before() {
        player1 =  new Player("Jim");
        player2 =  new Player("Susan");
        player3 =  new Player("Anne");
        player4 =  new Player("John");
        gameTable = new GameTable();
        gameTable.addPlayer(player1);
        gameTable.addPlayer(player2);
        gameTable.addPlayer(player3);
        gameTable.addPlayer(player4);
        dealer = new Dealer("Jane Doe");
        deck = new Deck();
        blackjack = new BlackJack(gameTable, dealer, deck);
        card1 = new Card(CardSuit.HEARTS, CardValue.SEVEN);
        card2 = new Card(CardSuit.CLUBS, CardValue.ACE);
        card3 = new Card(CardSuit.HEARTS, CardValue.TEN);
        card4 = new Card(CardSuit.CLUBS, CardValue.KING);
    }

    @Test
    public void canDealCards() {
        blackjack.deal();
        assertEquals(2, player1.getCardsSize());
        assertEquals(2, player2.getCardsSize());
        assertEquals(2, player3.getCardsSize());
        assertEquals(2, player4.getCardsSize());
        assertEquals(2, dealer.getCardsSize());
        assertEquals(42, deck.getDeckSize());
    }

    @Test
    public void canPlayerTwist() {
        player1.addCard(card4);
        blackjack.playerTwist(player1);
        assertEquals(2, player1.getCardsSize());
    }

    @Test
    public void canDealerTwist() {
        dealer.addCard(card4);
        blackjack.dealerTwist();
        assertEquals(2, dealer.getCardsSize());
    }

    @Test
    public void canCompareTotalsPlayerWins() {
        dealer.addCard(card1);
        dealer.addCard(card2);
        player1.addCard(card3);
        player1.addCard(card4);
        assertEquals("Jim", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsPlayerWinsMultiCards() {
        dealer.addCard(card1);
        player1.addCard(card2);
        dealer.addCard(card3);
        player1.addCard(card4);
        assertEquals("Jim", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsDealerWins() {
        dealer.addCard(card2);
        dealer.addCard(card4);
        player1.addCard(card1);
        assertEquals("Jane Doe", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsDealerWinsMultiCards() {
        dealer.addCard(card2);
        player1.addCard(card1);
        dealer.addCard(card4);
        player1.addCard(card3);
        assertEquals("Jane Doe", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsHouseWinsOnDraw() {
        dealer.addCard(card3);
        dealer.addCard(card4);
        player1.addCard(card3);
        player1.addCard(card4);
        assertEquals("Jane Doe", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsDealerBustMultiCards() {
        dealer.addCard(card2);
        player1.addCard(card1);
        dealer.addCard(card4);
        player1.addCard(card3);
        dealer.addCard(card3);
        assertEquals("Jim", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canCompareTotalsPlayerBustMultiCards() {
        dealer.addCard(card1);
        player1.addCard(card2);
        dealer.addCard(card3);
        player1.addCard(card3);
        player1.addCard(card3);
        assertEquals("Jane Doe", blackjack.compareTotals(dealer, player1));
    }

    @Test
    public void canRemovePlayerIfNoCash() {
        player1.setCash(0);
        blackjack.checkPlayerCash(player1);
        assertEquals(3, gameTable.getPlayersSize());
    }

    @Test
    public void canRemoveMultiplePlayersIfNoCash() {
        player1.setCash(0);
        player2.setCash(0);
        blackjack.checkPlayerCash(player1);
        blackjack.checkPlayerCash(player2);
        assertEquals(2, gameTable.getPlayersSize());
    }

}
