import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack!");

        Player player = new Player("");

        System.out.println("Please enter your name:");
        Scanner userInput = new Scanner(System.in);
        String name = userInput.next();
        player.setName(name);
        System.out.println("Welcome " + player.getName() + "!");


    }
}
