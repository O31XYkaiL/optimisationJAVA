package task2;

import org.junit.Test;
import task2.task2_2;

import static org.junit.Assert.*;

public class test_task2_2 {

    @Test
    public void testAsymptote() {
        // Пример функции: f(N) ≈ C·N^α
        task2_2 customFunctionAnalysis = new task2_2(n -> 5 * Math.pow(n, 1.8));

        // Используем методы task2.task2_2 для получения данных
        task2_2.Asymptote asymptoteResult = customFunctionAnalysis.getAsymptote();

        // Проверяем, что значение alpha округленное до целого равно 2
        assertEquals(2, Math.round(asymptoteResult.getAlpha()));
    }
}