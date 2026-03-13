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
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}