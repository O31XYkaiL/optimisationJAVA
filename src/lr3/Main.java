package lr3;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Double, Double> func1 = x -> Math.pow(x, 6) - 5 * Math.pow(x, 5) + 5 * Math.pow(x, 3) - 10 * Math.pow(x, 2) + x;
        LR3Optimization func1Optimization = new LR3Optimization(func1, 3.5);
        printOptimizationResults(func1Optimization, 45);

        System.out.println();

        Function<Double, Double> func2 = t ->
                Math.pow(2 - t, 2) + 5 * Math.pow(1 + 2 * t, 2) + Math.pow(5 + t, 2) +
                        3 * (2 - t) * (1 + 2 * t) - 5 * (2 - t) * (5 + t) - (1 + 2 * t) * (5 + t) + (2 - t) - 5 * (1 + 2 * t) + (5 + t);
        LR3Optimization func2Optimization = new LR3Optimization(func2, -1.0);
        printOptimizationResults(func2Optimization, 50);
    }

    private static void printOptimizationResults(LR3Optimization optimization, int iterations) {
        GoldenTriplet triplet = optimization.getArea();

        for (int i = 1; i <= iterations; i++) {
            System.out.printf("%d\t%.8f\t%.8f\t%.8f\t%.8f\n", i, triplet.getA(), triplet.getLeftCenter(), triplet.getRightCenter(), triplet.getB());
            triplet = optimization.findNeedNum(triplet);
        }
    }
}
