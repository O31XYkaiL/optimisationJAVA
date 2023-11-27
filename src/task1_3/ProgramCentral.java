package task1_3;

import java.util.function.Function;
import java.util.Locale;

public class ProgramCentral {
    static double centralRectangle(Function<Double, Double> f, double a, double b, long n) {
        double h = (b - a) / n;
        double sum = (f.apply(a) + f.apply(b)) / 2;

        for (long i = 1; i < n; i++) {
            double x = a + h * i;
            sum += f.apply(x);
        }

        double result = h * sum;
        return result;
    }

    public static void main(String[] args) {
        // Лямбда-выражение для функции
        Function<Double, Double> f = x -> Math.sin(11 * x) + Math.sqrt(x * x + 11 * x);

        double lowerLimit = 11.0;
        double upperLimit = 22.0;
        long initialN = 1L;
        double maxN = 1E+10;

        // Устанавливаем локаль с разделителем запятой
        Locale.setDefault(Locale.FRENCH);

        for (long n = initialN; n <= maxN; n *= 10) {
            double result = centralRectangle(f, lowerLimit, upperLimit, n);
            System.out.printf("Результат для n = %d: %,.12f%n", n, result);
        }
    }
}
