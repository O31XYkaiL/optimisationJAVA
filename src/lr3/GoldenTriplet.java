package lr3;

public class GoldenTriplet {
    public static final double SMALL_GOLDEN = 0.3819660113;
    public static final double GOLDEN = 0.6180339887;
    public static final double BIG_GOLDEN = 1.6180339887;

    private double a;
    private double b;

    public GoldenTriplet(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getRightCenter() {
        return a + (b - a) * GOLDEN;
    }

    public void setRightCenter(double value) {
        b = value * BIG_GOLDEN - a * GOLDEN;
    }

    public double getLeftCenter() {
        return b - (b - a) * GOLDEN;
    }

    public void setLeftCenter(double value) {
        b = value + BIG_GOLDEN * (value - a);
    }
}
