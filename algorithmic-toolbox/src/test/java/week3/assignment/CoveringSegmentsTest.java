package week3.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CoveringSegmentsTest {

    @Test
    void optimalPoints() {
        CoveringSegments.Segment[] segments =
                {new CoveringSegments.Segment(1, 3),
                        new CoveringSegments.Segment(2, 5),
                        new CoveringSegments.Segment(3, 6)};
       assertArrayEquals(new int[]{3}, CoveringSegments.optimalPoints(segments));
    }
    @Test void optimalPoints2() {
        CoveringSegments.Segment[] segments =
                {new CoveringSegments.Segment(4, 7),
                        new CoveringSegments.Segment(1, 3),
                        new CoveringSegments.Segment(2, 5),
                        new CoveringSegments.Segment(5, 6)};
        assertArrayEquals(new int[]{3,6}, CoveringSegments.optimalPoints(segments));
    }
}