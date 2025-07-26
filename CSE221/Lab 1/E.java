import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (n < 3) {
            int[] sortedA = new int[n];
            for (int i = 0; i < n; i++) {
                sortedA[i] = a[i];
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (sortedA[j] > sortedA[j + 1]) {
                        int temp = sortedA[j];
                        sortedA[j] = sortedA[j + 1];
                        sortedA[j + 1] = temp;
                    }
                }
            }

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != sortedA[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int inv = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i] > a[j]) {
                        inv++;
                    }
                }
            }
            if (inv % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
