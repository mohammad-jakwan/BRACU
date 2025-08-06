import java.io.*;
import java.util.*;

public class B {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int cost, u;
        Node(int cost, int u) {
            this.cost = cost;
            this.u = u;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static void shortestPath(int N, int M, int S, int D, int[] uList, int[] vList, int[] wList) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            graph.get(uList[i]).add(new Edge(vList[i], wList[i]));
        }

        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        dist[S] = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(0, S));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int d = cur.cost, node = cur.u;
            if (d > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int neighbor = edge.to, weight = edge.weight;
                if (dist[node] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[node] + weight;
                    prev[neighbor] = node;
                    heap.add(new Node(dist[neighbor], neighbor));
                }
            }
        }

        if (dist[D] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(dist[D]);

        List<Integer> path = new ArrayList<>();
        for (int cur = D; cur != -1; cur = prev[cur]) {
            path.add(cur);
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i + 1 < path.size()) sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] uList = new int[M];
        int[] vList = new int[M];
        int[] wList = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) uList[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) vList[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) wList[i] = Integer.parseInt(st.nextToken());

        shortestPath(N, M, S, D, uList, vList, wList);
    }
}
