import java.io.*;
import java.util.*;

public class TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] ui = new int[M];
        int[] vi = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) ui[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) vi[i] = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = ui[i];
            int v = vi[i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // ✅ Only sort once if needed
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        boolean[] visited = new boolean[N + 1];
        int[] parent = new int[N + 1];
        Arrays.fill(parent, -1);

        // ✅ Faster queue
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(S);
        visited[S] = true;

        boolean found = false;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == D) {
                found = true;
                break;
            }
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = curr;
                    q.add(neighbor);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (!found) {
            sb.append(-1).append("\n");
        } else {
            List<Integer> path = new ArrayList<>();
            int node = D;
            while (node != -1) {
                path.add(node);
                node = parent[node];
            }
            Collections.reverse(path);

            sb.append(path.size() - 1).append("\n");
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i < path.size() - 1) sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
