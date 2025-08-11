import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] begin = new int[m];
        int[] end = new int[m];
        for (int i = 0; i < m; i++) begin[i] = sc.nextInt();
        for (int i = 0; i < m; i++) end[i] = sc.nextInt();
        int[] arr = new int[n + 1];
        int odd = 0;
        for (int i = 0; i < m; i++) {
            arr[begin[i]]++;
            arr[end[i]]++;
        }
        for (int j = 1; j <= n; j++) {
            if (arr[j] % 2 == 1) odd++;
        }
        if (odd == 0 || odd == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
