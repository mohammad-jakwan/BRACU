import java.util.*;
public class eight_queens_problem {


    static final int N = 8;
    static Set<String> visited = new HashSet<>();
    static List<String> moves = new ArrayList<>();

    // Print board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Encode board state for visited-check
    static String encode(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int val : row) sb.append(val);
        }
        return sb.toString();
    }

    // Check if position (row, col) is safe
    static boolean isSafe(int[][] board, int row, int col) {
        // Column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;

        // Upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        // Upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    // DFS search
    static boolean dfs(int[][] board, int row) {
        // 1. Base case
        if (row == N) {
            printBoard(board);   // solved board
            return true;
        }

        // 2. Avoid repeated states
        String code = encode(board) + "-" + row;
        if (visited.contains(code)) return false;
        visited.add(code);

        // 3. Try placing queen in each column
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen

                // 4. Recurse
                if (dfs(board, row + 1)) {
                    moves.add("Row " + row + " → Col " + col);
                    return true; // solution found
                }

                board[row][col] = 0; // backtrack
            }
        }

        return false; // no solution in this path
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (dfs(board, 0)) {
            Collections.reverse(moves);
            System.out.println("Solution path:");
            for (String move : moves) {
                System.out.println(move);
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}

