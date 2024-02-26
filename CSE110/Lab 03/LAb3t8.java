import java.util.Scanner;

public class LAb3t8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the 1st number: ");
        int n1 = scanner.nextInt();

        System.out.print("Input the 2nd number: ");
        int n2 = scanner.nextInt();

        System.out.print("Input the 3rd number: ");
        int n3 = scanner.nextInt();

        if (n1 == n2 && n2 == n3) {
            System.out.println("All numbers are equal");
        } else if (n1 != n2 && n1 != n3 && n2 != n3) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }
}