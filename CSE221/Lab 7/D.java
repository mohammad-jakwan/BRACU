import java.io.*;
import java.util.*;

public class D {

    static int[] weights;

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

    static int dijkstra(int N, int S, int D, List<List<Integer>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = weights[S - 1];

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(dist[S], S));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int currentCost = cur.cost, u = cur.u;
            if (currentCost > dist[u]) continue;

            for (int v : graph.get(u)) {
                int newCost = currentCost + weights[v - 1];
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    heap.add(new Node(newCost, v));
                }
            }
        }
        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        System.out.println(dijkstra(N, S, D, graph));
    }
}
