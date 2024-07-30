import java.util.Scanner;
public class L2_T5_A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N = ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Please enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int[] newarr = new int[N];
        int count = 0;
        newarr[0] = arr[0];
        int index=1;
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[i - 1]) {
                newarr[index] = arr[i];
                index++;
            } else {
                count++;
            }
        }
        System.out.print("New Array: ");
        for (int i = 0; i < index; i++) {
            System.out.print(newarr[i] + " ");
        }
        System.out.println();
        System.out.println("Removed elements: " + count);
    }
}
