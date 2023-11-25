package task2_1;

import java.util.function.Function;

public class Asymptote {
    private double alpha;
    private double k;

    /**
     * Конструктор класса.
     *
     * @param function Функция для расчета асимптоты.
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
     * Возвращает значение параметра alpha.
     *
     * @return Значение параметра alpha.
     */
    public double getAlpha() {
        return alpha;
    }

    /**
     * Возвращает значение параметра k.
     *
     * @return Значение параметра k.
     */
    public double getK() {
        return k;
    }
}