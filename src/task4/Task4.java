package task4;

import task2_1.Asymptote;
import task2_1.Table;
import task2_1.Task2_1;

import java.util.function.Function;

public class Task4 {
    private final Function<Vector, Double> function;
    private final Vector vector;
    private final Vector point;
    private final Task2_1 func;

    public Task4(Function<Vector, Double> function, Vector point, Vector vector) {
        this.function = function;
        this.point = point;
        this.vector = vector;
        func = new Task2_1(this::function);
    }

    public Table[] getTable() {
        return func.getTable(0, 16);
    }

    public double getC() {
        return func.getC();
    }

    public Asymptote getAsymptote() {
        return func.getAsymptote();
    }

    public Vector[] getPointForCircle(int iterationsAmount) {
        Matrix rotationMatrix = MathUtils.getRotationMatrix(Math.PI / 90);
        Vector[] res = new Vector[iterationsAmount];
        Vector rotatedVector = this.vector;

        for (int i = 0; i < iterationsAmount; i++) {
            Function<Double, Double> func = createFunction(rotatedVector);
            Task2_1 tempFunc = new Task2_1(func);
            res[i] = point.add(rotatedVector.multiply(tempFunc.getC()));
            rotatedVector = rotatedVector.multiply(rotationMatrix);
        }

        return res;
    }

    private Function<Double, Double> createFunction(Vector rotatedVector) {
        return t -> function.apply(point.add(rotatedVector.multiply(t))) - function.apply(point);
    }

    private double function(double t) {
        return function.apply(point.add(vector.multiply(t))) - function.apply(point);
    }
}
