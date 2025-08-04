import java.io.*;
import java.util.*;

public class C {
    static int[][] moves = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x1, y1, 0});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1], d = curr[2];

            if (x == x2 && y == y2) {
                System.out.println(d);
                return;
            }

            for (int[] mv : moves) {
                int nx = x + mv[0], ny = y + mv[1];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
        }

        System.out.println(-1);
    }
}

