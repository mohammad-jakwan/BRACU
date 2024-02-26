import java.util.Scanner;

public class Lab3t3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        int x = scanner.nextInt();

        int f = 0;

        if (x < 0) {
            f = 2 * x;
        } else if ((x>=0) && (x < 2)) {
            f = x + 1;
        } else if ((x>=2) && (x < 5)) {
            f = (x*x) -1;
        } else if(x>=5) {
            f = (3 * (x*x)) + 2;
        }

        System.out.println("output: " + f);
    }
}