import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, result;
        String op;

        System.out.print("Enter the first number: ");
        num1 = input.nextInt();

        System.out.print("Enter the operator (+, -, *, /): ");
        op = input.next();

        System.out.print("Enter the second number: ");
        num2 = input.nextInt();

        if (op.equals("+")) {
            result = num1 + num2;
        } else if (op.equals("-")) {
            result = num1 - num2;
        } else if (op.equals("*")) {
            result = num1 * num2;
        } else if (op.equals("/")) {
            if (num2 == 0) {
                System.out.println("Error: Division by zero");
            } else {
                result = num1 / num2;
            }
        } else {
            System.out.println("Invalid operator");
            return;
        }

        System.out.println("Result = " + result);
    }
}