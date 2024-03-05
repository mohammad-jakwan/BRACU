import java.util.Scanner;

public class Lab4T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        while (number != 0) {
            number /= 10; 
            count++; 
        }

        System.out.println("Total digits = " + count);
    }
}
