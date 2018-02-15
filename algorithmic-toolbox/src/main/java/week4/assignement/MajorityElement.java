package week4.assignement;

import java.util.*;
import java.io.*;

public class MajorityElement {
    protected static int getMajorityElement(int[] a) {
        HashMap<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            store.put(a[i], store.getOrDefault(a[i], 0) + 1);
        }
        int mid = a.length / 2 + 1;
        return store.entrySet()
                .stream()
                .filter(e -> e.getValue() >= mid)
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(0);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getMajorityElement(a));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

