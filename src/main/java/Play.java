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

        System.out.println("\n");
        System.out.println("Great! " + player.getName() + " you have " + player.getCash() + " bucks!");
        System.out.println("Dealing....");

        blackJack.deal();
//
        System.out.println("Your hand: ");
        System.out.println(player.getCardFaceValueCardOne() + " " + player.getCardSuitCardOne() + " & " + player.getCardFaceValueCardTwo() + " " + player.getCardSuitCardTwo());
        System.out.println("Hand Total: " + player.handTotal() + "\n");
        System.out.println("Dealers hand: " + dealer.getCardFaceValueCardOne() + " " + dealer.getCardSuitCardOne());

        System.out.println("\n");

        System.out.println("Stick or Twist? (S/T)");
        String stickOrTwist = userInput.next();

        blackJack.stickOrTwist(player, stickOrTwist);

        System.out.println("Your hand: " + player.handTotal());
        System.out.println("Dealers hand: " + dealer.handTotal());
        System.out.println(blackJack.compareTotals(dealer, player) + " WINS!");



    }
}
