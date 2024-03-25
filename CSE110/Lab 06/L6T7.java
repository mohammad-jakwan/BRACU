import java.util.Scanner;

public class L6T7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        int spaces = rows - 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print("   ");
            }
            if (i == 1) {
                System.out.println(" 1");
            } else {
                System.out.print(" 1");
                for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                    System.out.print("   ");
                }
                System.out.println(" " + (2 * i - 1));
            }

            spaces--;
        }
        spaces = 1;
        for (int i = rows - 1; i >= 1; i--) {
            // Printing spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print("   ");
            }

            // Printing numbers
            if (i == 1) {
                System.out.println(" 1");
            } else {
                System.out.print(" 1");
                for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                    System.out.print("   ");
                }
                System.out.println(" " + (2 * i - 1));
            }

            spaces++;
        }

        
    }
}
