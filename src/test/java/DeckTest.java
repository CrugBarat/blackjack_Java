import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

    public class DeckTest {

        private Deck deck;

        @Before
        public void before() {
            deck = new Deck();
        }

        @Test
        public void canGetDeckSizeStartAtZero() {
            assertEquals(0, deck.getDeckSize());
        }

        @Test
        public void canGetDeckSizeFullDeck() {
            deck.addCards();
            assertEquals(52, deck.getDeckSize());
        }

        @Test
        public void canDealACard() {
            deck.addCards();
            deck.dealCard();
            assertEquals(51, deck.getDeckSize());
        }


    }

