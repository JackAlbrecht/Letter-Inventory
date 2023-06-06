package letterinventory;

public class LetterInventory {
   // Represents the size of the alphabet
   private static final int ALPHABET_SIZE = 26;
   // Array to store the counts of each letter in the inventory
   private int[] inventory;
   // Constructor to initialize the inventory
   public LetterInventory(String data) { 
      inventory = new int[ALPHABET_SIZE];
      data = data.toLowerCase();
   
      for (int i = 0; i < data.length(); i++) {
         char letter = data.charAt(i);
         if (Character.isLetter(letter)) {
            int index = letter - 'a';
            inventory[index]++;
         }
      }
   }
   // Returns the count of a specific letter in the inventory
   public int get(char letter) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException("Invalid letter: " + letter);
      }
   
      int index = letter - 'a';
      return inventory[index];
   }
   // Sets the count of a specific letter in the inventory
   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException("Invalid letter or value");
      }
   
      int index = letter - 'a';
      inventory[index] = value;
   }
   // Returns the size of the inventory (total count of all letters) 
   public int size() {
      int sum = 0;
      for (int count : inventory) {
         sum += count;
      }
      return sum;
   }
   // Checks if the inventory is empty (all letter counts are zero)
   public boolean isEmpty() {
      for (int count : inventory) {
         if (count > 0) {
            return false;
         }
      }
      return true;
   }
   // Returns a string representation of the inventory
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append('[');
      for (int i = 0; i < ALPHABET_SIZE; i++) {
         char letter = (char) ('a' + i);
         for (int j = 0; j < inventory[i]; j++) {
            sb.append(letter);
         }
      }
      sb.append(']');
      return sb.toString();
   }
   // Adds the counts of letters from another inventory to this inventory
   public LetterInventory add(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = 0; i < ALPHABET_SIZE; i++) {
         result.inventory[i] = this.inventory[i] + other.inventory[i];
      }
      return result;
   }
   // Subtracts the counts of letters from another inventory from this inventory
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = 0; i < ALPHABET_SIZE; i++) {
         result.inventory[i] = this.inventory[i] - other.inventory[i];
         if (result.inventory[i] < 0) {
            return null;
         }
      }
      return result;
   }
}
