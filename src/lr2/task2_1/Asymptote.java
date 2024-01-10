package lr2.task2_1;

import java.util.function.Function;

public class Asymptote {
    private double a;
    private double k;

    public Asymptote(Function<Double, Double> function) {
        double r = Math.pow(10, -4);
        double l = Math.pow(10, -4.001);

        a = logOfAbs(function.apply(r) / function.apply(l)) / Math.log10(r / l);
        k = -1 * Math.log10(r) * logOfAbs(function.apply(l) / function.apply(r)) / Math.log10(l / r) + logOfAbs(function.apply(r));
    }

    private double logOfAbs(double a) {
        return (a == 0) ? Double.NEGATIVE_INFINITY : Math.log10(Math.abs(a));
    }

    public double getA() {
        return a;
    }

    public double getK() {
        return k;
    }
}
