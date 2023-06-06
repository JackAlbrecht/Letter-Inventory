package letterinventory;
import java.util.Scanner;
class LetterInventoryMain {
   public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  System.out.println("*******************************************************************************");
	  System.out.println("Welcome to the Letter Inventory!");
	  System.out.println("Please choose a word and I will rearrange it for you in alphabetical order!");
	  System.out.println("What word would you like rearranged?");
	  System.out.println("*******************************************************************************");
	  String word = scanner.nextLine();
      LetterInventory inventory1 = new LetterInventory(word);
      System.out.println("*******************************************************************************");
      System.out.println("Next we will combine 2 words!");
      System.out.println("What other word would you like to use?");
      System.out.println("*******************************************************************************");
      String word2 = scanner.nextLine();
      LetterInventory inventory2 = new LetterInventory(word2);
      System.out.println("*******************************************************************************");
      System.out.println("This is the alphabetically correct order of " + word);
      System.out.println(inventory1);
      System.out.println("*******************************************************************************");
      System.out.println("This is the alphabetically correct order of " + word2);
      System.out.println(inventory2);
      System.out.println("*******************************************************************************");
      System.out.println("This is the alphabetically correct order of " + word + " and " + word2);
      LetterInventory sum = inventory1.add(inventory2);
      System.out.println(sum);
      System.out.println("*******************************************************************************");
      LetterInventory subtractResult = inventory1.subtract(inventory2);
      System.out.println(subtractResult);
      scanner.close();
      
   }
}
