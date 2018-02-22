package week5.assignment;

import java.util.Scanner;

public class EditDistance {
    public static int editDistance(String s, String t) {
        int[][] m = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            m[i][0] = i;
        }
        for (int j = 0; j <= t.length(); j++) {
            m[0][j] = j;
        }

        for (int j = 1; j <= t.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                int minInDel = Math.min(m[i][j - 1] + 1, m[i - 1][j] + 1);
                int last = m[i - 1][j - 1];
                m[i][j] = s.charAt(i-1) == t.charAt(j-1) ?
                        Math.min(minInDel, last)
                        : Math.min(minInDel, last + 1);
            }
        }

        return m[s.length()][t.length()];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }

}
