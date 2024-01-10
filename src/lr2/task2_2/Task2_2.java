package lr2.task2_2;

import lr2.task2_1.Asymptote;
import lr2.task2_1.Table;
import lr2.task2_1.Task2_1;

public class Task2_2 {
    private final Task2_1 function;
    private final ISort sort;

    public Task2_2() {
        function = new Task2_1(x -> 1.0 / iterations((int) Math.round(1 / x)));
        sort = new BubbleSort();
    }

    public Table[] getTable() {
        return function.getTable(1, 6);
    }

    public double getC() {
        return function.getC();
    }

    public Asymptote getAsymptote() {
        return function.getAsymptote();
    }

    private int iterations(int items) {
        int[] amounts = new int[items];
        for (int i = 0; i < items; i++) {
            amounts[i] = i;
        }
        return sort.sort(amounts);
    }
}
