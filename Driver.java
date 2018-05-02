import java.util.*;
import java.io.*;

public class Driver {
   public static void main(String[] args) throws IOException {
      QuadraticEquation[] quadraticEquations = new QuadraticEquation[10];
      fillArray(quadraticEquations);
      getResult(quadraticEquations);
   }
   
   public static void fillArray(QuadraticEquation[] equationsArr) throws IOException {
      File f = new File("equations.txt");
      Scanner input = new Scanner(f);
      int i = 0;
      while(input.hasNextLine()) {
         double a = input.nextDouble();
         double b = input.nextDouble();
         double c = input.nextDouble();
         equationsArr[i] = new QuadraticEquation(a, b, c);
         i++;
      }
   }
   
   public static void getResult(QuadraticEquation[] equations) {
      System.out.println("--------------------------");
      for(int i = 0; i < equations.length; i++) {
         System.out.println("Object " + (i + 1) + "\n");
         System.out.println(equations[i].getEquation());
         System.out.println(equations[i].getDiscriminant());
         System.out.println(equations[i].getRoot1());
         System.out.println(equations[i].getRoot2());
         System.out.println("--------------------------");

      }
   }
}