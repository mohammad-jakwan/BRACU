import java.util.*;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        int MAX = 20000000; 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] count = new int[MAX];
        int left = 0, maxLen = 0, dist = 0;

        for (int right = 0; right < n; right++) {
            int num = a[right];
            count[num]++;
            if (count[num] == 1) {
                dist++;
            }

            while (dist > k) {
                int leftNum = a[left];
                count[leftNum]--;
                if (count[leftNum] == 0) {
                    dist--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
