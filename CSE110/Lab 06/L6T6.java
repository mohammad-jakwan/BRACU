import java.util.Scanner;

public class L6T6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();

        // Upper half
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= d - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // Lower half
        for (int i = d - 1; i >= 1; i--) {
            for (int j = 1; j <= d - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
