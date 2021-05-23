import java.util.Scanner;

public class MazeProgram {

	public static void maze(String name){
        String x;
        x = "y";
        Scanner input = new Scanner(System.in);
        while (x.equals("y")) {
            Maze myMap = new Maze();
            System.out.println("Welcome "+name+" to Maze Runner! ");
            System.out.println("Here is your current position: ");
            myMap.printMap();
            int count = 0;
            boolean test = true;

            while (test) {
                if (myMap.didIWin()) {
                    System.out.println("Congratulations, you made it out alive! ");
                    System.out.println("and you did it in " + count + " moves. ");
                    test = false;

                } else {
                    System.out.print("Where would you like to move? (R,L,U,D) ");
                    String choose = input.next().toUpperCase();


                    while (!choose.equals("R") && !choose.equals("L") && !choose.equals("U") && !choose.equals("D")) {
                        System.out.print("Please enter (R,L,U,D) ");
                        choose = input.next().toUpperCase();
                    }
                    if (myMap.isThereAPit(choose)) {

                        System.out.print("Watch out! There's a pit ahead, jump it (Y,N) ");
                        String answer = input.next().toUpperCase();

                        while (!answer.equals("Y") && !answer.equals("N")){
                            System.out.print("Please enter (Y,N) ");
                            answer = input.next().toUpperCase();

                        }

                        if (answer.equals("Y")){
                            myMap.jumpOverPit(choose);
                            myMap.printMap();

                        }
                        count++;
                    } else {
                        if (choose.equals("R")) {
                            if (myMap.canIMoveRight()) {
                                myMap.moveRight();
                                count++;
                            } else {
                                System.out.println("Sorry, you've hit a wall. ");
                                count++;
                            }
                        }
                        if (choose.equals("L")){
                            if (myMap.canIMoveLeft()){
                                myMap.moveLeft();
                                count++;
                            } else {
                                System.out.println("Sorry, you've hit a wall. ");
                                count++;
                            }
                        }
                        if (choose.equals("U")) {
                            if (myMap.canIMoveUp()) {
                                myMap.moveUp();
                                count++;
                            } else {
                                System.out.println("Sorry, you've hit a wall. ");
                                count++;
                            }
                        }
                        if (choose.equals("D")) {
                            if (myMap.canIMoveDown()) {
                                myMap.moveDown();
                            }
                            else {
                                System.out.println("Sorry, you've hit a wall. ");
                                count++;
                            }
                        }
                    }
                    movesMessage(count);
                    myMap.printMap();

                    if (count == 100) {
                    System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                    test = false;
                    }
                }
            }

            System.out.print("Do you want to play again? (Y,N) ");
            x = input.next().toLowerCase();

            while (!x.equals("y") && !x.equals("n")){
                System.out.print("Please enter (Y,N) ");
                x = input.next().toLowerCase();
            }

        }
        System.out.println("-------------- \n");

    }

    public static void movesMessage(int moves) {
        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes. ");
        } else if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape. ");
        } else if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!! ");

        }
    }
}

