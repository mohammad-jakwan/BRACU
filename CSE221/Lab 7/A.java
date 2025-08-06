import java.io.*;
import java.util.*;

public class A {

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

    static int[] dijkstra(int N, List<List<Edge>> graph, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(0, start));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int d = cur.cost, u = cur.u;
            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to, w = edge.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    heap.add(new Node(dist[v], v));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        int[] distS = dijkstra(N, graph, S);
        int[] distT = dijkstra(N, graph, T);

        int resTime = Integer.MAX_VALUE;
        int resNode = -1;

        for (int u = 1; u <= N; u++) {
            int d1 = distS[u], d2 = distT[u];
            if (d1 == Integer.MAX_VALUE || d2 == Integer.MAX_VALUE) continue;
            int maxD = Math.max(d1, d2);
            if (maxD < resTime || (maxD == resTime && u < resNode)) {
                resTime = maxD;
                resNode = u;
            }
        }

        if (resNode == -1) {
            System.out.println(-1);
        } else {
            System.out.println(resTime + " " + resNode);
        }
    }
}
