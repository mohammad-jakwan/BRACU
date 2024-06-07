import java.util.Scanner;
public class L2T5{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int sum= 0;
    int max = -99999;
    int min = 99999;
    double counter = 0.0;
    int zerocount=0;
    
    while (true){
      if ( zerocount==3){
        break;
      }
      int input = sc.nextInt();
      if (input == 0){
        zerocount+=1;
      }
      else{
        zerocount=0;
      }
      if (input!=0){
      counter+=1;
      }
      sum+=input;
      
      if (input!=0){
        if (input<min){
        min = input;
        }
        if (input>max){
        max = input;
        }
      }
    }
    System.out.println("Sum = "+sum);
    System.out.println("Minimum = "+min);
    System.out.println("Maximum = "+max);
    System.out.println("Average = " + (sum/counter));
    
    
  }
  }