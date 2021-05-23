import java.util.Scanner;

public class TripProgram {

    public static void trip(String name){
        String x;
        x = "y";
        Scanner input = new Scanner(System.in);
        while (x.equals("y")) {
            greeting(name);
            travel();
            timeDifference();
            area();

            System.out.print("Do you enter a new trip planner? (Y,N) ");
            x = input.next().toLowerCase();
            while (!x.equals("y") && !x.equals("n")){
                System.out.print("Please enter (Y,N) ");
                x = input.next().toLowerCase();
            }

        }
        System.out.println("-------------- \n");
    }

    public static void greeting(String name) {
        String travel;
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to Trip Program! \n");

        System.out.print("Nice to meet you " + name + ", Where are you travelling too? ");
        travel = input.nextLine();
        System.out.println("Great! " + travel + " sounds like a great trip.");
        System.out.println("-------------- \n");
    }

    public static void travel() {
        Scanner input = new Scanner(System.in);
        String symbol;
        int days, hours, minutes;
        double spend, money, currency, preDay, preMoney,preDay2, preMoney2;


        System.out.print("How many days are you going to spend travelling? ");
        days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        spend = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        symbol = input.next();
        System.out.print("How many " + symbol + " are there in 1 USD? ");
        currency = input.nextDouble();

        hours = days * 24;
        minutes = hours * 60;
        preDay = spend / days * 100;
        preDay2 = (int) preDay;
        preDay2 /= 100.00;
        money = spend * currency ;
        preMoney = money / days * 100;
        preMoney2 = (int) preMoney;
        preMoney2 /= 100.00;


        System.out.println("\nif you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes. ");
        System.out.println("If you are going to spend " + spend + " USD that means per day you can spend up to " + preDay2 + " USD. ");
        System.out.println("Your total budget in " + symbol + " is " + money+" " + symbol + ", which per day is " + preMoney2 +" "+ symbol);
        System.out.println("-------------- \n");
    }

    public static void timeDifference(){
        int time, midnight, noon;
        Scanner input = new Scanner(System.in);

        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        time = input.nextInt();
        midnight = (time + 24) % 24;
        noon = (midnight + 12) % 24;

        System.out.println("That means that when it is midnight at home it will be " +midnight+":00 in your travel destination ");
        System.out.println("and when it is noon at home it will be "+noon+":00");
        System.out.println("-------------- \n");

    }

    public static void area(){
        double km, miles, miles2;
        Scanner input = new Scanner(System.in);

        System.out.print("What is the square area of your destination country in km2? ");
        km = input.nextDouble();
        miles = km * 0.38610 * 100;
        miles2 = (int)miles;
        miles2 /= 100.00;

        System.out.println("In miles2 that is "+miles2);
        System.out.println("-------------- \n");
    }
}
