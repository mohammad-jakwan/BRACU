import java.util.Scanner;

public class Lab3t1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        String op = input.next();

        if (op.equals("+")) {
             System.out.println("Result = " + (num1 + num2));
        } else if (op.equals("-")) {
            System.out.println("Result = " + (num1 - num2));
        } else if (op.equals("*")) {
            System.out.println("Result = "+ (num1 * num2));
        } else if (op.equals("/")) {
            System.out.println("Result = " +(num1 / num2));
            }
    }
}

