import java.io.*;
import java.util.*;

public class TaskB {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> arr;

    static void dfsOfGraph(int s) {
        visited[s] = true;
        arr.add(s);
        for (int x : graph.get(s)) {
            if (!visited[x]) {
                dfsOfGraph(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] ui = new int[M];
        int[] vi = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) ui[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) vi[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int u = ui[i];
            int v = vi[i];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // ✅ Sort adjacency lists ONCE
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        arr = new ArrayList<>();

        dfsOfGraph(1);

        // Efficient output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (i < arr.size() - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
