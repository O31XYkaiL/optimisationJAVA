package task2_2;

public class BubbleSort implements ISort {
    /**
     * Сортирует массив в порядке убывания и возвращает количество перестановок.
     *
     * @param arr Массив, который нужно отсортировать.
     * @return Количество перестановок.
     */
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
     * Меняет местами элементы с индексами a и b в массиве.
     *
     * @param arr Массив, в котором происходит обмен элементов.
     * @param a   Индекс первого элемента для обмена.
     * @param b   Индекс второго элемента для обмена.
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}