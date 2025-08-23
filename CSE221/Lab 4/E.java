import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] U = new int[M];
        int[] V = new int[M];
        for (int i = 0; i < M; i++) {
            U[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            V[i] = sc.nextInt();
        }
        int[] listIndeg = new int[N + 1];
        int[] listOutdeg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int point1 = U[i];
            listOutdeg[point1]++;
            int point2 = V[i];
            listIndeg[point2]++;
        }
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int diff = listIndeg[i] - listOutdeg[i];
            output.add(diff);
        }
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i));
            if (i < output.size() - 1) System.out.print(" ");
        }
    }
}
