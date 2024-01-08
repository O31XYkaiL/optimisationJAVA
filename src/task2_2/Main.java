package task2_2;

public class Main {
    public static void main(String[] args) {
        Task2_2 infiniteAnalyzer = new Task2_2();

        printToConsole(infiniteAnalyzer);
    }

    private static void printToConsole(Task2_2 infiniteAnalyzer) {
        System.out.println("N\tF\tLogN\tLogF");

        for (int N = 100; N <= 1000; N += 100) {
            double F = infiniteAnalyzer.getC() * Math.pow(N, infiniteAnalyzer.getAsymptote().getA());

            System.out.println(N + "\t" + F + "\t" + Math.log10(N) + "\t" + Math.log10(Math.abs(F)));
        }

        System.out.println("Asymptote (α): " + infiniteAnalyzer.getAsymptote().getA());
        System.out.println("Coefficient (C): " + infiniteAnalyzer.getC());
    }
}