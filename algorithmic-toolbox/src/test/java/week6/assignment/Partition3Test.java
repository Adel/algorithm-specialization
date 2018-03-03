package week6.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Partition3Test {

    @Test
    void shouldReturnCorrectOutput() {
        assertEquals(0, Partition3.partition3(new int[]{3, 3, 3, 3}));
    }

    @Test
    void shouldReturnCorrectOutput2() {
        assertEquals(0, Partition3.partition3(new int[]{60}));
    }

    @Test
    void shouldReturnCorrectOutput3() {
        assertEquals(1, Partition3.partition3(new int[]{17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59}));
    }

    @Test
    void shouldReturnCorrectOutput4() {
        assertEquals(1, Partition3.partition3(new int[]{1, 5, 2, 3, 4, 3}));
    }

    @Test
    void shouldReturnCorrectOutput5() {
        assertEquals(1, Partition3.partition3(new int[]{1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25}));
    }
}