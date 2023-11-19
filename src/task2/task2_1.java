package task2;

import java.util.function.Function;

public class task2_1 {
    private static final double[] PowersOfTen = {
            1, 1E-01, 1E-02, 1E-03, 1E-04, 1E-05, 1E-06, 1E-07, 1E-08, 1E-09,
            1E-10, 1E-11, 1E-12, 1E-13, 1E-14, 1E-15
    };

    private Function<Double, Double> function;

    public task2_1(Function<Double, Double> function) {
        this.function = function;
    }

    public boolean isInfinitesimal() {
        return function.apply(0.0) == 0.0;
    }

    public TableItem[] getTableRepresentation(int start, int amount) {
        if (amount > 16) {
            throw new IllegalArgumentException("количество ячеек не более 16");
        }

        if (start + amount > 16) {
            throw new IllegalArgumentException("нельзя пытаться вылезти за 16");
        }

        TableItem[] answer = new TableItem[amount - start];

        for (int i = start; i < start + amount; i++) {
            answer[i - start] = new TableItem(PowersOfTen[i], function.apply(PowersOfTen[i]));
        }

        return answer;
    }

    public Asymptote getAsymptote() {
        return new Asymptote(function);
    }

    public double getCoefficient() {
        return Math.pow(10, getAsymptote().getK());
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

        public double getLgInput() {
            return Math.log10(input);
        }

        public double getLgOutput() {
            return Math.log10(Math.abs(output));
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

        private double logOfAbs(double a) {
            return Math.log10(Math.abs(a));
        }

        public double getAlpha() {
            return alpha;
        }

        public double getK() {
            return k;
        }
    }
}
