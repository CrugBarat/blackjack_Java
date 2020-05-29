public class BlackJack {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public BlackJack(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.deck.addCards();
        this.getDeck().shuffleCards();
    }

    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void deal() {
        dealer.dealToPlayer(player, deck);
        dealer.dealToPlayer(player, deck);
        dealer.dealToSelf(deck);
        dealer.dealToSelf(deck);
    }

    public Object compareTotals(Dealer dealer, Player player) {
        if (dealer.checkTotal(deck) != player.checkTotal()) {
            if (dealer.checkTotal(deck) > player.checkTotal()) {
                return dealer;
            } else {
                return player;
            }
        } return dealer;
    }

    public Object blackJack() {
        deal();
        return compareTotals(dealer, player);
    }
}
