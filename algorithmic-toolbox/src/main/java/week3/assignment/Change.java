package week3.assignment;

import java.util.Scanner;

public class Change {
    private static int[] COINS = {10, 5, 1};

    protected static int getChange(int m) {
        int nb = 0, i = 0;
        while (m > 0 && i < COINS.length) {
            if (m - COINS[i] >= 0) {
                int times = m / COINS[i];
                nb += times;
                m = m - COINS[i] * times;
            } else {
                i++;
            }
        }
        return nb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
