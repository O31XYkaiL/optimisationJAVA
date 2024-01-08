package task4;

public class Vector {
    private final double[] items;

    public Vector(double... items) {
        this.items = items;
    }

    public double get(int index) {
        return items[index];
    }

    public Vector add(Vector other) {
        if (items.length != other.items.length) {
            throw new IllegalArgumentException("Неверная длина");
        }

        double[] result = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = items[i] + other.items[i];
        }

        return new Vector(result);
    }

    public Vector subtract(Vector other) {
        if (items.length != other.items.length) {
            throw new IllegalArgumentException("Неверная длина");
        }

        double[] result = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = items[i] - other.items[i];
        }

        return new Vector(result);
    }

    public double dotProduct(Vector other) {
        if (items.length != other.items.length) {
            throw new IllegalArgumentException("Неверная длина");
        }

        double result = 0;
        for (int i = 0; i < items.length; i++) {
            result += items[i] * other.items[i];
        }

        return result;
    }

    public Vector multiply(double number) {
        double[] result = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = number * items[i];
        }

        return new Vector(result);
    }

    public Vector multiply(Matrix matrix) {
        if (this.items.length != matrix.getLength()) {
            throw new IllegalArgumentException("Неверная длина");
        }

        double[] result = new double[this.items.length];

        for (int i = 0; i < this.items.length; i++) {
            result[i] = 0;

            for (int j = 0; j < this.items.length; j++) {
                result[i] += this.items[j] * matrix.get(j, i);
            }
        }

        return new Vector(result);
    }

    public Vector getOrth() {
        return new Vector(get(1), -1 * get(0));
    }

    public int length() {
        return items.length;
    }

    public Vector normal() {
        double length = Math.sqrt(dotProduct(this));
        return multiply(1.0 / length);
    }
}
