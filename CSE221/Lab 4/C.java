import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            for (int j = 0; j < count; j++) {
                int val = sc.nextInt();
                graph[i][val] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                System.out.print(graph[j][k] + " ");
            }
            System.out.println();
        }

    }
}
