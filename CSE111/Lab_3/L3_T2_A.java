import java.util.*;
public class L3_T2_A{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int [] arr1= new int [5];
        int max = -9999999;
        int min = 99999999;
        int locmax=0;
        int locmin=0;
        

        for(int i=0;i<5;i++){
          int element = sc.nextInt();
          arr1[i]= element;
        }
                 
        for (int j =0; j<arr1.length; j++){
          if (arr1[j]>max){
            max = arr1[j];
            locmax=j;         
          }
        }

          System.out.println("The lagest number "+max+" was found at location "+locmax+".");
   
        for (int i =0; i<arr1.length; i++){
          if (arr1[i]<min){
            min= arr1[i];
            locmin=i;         
          }
        }

          System.out.println("The smallest number "+min+" was found at location "+locmin+".");
        
          
    }
}