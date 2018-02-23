package week5.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCS2Test {

    @Test
    void shouldComputeCorrectLcs_1() {
        assertEquals(2, LCS2.lcs2(new int[]{2,7,5}, new int[]{2,5}));
    }
    @Test void shouldComputeCorrectLcs_2() {
        assertEquals(0, LCS2.lcs2(new int[]{7}, new int[]{1,2,3,4}));
    }
    @Test void shouldComputeCorrectLcs_3() {
        assertEquals(2, LCS2.lcs2(new int[]{2,7,8,3}, new int[]{5,2,8,7}));
    }
    @Test void shouldComputeCorrectLcs_4() {
        assertEquals(5, LCS2.lcs2(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,6,5}));
    }
}