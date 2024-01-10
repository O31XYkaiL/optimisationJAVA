package lr2.task2_2;

public class BubbleSort implements ISort {
    public int sort(int[] arr) {
        int amount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    iteration(arr, j);
                    amount++;
                }
            }
        }
        return amount;
    }

    private static void iteration(int[] arr, int i) {
        arr[i + 1] += arr[i];
        arr[i] = arr[i + 1] - arr[i];
        arr[i + 1] -= arr[i];
    }
}
