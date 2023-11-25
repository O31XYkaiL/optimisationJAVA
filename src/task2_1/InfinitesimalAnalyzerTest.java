package task2_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfinitesimalAnalyzerTest {

    private static final double[] ExpectedTableInputs = {
            1, 1E-01, 1E-02, 1E-03, 1E-04, 1E-05, 1E-06, 1E-07, 1E-08, 1E-09,
            1E-10, 1E-11, 1E-12, 1E-13, 1E-14, 1E-15
    };

    private static final double[] ExpectedTableOutputs = {
            1E+01, 1, 1E-01, 1E-02, 1E-03, 1E-04, 1E-05, 1E-06, 1E-07, 1E-08,
            1E-09, 1E-10, 1E-11, 1E-12, 1E-13, 1E-14
    };

    private static final double[] ExpectedTableLgInputs = {
            0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15
    };

    private static final double[] ExpectedTableLgOutputs = {
            1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14
    };

    @Test
    public void infinitesimalTest() {
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(this::function);
        boolean got = ia.isInfinitesimal();
        assertTrue(got);
    }

    @Test
    public void notInfinitesimalTest() {
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(this::notInfinitesimalFunction);
        boolean got = ia.isInfinitesimal();
        assertFalse(got);
    }

    @Test
    public void tableRepresentationTest() {
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(this::function);
        TableItem[] got = ia.getTableRepresentation(0, 16);

        for (int i = 0; i < 16; i++) {
            assertEquals(ExpectedTableInputs[i], got[i].getInput());
            assertTrue(Math.abs(ExpectedTableOutputs[i] - got[i].getOutput()) < 1e-10);
            assertEquals(ExpectedTableLgInputs[i], got[i].getLgInput());
            assertEquals(ExpectedTableLgOutputs[i], got[i].getLgOutput());
        }
    }

    @Test
    public void asymptoteTest() {
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(this::function);
        Asymptote got = ia.getAsymptote();
        assertEquals(1, got.getAlpha());
        assertEquals(1, got.getK());
    }

    @Test
    public void coefficientTest() {
        InfinitesimalAnalyzer ia = new InfinitesimalAnalyzer(this::function);
        double got = ia.getCoefficient();
        assertEquals(10, got);
    }

    private double function(double x) {
        return 10 * x;
    }

    private double notInfinitesimalFunction(double x) {
        return x + 1;
    }
}
