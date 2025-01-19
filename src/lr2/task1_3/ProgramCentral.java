package lr2.task1_3;

import java.util.function.Function;
import java.util.Locale;

public class ProgramCentral {
    static double centralRectangle(Function<Double, Double> f, double a, double b, long n) {
        double h = (b - a) / n;
        double sum = 0;

        for (long i = 1; i <= n; i++) {
            double x = a + h * (i - 0.5);
            sum += f.apply(x);
        }

        return h * sum;
    }

    public static void main(String[] args) {
        Function<Double, Double> f = x -> Math.sin(8 * x) + Math.sqrt(x * x + 8 * x);

        double lowerLimit = 8.0;
        double upperLimit = 16.0;
        long initialN = 1L;
        double maxN = 1E+10;

        Locale.setDefault(Locale.FRENCH);

        for (long n = initialN; n <= maxN; n *= 10) {
            double result = centralRectangle(f, lowerLimit, upperLimit, n);
            System.out.printf("Результат для n = %d: %,.12f%n", n, result);
        }
    }
}
