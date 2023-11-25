package task4;

import task2_1.Asymptote;
import task2_1.TableItem;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Задача 4.1
        System.out.println("Task 4.1:");
        Function<Vector, Double> function1 = vector -> Math.pow(vector.get(0), 2) - 6 * Math.sqrt(vector.get(0) * vector.get(1));
        Vector r1 = new Vector(1, 6/2).multiply(1/Math.sqrt(1 + Math.pow(6, 2)/4));
        Vector x0 = new Vector(1, 1);
        MultivariateAnalyzer analyzer1 = new MultivariateAnalyzer(function1, x0, r1);

        double alpha1 = analyzer1.getCoefficient();
        double coefficient1 = analyzer1.getCoefficient();

        System.out.println("Alpha: " + alpha1);
        System.out.println("Coefficient C: " + coefficient1);

        // Вывод табличного представления
        TableItem[] table1 = analyzer1.getTableRepresentation(0, 15);
        System.out.println("Table for Task 4.1:");
        for (TableItem item : table1) {
            System.out.printf("t: %.5f, f(x_0 + t*r): %.2E, lg(f(x_0 + t*r)): %.5f%n",
                    item.getInput(), item.getOutput(), item.getLgOutput());
        }

        Asymptote asymptote1 = analyzer1.getAsymptote();
        System.out.printf("lg(Y) приблизительно равен %.5f * lg(X) + %.5f%n", asymptote1.getAlpha(), asymptote1.getK());


        // Задача 4.2
        System.out.println("\nTask 4.2:");
        // Здесь предполагается использование перпендикуляра к градиенту, но для примера используем тот же r1
        Vector r2 = r1;
        MultivariateAnalyzer analyzer2 = new MultivariateAnalyzer(function1, x0, r2);

        double alpha2 = analyzer2.getCoefficient();
        double coefficient2 = analyzer2.getCoefficient();

        System.out.println("Alpha: " + alpha2);
        System.out.println("Coefficient C: " + coefficient2);

        // Вывод табличного представления
        TableItem[] table2 = analyzer2.getTableRepresentation(0, 7);
        System.out.println("Table for Task 4.2:");
        for (TableItem item : table2) {
            System.out.printf("t: %.5f, f(x_0 + t*r): %.2E, lg(f(x_0 + t*r)): %.5f%n",
                    item.getInput(), item.getOutput(), item.getLgOutput());
        }

        Asymptote asymptote2 = analyzer2.getAsymptote();
        System.out.printf("lg(Y) приблизительно равен %.5f * lg(X) + %.5f%n", asymptote2.getAlpha(), asymptote2.getK());
    }
}
