import java.io.*;
import java.util.*;

public class C {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int danger, u;
        Node(int danger, int u) {
            this.danger = danger;
            this.u = u;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.danger, other.danger);
        }
    }

    static void minimumDanger(int N, List<List<Edge>> graph) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(0, 1));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int danger = cur.danger, node = cur.u;
            if (danger > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int neighbor = edge.to, weight = edge.weight;
                int newDanger = Math.max(danger, weight);
                if (newDanger < dist[neighbor]) {
                    dist[neighbor] = newDanger;
                    heap.add(new Node(newDanger, neighbor));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i == 1) sb.append(0);
            else sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
            if (i < N) sb.append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w)); // undirected
        }

        minimumDanger(N, graph);
    }
}
