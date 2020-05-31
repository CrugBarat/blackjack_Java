public class Card {

    private final CardSuit suit;
    private final CardValue value;

    public Card (CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public int getCardValue() {
        return this.value.getValue();
    }

    public CardValue getCardFaceValue() {
        return this.value;
    }
}
