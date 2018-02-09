package week2.assignement;

import java.util.Scanner;

public class Fibonacci {
    public static long calc_fib(int n) {
        if (n <= 1) {
            return n;
        }
        long previous = 0l, current = 1l;
        for (int i = 2; i <= n; i++) {
            long temp = previous + current;
            previous = current;
            current = temp;
        }
        return current;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
