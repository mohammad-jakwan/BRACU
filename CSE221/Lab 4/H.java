import java.util.*;

public class H {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        List<List<Integer>> G = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            G.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && gcd(i, j) == 1) {
                    G.get(i).add(j);
                }
            }
            Collections.sort(G.get(i));
        }
        for (int t = 0; t < Q; t++) {
            int X = sc.nextInt();
            int K = sc.nextInt();
            if (K <= G.get(X).size()) {
                System.out.println(G.get(X).get(K - 1));
            } else {
                System.out.println(-1);
            }
        }
    }
}
