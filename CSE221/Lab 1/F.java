import java.util.Scanner;
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortingArr(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

  
    }

    public static void sortingArr(int[] arr) {
        int n = arr.length;
        boolean swap = true;

        while (swap) {
            swap = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] % 2 == arr[i + 1] % 2 && arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
        }
    }
}

