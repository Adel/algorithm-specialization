package week3.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
    protected static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int current = 1;
        while (n > 0) {
            if (n - current > current) {
                n -= current;
                summands.add(current);
                current++;
            } else{
                summands.add(n);
                n=0;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
