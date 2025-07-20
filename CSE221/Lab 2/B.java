import java.util.*;

public class B{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int i = 0;
        int j = M - 1;
        int close_i = 0;
        int close_j = 0;
        int min_diff = Integer.MAX_VALUE;

        while (i < N && j >= 0) {
            int total = A[i] + B[j];
            int diff = Math.abs(total - K);

            if (diff < min_diff) {
                min_diff = diff;
                close_i = i;
                close_j = j;
            }

            if (total < K) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println((close_i + 1) + " " + (close_j + 1));

    }
    
}
