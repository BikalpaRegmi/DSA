public class GCD {
    public static void main(String[] args) {
        GCDImplement gcd = new GCDImplement();
        System.out.println("GCD of 48 and 18: " + gcd.gcd(48, 18));
    }
}

class GCDImplement {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        //yo direct recursion ho.
        return gcd(b, a % b);
    }
}