package week2.assignement;

import java.util.*;

public class FibonacciLastDigit {
    public static int getLastDigit(int n) {
        if (n <= 1)
            return n;
        int previous = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (previous + current) % 10;
            previous = current;
            current = temp;
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getLastDigit(n);
        System.out.println(c);
    }
}
