import java.util.Scanner;

public class L3_T1_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements (N): ");
        int N = sc.nextInt();
        int[] array = new int[N];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Remove Element: ");
        int remove = sc.nextInt();
        int newsize = 0;
        int count=0;
        for (int i = 0; i < N; i++) {
            int temp = array[i];
            if(temp==remove){
                count++;
            }
            if (temp != remove) {
                newsize++;
            }
        }
        if(count>0) {

            int[] arra = new int[newsize];
            int index = 0;
            for (int j = 0; j < N; j++) {
                if (array[j] != remove) {
                    arra[index++] = array[j];
                }
            }
            System.out.println("input array");
            for (int k = 0; k < N; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
            System.out.println("new array:");
            for (int j = 0; j < newsize; j++) {
                System.out.print(arra[j] + " ");
            }
        }
        else{
            System.out.println("input array");
            for (int k = 0; k < N; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
            System.out.println("Element not found");
        }

    }
}
