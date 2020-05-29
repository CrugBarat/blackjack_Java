public class BlackJack {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public BlackJack(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.deck.addCards();
        this.deck.shuffleCards();
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

    public void playerTwist() {
        if (player.checkTotal() < 21) {
            dealer.dealToPlayer(player, deck);
        }
    }

    public int playerStick() {
        if (player.checkTotal() < 21) {
            return player.checkTotal();
        }
        return 0;
    }

    public Object compareTotals(Dealer dealer, Player player) {
        if (dealer.checkDealerTotal(deck) != player.checkTotal()) {
            if (dealer.checkDealerTotal(deck) > player.checkTotal()) {
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
