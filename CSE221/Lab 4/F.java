import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        List<int[]> movesArr = new ArrayList<>();
        int moves = 0;
        int h = x - 1, k = y - 1;
        if (h >= 0 && h < n && k >= 0 && k < n) {
            for (int i = h - 1; i <= h + 1; i++) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (i >= 0 && i < n) {
                        if (j >= 0 && j < n) {
                            movesArr.add(new int[]{i + 1, j + 1});
                            moves++;
                        }
                    }
                }
            }
        }
        if (moves == 0) {
            System.out.println(moves);
            System.out.println("0 0");
        } else {
            System.out.println(moves - 1);
            for (int[] q : movesArr) {
                if (q[0] == x && q[1] == y) {
                    continue;
                } else {
                    System.out.println(q[0] + " " + q[1]);
                }
            }
        }
    }
}
