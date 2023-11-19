package task2;

import java.util.function.Function;

public class Task2_2 {

    /**
     * Функция, подлежащая анализу.
     */
    private final Function<Double, Double> function;

    /**
     * Интерфейс для сортировки.
     */
    private final ISort sort;

    /**
     * Конструктор класса Task2_2.
     *
     * @param function Функция для анализа.
     */
    public Task2_2(Function<Double, Double> function) {
        this.function = function;
        this.sort = new BubbleSort();
    }

    /**
     * Возвращает табличное представление функции.
     *
     * @return Массив объектов TableItem, представляющих табличное представление функции.
     */
    public TableItem[] getTableRepresentation() {
        return analyzeFunction(1, 6);
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
     * Анализирует функцию и возвращает табличное представление.
     *
     * @param start  Начальное значение.
     * @param amount Количество значений для анализа.
     * @return Массив объектов TableItem, представляющих табличное представление функции.
     */
    private TableItem[] analyzeFunction(int start, int amount) {
        TableItem[] result = new TableItem[amount];

        for (int i = 0; i < amount; i++) {
            result[i] = new TableItem(start + i, function.apply((double) (start + i)));
        }

        return result;
    }

    /**
     * Вычисляет количество итераций для сортировки массива.
     *
     * @param itemsAmount Количество элементов в массиве.
     * @return Количество итераций для сортировки.
     */
    private int iterationsAmount(int itemsAmount) {
        int[] arr = new int[itemsAmount];
        for (int i = 0; i < itemsAmount; i++) {
            arr[i] = i;
        }
        return sort.sort(arr);
    }

    /**
     * Интерфейс для сортировки.
     */
    public interface ISort {
        int sort(int[] arr);
    }

    /**
     * Вложенный класс BubbleSort для реализации сортировки пузырьком.
     */
    public static class BubbleSort implements ISort {
        @Override
        public int sort(int[] arr) {
            int counter = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j + 1] > arr[j]) {
                        swap(arr, j, j + 1);
                        counter++;
                    }
                }
            }
            return counter;
        }

        /**
         * Меняет местами два элемента массива.
         *
         * @param arr Массив.
         * @param a   Индекс первого элемента.
         * @param b   Индекс второго элемента.
         */
        private void swap(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
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
