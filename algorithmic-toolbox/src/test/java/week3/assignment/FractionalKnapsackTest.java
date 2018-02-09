package week3.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionalKnapsackTest {

    @Test
    public void getOptimalValue() {
        int[] values = {60, 100, 120};
        int[] weights = {20, 50, 30};
        assertEquals(180.0000, FractionalKnapsack.getOptimalValue(50, values, weights), 0.001);
    }
    @Test public void getOptimalValue2() {
        int[] values = {500};
        int[] weights = {30};
        assertEquals(166.6667, FractionalKnapsack.getOptimalValue(10, values, weights), 0.001);
    }
    @Test public void getOptimalValue3() {
        int[] values = {500};
        int[] weights = {30};
        assertEquals(500, FractionalKnapsack.getOptimalValue(1000, values, weights), 0.001);
    }
}