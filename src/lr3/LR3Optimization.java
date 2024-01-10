package lr3;

import java.util.function.Function;

public class LR3Optimization {
    private final Function<Double, Double> func;
    private final double start;
    private final double step;
    private final double precision;
    private final int amount;
    private final boolean lookingMax;
    private int counter;

    public LR3Optimization(Function<Double, Double> function, double start, double step, double precision, int amount, boolean lookingForMax) {
        this.func = function;
        this.start = start;
        this.step = (function.apply(start + step) > function.apply(start - step))
                ? (lookingForMax ? step : -step)
                : (lookingForMax ? -step : step);
        this.precision = precision;
        this.amount = amount;
        this.lookingMax = lookingForMax;
        resetCounter();
    }

    public LR3Optimization(Function<Double, Double> function, double start) {
        this(function, start, 1E-02, 1E-04, 150, false);
    }

    public double getOptimal() {
        GoldenTriplet triplet = getArea();
        while (!lookingSmall(triplet)) {
            if (isCountDown()) {
                throw new IllegalStateException("Unable to find optimal solution");
            }
            triplet = findNeedNum(triplet);
        }
        return triplet.getA() + (triplet.getB() - triplet.getA()) / 2;
    }

    public GoldenTriplet getArea() {
        double step = this.step;
        GoldenTriplet triplet = new GoldenTriplet(start, start + step);
        while (!lookingLucky(triplet)) {
            if (isCountDown()) {
                throw new IllegalStateException("Unable to find search area");
            }
            triplet.setLeftCenter(triplet.getB());
        }
        resetCounter();
        return triplet;
    }

    private void resetCounter() {
        counter = 0;
    }

    private boolean lookingLucky(GoldenTriplet triplet) {
        return lookingMax
                ? func.apply(triplet.getRightCenter()) >= func.apply(triplet.getA()) &&
                func.apply(triplet.getRightCenter()) >= func.apply(triplet.getB())
                : func.apply(triplet.getRightCenter()) <= func.apply(triplet.getA()) &&
                func.apply(triplet.getRightCenter()) <= func.apply(triplet.getB());
    }

    private boolean lookingSmall(GoldenTriplet triplet) {
        return Math.abs(triplet.getB() - triplet.getA()) <= precision;
    }

    public GoldenTriplet findNeedNum(GoldenTriplet old) {
        if (lookingMax) {
            return func.apply(old.getLeftCenter()) > func.apply(old.getRightCenter())
                    ? new GoldenTriplet(old.getLeftCenter(), old.getB())
                    : new GoldenTriplet(old.getA(), old.getRightCenter());
        } else {
            return func.apply(old.getLeftCenter()) < func.apply(old.getRightCenter())
                    ? new GoldenTriplet(old.getA(), old.getRightCenter())
                    : new GoldenTriplet(old.getLeftCenter(), old.getB());
        }
    }

    private boolean isCountDown() {
        return counter++ > amount;
    }
}
