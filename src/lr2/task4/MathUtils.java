package lr2.task4;

public class MathUtils {
    public static Matrix getRotationMatrix(double angle) {
        double[][] matrixAsArray = {
                {Math.cos(angle), -Math.sin(angle)},
                {Math.sin(angle), Math.cos(angle)}
        };

        return new Matrix(matrixAsArray);
    }
}
