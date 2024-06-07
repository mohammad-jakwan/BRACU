import java.util.Scanner;
public class L2T7_b{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    int next = 0;
    int current = 1;
    int previous = 0;
    int sum = 0;
    
    while (true){
        if (current>input){
        break;
      }
      System.out.print(current+" ");
      next = current + previous;
      previous = current;
      current = next;
      sum += previous;
    }
    System.out.println("Sum = " +sum);
  }
}