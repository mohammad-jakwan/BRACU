import java.util.Scanner;
public class L5T5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = 2;
        int count = 0;

        while (count < n) {
            int sum = 1;
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    if (i * i != number) {
                        sum = sum + i + number / i;
                    } else {
                        sum = sum + i;
                    }
                }
            }
            if (sum == number) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
}
