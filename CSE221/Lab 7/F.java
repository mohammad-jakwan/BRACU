import java.io.*;
import java.util.*;

public class F {

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

    static void secondShortestPath(int N, int S, int D, List<List<Edge>> graph) {
        int[][] dist = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
        }
        dist[S][0] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(0, S));

        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            int cost = cur.cost, node = cur.u;

            for (Edge edge : graph.get(node)) {
                int neighbour = edge.to, newCost = cost + edge.weight;

                if (newCost < dist[neighbour][0]) {
                    dist[neighbour][1] = dist[neighbour][0];
                    dist[neighbour][0] = newCost;
                    heap.add(new Node(newCost, neighbour));
                } else if (newCost > dist[neighbour][0] && newCost < dist[neighbour][1]) {
                    dist[neighbour][1] = newCost;
                    heap.add(new Node(newCost, neighbour));
                }
            }
        }

        int res = dist[D][1];
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        secondShortestPath(N, S, D, graph);
    }
}
