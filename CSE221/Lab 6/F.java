import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.get(u).add(v);
            g.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        int[] sources = new int[s];
        for (int i = 0; i < s; i++) sources[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) queries[i] = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int src : sources) {
            dist[src] = 0;
            dq.add(src);
        }

        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : g.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.add(v);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            if (i > 0) sb.append(" ");
            sb.append(dist[queries[i]]);
        }
        System.out.println(sb.toString());
    }
}

