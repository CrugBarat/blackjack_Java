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

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void dealToSelf(Deck deck) {
        addCard(deck.dealCard());
    }

    public int handTotal(){
        int total = 0;
        for(Card card : this.cards) total += card.getCardValue();
        return total;
    }

    public int checkTotal(Deck deck) {
        if (handTotal() > 21){
            return 0;
        } else if (handTotal() < 16) {
            dealToSelf(deck);
            checkTotal(deck);
        } else return handTotal();
        return 0;
    }

}
