package week4.assignement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    @Test void getMajorityElementForOneElement() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1}));
    }
    @Test void getMajorityElementForTwoDifferentElement() {
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1,2}));
    }
    @Test void getMajorityElementForTwoSameElements() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1,1}));
    }
    @Test void getMajorityElementForThreeSameElements() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1,1,1}));
    }
    @Test @DisplayName("should return element if it appears n/2 + 1 times for even length array") void getMajorityElementForEvenNumberOfElements() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1,2,1,3,1,4,1,1}));
    }
    @Test @DisplayName("should not return element if it appears n/2 times for even length array") void shouldNotReturnElement() {
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1,2,1,3,1,4,1,5}));
    }
    @Test @DisplayName("should not return element if it appears n/2 times for odd length array") void shouldNotReturnElement2() {
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1,2,1,3,1,4,1,5,9}));
    }
    @Test @DisplayName("should return element if it appears n/2 + 1 times for even length array") void shouldReturnElement() {
        assertEquals(0, MajorityElement.getMajorityElement(new int[]{1,2,1,3,1,4,1,5}));
    }
    @Test @DisplayName("should return element if it appears n/2 + 1 times for odd length array") void shouldReturnElement2() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{1,2,1,3,1,4,1,5,1}));
    }

    @Test void shouldReturnElementSubmissionTest() {
        assertEquals(1, MajorityElement.getMajorityElement(new int[]{2,3,9,2,2}));
    }
}