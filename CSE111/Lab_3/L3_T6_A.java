import java.util.*;
public class L3_T6_A{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int [] arr1= new int [size];

        for(int i=0;i<size;i++){
          int element = sc.nextInt();
          arr1[i]= element;
        } 
        for (int j =0; j<arr1.length-1; j++){
          for (int i = 0; i<arr1.length-i-1; i++){
            if (arr1[j]>arr1[j+1]){
              int temp = arr1[j];
              arr1[j] = arr1[j+1];
              arr1[j+1] = temp;
            }
          }
        }
        
        if(size%2!=0){
          System.out.println("The median is "+arr1[arr1.length/2]);
        }
        else{
          System.out.println("The median is "+(arr1[arr1.length/2]+arr1[arr1.length/2-1])/2);
        }

        System.out.println(Arrays.toString(arr1));
        
    }
}