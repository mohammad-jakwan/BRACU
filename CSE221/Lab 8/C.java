import java.io.*;
import java.util.*;

public class C {

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n + 1];
            r = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (r[ra] < r[rb]) {
                int t = ra; ra = rb; rb = t;
            }
            p[rb] = ra;
            if (r[ra] == r[rb]) r[ra]++;
            return true;
        }
    }

    static class Edge implements Comparable<Edge> {
        int w, u, v, idx;
        Edge(int w, int u, int v, int idx) {
            this.w = w; this.u = u; this.v = v; this.idx = idx;
        }
        public int compareTo(Edge o) { return Integer.compare(this.w, o.w); }
    }

    static class KruskalResult {
        Integer cost;
        List<Integer> used;
        KruskalResult(Integer c, List<Integer> u) {
            cost = c; used = u;
        }
    }

    static KruskalResult kruskal(int n, List<Edge> E, Integer skip) {
        DSU d = new DSU(n);
        int t = 0, cnt = 0;
        List<Integer> used = new ArrayList<>();
        for (Edge e : E) {
            if (skip != null && e.idx == skip) continue;
            if (d.union(e.u, e.v)) {
                t += e.w;
                used.add(e.idx);
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        if (cnt != n - 1) return new KruskalResult(null, null);
        return new KruskalResult(t, used);
    }

    static int secondMST(int n, List<Edge> E) {
        Collections.sort(E);
        KruskalResult bestRes = kruskal(n, E, null);
        if (bestRes.cost == null) return -1;
        int best = bestRes.cost;
        Integer ans = null;

        for (int i : bestRes.used) {
            KruskalResult alt = kruskal(n, E, i);
            if (alt.cost != null && alt.cost > best) {
                if (ans == null || alt.cost < ans) ans = alt.cost;
            }
        }

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        Set<Integer> s = new HashSet<>(bestRes.used);
        for (Edge e : E) {
            if (s.contains(e.idx)) {
                adj.get(e.u).add(new int[]{e.v, e.w});
                adj.get(e.v).add(new int[]{e.u, e.w});
            }
        }

        int[][] mx = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            boolean[] vis = new boolean[n + 1];
            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{i, 0});
            vis[i] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int u = cur[0], c = cur[1];
                for (int[] nb : adj.get(u)) {
                    int v = nb[0], w = nb[1];
                    if (!vis[v]) {
                        vis[v] = true;
                        mx[i][v] = Math.max(c, w);
                        q.add(new int[]{v, mx[i][v]});
                    }
                }
            }
        }

        for (Edge e : E) {
            if (!s.contains(e.idx)) {
                int cand = best + e.w - mx[e.u][e.v];
                if (cand > best) {
                    if (ans == null || cand < ans) ans = cand;
                }
            }
        }

        return ans == null ? -1 : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> E = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            E.add(new Edge(w, u, v, i));
        }
        System.out.println(secondMST(n, E));
    }
}
