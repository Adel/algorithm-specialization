package week6.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void shouldReturnOptimalWeight() {
        assertEquals(9, Knapsack.optimalWeight(10, new int[]{1, 4, 8}));
    }

    @Test
    void shouldReturnOptimalWeight2() {
        assertEquals(19, Knapsack.optimalWeight(20, new int[]{5, 7, 12, 18}));
    }

    @Test
    void shouldReturnOptimalWeight4() {
        assertEquals(9, Knapsack.optimalWeight(10, new int[]{3, 3, 3, 20}));
    }

    @Test
    void shouldReturnOptimalWeight5() {
        assertEquals(16, Knapsack.optimalWeight(16, new int[]{10, 5, 4, 2}));
    }


}