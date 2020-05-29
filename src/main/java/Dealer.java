public class Dealer {

    private String name;

    public Dealer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void deal(Player player, Deck deck) {
        player.addCard(deck.dealCard());
    }

}
