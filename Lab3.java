/*
* @Name: Nazar Maksymchuk
* @Date: 02-14-2018
*/
public class Lab3 {
   //1 Foot = .305meter
   public static final double CONVERSIONRATE = 0.305;
      
   public static void main(String[] args) {
         printConversionTable();
   }
   
   public static double convertFootToMeter(double foot) {
      return foot * CONVERSIONRATE;
   }
   public static double convertMeterToFoot(double meter) {
      return meter / CONVERSIONRATE ;
   }
   public static void printConversionTable() {
      System.out.println("     Feet         Meter      Meter           Feet ");
      double i;
      for(i = 1; i <= 20; i++) {
         System.out.printf("%8.0f%14.2f |%9.0f%16.2f |\n",  i, convertFootToMeter(i),  i*2, convertMeterToFoot( i*2));
      }
      //                   % means place a value here
      //                    8 the amount of space to reserve; values are placed in Right To Left(RTL)
      //                                  .0 indicates to add zero decimals, 1 would indicate the value followed by 1 decimal
      //                                             \n print on a new line(String Literals)
      //                                                  i*10 is the value which replaces the first occurence "%8.0f in the first argument of printf
      //System.out.printf("%8.0f%14.2f |%8.0f%14.2f |\n", i*10, convertFootToMeter(i*10),  i*20, convertMeterToFoot(i*20));
      System.out.println("---------------------------------------------------");
      System.out.printf("%8.0f%14.2f |%9.0f%16.2f |\n", i*10, convertFootToMeter(i*10),  i*20, convertMeterToFoot(i*20));
   }
}