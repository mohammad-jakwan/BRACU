
//task4

import java.util.Scanner;

public class L3_T4_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N = ");
        int n=sc.nextInt();
        int arr[] = new int[n];        
        boolean checked[] = new boolean[n];  

        System.out.println("Enter N integers:");

        // Input the array elements
        for (int i = 0; i < arr.length; i++) { 
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            
            if (!checked[i]) { 
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        checked[j] = true; 
                    }
                }
                if (count > 0) {
                    System.out.println(arr[i] + " occurred " + count + " times");
                }
            }
        }
    }
}