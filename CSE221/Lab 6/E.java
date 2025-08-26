import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = br.readLine();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 26; i++) g.add(new ArrayList<>());
        int[] indeg = new int[26];
        int[] used = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String w1 = a[i], w2 = a[i + 1];
            int m = Math.min(w1.length(), w2.length());
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    g.get(u).add(v);
                    indeg[v]++;
                    found = true;
                    break;
                }
            }
            if (!found && w1.length() > w2.length()) {
                System.out.println(-1);
                return;
            }
        }

        for (String s : a) {
            for (char c : s.toCharArray()) {
                used[c - 'a'] = 1;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (indeg[i] == 0 && used[i] == 1) pq.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int x = pq.poll();
            res.add(x);
            for (int v : g.get(x)) {
                indeg[v]--;
                if (indeg[v] == 0) pq.add(v);
            }
        }

        int totalUsed = 0;
        for (int u : used) totalUsed += u;

        if (res.size() != totalUsed) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int x : res) sb.append((char) (x + 'a'));
            System.out.println(sb.toString());
        }
    }
}
