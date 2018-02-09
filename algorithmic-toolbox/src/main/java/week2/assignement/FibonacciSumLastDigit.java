package week2.assignement;

import java.util.Scanner;

public class FibonacciSumLastDigit {
    /**
     * fibonacci last digits from 0 to 60
     */
    private static int[] DIGITS = computeFirstDigits(60);

    /**
     * The series of last digits is a repetition of first 60 last digits over and over again
     * To find the last digit of the sum, we use the fact that:
     * Sum(f(i) i from 0 to n) to n is equal to f(n + 2) - 1
     * We just have to find the last digit of f(n+2) to get the last digit of the sum
     *
     * @param n
     * @return
     */
    public static long getFibonacciSum(long n) {
        int r = DIGITS[(int) ((n + 2) % 60l)] - 1;
        return r == -1 ? 9 : r;
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
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

