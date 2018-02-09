package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
    @Test
    public void calc_fib() {
        assertEquals(0, Fibonacci.calc_fib(0));
        assertEquals(1, Fibonacci.calc_fib(1));
        assertEquals(1, Fibonacci.calc_fib(2));
        assertEquals(2, Fibonacci.calc_fib(3));
        assertEquals(3, Fibonacci.calc_fib(4));
        assertEquals(5, Fibonacci.calc_fib(5));
        assertEquals(144, Fibonacci.calc_fib(12));
        assertEquals(23416728348467685l, Fibonacci.calc_fib(80));
    }
}