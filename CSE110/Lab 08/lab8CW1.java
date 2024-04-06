import java.util.Scanner;
public class lab8CW1{
  public static void main (String [] args){
  Scanner sc = new Scanner(System.in);
  int arr[] = {5,6,7,8,9 ,10};
  
  for (int i = 0; i<arr.length; i++){
    int a = sc.nextInt();
    arr[i] = a;
    System.out.print(arr[i]+" " );
  }
    
    
  }
}