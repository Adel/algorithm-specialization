package week3.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
    protected static String largestNumber(String[] a) {
        Arrays.sort(a, (x, y) -> (y+x).compareTo(x+y));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++){
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
