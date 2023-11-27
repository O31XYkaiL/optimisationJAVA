package task2_2;

import task2_1.Asymptote;

public class Main {
    public static void main(String[] args) {
        // Заданные значения для альфа и C
        double alpha = 2.0;
        double C = 0.15;

        // Определение интервала
        int start = 100;
        int end = 1000;
        int step = 100;

        // Создание объекта для анализа
        InfiniteAnalyzer analyzer = new InfiniteAnalyzer();

        // Исследование функции на заданном интервале
        for (int N = start; N <= end; N += step) {
            // Рассчитываем F = C * N^α
            double F = C * Math.pow(N, alpha);

            // Выводим результаты в таблице
            System.out.printf("N: %d, F: %.2E, lg(N): %.6E, lg(F): %.6E%n",
                    N, F, Math.log10(N), Math.log10(F));
        }

        // Получаем асимптоту и коэффициент C
        Asymptote asymptote = analyzer.getAsymptote();
        double coefficientC = analyzer.getCoefficient();

        System.out.println("Асимптота lg-графика:");
        System.out.println("lg(Y) приблизительно равен " + asymptote.getAlpha() + " * lg(X) + " + asymptote.getK());
        System.out.println("Coefficient C: " + coefficientC);
    }
}