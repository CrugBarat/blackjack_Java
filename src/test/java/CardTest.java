import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private Card card;

    @Before
    public void before() {
        card = new Card(CardSuit.HEARTS, CardValue.FIVE);
    }

    @Test
    public void canGetSuit() {
        assertEquals(CardSuit.HEARTS, card.getSuit());
    }

    @Test
    public void canGetCardValue() {
        assertEquals(5, card.getCardValue());
    }

}
