import java.io.*;
import java.util.*;

public class E {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int cost, u, prevParity;
        Node(int cost, int u, int prevParity) {
            this.cost = cost;
            this.u = u;
            this.prevParity = prevParity;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static void editedDijkstra(int N, List<List<Edge>> graph) {
        int[][] dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][0] = dist[1][1] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(0, 1, -1));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int cost = cur.cost, node = cur.u, prev = cur.prevParity;

            for (Edge edge : graph.get(node)) {
                int neighbour = edge.to, weight = edge.weight;
                int curr = weight % 2;
                if (curr == prev) continue;
                if (cost + weight < dist[neighbour][curr]) {
                    dist[neighbour][curr] = cost + weight;
                    heap.add(new Node(cost + weight, neighbour, curr));
                }
            }
        }

        int res = Math.min(dist[N][0], dist[N][1]);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        int[] u = new int[M], v = new int[M], w = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) w[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            graph.get(u[i]).add(new Edge(v[i], w[i]));
        }

        editedDijkstra(N, graph);
    }
}
