import java.util.ArrayList;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");
        System.out.println("\n");

        Dealer dealer = new Dealer("Dealer");
        GameTable gametable = new GameTable();
        Deck deck = new Deck();
        BlackJack blackJack = new BlackJack(gametable, dealer, deck);
        Scanner userInput = new Scanner(System.in);

        System.out.println("How many players?");
        int players = Integer.parseInt(userInput.next());
        int i = 1;

        while (players > 0) {
            Player player = new Player("");
            System.out.println("\nPlease enter Player" + i + "'s name:");
            String name = userInput.next();
            player.setName(name);
            gametable.addPlayer(player);
            System.out.println("How much cash you got?");
            int cash = Integer.parseInt(userInput.next());
            player.setCash(cash);
            System.out.println("Sweet! Here's " + player.getCash() + " bucks worth of chips " + player.getName() + "!");
            i++;
            players--;
        }

        boolean isBlackJack = false;
        int playerBet = 0;

        while (gametable.getPlayersSize() > 0) {
            for (Player player : gametable.getPlayers()) {
                blackJack.checkPlayerCash(player);
                if(gametable.getPlayersSize() == 0) {
                    break;
                }
            }

            for (Player player : gametable.getPlayers()) {
                player.setCards(new ArrayList<Card>());
            }

            dealer.setCards(new ArrayList<Card>());

            blackJack.newDeck();
            blackJack.deal();

            System.out.println("\n");
            System.out.println("Beep Bop Boop. Dealing.........");
            System.out.println("\n");

            for (Player player : gametable.getPlayers()) {
                System.out.println("Let me see that green " + player.getName() + "!");
                System.out.println("You have " + player.getCash() + " sheckles!" + " How much you wanna bet?");

                playerBet = Integer.parseInt(userInput.next());
                player.setCash(player.getCash() - playerBet);

                System.out.println("Bet placed! You have " + player.getCash() + " spondoolies left!");


                System.out.println("\n" + player.getName() + "'s hand:");
                System.out.println(player.getCards().get(0).getCardFaceValue() + " " + player.getCards().get(0).getSuit() + " - " + player.getCards().get(1).getCardFaceValue() + " " + player.getCards().get(1).getSuit());
                System.out.println("Hand total: " + player.handTotal() + "\n");
            }
            System.out.println("Dealers hand: ");
            System.out.println(dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit() + " - |HOLE CARD|\n");

            for (Player player : gametable.getPlayers()) {
                boolean gameRound = true;

                while (gameRound) {
                    if (player.getCardsSize() == 2 && player.handTotal() == 21) {
                        System.out.println("BLACKJACK Y'ALL!!!");
                        isBlackJack = true;
                        break;
                    }

                    System.out.println("\n" + player.getName() + ", you're on " + player.handTotal() + " - Stick or Twist? (S/T)");
                    String stickOrTwist = userInput.next();

                    if (stickOrTwist.equals("T")) {
                        blackJack.stickOrTwist(player, stickOrTwist);
                        System.out.println("\n" + player.getCards().get(player.getCardsSize() - 1).getCardFaceValue() + " " + player.getCards().get(player.getCardsSize() - 1).getSuit());
                        System.out.println(player.getName() + " hand total: " + player.handTotal() + "\n");
                        if (player.handTotal() > 21) {
                            System.out.println("No luck, you're BUST!");
                            break;
                        }
                    }

                    if (stickOrTwist.equals("S")) {
                        break;
                    }
                }
            }
            System.out.println("\nDealers hand: " + dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit() + " - " + dealer.getCards().get(1).getCardFaceValue() + " " + dealer.getCards().get(1).getSuit());
            System.out.println("Dealer's hand total: " + dealer.handTotal() + "\n");

            if (isBlackJack == false) {
                if (dealer.getCardsSize() == 2 && dealer.handTotal() == 21) {
                    System.out.println("BLACKJACK Y'ALL!!!\n");
                } else {
                    while (dealer.handTotal() < 16) {
                        System.out.println("Dealer twist:");
                        blackJack.dealerTwist();
                        System.out.println(dealer.getCards().get(dealer.getCardsSize() - 1).getCardFaceValue() + " " + dealer.getCards().get(dealer.getCardsSize() - 1).getSuit());
                        System.out.println("Dealer total: " + dealer.handTotal() + "\n");
                        if (dealer.handTotal() > 21) {
                            System.out.println("Oooft! The Dealer's BUST! \n");
                            break;
                        }
                    }
                }
            }

            for (Player player : gametable.getPlayers()) {
                System.out.println("Dealer total: " + dealer.handTotal());
                System.out.println(player.getName() + " Hand total: " + player.handTotal() + "\n");

                System.out.println(blackJack.compareTotals(dealer, player) + " WINS!");

                if (blackJack.compareTotals(dealer, player).equals(player.getName())) {
                    player.setCash(player.getCash() + playerBet * 2);
                }
            }
        }
        System.out.println("WAH WAH WAH! GAME OVER - no players with cashola!");
    }
}


