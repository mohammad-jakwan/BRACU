
import java.util.Scanner;
public class Ealt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sortedArr[i] = arr[i];
        }


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
        }

        if (n < 3) {
            boolean isSorted = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] != sortedArr[i]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            int oddSize = (n + 1) / 2;  // ceil(n/2)
            int evenSize = n / 2;

            int[] mainOdd = new int[oddSize];
            int[] mainEven = new int[evenSize];
            int[] sortedOdd = new int[oddSize];
            int[] sortedEven = new int[evenSize];

            int oddIndex = 0;
            int evenIndex = 0;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    mainOdd[oddIndex] = arr[i];
                    sortedOdd[oddIndex] = sortedArr[i];
                    oddIndex++;
                } else {
                    mainEven[evenIndex] = arr[i];
                    sortedEven[evenIndex] = sortedArr[i];
                    evenIndex++;
                }
            }

            bubbleSort(mainOdd);
            bubbleSort(sortedOdd);
            bubbleSort(mainEven);
            bubbleSort(sortedEven);

            boolean isSame = arraysEqual(mainOdd, sortedOdd) && arraysEqual(mainEven, sortedEven);

            if (isSame) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }


    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}



 
