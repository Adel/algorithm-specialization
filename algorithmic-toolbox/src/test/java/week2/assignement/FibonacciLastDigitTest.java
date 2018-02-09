package week2.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciLastDigitTest {

    @Test
    public void getLastDigit() {
        assertEquals(0, FibonacciLastDigit.getLastDigit(0));
        assertEquals(1, FibonacciLastDigit.getLastDigit(1));
        assertEquals(1, FibonacciLastDigit.getLastDigit(2));
        assertEquals(2, FibonacciLastDigit.getLastDigit(3));
        assertEquals(3, FibonacciLastDigit.getLastDigit(4));
        assertEquals(5, FibonacciLastDigit.getLastDigit(5));
        assertEquals(5, FibonacciLastDigit.getLastDigit(10));
        assertEquals(5, FibonacciLastDigit.getLastDigit(80));
        assertEquals(6, FibonacciLastDigit.getLastDigit(99));
        assertEquals(9, FibonacciLastDigit.getLastDigit(331));
        assertEquals(5, FibonacciLastDigit.getLastDigit(327305));
    }

}