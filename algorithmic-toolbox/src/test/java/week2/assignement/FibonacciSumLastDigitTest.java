package week2.assignement;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSumLastDigitTest {

    @Test
    public void shouldComputeCorrectDigit() {
        assertEquals(0, FibonacciSumLastDigit.getFibonacciSum(0));
        assertEquals(1, FibonacciSumLastDigit.getFibonacciSum(1));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSum(2));
        assertEquals(1, FibonacciSumLastDigit.getFibonacciSum(1));
        assertEquals(4, FibonacciSumLastDigit.getFibonacciSum(3));
        assertEquals(2, FibonacciSumLastDigit.getFibonacciSum(5));
        assertEquals(0, FibonacciSumLastDigit.getFibonacciSum(6));
        assertEquals(5, FibonacciSumLastDigit.getFibonacciSum(100));
    }

    @Test
    public void shouldComputeBigFibDigit() {
        assertEquals(3, FibonacciSumLastDigit.getFibonacciSum(832564823476l));
    }

}