import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
        //1. trip planner 2. odds and evens 3. crypto 4. maze 5. end program
        String name, continueProgram;
        int choose;
        System.out.print("Welcome! Please enter your name: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();

        continueProgram = "y";
        do {
            System.out.println("1. Trip Planner \n2. Odds and Evens \n3. Crypto \n4. Maze \n5. End Program ");
            System.out.print("Please choose (1-5) ");
            if(input.hasNextInt()) {
            	choose = input.nextInt();
            
	            switch (choose) {
				case 1: {
					TripProgram trip = new TripProgram();
	                trip.trip(name);
	                break;
				}
				case 2: {
	                OddsAndEvensProgram oddsEvens = new OddsAndEvensProgram();
	                oddsEvens.oddsEvens(name);
	                break;
				}
				case 3: {
	                CryptoProgram crypto = new CryptoProgram();
	                crypto.crypto(name);
	                break;
				}
				case 4: {
	                MazeProgram maze = new MazeProgram();
	                maze.maze(name);
	                break;
				}
				case 5: {
					continueProgram = "n";
	                break;
				}
				default:
					
					break;
				}
            } else {
            	System.out.println("Please enter a number \n");
            	input.next();
            }
        } while (continueProgram.equals("y"));

	}

}
