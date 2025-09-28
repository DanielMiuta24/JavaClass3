package algorithms;

public class Factorial {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long res = 1L;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
