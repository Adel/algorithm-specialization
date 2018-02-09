package week2.assignement;

import java.util.*;

public class FibonacciPartialSum {
    /**
     * fibonacci last digits from 0 to 60
     */
    private static int[] DIGITS = computeFirstDigits(60);

    /**
     * Sum of fibonacci numbers for n is f(n+2) -1
     * Sum from m to n is f(n+2) - f(m+1)
     * Sum of digit is last(f(n+2)) - last(f(m+1))
     */
    public static long getSum(long from, long to) {
        if (to < from) {
            throw new IllegalArgumentException("first argument should be less then second");
        }
        int r;
        if (from == to) {
            r = DIGITS[(int) (to % 60l)];
        } else {
            int firstDigit = DIGITS[(int) ((from + 1) % 60l)],
                    secondDigit = DIGITS[(int) ((to + 2) % 60l)];
            r = secondDigit - firstDigit;
        }
        return r < 0 ? 10 + r : r;
    }

    /**
     * compute the last digits of the first n fibonacci numbers
     */
    private static int[] computeFirstDigits(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 10;
        }
        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getSum(from, to));
    }
}

