package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciHugeTest {

    @Test
    public void shouldComputeCorrectLengthForPisanoPeriod(){
        assertEquals(3, FibonacciHuge.pisanoPeriodLength(2));
        assertEquals(8, FibonacciHuge.pisanoPeriodLength(3));
    }

    @Test
    public void shouldComputeCorrectly(){
        assertEquals(1, FibonacciHuge.getFibonacciHuge(2015, 3));
        assertEquals(161, FibonacciHuge.getFibonacciHuge(239, 1000));
        assertEquals(10249, FibonacciHuge.getFibonacciHuge(2816213588l, 30524));
    }

}