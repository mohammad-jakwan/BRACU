import java.io.*;
import java.util.*;

public class D {
    static int n;
    static List<List<Integer>> g;

    static int[] bfs(int s) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        vis[s] = 0;
        int[] far = {0, s};

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int k : g.get(x)) {
                if (vis[k] == -1) {
                    vis[k] = vis[x] + 1;
                    q.add(k);
                    if (vis[k] > far[0]) {
                        far[0] = vis[k];
                        far[1] = k;
                    }
                }
            }
        }
        return far;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.get(u).add(v);
            g.get(v).add(u);
        }

        int[] first = bfs(1);
        int[] second = bfs(first[1]);

        System.out.println(second[0]);
        System.out.println(first[1] + " " + second[1]);
    }
}
