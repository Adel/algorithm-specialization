package week2;

import java.util.HashMap;

public class FibonacciNumbers {

    private HashMap<Long, Long> store = new HashMap<>();

    public FibonacciNumbers() {
        this.store.put(0l, 0l);
        this.store.put(1l, 1l);
    }


    public static long fibonacci(long n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacciMemoization(long n) {
        long v = this.store.getOrDefault(n, -1l);
        if (v != -1) {
            return v;
        } else {
            return fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2);
        }
    }

    public static long fibonacciFast(long n) {
        if (n <= 1) {
            return n;
        }
        long previous = 0l, current = 1l;
        for (int i = 2; i <= n; i++) {
            long temp = previous + current;
            previous = current;
            current = temp;
        }
        return current;
    }

    public static long[] fibonacciList(int n) {
        long[] arr = new long[n];
        arr[0] = 0l;
        arr[1] = 1l;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }
}
