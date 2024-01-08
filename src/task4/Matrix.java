package task4;

public class Matrix {
    private final double[][] items;

    public Matrix(double[][] items) {
        if (items.length != items[0].length) {
            throw new IllegalArgumentException("Неверная матрица");
        }

        this.items = items;
    }

    public double get(int index1, int index2) {
        return items[index1][index2];
    }

    public int getLength() {
        return items.length;
    }

    public Vector multiply(Vector vector) {
        if (vector.length() != items.length) {
            throw new IllegalArgumentException("Неверная длина");
        }

        double[] result = new double[vector.length()];
        Vector temp;

        for (int i = 0; i < vector.length(); i++) {
            temp = new Vector(items[i]);
            result[i] = temp.dotProduct(vector);
        }

        return new Vector(result);
    }

    public Matrix reverse() {
        double det = getSmallDeterminant();
        double[][] matrix = new double[2][];
        matrix[0] = new double[2];
        matrix[0][0] = items[1][1] / det;
        matrix[0][1] = -1 * items[0][1] / det;
        matrix[1] = new double[2];
        matrix[1][0] = -1 * items[1][0] / det;
        matrix[1][1] = items[0][0] / det;

        return new Matrix(matrix);
    }

    private double getSmallDeterminant() {
        return items[0][0] * items[1][1] - items[0][1] * items[1][0];
    }
}
