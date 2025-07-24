import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // We need original indices after sorting, so store value+index pairs
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(a[i], i + 1); // store 1-based index
        }

        Arrays.sort(arr, Comparator.comparingInt(p -> p.val));

        boolean found = false;

        for (int i = 0; i < n - 2 && !found; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i].val + arr[left].val + arr[right].val;
                if (sum == x) {
                    System.out.println(arr[i].idx + " " + arr[left].idx + " " + arr[right].idx);
                    found = true;
                    break;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        if (!found) {
            System.out.println(-1);
        }

        sc.close();
    }

    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
