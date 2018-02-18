package week4.assignement;

import java.util.Scanner;

public class Inversions {

    protected static long getNumberOfInversions(long[] arr) {
        return sortAndCountInversions(arr, 0, arr.length - 1);
    }

    private static long sortAndCountInversions(long[] arr, int left, int right) {
        long inversions = 0;
        if (right > left) {
            int mid = (right + left) / 2;

            inversions = sortAndCountInversions(arr, left, mid);
            inversions += sortAndCountInversions(arr, mid + 1, right);
            inversions += merge(arr, left, mid + 1, right);
        }
        return inversions;
    }

    private static long merge(long[] arr, int left, int mid, int right) {
        // pointer in first array [from left to mid - 1]
        int i = left;
        // pointer in second array [from mid to right]
        int j = mid;
        // store sorted values in temp array
        long[] temp = new long[right - left + 1];
        // index in temp array
        int k = 0;
        long inversions = 0;
        // loop and sort while counting inversions
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // since all elements from i + 1 to mid - 1 are greater then arr[j], we add all these inversions here
                inversions = inversions + (mid - i);
            }
        }
        //copy remaining elements from left and right array
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // copy elements back to original array
        for (int z = 0; z < temp.length; z++)
            arr[left + z] = temp[z];

        return inversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a));
    }
}
