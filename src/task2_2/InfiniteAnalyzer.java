package task2_2;

import task2_1.Asymptote;
import task2_1.InfinitesimalAnalyzer;
import task2_1.TableItem;

/**
 * Класс InfiniteAnalyzer предназначен для анализа бесконечно малой величины.
 * Использует сортировку и асимптоту для расчетов.
 */
public class InfiniteAnalyzer {

    /**
     * Анализатор бесконечно малой величины.
     */
    private final InfinitesimalAnalyzer analyzer;

    /**
     * Собственно, сортировка.
     * Вместо неё может быть любая ББФ, которая по методу `Sort` возвратит число.
     */
    private final ISort sort;

    /**
     * Конструктор класса InfiniteAnalyzer.
     * Создает объект InfinitesimalAnalyzer с использованием
     * заданной функции и объекта сортировки BubbleSort.
     */
    public InfiniteAnalyzer() {
        // ББФ := 1 / БМФ(1 / x)
        this.analyzer = new InfinitesimalAnalyzer((x) -> (1.0 / IterationsAmount((int) Math.round(1 / x))));
        this.sort = new BubbleSort();
    }

    /**
     * Возвращает табличное представление функции для заданного диапазона.
     *
     * @param start  Начальный индекс.
     * @param amount Количество элементов в табличном представлении.
     * @return Массив элементов таблицы.
     */
    public TableItem[] getTableRepresentation(int start, int amount) {
        return this.analyzer.getTableRepresentation(start, amount);
    }

    /**
     * Рассчитывает ассимптоту lg-графика БМФ, которая задана вместо ББФ.
     *
     * @return Асимптота графика.
     */
    public Asymptote getAsymptote() {
        return this.analyzer.getAsymptote();
    }

    /**
     * Рассчитывает коэффициент `C` БМФ, которая задана вместо ББФ.
     *
     * @return Коэффициент.
     */
    public double getCoefficient() {
        return this.analyzer.getCoefficient();
    }

    /**
     * Считает количество перестановок для массива.
     *
     * @param itemsAmount Количество элементов массива.
     * @return Количество перестановок в массиве.
     */
    public int IterationsAmount(int itemsAmount) {
        // пустой массив
        int[] arr = new int[itemsAmount];
        // заполняем массив наихудшим случаем
        for (int i = 0; i < itemsAmount; i++)
            arr[i] = i;
        // запускаем сортировку и передаём количество перестановок
        return this.sort.sort(arr);
    }
}
