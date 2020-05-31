import java.util.ArrayList;
import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");
        System.out.println("\n");

        Player player = new Player("");
        Dealer dealer = new Dealer("Dealer");
        GameTable gametable = new GameTable();
        Deck deck = new Deck();
        BlackJack blackJack = new BlackJack(gametable, dealer, deck);
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter your name:");
        String name = userInput.next();
        player.setName(name);
        gametable.addPlayer(player);

        System.out.println("\n");
        System.out.println("Welcome " + player.getName() + "!");


        System.out.println("How much cash do you have?");
        int cash = Integer.parseInt(userInput.next());
        player.setCash(cash);
        System.out.println("Sweet! You have " + player.getCash() + " bucks " + player.getName() + "!");
        System.out.println("\n");

        while(player.getCash() >0) {
            player.setCards(new ArrayList<Card>());
            dealer.setCards(new ArrayList<Card>());

            System.out.println("Let me see that green " + player.getName() + "!");
            System.out.println("You have " + player.getCash() + " sheckles!" + " How much you wanna bet?");

            int playerBet = Integer.parseInt(userInput.next());
            player.setCash(player.getCash() - playerBet);

            System.out.println("Bet placed! You have " + player.getCash() + " spondoolies left!");

            System.out.println("\n");
            System.out.println("Beep Bop Boop. Dealing.........");
            System.out.println("\n");

            blackJack.deal();

            System.out.println("Your hand: ");
            System.out.println(player.getCards().get(0).getCardFaceValue() + " " + player.getCards().get(0).getSuit() + " - " + player.getCards().get(1).getCardFaceValue() + " " + player.getCards().get(1).getSuit());
            System.out.println("Hand total: " + player.handTotal() + "\n");

            System.out.println("Dealers hand: ");
            System.out.println(dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit() + "\n");

            boolean gameRound = true;

            while (gameRound) {
                System.out.println("Stick or Twist? (S/T)");
                String stickOrTwist = userInput.next();

                if(stickOrTwist.equals("T")) {
                    blackJack.stickOrTwist(player, stickOrTwist);
                    System.out.println("\n" + player.getCards().get(player.getCardsSize()-1).getCardFaceValue() + " " + player.getCards().get(player.getCardsSize()-1).getSuit());
                    System.out.println("Hand total: " + player.handTotal() + "\n");
                    if(player.handTotal() > 21) {
                        System.out.println("No luck, you're BUST");
                        break;
                    }
                }

                if(stickOrTwist.equals("S")) {
                    break;
                }
            }

            System.out.println("\nDealers hand: " + dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit() + " - " + dealer.getCards().get(1).getCardFaceValue() + " " + dealer.getCards().get(1).getSuit());
            System.out.println("Dealer's hand total: " + dealer.handTotal() + "\n");

            while(dealer.handTotal() < 16) {
                System.out.println("Dealer twist:");
                blackJack.dealerTwist();
                System.out.println(dealer.getCards().get(dealer.getCardsSize()-1).getCardFaceValue() + " " + dealer.getCards().get(dealer.getCardsSize()-1).getSuit());
                System.out.println("Dealer total: " + dealer.handTotal() + "\n");
                if(dealer.handTotal() > 21){
                    System.out.println("Oooft! The Dealer's BUST \n");
                    break;
                }
            }

            System.out.println("Dealer total: " + dealer.handTotal());
            System.out.println("Your Hand total: " + player.handTotal() + "\n");

            System.out.println(blackJack.compareTotals(dealer, player) + " WINS! \n");

            if (blackJack.compareTotals(dealer, player).equals(player.getName())) {
                player.setCash(player.getCash() + playerBet * 2);
            }

            gameRound = false;
        }
        System.out.println("WAH WAH WAH! You're outta luck - See ya!");
        }
    }

