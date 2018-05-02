public class QuadraticEquation {
   private double a;
   private double b;
   private double c;

   //constructor
   public QuadraticEquation(double a, double b, double c) {
      this.setA(a);
      this.setB(b);
      this.setC(c);
   }

   public void setA(double a) {
      this.a = a;
   }

   public void setB(double b) {
      this.b = b;
   }

   public void setC(double c) {
      this.c = c;
   }
   
   public double getA() {
      return this.a;
   }
 
   public double getB() {
      return this.b;
   }
   
   public double getC() {
      return this.c;
   }
   
   public double getDiscriminant() {
      double r = Math.pow(this.b, 2) - 4 * a * c;
      return r >= 0 ? Math.sqrt(r) : 0;
   }
   
   public double getRoot1() {
      double d = this.getDiscriminant();
      if(d == 0)
         return (-b - d) / (2.0 * a);
      return 0;
   }
   
   public double getRoot2() {
      double d = this.getDiscriminant();
      if(d == 0)
         return (-b + d) / (2.0 * a);
      return 0;
   }
   
   public boolean equals(QuadraticEquation e) {
      return this.a == e.getA() && this.b == e.getB() && this.c == e.getC();
   }
   public String getEquation() {
      return this.a + "x\u00B2 " + this.printableNum(this.b) + "x " + this.printableNum(this.c);
   }
   public String toString() {
      return "";
   }
   public String printableNum(double num) {
      return num >= 0 ? "+ "+num : " - " +num;
   }
}
