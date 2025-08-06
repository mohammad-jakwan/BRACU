import java.io.*;
import java.util.*;

public class G {
    public static int bfs(int x, int y, char[][] grid, boolean[][] visited, int rows, int cols) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int diamonds = (grid[x][y] == 'D') ? 1 : 0;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];

            for (int[] d : directions) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (0 <= ni && ni < rows && 0 <= nj && nj < cols) {
                    if (!visited[ni][nj] && grid[ni][nj] != '#') {
                        visited[ni][nj] = true;
                        if (grid[ni][nj] == 'D') diamonds++;
                        queue.add(new int[]{ni, nj});
                    }
                }
            }
        }
        return diamonds;
    }

    static int max_diamonds(char[][] grid, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int max_count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] != '#') {
                    int count = bfs(i, j, grid, visited, rows, cols);
                    max_count = Math.max(max_count, count);
                }
            }
        }
        return max_count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][H];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < H; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        System.out.println(max_diamonds(grid, R, H));
    }
}
