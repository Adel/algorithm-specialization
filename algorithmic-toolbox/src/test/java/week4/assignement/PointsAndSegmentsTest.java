package week4.assignement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsAndSegmentsTest {

    @Test void fastCountSegmentsAssignmentSample() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{0, 7}, new long[]{5, 10}, new long[]{1, 6, 11});
        assertArrayEquals(new int[]{1,0,0}, counts);
    }
    @Test void fastCountSegmentsAssignmentSample2() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{-10}, new long[]{10}, new long[]{-100,100,0});
        assertArrayEquals(new int[]{0,0,1}, counts);
    }
    @Test void fastCountSegmentsAssignmentSample3() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{0,-3,7}, new long[]{5,2,10}, new long[]{1,6});
        assertArrayEquals(new int[]{2, 0}, counts);
    }
    @Test @DisplayName("one segment and point in segment") void fastCountSegment1() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{0}, new long[]{5}, new long[]{1});
        assertArrayEquals(new int[]{1}, counts);
    }
    @Test @DisplayName("one segment and point not in segment") void fastCountSegment2() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{0}, new long[]{5}, new long[]{-1});
        assertArrayEquals(new int[]{0}, counts);
    }
    @Test @DisplayName("negative points and segments") void fastCountSegment3() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{-1}, new long[]{0}, new long[]{-1});
        assertArrayEquals(new int[]{1}, counts);
    }
    @Test @DisplayName("identical segments, one point") void fastCountSegment4() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{-1,-1,-1}, new long[]{0,0,0}, new long[]{-1});
        assertArrayEquals(new int[]{3}, counts);
    }
    @Test @DisplayName("odd number of segments") void fastCountSegment5() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{-1,0,1}, new long[]{0,1,2}, new long[]{-1,0,1});
        assertArrayEquals(new int[]{1,2,2}, counts);
    }
    @Test @DisplayName("even number of segments") void fastCountSegment6() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{-1,0,1,2}, new long[]{0,1,2,3}, new long[]{-1,0,1});
        assertArrayEquals(new int[]{1,2,2}, counts);
    }
    @Test @DisplayName("segment of length 0") void fastCountSegment7() {
        int[] counts = PointsAndSegments.fastCountSegments(new long[]{0,0}, new long[]{0,0}, new long[]{0,0,0});
        assertArrayEquals(new int[]{2,2,2}, counts);
    }
}