package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciPartialSumTest {

    @Test
    public void shouldComputeCorrectSum(){
        assertEquals(1, FibonacciPartialSum.getSum(0,1));
        assertEquals(2, FibonacciPartialSum.getSum(0,2));
        assertEquals(2, FibonacciPartialSum.getSum(0,5));
        assertEquals(5, FibonacciPartialSum.getSum(10,10));
        assertEquals(2, FibonacciPartialSum.getSum(10,200));
    }

}