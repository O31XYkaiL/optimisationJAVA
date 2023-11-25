package task4;

public class MathUtilities {
    public static double[][] getRotationMatrix(double angle) {
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        return new double[][]{{cosAngle, sinAngle}, {-1 * sinAngle, cosAngle}};
    }
}
