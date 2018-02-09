package week3.assignment;

import java.util.*;

public class CoveringSegments {
    protected static int[] optimalPoints(Segment[] segments) {
        //sort segments by end
        Arrays.sort(segments, Comparator.comparingInt(a -> a.end));
        List<Integer> points = new ArrayList<>();
        points.add(segments[0].end);
        for (Segment segment : segments) {
            int lastPoint = points.get(points.size() - 1);
            if (lastPoint >= segment.start && lastPoint <= segment.end) {
                //no need to add a new point
                continue;

            } else {
                points.add(segment.end);
            }
        }
        return points.stream().mapToInt(i -> i).toArray();
    }

    protected static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
