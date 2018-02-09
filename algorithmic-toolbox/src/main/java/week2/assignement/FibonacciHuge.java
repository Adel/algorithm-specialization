package week2.assignement;

import java.util.Scanner;

public class FibonacciHuge {
    protected static long getFibonacciHuge(long n, long m) {
        long remainder = n % pisanoPeriodLength(m);
        return fibModM(remainder, m);
    }

    private static long fibModM(long n, long m) {
        if (n <= 1) {
            return n % m;
        }
        long previous = 0l, current = 1l;
        for (long i = 1; i < n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }
        return current % m;
    }

    /**
     * pisano period always starts with 01
     * iterate till we find 01 and return length
     */
    protected static int pisanoPeriodLength(long m) {
        long previous = 0, current = 1;
        for (int i = 0; i < m * m; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }
        throw new RuntimeException("cannot compute pisano period");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

