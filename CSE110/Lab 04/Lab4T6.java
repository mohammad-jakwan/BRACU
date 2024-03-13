import java.util.Scanner;
public class Lab4T6{
  public static void main (String[] args){
  Scanner sc = new Scanner (System.in);
    int num = sc.nextInt();
    int count = 0;
    int sum = 1;
    
    for ( int i =2; i<num; i++){
      if (num%i ==0){
      count+=1;
      sum+=i;
      }
    }
    System.out.println(sum);
      if (count == 0){
        System.out.println(num+ " is a prime number");
      }
      else{
        System.out.println(num+ " is not a prime number");
      }
      if (sum == num ){
        System.out.println(num+ " is a perfect number");
      }
      else{
        System.out.println(num+ " is not a perfect number");
      }
    }  
  }