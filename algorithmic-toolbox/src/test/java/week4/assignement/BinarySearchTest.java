package week4.assignement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearchWithNoElement() {
        assertEquals(-1, BinarySearch.binarySearch(new int[0], 3));
    }

    @Test
    void binarySearchWithOneElementNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{5}, 3));
    }

    @Test
    void binarySearchWithOneElementFound() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{5}, 5));
    }

    @Test
    void binarySearchWithNEvenElementsFound() {
        assertEquals(3, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4));
    }

    @Test
    void binarySearchWithNEvenElementsNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10));
    }

    @Test
    void binarySearchWithNOddElementsFound() {
        assertEquals(4, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    }

    @Test
    void binarySearchWithNOddElementsNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
    }

    @Test
    void binarySearchShouldFindFirstElement() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1));
    }

    @Test
    void binarySearchShouldFindLastElement() {
        assertEquals(8, BinarySearch.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9));
    }
}