import java.util.Scanner;

public class Lab3t6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float n1 = scanner.nextFloat();
        float n2 = scanner.nextFloat();
        float n3 = scanner.nextFloat();

        float max=0;
        float min=0;

        if (n1 > n2) {
            if (n1 > n3) {
                max = n1;
            } else {
                max = n3;
            }
            if (n2 < n3) {
                min = n2;
            } else {
                min = n3;
            }
        } else {
            if (n2 > n3) {
                max = n2;
            } else {
                max = n3;
            }
            if (n1 < n3) {
                min = n1;
            } else {
                min = n3;
            }
        }

        System.out.println("Maximum number is " + max);
        System.out.println("Minimum number is " + min);
    }
}
