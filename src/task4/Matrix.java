package task4;

class Matrix {
    private static final String ITEM_DELIMITER = ", ";
    private static final String ROW_DELIMITER = "\n";
    private final double[][] items;

    public Matrix(double[][] items) {
        if (items.length != items[0].length) {
            throw new IllegalArgumentException("Matrix must be square.");
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
        int length = vector.getLength();
        double[] result = new double[length];

        for (int i = 0; i < length; i++) {
            result[i] = 0;
            for (int j = 0; j < length; j++) {
                result[i] += items[i][j] * vector.get(j);
            }
        }

        return new Vector(result);
    }

    public Matrix getReversed() {
        double det = getSmallDeterminant();
        double[][] result = new double[2][2];

        result[0][0] = items[1][1] / det;
        result[0][1] = -1 * items[0][1] / det;
        result[1][0] = -1 * items[1][0] / det;
        result[1][1] = items[0][0] / det;

        return new Matrix(result);
    }

    private double getSmallDeterminant() {
        return items[0][0] * items[1][1] - items[0][1] * items[1][0];
    }

    public static double[][] getRotationMatrix(double angle) {
        double[][] rotationMatrix = new double[2][2];
        rotationMatrix[0][0] = Math.cos(angle);
        rotationMatrix[0][1] = Math.sin(angle);
        rotationMatrix[1][0] = -Math.sin(angle);
        rotationMatrix[1][1] = Math.cos(angle);
        return rotationMatrix;
    }
}