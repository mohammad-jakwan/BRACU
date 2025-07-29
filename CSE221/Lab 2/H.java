import java.util.*;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            int x = sc.nextInt();

            int low = 1;
            int high = 2000000000;

            while (low < high) {
                int mid = low + (high - low) / 2;
                int no = mid - (mid / x);

                if (no < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            System.out.println(low);
        }
    }
}
