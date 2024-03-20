import java.util.Scanner;

public class RhombusPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the vertical diagonal length of the rhombus: ");
        int diagonal = scanner.nextInt();

        // Upper half
        for (int i = 1; i <= diagonal; i++) {
            for (int j = 1; j <= diagonal - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // Lower half
        for (int i = diagonal - 1; i >= 1; i--) {
            for (int j = 1; j <= diagonal - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
