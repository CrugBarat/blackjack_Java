import java.util.ArrayList;

public class Dealer extends Player {

    private ArrayList<Card> cards;

    public Dealer(String name) {
        super(name);
        this.cards = new ArrayList<Card>();
    }

    public void dealToPlayer(Player player, Deck deck) {
        player.addCard(deck.dealCard());
    }

    public void dealToSelf(Deck deck) {
        addCard(deck.dealCard());
    }


}
