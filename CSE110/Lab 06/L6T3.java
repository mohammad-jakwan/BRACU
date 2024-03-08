import java.util.Scanner;

public class L6T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int w = scanner.nextInt();

        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= l; j++) {
                if (i == 1 || i == w || j == 1 || j == l) {
                    System.out.print(j + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
