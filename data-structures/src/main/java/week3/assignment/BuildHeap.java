package week3.assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private int[] readData() throws IOException {
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; ++i) {
            data[i] = in.nextInt();
        }
        return data;
    }

    private void writeResponse(List<Swap> swaps) {
        out.println(swaps.size());
        for (Swap swap : swaps) {
            out.println(swap.toString());
        }
    }

    private static int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private static int getRightChild(int i) {
        return 2 * i + 2;
    }

    protected static void shiftDown(int[] arr, int i, List<Swap> swaps) {
        int minIndex = i;
        int l = getLeftChild(i);
        if (l < arr.length && arr[l] < arr[minIndex]) {
            minIndex = l;
        }
        int r = getRightChild(i);

        if (r < arr.length && arr[r] < arr[minIndex]) {
            minIndex = r;
        }
        if (i != minIndex) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            swaps.add(new Swap(i, minIndex));
            shiftDown(arr, minIndex, swaps);
        }

    }

    protected static List<Swap> buildHeap(int[] arr) {
        List<Swap> swaps = new ArrayList<>();
        for (int i = arr.length / 2; i >= 0; i--) {
            shiftDown(arr, i, swaps);
        }
        return swaps;
    }

    private List<Swap> generateSwaps(int[] arr) {
        return buildHeap(arr);
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int[] data = readData();
        List<Swap> swaps = generateSwaps(data);
        writeResponse(swaps);
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public String toString() {
            return index1 + " " + index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}