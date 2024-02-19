import java.util.Scanner;

public class Lab3t2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if (num % 5 == 0 && num % 7 == 0) {
            System.out.println("Divisible by Both");
        } else if (num % 5 == 0) {
            System.out.println("Invalid: Divisible by 5 Only");
        } else if (num % 7 == 0) {
            System.out.println("Invalid: Divisible by 7 Only");
        } else {
            System.out.println("No");
        }
    }
}