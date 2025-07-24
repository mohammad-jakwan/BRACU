import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] list1 = new int[N];
        for (int i = 0; i < N; i++) {
            list1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] list2 = new int[M];
        for (int i = 0; i < M; i++) {
            list2[i] = sc.nextInt();
        }

        int i = 0, j = 0;

        while (i < N && j < M) {
            if (list1[i] <= list2[j]) {
                System.out.print(list1[i++] + " ");
            } else {
                System.out.print(list2[j++] + " ");
            }
        }

        while (i < N) {
            System.out.print(list1[i++] + " ");
        }

        while (j < M) {
            System.out.print(list2[j++] + " ");
        }
    }
}
