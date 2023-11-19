package task2;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        runTask2_1();
        runTask2_2();
    }

    private static void runTask2_1() {
        // Пример функции: f(x) = 3 * x^(3/2)
        Function<Double, Double> quadraticFunction = x -> 3 * Math.pow(x, 1.5);

        // Создаем объект task2.Task2_1
        Task2_1 analyzer = new Task2_1(quadraticFunction);

        // Проверяем, является ли функция бесконечно малой
        System.out.println("Task2_1 - Is Infinitesimal: " + analyzer.isInfinitesimal());

        // Получаем табличное представление функции
        Task2_1.TableItem[] table = analyzer.getTableRepresentation(0, 15);
        System.out.println("Task2_1 - Table Representation:");
        for (Task2_1.TableItem item : table) {
            System.out.println("Input: " + item.getInput() + ", Output: " + item.getOutput() +
                    ", Log Input: " + item.getLgInput() + ", Log Output: " + item.getLgOutput());
        }

        // Получаем асимптоту lg-графика
        Task2_1.Asymptote asymptote = analyzer.getAsymptote();
        System.out.println("Task2_1 - Asymptote: Alpha = " + asymptote.getAlpha() + ", K = " + asymptote.getK());

        // Получаем коэффициент C БМФ
        System.out.println("Task2_1 - Coefficient C: " + analyzer.getCoefficient());
    }

    private static void runTask2_2() {
        // Пример функции: f(N) ≈ C·N^α
        Function<Double, Double> customFunction = n -> 5 * Math.pow(n, 1.8);

        // Используем task2.Task2_2 для анализа пользовательской функции
        Task2_2 customFunctionAnalysis = new Task2_2(customFunction);

        // Используем методы task2.Task2_2 для получения данных
        Task2_2.TableItem[] tableItems = customFunctionAnalysis.getTableRepresentation();
        Task2_2.Asymptote asymptoteResult = customFunctionAnalysis.getAsymptote();
        double coefficientResult = customFunctionAnalysis.getCoefficient();

        // Вывод результатов или их использование по необходимости
        System.out.println("Task2_2 - Table Representation:");
        for (Task2_2.TableItem item : tableItems) {
            System.out.println("Input: " + item.getInput() + ", Output: " + item.getOutput());
        }

        System.out.println("Task2_2 - Asymptote:");
        System.out.println("Alpha: " + asymptoteResult.getAlpha() + ", K: " + asymptoteResult.getK());

        System.out.println("Task2_2 - Coefficient: " + coefficientResult);
    }
}
