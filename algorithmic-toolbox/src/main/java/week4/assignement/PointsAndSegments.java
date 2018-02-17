package week4.assignement;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {

    protected static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        Segment[] segments = new Segment[starts.length];
        for (int i = 0; i < starts.length; i++) {
            segments[i] = new Segment(starts[i], ends[i]);
        }
        Arrays.sort(segments, Comparator.comparing(Segment::getStart));
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            cnt[i] = binarySearchCount(segments, points[i]);
        }
        return cnt;
    }


    protected static int binarySearchCount(Segment[] segments, int point) {
        int low = 0, high = segments.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Segment midSegment = segments[mid];
            if (midSegment.start <= point && point <= midSegment.end) {
                int count = 1; //one segment already found
                int j = mid + 1;
                //check from mid + 1 to high for segments corresponding
                while (j <= high && segments[j].start <= point && point <= segments[j].end) {
                    count++;
                    j++;
                }
                j = mid - 1;
                while (j >= low && segments[j].start <= point && point <= segments[j].end) {
                    count++;
                    j--;
                }
                return count;
            } else if (point < midSegment.start) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
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

    protected static class Segment {
        final int start;
        final int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }
    }
}
