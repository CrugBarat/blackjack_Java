import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");
        System.out.println("\n");

        Player player = new Player("");
        Dealer dealer = new Dealer("Maverick");
        GameTable gametable = new GameTable();
        Deck deck = new Deck();
        BlackJack blackJack = new BlackJack(gametable, dealer, deck);

        System.out.println("Please enter your name:");
        Scanner userName = new Scanner(System.in);
        String name = userName.next();
        player.setName(name);
        gametable.addPlayer(player);

        System.out.println("\n");
        System.out.println("Welcome " + player.getName() + "!");


        System.out.println("How much cash do you have?");
        Scanner userCash = new Scanner(System.in);
        int cash = Integer.parseInt(userCash.next());
        player.setCash(cash);

        System.out.println("\n");
        System.out.println("Great! " + player.getName() + " you have " + player.getCash() + " bucks!");
        System.out.println("Dealing....");

        blackJack.deal();

        System.out.println("Your hand: " + player.handTotal());
        System.out.println("Dealers hand: " + dealer.handTotal());


    }
}
