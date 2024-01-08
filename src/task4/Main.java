package task4;

import task2_1.Table;

import java.util.function.Function;

public class Main {
//    public static void main(String[] args) {
//        Function<Vector, Double> example = vector -> vector.get(0) * vector.get(0) - 11 * Math.sqrt(vector.get(0) * vector.get(1));
//
//        Vector pointOfView = new Vector(1, 1);
//        Vector r = new Vector(1.0 / Math.sqrt(1 + 11 * 11 / 4), 5.5 / Math.sqrt(1 + 11 * 11 / 4));
//
//        Task4 exampleFunc = new Task4(example, pointOfView, r);
//
//        printToConsole(exampleFunc);
//    }
//
//    private static void printToConsole(Task4 exampleFunc) {
//        System.out.println("N\tF\tLogN\tLogF");
//
//        Table[] table = exampleFunc.getTable();
//        for (Table item : table) {
//            System.out.println(item.getN() + "\t" + item.getF() + "\t" + item.getLogN() + "\t" + item.getLogF());
//        }
//
//        System.out.println("Asymptote (α): " + exampleFunc.getAsymptote().getA());
//        System.out.println("Coefficient (C): " + exampleFunc.getC());
//    }

    public static void main(String[] args) {
        Function<Vector, Double> multivariateFunction = v -> v.get(0) * v.get(0) - 11 * Math.sqrt(v.get(0) * v.get(1));

        Vector pointOfView = new Vector(1, 1);
        Vector gradient = new Vector(pointOfView.get(0) * pointOfView.get(0) - 11 * Math.sqrt(pointOfView.get(0) * pointOfView.get(1)),
                6.5 / Math.sqrt(pointOfView.get(0) * pointOfView.get(1)));
        Vector vectorR = gradient.getOrth().normal();

        Task4 analyzer = new Task4(multivariateFunction, pointOfView, vectorR);

        printToConsole(analyzer);
    }

    private static void printToConsole(Task4 analyzer) {
        System.out.println("T\tG\tLogT\tLogG");

        Table[] table = analyzer.getTable();
        for (Table item : table) {
            System.out.println(item.getN() + "\t" + item.getF() + "\t" + item.getLogN() + "\t" + item.getLogF());
        }

        System.out.println("Asymptote (α): " + analyzer.getAsymptote().getA());
        System.out.println("Coefficient (C): " + analyzer.getC());
    }

//    public static void main(String[] args) {
//        Function<Vector, Double> example = vector -> vector.get(0) * vector.get(0) - 11 * Math.sqrt(vector.get(0) * vector.get(1));
//
//        Vector pointOfView = new Vector(1, 1);
//        Vector r = new Vector(1.0 / Math.sqrt(1 + 11 * 11 / 4), 5.5 / Math.sqrt(1 + 11 * 11 / 4));
//
//        Task4 exampleFunc = new Task4(example, pointOfView, r);
//
//        Vector[] circlePoints = exampleFunc.getPointForCircle(180);
//
//        printPointsToConsole(circlePoints);
//    }
//
//    private static void printPointsToConsole(Vector[] circlePoints) {
//        System.out.println("X\tY");
//
//        for (Vector point : circlePoints) {
//            System.out.println(point.get(0) + "\t" + point.get(1));
//        }
//    }
}