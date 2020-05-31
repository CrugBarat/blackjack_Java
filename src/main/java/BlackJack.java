public class BlackJack {

    private Dealer dealer;
    private Deck deck;
    private GameTable gameTable;

    public BlackJack(GameTable gameTable, Dealer dealer, Deck deck) {
        this.gameTable = gameTable;
        this.dealer = dealer;
        this.deck = deck;
        this.deck.addCards();
        this.deck.shuffleCards();
    }

    public GameTable getGameTable() {
        return this.gameTable;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void deal() {
        if (this.gameTable.getPlayersSize() > 0) {
            for (Player player : this.gameTable.getPlayers()) {
                dealer.dealToPlayer(player, deck);
                dealer.dealToPlayer(player, deck);
            }
        }
        dealer.dealToSelf(deck);
        dealer.dealToSelf(deck);
    }

    public void playerTwist(Player player) {
        if (player.checkTotal() < 21) {
            dealer.dealToPlayer(player, deck);
        }
    }

    public int playerStick(Player player) {
        if (player.checkTotal() < 21) {
            return player.checkTotal();
        }
        return 0;
    }

    public void stickOrTwist(Player player, String input) {
        if(input.equals("T")){
            playerTwist(player);
        }
    }

    public Object compareTotals(Dealer dealer, Player player) {
        if (dealer.checkDealerTotal(deck) != player.checkTotal()) {
            if (dealer.checkDealerTotal(deck) > player.checkTotal()) {
                return dealer.getName();
            } else {
                return player.getName();
            }
        } return dealer;
    }

    public Object blackJack(Player player) {
        deal();
        return compareTotals(dealer, player);
    }
}
