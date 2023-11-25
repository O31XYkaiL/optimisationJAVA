package task2_1;

public class TableItem {
    private double input;
    private double output;

    /**
     * Конструктор класса.
     *
     * @param input  Входное значение.
     * @param output Выходное значение.
     */
    public TableItem(double input, double output) {
        this.input = input;
        this.output = output;
    }

    /**
     * Возвращает входное значение.
     *
     * @return Входное значение.
     */
    public double getInput() {
        return input;
    }

    /**
     * Возвращает выходное значение.
     *
     * @return Выходное значение.
     */
    public double getOutput() {
        return output;
    }

    /**
     * Возвращает логарифм по основанию 10 от входного значения.
     *
     * @return Логарифм по основанию 10 от входного значения.
     */
    public double getLgInput() {
        return Math.log10(input);
    }

    /**
     * Возвращает логарифм по основанию 10 от абсолютного значения выходного значения.
     *
     * @return Логарифм по основанию 10 от абсолютного значения выходного значения.
     */
    public double getLgOutput() {
        return Math.log10(Math.abs(output));
    }
}
