package task2_1;

import java.util.function.Function;

public class InfinitesimalAnalyzer {

    private static final double[] PowersOfTen = {
            1, 1E-01, 1E-02, 1E-03, 1E-04, 1E-05, 1E-06, 1E-07, 1E-08, 1E-09,
            1E-10, 1E-11, 1E-12, 1E-13, 1E-14, 1E-15
    };

    private Function<Double, Double> function;

    /**
     * Конструктор класса.
     *
     * @param function Функция для анализа.
     */
    public InfinitesimalAnalyzer(Function<Double, Double> function) {
        this.function = function;
    }

    /**
     * Проверяет, является ли функция бесконечно малой.
     *
     * @return true, если функция бесконечно мала, иначе false.
     */
    public boolean isInfinitesimal() {
        return function.apply(0.0) == 0.0;
    }

    /**
     * Возвращает табличное представление функции для заданного диапазона.
     *
     * @param start  Начальный индекс.
     * @param amount Количество элементов в табличном представлении.
     * @return Массив элементов таблицы.
     * @throws IllegalArgumentException Если количество ячеек больше 16.
     */
    public TableItem[] getTableRepresentation(int start, int amount) {
        if (amount > 16) {
            throw new IllegalArgumentException("Количество ячеек не более 16");
        }

        if (start + amount > 16) {
            throw new IllegalArgumentException("Нельзя пытаться выйти за 16");
        }

        TableItem[] answer = new TableItem[amount - start];

        for (int i = start; i < start + amount; i++) {
            answer[i - start] = new TableItem(PowersOfTen[i], function.apply(PowersOfTen[i]));
        }

        return answer;
    }

    /**
     * Возвращает асимптоту функции.
     *
     * @return Асимптота функции.
     */
    public Asymptote getAsymptote() {
        return new Asymptote(function);
    }

    /**
     * Возвращает коэффициент `C` функции.
     *
     * @return Коэффициент `C`.
     */
    public double getCoefficient() {
        return Math.pow(10, getAsymptote().getK());
    }

    public void setFunction(Function<Double, Double> function) {
        this.function = function;
    }

    public Function<Double, Double> getFunction() {
        return function;
    }
}