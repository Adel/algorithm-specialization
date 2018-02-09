package week3.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DotProductTest {

    @Test
    public void shouldReturnCorrectDotProduct() {
        long[] a = {23};
        long[] b = {39};
        assertEquals(897, DotProduct.maxDotProduct(a, b));
    }

    @Test
    public void shouldReturnCorrectDotProduct2() {
        long[] a = {1, 3, -5};
        long[] b = {-2, 4, 1};
        assertEquals(23, DotProduct.maxDotProduct(a, b));
    }

}