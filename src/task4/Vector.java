package task4;

class Vector {
    private final double[] items;

    public Vector(double... items) {
        this.items = items;
    }

    public int getLength() {
        return items.length;
    }

    public double get(int index) {
        return items[index];
    }

    public Vector add(Vector other) {
        if (getLength() != other.getLength()) {
            throw new RuntimeException("Vectors must be of the same length for addition.");
        }

        double[] result = new double[getLength()];
        for (int i = 0; i < getLength(); i++) {
            result[i] = get(i) + other.get(i);
        }

        return new Vector(result);
    }

    public Vector subtract(Vector other) {
        if (getLength() != other.getLength()) {
            throw new RuntimeException("Vectors must be of the same length for subtraction.");
        }

        double[] result = new double[getLength()];
        for (int i = 0; i < getLength(); i++) {
            result[i] = get(i) - other.get(i);
        }

        return new Vector(result);
    }

    public double dot(Vector other) {
        if (getLength() != other.getLength()) {
            throw new RuntimeException("Vectors must be of the same length for dot product.");
        }

        double result = 0;
        for (int i = 0; i < getLength(); i++) {
            result += get(i) * other.get(i);
        }

        return result;
    }

    public Vector multiply(Object scalarOrMatrix) {
        if (scalarOrMatrix instanceof Double) {
            double scalar = (Double) scalarOrMatrix;
            double[] result = new double[getLength()];
            for (int i = 0; i < getLength(); i++) {
                result[i] = scalar * get(i);
            }
            return new Vector(result);
        } else if (scalarOrMatrix instanceof Matrix) {
            Matrix matrix = (Matrix) scalarOrMatrix;
            return matrix.multiply(this);
        } else {
            throw new IllegalArgumentException("Unsupported type for multiplication: " + scalarOrMatrix.getClass());
        }
    }
}