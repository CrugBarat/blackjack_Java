import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");
        System.out.println("\n");

        Player player = new Player("");

        System.out.println("Please enter your name:");
        Scanner userName = new Scanner(System.in);
        String name = userName.next();
        player.setName(name);

        System.out.println("\n");
        System.out.println("Welcome " + player.getName() + "!");


        System.out.println("How much cash do you have?");
        Scanner userCash = new Scanner(System.in);
        int cash = Integer.parseInt(userCash.next());
        player.setCash(cash);

        System.out.println("\n");
        System.out.println("Great! " + player.getName() + " you have " + player.getCash() + " bucks!");
    }
}
