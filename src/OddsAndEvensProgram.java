import java.util.Random;
import java.util.Scanner;

public class OddsAndEvensProgram {
	 private static Scanner input = new Scanner(System.in);

    public static void oddsEvens(String name){
        String x;
        x = "y";
        while (x.equals("y")) {
            playOddsEvens(name);

            System.out.print("Do you want to play again? (Y,N) ");
            x = input.next().toLowerCase();

            while (!x.equals("y") && !x.equals("n")){
                System.out.print("Please enter (Y,N) ");
                x = input.next().toLowerCase();
            }

        }
        System.out.println("-------------- \n");

    }

    public static void playOddsEvens(String name){
        String choose, player, computer;
        int playerNum, computerNum, total, win;

        System.out.println("Let's play a game called \"Odds and Evens\" ");
        System.out.print("Hi "+name+", which do you choose? (O)dds or (E)vens? ");
        choose = input.next();
        choose = choose.toLowerCase();

        while (!choose.equals("o") && (!choose.equals("e"))){
            System.out.print("Please enter (O,E)");
            choose = input.next();
        }
        if (choose.equals("e")){
            computer = "odds";
            player = "evens";

        } else {
            computer = "evens";
            player = "odds";
        }
        System.out.println(name + " has picked "+player+"! The computer will be "+computer+"! ");
        System.out.println("-------------- \n");

        Random rand = new Random();
        computerNum = rand.nextInt(6);
        
        do {
	        System.out.print("How many \"fingers\" do you put out? ");
	        if(input.hasNextInt()) {
	        	playerNum = input.nextInt();
	        	break;
	        }else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        }
        } while(true);
        
        System.out.println(name+ " number is "+playerNum+". The computer number is "+computerNum+". ");
        System.out.println("-------------- \n");

        total = playerNum + computerNum;
        win = total % 2;
        System.out.println(playerNum +" + "+computerNum+" = "+total);

        if (win == 0) {
            if (choose.equals("e")) {
                System.out.println(total + " is even ");
                System.out.println("You choosed "+player);
                System.out.println("That means " + name + " wins! ");
            } else {
                System.out.println(total + " is even ");
                System.out.println("You choosed "+player);
                System.out.println("That means " + name + " lose! ");
            }
        }
        if (win == 1){
            if (choose.equals("e")) {
                    System.out.println(total + " is odds ");
                System.out.println("You choosed "+player);
                    System.out.println("That means " + name + " lose! ");
                } else {
                    System.out.println(total + " is odds ");
                    System.out.println("You choosed "+player);
                    System.out.println("That means " + name + " win! ");
                }
            }
        System.out.println("-------------- \n");
        }
}
