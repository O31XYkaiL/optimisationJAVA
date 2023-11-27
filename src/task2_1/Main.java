package task2_1;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр InfinitesimalAnalyzer с функцией f(x) = 3*x^1.5
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(Main::function);

        // Печать результата проверки, является ли функция бесконечно малой
        System.out.println("БМВ?: " + ia.isInfinitesimal());

        // Получение и вывод табличного представления функции
        TableItem[] table = ia.getTableRepresentation(0, 16);
        System.out.println("Таблица:");
        for (TableItem item : table) {
            System.out.printf("X: %.1E, Y: %.6E, lg(X): %.1E, lg(Y): %.6E%n",
                    item.getInput(), item.getOutput(),  item.getLgInput(), item.getLgOutput());
        }

        // Получение и вывод асимптоты lg-графика
        Asymptote asymptote = ia.getAsymptote();
        System.out.println("Асимптота lg-графика:");
        System.out.println("lg(Y) приблизительно равен " + asymptote.getAlpha() + " * lg(X) + " + asymptote.getK());

        // Получение и вывод коэффициента C БМФ
        double coefficient = ia.getCoefficient();
        System.out.println("C: " + coefficient);
    }

    // Функция f(x) = 3*x^1.5
    private static double function(double x) {
        return 3 * Math.pow(x, 1.5);
    }
}

