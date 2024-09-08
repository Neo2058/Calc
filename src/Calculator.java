import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Invalid expression or numbers out of range.");
        }
    }

    // Метод для вычисления арифметического выражения
    public static String calc(String input) throws Exception {
        if (!isValidExpression(input)) {
            throw new Exception("Invalid expression or numbers out of range.");
        }

        int a = Integer.parseInt(input.split(" ")[0]);
        char operation = input.split(" ")[1].charAt(0);
        int b = Integer.parseInt(input.split(" ")[2]);

        switch (operation) {
            case '+': return String.valueOf(a + b);
            case '-': return String.valueOf(a - b);
            case '*': return String.valueOf(a * b);
            case '/': return String.valueOf((int)(a / b)); // Целая часть от деления
            default: throw new Exception("Unknown operator.");
        }
    }

    private static boolean isValidExpression(String input) {
        // Проверка на соответствие формату: два числа и операция между ними
        return input.matches("\\d+ \\D+ \\d+");
    }
}
