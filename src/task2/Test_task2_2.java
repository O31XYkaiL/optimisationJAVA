package task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_task2_2 {

    @Test
    public void testAsymptote() {
        // Пример функции: f(N) ≈ C·N^α
        Task2_2 customFunctionAnalysis = new Task2_2(n -> 5 * Math.pow(n, 1.8));

        // Используем методы task2.Task2_2 для получения данных
        Task2_2.Asymptote asymptoteResult = customFunctionAnalysis.getAsymptote();

        // Проверяем, что значение alpha округленное до целого равно 2
        assertEquals(2, Math.round(asymptoteResult.getAlpha()));
    }
}