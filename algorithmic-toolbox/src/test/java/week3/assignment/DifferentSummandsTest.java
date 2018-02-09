package week3.assignment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DifferentSummandsTest {

    @Test
    void optimalSummands() {
        assertEquals(Arrays.asList(1, 2, 3), DifferentSummands.optimalSummands(6));
    }

    @Test
    void optimalSummands2() {
        assertEquals(Arrays.asList(1, 2, 5), DifferentSummands.optimalSummands(8));
    }

    @Test
    void optimalSummands3() { assertEquals(Arrays.asList(2), DifferentSummands.optimalSummands(2)); }
}