package task4;

import task2_1.Asymptote;
import task2_1.InfinitesimalAnalyzer;
import task2_1.TableItem;

import java.util.function.Function;

public class MultivariateAnalyzer {
    private final Function<Vector, Double> multivariateFunction;
    private final Vector pointOfView;
    private final Vector vector;
    private final InfinitesimalAnalyzer analyzer;

    public MultivariateAnalyzer(Function<Vector, Double> multivariateFunction, Vector pointOfView, Vector vector) {
        this.multivariateFunction = multivariateFunction;
        this.pointOfView = pointOfView;
        this.vector = vector;
        this.analyzer = new InfinitesimalAnalyzer(this::function);
    }

    public TableItem[] getTableRepresentation(int start, int amount) {
        return analyzer.getTableRepresentation(start, amount);
    }

    public Asymptote getAsymptote() {
        return analyzer.getAsymptote();
    }

    public double getCoefficient() {
        return analyzer.getCoefficient();
    }

    public Vector[] getCircle(int iterationsAmount) {
        double[][] rotationMatrix = MathUtilities.getRotationMatrix(Math.PI / 90);
        Vector[] answer = new Vector[iterationsAmount];
        Vector rotatedVector = vector;

        for (int i = 0; i < iterationsAmount; i++) {
            final Vector finalRotatedVector = rotatedVector; // Создаем финальную переменную
            Function<Double, Double> f = t -> multivariateFunction.apply(pointOfView.add(finalRotatedVector.multiply(t))) -
                    multivariateFunction.apply(pointOfView);

            analyzer.setFunction(f);
            double coefficient = analyzer.getCoefficient();

            // Создаем вектор с единичным значением, умножаем на коэффициент и прибавляем к pointOfView
            Vector unitVector = new Vector(1.0, rotatedVector.getLength());
            Vector scaledVector = unitVector.multiply(coefficient);
            answer[i] = pointOfView.add(scaledVector);

            rotatedVector = rotatedVector.multiply(rotationMatrix);
        }

        return answer;
    }

    private double function(double t) {
        return multivariateFunction.apply(pointOfView.add(vector.multiply(t))) - multivariateFunction.apply(pointOfView);
    }
}