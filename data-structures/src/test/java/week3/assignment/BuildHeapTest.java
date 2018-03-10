package week3.assignment;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BuildHeapTest {

    @Test
    void shouldShiftDownCorrectly() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        BuildHeap.shiftDown(arr, 1, new ArrayList<>());
        assertArrayEquals(new int[]{5, 1, 3, 2, 4}, arr);
    }

    @Test
    void shouldShiftDownCorrectly2() {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        BuildHeap.shiftDown(arr, 1, new ArrayList<>());
        assertArrayEquals(new int[]{10, 6, 8, 7, 0, 5, 4, 3, 2, 1, 9}, arr);
    }

    @Test
    void shouldBuildCorrectHeap() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        List<BuildHeap.Swap> list = BuildHeap.buildHeap(arr);
        assertTrue(list.size() <= arr.length * 4);
        assertArrayEquals(new int[]{1,2,3,5,4}, arr);
    }

    @Test
    void shouldBuildCorrectHeap2() {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        List<BuildHeap.Swap> list = BuildHeap.buildHeap(arr);
        assertTrue(list.size() == 0);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7}, arr);
    }
}