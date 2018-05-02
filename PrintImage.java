/*
* @Name: Nazar Maksymchuk
* @Date: 02-13-2018
*/

public class PrintImage {
   
   public static final int SIZE = 5;
   
   public static void main(String[] args) {
      drawImage();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("1" + 2 + 3 + "4" + 5 * 6 + "7" + (8 + 9));
   }
   
   public static void drawImage() {
      printLine();
      printTop();
      printTop();
      printLine();
      printBottom();
      printBottom();
      printLine();
   }
   
   public static void printTop() {
      for(int line = 0; line < SIZE; line++) {
         System.out.print("|");
         for(int i = SIZE-1; i > line; i--) {
            System.out.print(" ");
         }
         System.out.print("^");
         for(int i = 0; i < line*2; i++) {
            System.out.print(" ");
         }
         System.out.print("^");
         for(int i = SIZE-1; i > line; i--) {
            System.out.print(" ");
         }
         System.out.print("|\n");
      }
   }
   
   public static void printBottom() {
      for(int line = 0; line < SIZE; line++) {
         System.out.print("|");
         for(int i = 0; i < line; i++) {
            System.out.print(" ");
         }
         System.out.print("V");
         for(int i = SIZE-1; i > line; i--) {
            System.out.print(" ");
         }
         for(int i = SIZE-1; i > line; i--) {
            System.out.print(" ");
         }
         System.out.print("V");
         for(int i = 0; i < line; i++) {
            System.out.print(" ");
         }
         System.out.print("|\n");
      }
   }
   public static void printLine() {
      System.out.print("+");
      for(int i = 0; i < SIZE*2; i++) {
         System.out.print("-");
      }
      System.out.print("+\n");   
   }

}