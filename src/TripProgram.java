import java.text.DecimalFormat;
import java.util.Scanner;

public class TripProgram {
    private static Scanner input = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void trip(String name){
        String x;
        x = "y";
       
        while (x.equals("y")) {
            greeting(name);
            travel();
            timeDifference();
            area();

            System.out.print("Do you want to enter a new trip planner? (Y,N) ");
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

        System.out.println("\n Hello! Welcome to Trip Program! \n");

        System.out.print("Nice to meet you " + name + ", Where are you travelling too? ");
        travel = input.nextLine();
        System.out.println("Great! " + travel + " sounds like a great trip.");
        System.out.println("-------------- \n");
    }

    public static void travel() {
  
        String symbol;
        int days, hours, minutes;
        double spend, money, currency, preDay, preMoney;
        
        do {
	        System.out.print("How many days are you going to spend travelling? ");
	        if(input.hasNextInt()) {
	        	days = input.nextInt();
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        } 
        }while(true);
        
        do {
	        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
	        if(input.hasNextDouble()) {
		        spend = input.nextDouble();
		        break;
	        }
	        else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        } 
        } while(true);
        
        do {
	        System.out.print("What is the three letter currency symbol for your travel destination? ");
	        symbol = input.next();
	        if(symbol.length() == 3) {
		        break;
	        } else {
	        	System.out.println("Please enter three letter");
	        	input.next();
	        }
        } while(true);
        
        do {
	        System.out.print("How many " + symbol + " are there in 1 USD? ");
	        if(input.hasNextInt()) {
	        	currency = input.nextDouble();
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        }
        } while(true);

        hours = days * 24;
        minutes = hours * 60;
        preDay = spend / days;

        money = spend * currency ;
        preMoney = money / days;

        System.out.println("\nif you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes. ");
        System.out.println("If you are going to spend " + df2.format(spend) + " USD that means per day you can spend up to " + df2.format(preDay) + " USD. ");
        System.out.println("Your total budget in " + symbol + " is " + df2.format(money)+" " + symbol + ", which per day is " +df2.format(preMoney) +" "+ symbol);
        System.out.println("-------------- \n");
    }

    public static void timeDifference(){
        int time, midnight, noon;
        
        do {
	        System.out.print("What is the time difference, in hours, between your home and your destination? ");
	        if(input.hasNextInt()) {
	        	time = input.nextInt();
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        }
        } while(true);
        midnight = (time + 24) % 24;
        noon = (midnight + 12) % 24;

        System.out.println("That means that when it is midnight at home it will be " +midnight+":00 in your travel destination ");
        System.out.println("and when it is noon at home it will be "+noon+":00");
        System.out.println("-------------- \n");

    }

    public static void area(){
        double km, miles;
        do {
	        System.out.print("What is the square area of your destination country in km2? ");
	        if(input.hasNextDouble()) {
	        	km = input.nextDouble();
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number");
	        	input.next();
	        }
        } while(true);
        miles = Math.round( km * 0.38610 * 100) / 100.00;
        System.out.println("In miles2 that is "+miles);
        System.out.println("-------------- \n");
    }
}
