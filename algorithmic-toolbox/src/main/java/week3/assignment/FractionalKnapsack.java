package week3.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static class Item {
        final int value;
        final int weight;
        final double ratio;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }

        public double getRatio() {
            return ratio;
        }
    }

    protected static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        Item[] items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        Arrays.sort(items, Comparator.comparingDouble(Item::getRatio).reversed());
        int i = 0;
        while (capacity > 0 && i <items.length){
            Item item = items[i];
            if (capacity >= item.weight){
                capacity-= item.weight;
                value+=item.value;
            } else {
                value+= capacity * item.ratio;
                capacity = 0;
            }
            i++;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
