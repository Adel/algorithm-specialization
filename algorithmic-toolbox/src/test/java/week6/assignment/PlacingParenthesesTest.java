package week6.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlacingParenthesesTest {

    @Test
    void getMaximalValue() {
        assertEquals(0, PlacingParentheses.getMaximalValue("0"));
    }

    @Test
    void getMaximalValue2() {
        assertEquals(6, PlacingParentheses.getMaximalValue("1+5"));
    }

    @Test
    void getMaximalValuz3() {
        assertEquals(81, PlacingParentheses.getMaximalValue("9*9"));
    }

    @Test
    void getMaximalValue4() {
        assertEquals(205891132094649l, PlacingParentheses.getMaximalValue("9*9*9*9*9*9*9*9*9*9*9*9*9*9*9"));
    }

    @Test
    void getMaximalValue5() {
        assertEquals(1650, PlacingParentheses.getMaximalValue("6*3-2-5+5+0+0+8-6*8+0-4-2+3+2"));
    }

    @Test
    void getMaximalValue6() {
        assertEquals(200, PlacingParentheses.getMaximalValue("5-8+7*4-8+9"));
    }
}