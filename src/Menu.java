import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
        //1. trip planner 2. odds and evens 3. crypto 4. maze 5. end program
        String name, choose, x;
        System.out.print("Welcome! Please enter your name: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();

        x = "y";
        while (x.equals("y")) {
            System.out.println("1. Trip Planner \n2. Odds and Evens \n3. Crypto \n4. Maze \n5. End Program ");
            System.out.print("Please choose (1-5) ");
            choose = input.next();
            while (!choose.equals("1") && !choose.equals("2") && !choose.equals("3") && !choose.equals("4") && !choose.equals("5")) {
                System.out.print("Please choose (1-5) ");
                choose = input.next();
            }

            if (choose.equals("1")) {
                System.out.println("-------------- \n");
                TripProgram trip = new TripProgram();
                trip.trip(name);
            } else if (choose.equals("2")) {
                System.out.println("-------------- \n");
                OddsAndEvensProgram oddsEvens = new OddsAndEvensProgram();
                oddsEvens.oddsEvens(name);

            } else if (choose.equals("3")) {
                System.out.println("-------------- \n");
                CryptoProgram crypto = new CryptoProgram();
                crypto.crypto(name);

            } else if (choose.equals("4")) {
                System.out.println("-------------- \n");
                MazeProgram maze = new MazeProgram();
                maze.maze(name);
            } else {
                x = "n";
            }

        }

	}

}
