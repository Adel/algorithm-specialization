package week5.assignment;

import java.util.*;
import java.util.function.Function;

public class PrimitiveCalculator {

    private static final List<Function<Integer, Integer>> FUNCTIONS = Arrays.asList(x -> x + 1, x -> x * 2, x -> x * 3);

    protected static List<Integer> optimalSequence(int n) {
        int[] parents = new int[n + 1];
        int[] steps = new int[n + 1];
        //construct parent arrays
        for (int i = 1; i <= n; i++) {
            int[] nextElems = new int[]{i + 1, i * 2, i * 3};
            for (int j = 0; j < 3; j++) {
                fillArrays(n, i, nextElems[j], parents, steps);
            }
        }

        int i = n;
        List<Integer> seq = new ArrayList<>();
        seq.add(i);
        while (i != 1) {
            i = parents[i];
            seq.add(i);
        }
        Collections.reverse(seq);
        return seq;
    }

    private static void fillArrays(int n, int parent, int curr, int[] parents, int[] steps) {
        int currSteps = steps[parent] + 1;
        if (curr <= n && (steps[curr] == 0 || currSteps < steps[curr])) {
            steps[curr] = currSteps;
            parents[curr] = parent;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
