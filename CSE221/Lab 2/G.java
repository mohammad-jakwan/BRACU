import java.util.*;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] list1 = new int[n];
        for (int i = 0; i < n; i++) {
            list1[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int p1 = 0, p2 = n;
            while (p1 < p2) {
                int mid = (p1 + p2) / 2;
                if (list1[mid] < x) {
                    p1 = mid + 1;
                } else {
                    p2 = mid;
                }
            }
            int gap1 = p1;

            p1 = 0;
            p2 = n;

            while (p1 < p2) {
                int mid = (p1 + p2) / 2;
                if (list1[mid] <= y) {
                    p1 = mid + 1;
                } else {
                    p2 = mid;
                }
            }
            int gap2 = p1;

            System.out.println(gap2 - gap1);
        }
    }
}
