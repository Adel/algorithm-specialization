package week4.assignement;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingTest {

    private static Random random = new Random();

    @Test
    void randomizedQuickSort() {
        int[] a = new int[]{2, 3, 9, 2, 2};
        Sorting.randomizedQuickSort(a, 0, 4);
        assertArrayEquals(new int[]{2, 2, 2, 3, 9}, a);
    }

    @Test
    void randomizedQuickSort2() {
        int[] a = new int[]{2, 3, 9, 2, 2, 5, 4, 6, 7, 9};
        int[] result = a.clone();
        Arrays.sort(result);
        Sorting.randomizedQuickSort(a, 0, a.length - 1);
        assertArrayEquals(result, a);
    }

    @RepeatedTest(100)
    void randomizedQuickSort3() {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1000);
        }
        int[] result = a.clone();
        Arrays.sort(result);
        Sorting.randomizedQuickSort(a, 0, a.length - 1);
        assertArrayEquals(result, a);

    }
}