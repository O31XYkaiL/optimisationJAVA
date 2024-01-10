package lr2.task2_1;

public class Table {
    private double n;
    private double f;

    public Table(double n, double f) {
        this.n = n;
        this.f = f;
    }

    public double getN() {
        return n;
    }

    public double getF() {
        return f;
    }

    public double getLogN() {
        return Math.log10(Math.abs(n));
    }

    public double getLogF() {
        return Math.log10(Math.abs(f));
    }
}
