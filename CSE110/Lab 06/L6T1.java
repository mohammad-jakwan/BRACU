import java.util.Scanner;

public class L6T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();

        for (int i = 0; i < width; i++) {
            for (int j = length; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
