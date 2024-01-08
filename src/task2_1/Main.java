package task2_1;

public class Main {
    public static void main(String[] args) {
        Task2_1 example = new Task2_1(x -> 3 * Math.pow(x, 1.5));

        printToConsole(example);
    }

    private static void printToConsole(Task2_1 example) {
        Table[] table = example.getTable(0, 16);

        System.out.println("N\tF\tLogN\tLogF");

        for (Table item : table) {
            System.out.println(item.getN() + "\t" + item.getF() + "\t" + item.getLogN() + "\t" + item.getLogF());
        }

        System.out.println("Asymptote (α): " + example.getAsymptote().getA());
        System.out.println("Coefficient (C): " + example.getC());
    }
}