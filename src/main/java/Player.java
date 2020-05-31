import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;
    private int cash;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.cash = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCardsSize() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public int handTotal(){
        int total = 0;
        for(Card card : this.cards) {
            total += card.getCardValue();
        }
        return total;
    }

    public int checkTotal() {
        if (handTotal() > 21){
            return 0;
        } else {
            return handTotal();
        }
    }

    public CardSuit getCardSuitCardOne() {
        return this.cards.get(0).getSuit();
    }

    public CardSuit getCardSuitCardTwo() {
        return this.cards.get(1).getSuit();
    }

    public CardValue getCardFaceValueCardOne() {
        return this.cards.get(0).getCardFaceValue();
    }

    public CardValue getCardFaceValueCardTwo() {
        return this.cards.get(1).getCardFaceValue();
    }

}
