import java.util.Scanner;

public class Lab3t5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        int paid = scanner.nextInt();

        if (age < 18) {
            System.out.println("Your tax amounts is 0 Tk");
        } else {
            if (paid < 10000) {
                System.out.println("Your tax amounts is 0 Tk");
            } else if (paid >= 10000 && paid <= 20000) {
                System.out.println("Your tax amounts is " + (paid * 0.05) + " Tk");
            } else if (paid > 20000) {
                System.out.println("Your tax amounts is " + (paid * 0.1) + " Tk");
            }
        }
    }
}
