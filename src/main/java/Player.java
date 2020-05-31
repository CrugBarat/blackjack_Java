import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

}
