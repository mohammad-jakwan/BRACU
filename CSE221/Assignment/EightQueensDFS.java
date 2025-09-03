import java.util.*;

public class EightQueensDFS {
    static final int N = 8;
    static List<String> moves = new ArrayList<>();

    // Print the board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if position (row, col) is safe
    static boolean isSafe(int[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // DFS/backtracking
    static boolean dfs(int[][] board, int row) {
        // 1. Base case: all queens placed
        if (row == N) {
            printBoard(board);
            return true;
        }

        // 2. Try placing queen in each column
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen
                moves.add("Row " + row + " → Col " + col);

                // 3. Recurse
                if (dfs(board, row + 1)) {
                    return true; // stop at first solution
                }

                // 4. Backtrack
                board[row][col] = 0;
                moves.remove(moves.size() - 1); // undo move
            }
        }

        return false; // no valid placement in this row
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (dfs(board, 0)) {
            System.out.println("Solution path:");
            for (String move : moves) {
                System.out.println(move);
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}