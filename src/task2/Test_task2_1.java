package task2;

import org.junit.Assert;
import org.junit.Test;

public class Test_task2_1 {

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
        Task2_1 ia = new Task2_1(this::function);
        boolean got = ia.isInfinitesimal();
        Assert.assertTrue(got);
    }

    @Test
    public void notInfinitesimalTest() {
        Task2_1 ia = new Task2_1(this::notInfinitesimalFunction);
        boolean got = ia.isInfinitesimal();
        Assert.assertFalse(got);
    }

    @Test
    public void tableRepresentationTest() {
        Task2_1 ia = new Task2_1(this::function);
        Task2_1.TableItem[] got = ia.getTableRepresentation(0, 16);

        for (int i = 0; i < 16; i++) {
            Assert.assertEquals(ExpectedTableInputs[i], got[i].getInput(), 0);
            Assert.assertTrue(Math.abs(ExpectedTableOutputs[i] - got[i].getOutput()) < 1e-10);
            Assert.assertEquals(ExpectedTableLgInputs[i], got[i].getLgInput(), 0);
            Assert.assertEquals(ExpectedTableLgOutputs[i], got[i].getLgOutput(), 0);
        }
    }

    @Test
    public void asymptoteTest() {
        Task2_1 ia = new Task2_1(this::function);
        Task2_1.Asymptote got = ia.getAsymptote();
        Assert.assertEquals(got.getAlpha(), 1, 0);
        Assert.assertEquals(got.getK(), 1, 0);
    }

    @Test
    public void coefficientTest() {
        Task2_1 ia = new Task2_1(this::function);
        double got = ia.getCoefficient();
        Assert.assertEquals(got, 10, 0);
    }

    private double function(double x) {
        return 10 * x;
    }

    private double notInfinitesimalFunction(double x) {
        return x + 1;
    }
}
