public class BlackJack {

    private Player player;
    private Dealer dealer;

    public BlackJack(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void deal(Deck deck) {
        dealer.dealToPlayer(player, deck);
        dealer.dealToPlayer(player, deck);
        dealer.dealToSelf(deck);
        dealer.dealToSelf(deck);
    }

    public Object compareTotals(Dealer dealer, Player player) {
        if (dealer.handTotal() != player.handTotal()) {
            if (dealer.handTotal() > player.handTotal()) {
                return dealer;
            } else {
                return player;
            }
        } return dealer;
    }
}
