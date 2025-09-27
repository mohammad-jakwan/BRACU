import java.util.*;
public class variation8qp {
    static final int N = 8;
    public static void main(String[] args) {
        solve8Queens();
    }

    private static void solve8Queens() {
        int[][] board = new int[N][N];

        if (!solve(board, 0)) {
            System.out.println("No solution exists for the 8-Queens problem.");
            return;
        }
        printSolution(board);
    }

    private static void printSolution(int[][] board) {
        System.out.println("--- 8-Queens Solution ---");
        System.out.println("\nVisual Board Layout:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) System.out.print(" Q ");
                else System.out.print(" . ");
            }
            System.out.println();
        }

        System.out.println("\nQueen Positions (row, col):");
        List<String> queenPositions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    queenPositions.add("(" + (i + 1) + ", " + (j + 1) + ")");
                }
            }
        }
        System.out.println(String.join(", ", queenPositions));
    }

    private static boolean check(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    private static boolean solve(int[][] board, int row) {
        if (row >= N) return true;

        for (int col = 0; col < N; col++) {
            if (check(board, row, col)) {
                board[row][col] = 1;

                if (solve(board, row + 1)) return true;

                board[row][col] = 0;
            }
        }
        return false;
    }
}

