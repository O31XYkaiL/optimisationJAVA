package task2;

import java.util.function.Function;

public class task2_2 {

    private final Function<Double, Double> function;
    private final ISort sort;

    public task2_2(Function<Double, Double> function) {
        this.function = function;
        this.sort = new BubbleSort();
    }

    public TableItem[] getTableRepresentation() {
        return analyzeFunction(1, 6);
    }

    public Asymptote getAsymptote() {
        return new Asymptote(function);
    }

    public double getCoefficient() {
        return Math.pow(10, getAsymptote().getK());
    }

    private TableItem[] analyzeFunction(int start, int amount) {
        TableItem[] result = new TableItem[amount];

        for (int i = 0; i < amount; i++) {
            result[i] = new TableItem(start + i, function.apply((double) (start + i)));
        }

        return result;
    }

    private int iterationsAmount(int itemsAmount) {
        int[] arr = new int[itemsAmount];
        for (int i = 0; i < itemsAmount; i++) {
            arr[i] = i;
        }
        return sort.sort(arr);
    }

    public interface ISort {
        int sort(int[] arr);
    }

    public static class BubbleSort implements ISort {
        @Override
        public int sort(int[] arr) {
            int counter = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j + 1] > arr[j]) {
                        swap(arr, j, j + 1);
                        counter++;
                    }
                }
            }
            return counter;
        }

        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static class TableItem {
        private double input;
        private double output;

        public TableItem(double input, double output) {
            this.input = input;
            this.output = output;
        }

        public double getInput() {
            return input;
        }

        public double getOutput() {
            return output;
        }
    }

    public static class Asymptote {
        private double alpha;
        private double k;

        public Asymptote(Function<Double, Double> function) {
            double left = Math.pow(10, -4);
            double right = Math.pow(10, -4.001);

            alpha = Math.log10(Math.abs(function.apply(right) / function.apply(left))) /
                    Math.log10(right / left);

            k = -1 * Math.log10(right) * Math.log10(Math.abs(function.apply(left) / function.apply(right))) /
                    Math.log10(left / right) + Math.log10(Math.abs(function.apply(right)));
        }

        public double getAlpha() {
            return alpha;
        }

        public double getK() {
            return k;
        }
    }
}