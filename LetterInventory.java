package letterinventory;

public class LetterInventory {
   private static final int ALPHABET_SIZE = 26;
   private int[] inventory;

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

   public int get(char letter) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter)) {
         throw new IllegalArgumentException("Invalid letter: " + letter);
      }
   
      int index = letter - 'a';
      return inventory[index];
   }

   public void set(char letter, int value) {
      letter = Character.toLowerCase(letter);
      if (!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException("Invalid letter or value");
      }
   
      int index = letter - 'a';
      inventory[index] = value;
   }

   public int size() {
      int sum = 0;
      for (int count : inventory) {
         sum += count;
      }
      return sum;
   }

   public boolean isEmpty() {
      for (int count : inventory) {
         if (count > 0) {
            return false;
         }
      }
      return true;
   }

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

   public LetterInventory add(LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = 0; i < ALPHABET_SIZE; i++) {
         result.inventory[i] = this.inventory[i] + other.inventory[i];
      }
      return result;
   }

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
