package week4.assignement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PointsAndSegments {

    /**
     * hint for solving this here:
     * https://www.coursera.org/learn/algorithmic-toolbox/discussions/all/threads/QJ1jK9wNEeWdPBL2iFTrAw/replies/Ihiw4txhEeWK5g7mfcS2Xw/comments/oyAMaeIiEeWyqwpvChh66Q
     *
     */
    protected static int[] fastCountSegments(long[] starts, long[] ends, long[] points) {
        int[] cnt = new int[points.length];
        List<Elem> list = new ArrayList<>(starts.length * 2 + points.length);
        for (int i = 0; i < starts.length; i++) {
            list.add(new Elem(starts[i], "l", i));
            list.add(new Elem(ends[i], "r", i));
        }
        for (int i = 0; i < points.length; i++) {
            list.add(new Elem(points[i], "p", i));
        }
        list.sort(Comparator.comparing(Elem::getValue).thenComparing(Elem::getType));
        int covered = 0;
        for (int i = 0; i < list.size(); i++) {
            Elem curr = list.get(i);
            switch (curr.type) {
                case "l":
                    covered++;
                    break;
                case "r":
                    covered--;
                    break;
                case "p":
                    cnt[curr.index] = covered;
            }
        }
        return cnt;
    }

    protected static class Elem {
        final long value;
        final String type;
        int index;

        public Elem(long value, String type, int index) {
            this.value = value;
            this.type = type;
            this.index = index;
        }

        public long getValue() {
            return value;
        }

        public String getType() {
            return type;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        long[] starts = new long[n];
        long[] ends = new long[n];
        long[] points = new long[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
