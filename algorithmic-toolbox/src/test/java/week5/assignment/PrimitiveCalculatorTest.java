package week5.assignment;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveCalculatorTest {

    @Test
    void optimalSequence1() {
        assertIterableEquals(Arrays.asList(1, 2, 4, 5), PrimitiveCalculator.optimalSequence(5));
    }
    @Test void optimalSequence2() {
        assertIterableEquals(Arrays.asList(1,2,6), PrimitiveCalculator.optimalSequence(6));
    }

    @Test void optimalSequence3() {
        assertIterableEquals(Arrays.asList(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234), PrimitiveCalculator.optimalSequence(96234));
    }
}