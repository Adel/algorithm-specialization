package week1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPairwiseProductTest {

    @Test
    public void getMaxPairwiseProduct() {
        assertEquals(4 * 3, MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{0, 1, 2, 3, 4}));
        assertEquals(6 * 5, MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{0, 1, 5, 2, 6, 3, 4}));

    }

    @Test
    public void getMaxPairwiseProduct2() {
        assertEquals(90000l * 100000l, MaxPairwiseProduct.getMaxPairwiseProduct(new int[]{100000, 90000}));

    }
}