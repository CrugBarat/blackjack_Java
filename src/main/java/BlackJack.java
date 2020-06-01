import java.util.ArrayList;
import java.util.List;

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
        dealer.dealToPlayer(player, deck);
    }

    public void dealerTwist() {
        dealer.dealToSelf(deck);
    }

    public void stickOrTwist(Player player, String input) {
        if(input.equals("T")){
            playerTwist(player);
        }
    }

    public Object compareTotals(Dealer dealer, Player player) {
        if (dealer.checkTotal() != player.checkTotal()) {
            if (dealer.checkTotal() > player.checkTotal()) {
                return dealer.getName();
            } else {
                return player.getName();
            }
        } return dealer.getName();
    }

    public void newDeck() {
        this.deck = new Deck();
        this.deck.addCards();
        this.deck.shuffleCards();
    }

    public void checkPlayerCash() {
        List<Player> toRemove = new ArrayList<Player>();
        for(Player player : this.gameTable.getPlayers()) {
            if (player.getCash() == 0) {
                toRemove.add(player);
            }
        }
        this.gameTable.removeAll(toRemove);
    }

}
