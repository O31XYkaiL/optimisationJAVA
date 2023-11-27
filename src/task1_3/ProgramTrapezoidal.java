package task1_3;

import java.util.function.Function;
import java.util.Locale;

public class ProgramTrapezoidal {

    public static void main(String[] args) {
        // Устанавливаем локаль с разделителем запятой
        Locale.setDefault(Locale.FRENCH);

        double lowerLimit = 11.0;
        double upperLimit = 22.0;

        double initialN = 1.0;

        for (double n = initialN; n <= 1E+10; n *= 10) {
            Function<Double, Double> function = x -> Math.sin(11 * x) + Math.sqrt(x * x + 11 * x);

            double result = trapezoidalIntegral(lowerLimit, upperLimit, n, function);

            System.out.printf("Результат для n = %.1f: %.12f%n", n, result);
        }
    }

    public static double trapezoidalIntegral(double a, double b, double n, Function<Double, Double> f) {
        double width = (b - a) / n;
        double trapezoidalIntegral = 0;

        for (double step = 0; step < n; step++) {
            double x1 = a + step * width;
            double x2 = a + (step + 1) * width;

            trapezoidalIntegral += 0.5 * (x2 - x1) * (f.apply(x1) + f.apply(x2));
        }

        return trapezoidalIntegral;
    }
}
