package week5.assignment;

import java.util.*;

public class LCS3 {

    protected static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] m = new int[a.length + 1][b.length + 1][c.length + 1];

        for (int k = 1; k <= c.length; k++) {
            for (int j = 1; j <= b.length; j++) {
                for (int i = 1; i <= a.length; i++) {
                    int maxInDel = Math.max(Math.max(m[i][j - 1][k], m[i - 1][j][k]), m[i][j][k - 1]);
                    int last = m[i - 1][j - 1][k - 1];
                    if (a[i - 1] == b[j-1] && a[i - 1] == c[k - 1]) {
                        last++;
                    }
                    m[i][j][k] = Math.max(maxInDel, last);
                }
            }
        }
        return m[a.length][b.length][c.length];

        //Write your code here
//        return Math.min(Math.min(a.length, b.length), c.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}


