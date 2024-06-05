import java.util.Scanner;
public class L2T4{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int sum= 0;
    int max = -99999999;
    int min = 999999999;
    double counter = 0.0;
    int count=0;
    
    while (count<10){
      count+=1;
      int input = sc.nextInt();
      if (input>0 && input%2!=0){
      counter+=1;
      sum+=input;   
        if (input<min){
        min = input;
        }
        if (input>max){
        max = input;
        }
        
        }
       else{
        continue;
      }
    }
      if (sum==0){
        System.out.println("No odd positive numbers found");
      }
      else{

    System.out.println("Sum = "+sum);
    System.out.println("Minimum = "+min);
    System.out.println("Maximum = "+max);
    System.out.println("Average = " + (sum/counter));
      }
  }
  }
  