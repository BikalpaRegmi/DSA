
public class SquareRootBinarySearch {
    public static double sqrt(int n) {
        if (n < 0) return -1; 
        if (n == 0 || n == 1) return n;
        
        double left = 0, right = n;
        double precision = 0.00001;
        
        while (right - left > precision) {
            double mid = (left + right) / 2;
            if (mid * mid > n) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
    
    
    public static void main(String[] args) {
        int n = 9;
        double result = sqrt(n);
        System.out.printf("Square root of %d is: %.5f\n", n, result);
            }
}