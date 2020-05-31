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
            System.out.println("Let me see that green " + player.getName() + "!");
            System.out.println("You have " + player.getCash() + "!" + " How much you wanna bet?");
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
            System.out.println(dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit());

            System.out.println("\n");

            System.out.println("Stick or Twist? (S/T)");
            String stickOrTwist = userInput.next();
            blackJack.stickOrTwist(player, stickOrTwist);

            while (stickOrTwist.equals("T")) {
                System.out.println(player.getCards().get(2).getCardFaceValue() + " " + player.getCards().get(2).getSuit());
                System.out.println("Hand Total: " + player.handTotal() + "\n");
                System.out.println("Stick or Twist? (S/T)");
                String stickOrTwist2 = userInput.next();
                blackJack.stickOrTwist(player, stickOrTwist2);
                if (stickOrTwist2.equals("S")) {
                    System.out.println("Dealers hand: " + dealer.getCards().get(0).getCardFaceValue() + " " + dealer.getCards().get(0).getSuit() + " - " + dealer.getCards().get(1).getCardFaceValue() + " " + dealer.getCards().get(1).getSuit());
                    System.out.println("Dealer's hand total: " + dealer.handTotal() + "\n");
                    System.out.println(blackJack.compareTotals(dealer, player) + " WINS!");
                    if (blackJack.compareTotals(dealer, player).equals(player.getName())) {
                        player.setCash(player.getCash() + (playerBet * 2));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println("WAH WAH WAH! You're outta luck - See ya!");
    }
}
