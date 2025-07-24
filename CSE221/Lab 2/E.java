    import java.util.*;

public class E {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] list1 = new int[N];
        for (int i = 0; i < N; i++) {
            list1[i] = sc.nextInt();
        }

        int i = 0, sum = 0, maxLength = 0;

        for (int j = 0; j < N; j++) {
            sum += list1[j];

            while (sum > K && i <= j) {
                sum -= list1[i];
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        System.out.println(maxLength);

        sc.close();
    }
}


