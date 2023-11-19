package task2;

import java.util.function.Function;

public class Task2_1 {
    /**
     * Массив степеней десяти.
     */
    private static final double[] PowersOfTen = {
            1, 1E-01, 1E-02, 1E-03, 1E-04, 1E-05, 1E-06, 1E-07, 1E-08, 1E-09,
            1E-10, 1E-11, 1E-12, 1E-13, 1E-14, 1E-15
    };

    /**
     * Функция, подлежащая анализу.
     */
    private Function<Double, Double> function;

    /**
     * Конструктор класса Task2_1.
     *
     * @param function Функция для анализа.
     */
    public Task2_1(Function<Double, Double> function) {
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
     * Возвращает табличное представление функции в заданном диапазоне.
     *
     * @param start  Начальный индекс степени десяти.
     * @param amount Количество ячеек для табличного представления.
     * @return Массив объектов TableItem, представляющих табличное представление функции.
     * @throws IllegalArgumentException если количество ячеек больше 16.
     * @throws IllegalArgumentException если попытка выхода за пределы массива степеней десяти.
     */
    public TableItem[] getTableRepresentation(int start, int amount) {
        if (amount > 16) {
            throw new IllegalArgumentException("количество ячеек не более 16");
        }

        if (start + amount > 16) {
            throw new IllegalArgumentException("нельзя пытаться вылезти за 16");
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
     * @return Объект Asymptote, представляющий асимптоту функции.
     */
    public Asymptote getAsymptote() {
        return new Asymptote(function);
    }

    /**
     * Возвращает коэффициент C БМФ функции.
     *
     * @return Коэффициент C БМФ.
     */
    public double getCoefficient() {
        return Math.pow(10, getAsymptote().getK());
    }

    /**
     * Вложенный класс TableItem для представления пары (вход, выход) в табличном представлении функции.
     */
    public static class TableItem {
        private double input;
        private double output;

        /**
         * Конструктор класса TableItem.
         *
         * @param input  Значение входа.
         * @param output Значение выхода.
         */
        public TableItem(double input, double output) {
            this.input = input;
            this.output = output;
        }

        /**
         * Получает значение входа.
         *
         * @return Значение входа.
         */
        public double getInput() {
            return input;
        }

        /**
         * Получает значение выхода.
         *
         * @return Значение выхода.
         */
        public double getOutput() {
            return output;
        }

        /**
         * Получает логарифм основания 10 от значения входа.
         *
         * @return Логарифм основания 10 от значения входа.
         */
        public double getLgInput() {
            return Math.log10(input);
        }

        /**
         * Получает логарифм основания 10 от абсолютного значения выхода.
         *
         * @return Логарифм основания 10 от абсолютного значения выхода.
         */
        public double getLgOutput() {
            return Math.log10(Math.abs(output));
        }
    }

    /**
     * Вложенный класс Asymptote для представления асимптоты функции.
     */
    public static class Asymptote {
        private double alpha;
        private double k;

        /**
         * Конструктор класса Asymptote.
         *
         * @param function Функция для вычисления асимптоты.
         */
        public Asymptote(Function<Double, Double> function) {
            double left = Math.pow(10, -4);
            double right = Math.pow(10, -4.001);

            alpha = Math.log10(Math.abs(function.apply(right) / function.apply(left))) /
                    Math.log10(right / left);

            k = -1 * Math.log10(right) * Math.log10(Math.abs(function.apply(left) / function.apply(right))) /
                    Math.log10(left / right) + Math.log10(Math.abs(function.apply(right)));
        }

        /**
         * Возвращает значение alpha асимптоты.
         *
         * @return Значение alpha асимптоты.
         */
        public double getAlpha() {
            return alpha;
        }

        /**
         * Возвращает значение k асимптоты.
         *
         * @return Значение k асимптоты.
         */
        public double getK() {
            return k;
        }
    }
}
