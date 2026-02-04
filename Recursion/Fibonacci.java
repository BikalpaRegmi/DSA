public class Fibonacci {
    public static void main(String[] args) {
        FibonacciImplement fib = new FibonacciImplement();
        System.out.println("Fibonacci of 5: " + fib.fibonacci(5));
    }
}

class FibonacciImplement {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // Eautai function ma 2 ta recursion xw tei vaera yeslai excessive recursion vnxw.
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}