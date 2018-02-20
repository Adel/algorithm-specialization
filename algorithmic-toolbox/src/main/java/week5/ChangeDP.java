package week5;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static final int[] COINS = {1, 3, 4};

    protected static int getChange(int money) {
        int[] minNumCoins = new int[money + 1];
        Arrays.fill(minNumCoins, Integer.MAX_VALUE);
        minNumCoins[0] = 0;
        for (int m = 1; m <= money; m++) {
            for (int i = 0; i < COINS.length && m >= COINS[i]; i++) {
                minNumCoins[m] = Math.min(minNumCoins[m - COINS[i]] + 1, minNumCoins[m]);
            }
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
