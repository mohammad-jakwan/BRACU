import java.util.Scanner;
public class L2T9_a{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    int count = 1;
    
    for (int i =1; i <=count; i++){
       input=input/10;
       count+=1;
        if (input==0){
        break;
        }
      }
    
    System.out.println(count-1+" digits");       
  }
  }

