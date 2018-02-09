package week2.assignement;

import java.util.Scanner;

public class GCD {
    public static int gcd(int a, int b) {
        int remainder;
        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (remainder > 0);
        return a;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd(a, b));
    }
}
