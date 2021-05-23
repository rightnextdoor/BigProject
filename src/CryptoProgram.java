import java.util.Scanner;

public class CryptoProgram {
	private static Scanner input = new Scanner(System.in);

	public static void crypto(String name){
        String x, text;
        int key, group;
        x = "y";
        System.out.println("Welcome "+name+" to crypto \n");

        while (x.equals("y")) {
            text = message();
            do {
	            System.out.print("Enter a key number ");
	            if(input.hasNextInt()) {
		            key = input.nextInt();
		            break;
	            }
	            else {
		        	System.out.println("Please enter a number");
		        	input.next();
		        }
            }while(true);
            
            do {
	            System.out.print("Enter a group number smaller than the text number ");
	            if(input.hasNextInt()) {
	            	group = input.nextInt();
	            	break;
	            }
	            else {
		        	System.out.println("Please enter a number");
		        	input.next();
		        }
            }while(true);

            text = encryptString(text, key, group);
            System.out.println("The encrypted messasge is "+ text);
            System.out.println("-------------- \n");

            text = decryptString(text, key);
            System.out.println("The decypted message is "+ text);
            System.out.println("-------------- \n");

            System.out.print("Do you want to crypto again? (Y,N) ");
            x = input.next().toLowerCase();

            while (!x.equals("y") && !x.equals("n")){
                System.out.print("Please enter (Y,N) ");
                x = input.next().toLowerCase();
            }

        }
        System.out.println("-------------- \n");

    }
    public static String message(){
        System.out.print("Please enter your message ");
        String text = input.nextLine();
        return text;
    }

    public static String encryptString(String text, int key, int group){
        text = normalizeText(text);
        text = caesarify(text, key);
        text = groupify(text, group);
        return text;

    }

    public static String normalizeText(String text){
        text = text.replaceAll("[^a-zA-Z]","").toUpperCase();
        System.out.println("Coded message is \n"+text);
        System.out.println("-------------- \n");
        return text;
    }

    public static String caesarify(String text, int key){
         int index;
         String newText, letter, newLetter;
         char newChar;

         letter = shiftAlphabet(0);
         newLetter = shiftAlphabet(key);
         newText = "";

         for (int x = 0; x < text.length(); x++){
             newChar = text.charAt(x);
             index = letter.indexOf(newChar);
             newText = newText + newLetter.charAt(index);

        }
        System.out.println("Encryped messase is \n " + newText);
        System.out.println("-------------- \n");
        return newText;

    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String text,int group){
        String newText = "";

        while ((text.length() % group) != 0){
            text += "x";
        }

        for (int x = 0; x < text.length(); x++){
            if ((x +1) % group == 0){
                newText = newText + text.charAt(x) + " ";
            } else {
                newText = newText + text.charAt(x);
            }
        }
        return newText;

    }
    public static String decryptString(String text, int key){
        key = key * -1;
        text = ungroupify(text);
        text = caesarify(text,key);
        return text;

    }


    public static String ungroupify(String text){
        String newText;
        newText = text.replaceAll("[^A-Z]","");
        return newText;

    }
}
