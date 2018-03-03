package week6.assignment;

import java.util.Scanner;

public class PlacingParentheses {
    static long getMaximalValue(String exp) {
        char[] operators = new char[exp.length() / 2];
        int n = exp.length() / 2 + 1;
        int[] digits = new int[n];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 == 0) {
                digits[i1] = exp.charAt(i) - '0';
                i1++;
            } else {
                operators[i2] = exp.charAt(i);
                i2++;
            }
        }
        //from 0 to n-1
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = digits[i];
            M[i][i] = digits[i];
        }
        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                minMax(operators, i, j, m, M);
            }
        }
        return M[0][n-1];
    }

    private static void minMax(char[] operators, int i, int j, long[][] min, long[][] max) {
        long minValue = Long.MAX_VALUE;
        long maxValue = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = eval(max[i][k], operators[k], max[k + 1][j]);
            long b = eval(max[i][k], operators[k], min[k + 1][j]);
            long c = eval(min[i][k], operators[k], max[k + 1][j]);
            long d = eval(min[i][k], operators[k], min[k + 1][j]);
            minValue = Math.min(Math.min(Math.min(minValue, a), Math.min(b, c)), d);
            maxValue = Math.max(Math.max(Math.max(maxValue, a), Math.max(b, c)), d);
        }
        min[i][j] = minValue;
        max[i][j] = maxValue;
    }


    private static long eval(long a, char op, long b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximalValue(exp));
    }
}
