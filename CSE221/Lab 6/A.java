import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        int[] indeg = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) if (indeg[i] == 0) q.add(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            order.add(curr);
            for (int x : graph.get(curr)) {
                indeg[x]--;
                if (indeg[x] == 0) q.add(x);
            }
        }
        if (order.size() < n) System.out.println(-1);
        else {
            for (int i = 0; i < order.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(order.get(i));
            }
        }
    }
}
