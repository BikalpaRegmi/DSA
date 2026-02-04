 public class Factorial {
    public static void main(String[] args) {
      FactorialImplement fact = new FactorialImplement();
      System.out.println("Factorial of 5 : "  + fact.factorial(5));
}
}
 
 class FactorialImplement {
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        
        //aphnu function ma aphu le directly once call gareko vaerw yo direct recursion ho.
        return n * factorial(n - 1);
    }
}