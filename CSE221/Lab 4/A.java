import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] adjMat = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(adjMat[i], 0);
        }

  
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjMat[u - 1][v - 1] = w;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(adjMat[i][j] + (j == N - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}
