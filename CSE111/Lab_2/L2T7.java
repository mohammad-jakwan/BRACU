import java.util.Scanner;
public class L2T7{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    int next = 0;
    int current = 1;
    int previous = 0;
    
    while (true){
      next = current + previous;
      previous = current;
      current = next;
        if (current>input){
        break;
      }
      System.out.print(current+" ");
    }
  }
}