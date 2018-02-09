package week3.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestNumberTest {

    @Test
    void largestNumber() {
        assertEquals("221", LargestNumber.largestNumber(new String[]{"21", "2"}));
    }

    @Test
    void largestNumber2() {
        assertEquals("99641", LargestNumber.largestNumber(new String[]{"9", "4", "6", "1", "9"}));
    }

    @Test
    void largestNumber3() {
        assertEquals("923923", LargestNumber.largestNumber(new String[]{"23", "39", "92"}));
    }
    @Test void largestNumber4() {
        assertEquals("9999992393823221", LargestNumber.largestNumber(new String[]{"23", "39", "92", "2", "21", "99", "38", "9", "99"}));
    }

    @Test void largestNumber5() {
        assertEquals("110100", LargestNumber.largestNumber(new String[]{"1", "10", "100"}));
    }
    @Test void largestNumber6() {
        assertEquals("885854", LargestNumber.largestNumber(new String[]{"854", "85", "8"}));
    }
    @Test void largestNumber7() {
        assertEquals("89989", LargestNumber.largestNumber(new String[]{"899", "89"}));
    }
    @Test void largestNumber8() {
        assertEquals("23232", LargestNumber.largestNumber(new String[]{"23", "232"}));
    }
    @Test void largestNumber9() {
        assertEquals("20220", LargestNumber.largestNumber(new String[]{"202", "20"}));
    }
}