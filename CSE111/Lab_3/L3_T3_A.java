import java.util.*;
public class L3_T3_A{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("N");
        int size=sc.nextInt();
        int [] arr1= new int [size];

        for(int i=0;i<size;i++){
          int element = sc.nextInt();
          arr1[i]= element;
     }
                 
        for (int i=arr1.length -1 ; i>=0; i--){
          System.out.print(arr1[i] + " ");
          }
        
          
    }
}