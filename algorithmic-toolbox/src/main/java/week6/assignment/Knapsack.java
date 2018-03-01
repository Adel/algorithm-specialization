package week6.assignment;

import java.util.*;

public class Knapsack {

    /*

     */
    static int optimalWeight(int W, int[] items) {
        int[][] values = new int[W + 1][items.length + 1];
        for (int i = 1; i <= items.length; i++) {
            for (int w = 1; w <= W; w++) {
                values[w][i] = values[w][i - 1];
                int item = items[i - 1];
                if (item <= w) {
                    int val = values[w - item][i - 1] + item;
                    if (values[w][i] < val) {
                        values[w][i] = val;
                    }
                }
            }
        }
        return values[W][items.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
