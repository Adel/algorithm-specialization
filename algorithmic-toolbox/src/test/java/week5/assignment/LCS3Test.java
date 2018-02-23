package week5.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCS3Test {

    @Test
    void lcs3() {
        assertEquals(2, LCS3.lcs3(new int[]{1,2,3},new int[]{2,1,3},new int[]{1,3,5}));
    }
    @Test void lcs3_2() {
        assertEquals(3, LCS3.lcs3(new int[]{8,3,2,1,7},new int[]{8,2,1,3,8,10,7},new int[]{6,8,3,1,4,7}));
    }
}