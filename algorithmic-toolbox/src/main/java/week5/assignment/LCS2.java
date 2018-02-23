package week5.assignment;

import java.util.*;

public class LCS2 {

    protected static int lcs2(int[] a, int[] b) {
        int[][] m = new int[a.length + 1][b.length + 1];

        for (int j = 1; j <= b.length; j++) {
            for (int i = 1; i <= a.length; i++) {
                int maxInDel = Math.max(m[i][j - 1], m[i - 1][j]);
                int last = m[i - 1][j - 1];
                m[i][j] = a[i - 1] == b[j - 1] ?
                        Math.max(maxInDel, last + 1)
                        : Math.max(maxInDel, last);
            }
        }
        return m[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

