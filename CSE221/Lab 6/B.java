import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == -1) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                visited[i] = 0;
                int c0 = 0, c1 = 0;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (visited[curr] == 0) c0++;
                    else c1++;

                    for (int x : graph.get(curr)) {
                        if (visited[x] == -1) {
                            visited[x] = 1 - visited[curr];
                            q.add(x);
                        }
                    }
                }
                ans += Math.max(c0, c1);
            }
        }

        System.out.println(ans);
    }
}
