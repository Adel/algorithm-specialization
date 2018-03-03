package week6.assignment;

import java.util.Scanner;

public class Partition3 {

    static int partition3(int[] arr) {
        //at least three items
        if (arr.length < 3) {
            return 0;
        }
        int S = 0;
        for (int i = 0; i < arr.length; i++) {
            S += arr[i];
        }
        //S should be divisible by 3
        if (S % 3 != 0) {
            return 0;
        }
        int sum = S / 3;
        boolean[][][] dp = new boolean[arr.length + 1][sum + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i][0] = false;
            dp[0][0][i] = false;
        }
        dp[0][0][0] = true;

        for (int k = 1; k <= arr.length; k++) {
            for (int i = 0; i <= sum; i++) {
                for (int j = 0; j <= sum; j++) {
                    dp[k][i][j] = dp[k - 1][i][j] ||
                            (i >= arr[k - 1] && dp[k - 1][i - arr[k - 1]][j]) ||
                            (j >= arr[k - 1] && dp[k - 1][i][j - arr[k - 1]]);
                }
            }
        }
        return dp[arr.length][sum][sum] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}