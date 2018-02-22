package week5.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    public void shouldComputeEditDistance() {
        assertEquals(0, EditDistance.editDistance("a", "a"));
    }

    @Test
    public void shouldComputeEditDistance2() {
        assertEquals(0, EditDistance.editDistance("ab", "ab"));
    }

    @Test
    public void shouldComputeEditDistance3() {
        assertEquals(3, EditDistance.editDistance("short", "ports"));
    }

    @Test
    public void shouldComputeEditDistance4() {
        assertEquals(5, EditDistance.editDistance("editing", "distance"));
    }

}