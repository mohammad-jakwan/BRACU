import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] list1 = new int[N];
        for (int i = 0; i < N; i++) {
            list1[i] = sc.nextInt();
        }
        Arrays.sort(list1);

        int i = 0;
        int j = N - 1;
        boolean found = false;

        while (i < j) { 
            int sum = list1[i] + list1[j];
            if (sum < S) {
                i++;
            } else if (sum > S) {
                j--;
            } else {
                System.out.println((i + 1) + " " + (j + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
