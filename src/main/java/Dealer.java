import java.util.ArrayList;

public class Dealer {

    private String name;
    private ArrayList<Card> cards;

    public Dealer(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public void dealToPlayer(Player player, Deck deck) {
        player.addCard(deck.dealCard());
    }

    public int getCardsSize() {
        return this.cards.size();
    }

    public void dealToSelf(Deck deck) {
        this.cards.add(deck.dealCard());
    }
}
