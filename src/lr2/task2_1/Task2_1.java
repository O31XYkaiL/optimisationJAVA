package lr2.task2_1;

import java.util.function.Function;

public class Task2_1 {
    private static final double[] powers = {
            1, 1E-01,
            1E-02, 1E-03,
            1E-04, 1E-05,
            1E-06, 1E-07,
            1E-08, 1E-09,
            1E-10, 1E-11,
            1E-12, 1E-13,
            1E-14, 1E-15
    };

    private Function<Double, Double> func;

    public Task2_1(Function<Double, Double> func) {
        this.func = func;
    }

    public boolean isBMV() {
        return func.apply(0.0) == 0.0;
    }

    public Table[] getTable(int start, int end) {
        if (end > 16 || start + end > 16)
            throw new IllegalArgumentException();

        Table[] res = new Table[end - start];

        for (int i = start, j = 0; i < 16 && j < end - start; i++, j++) {
            res[i - start] = new Table(powers[i], func.apply(powers[i]));
        }

        return res;
    }

    public double getC() {
        return Math.pow(10, getAsymptote().getK());
    }

    public Asymptote getAsymptote() {
        return new Asymptote(func);
    }
}
