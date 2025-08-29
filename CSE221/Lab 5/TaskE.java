import java.io.*;
import java.util.*;

public class TaskE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        int[] subtreesiz = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.get(u).add(v);
            g.get(v).add(u);
        }

        // Iterative DFS with manual stack
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{root, -1, 0}); // {node, parent, state}

        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], parent = top[1], state = top[2];
            if (state == 0) {
                stack.push(new int[]{node, parent, 1});
                for (int child : g.get(node)) {
                    if (child != parent) {
                        stack.push(new int[]{child, node, 0});
                    }
                }
            } else {
                int size = 1;
                for (int child : g.get(node)) {
                    if (child != parent) size += subtreesiz[child];
                }
                subtreesiz[node] = size;
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(subtreesiz[x]).append("\n");
        }
        System.out.print(sb);
    }
}
