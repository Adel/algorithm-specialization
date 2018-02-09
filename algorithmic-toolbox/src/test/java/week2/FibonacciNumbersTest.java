package week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumbersTest {

    @Test
    public void fibonacci0() {
        assertEquals(0, FibonacciNumbers.fibonacci(0));
    }

    public void fibonacci1() {
        assertEquals(1, FibonacciNumbers.fibonacci(1));
    }

    @Test
    public void fibonacci2() {
        assertEquals(1, FibonacciNumbers.fibonacci(2));
    }

    @Test
    public void fibonacci3() {
        assertEquals(2, FibonacciNumbers.fibonacci(3));
    }

    @Test
    public void fibonacci4() {
        assertEquals(3, FibonacciNumbers.fibonacci(4));
    }

    @Test
    public void fibonacci5() {
        assertEquals(5, FibonacciNumbers.fibonacci(5));
    }

    @Test
    public void fibonacci10() {
        assertEquals(144, FibonacciNumbers.fibonacci(12));
    }

    @Test
    public void fibonacciMemo1() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(5, fibonacciNumbers.fibonacciMemoization(5));
    }

    @Test
    public void fibonacciMemo10() {
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();
        assertEquals(144, fibonacciNumbers.fibonacciMemoization(12));
    }

    @Test
    public void fibonacciFast() {
        assertEquals(23416728348467685l, FibonacciNumbers.fibonacciFast(80));
    }

}