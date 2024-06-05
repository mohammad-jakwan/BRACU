import java.util.Scanner;
public class L2T3{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int sum= 0;
    int max = -99999;
    int min = 99999;
    double counter = 0.0;
    int count=0;
    
    while (count<10){

      int input = sc.nextInt();
      counter+=1;
      sum+=input;   
        if (input<min){
        min = input;
        }
        if (input>max){
        max = input;
        }
        count+=1;
      }
    System.out.println("Sum = "+sum);
    System.out.println("Minimum = "+min);
    System.out.println("Maximum = "+max);
    System.out.println("Average = " + (sum/counter));
  }
  }