package lr2.task1_3;

import java.util.function.Function;
import java.util.Locale;

public class ProgramTrapezoidal {

    public static void main(String[] args) {

        Locale.setDefault(Locale.FRENCH);

        double lowerLimit = 8.0;
        double upperLimit = 16.0;

        long initialN = 1L;

        for (long n = initialN; n <= 1E+10; n *= 10) {
            Function<Double, Double> function = x -> Math.sin(8 * x) + Math.sqrt(x * x + 8 * x);

            double result = trapezoidalIntegral(lowerLimit, upperLimit, n, function);

            System.out.printf("Результат для n = %d: %.12f%n", n, result);
        }
    }

    public static double trapezoidalIntegral(double a, double b, long n, Function<Double, Double> f) {
        double width = (b - a) / n;
        double sum = 0;

        for (long i = 1; i < n; i++) {
            double x = a + i * width;
            sum += f.apply(x);
        }

        sum += (f.apply(a) + f.apply(b)) / 2;

        return width * sum;
    }
}