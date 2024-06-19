import java.util.Scanner;

public class L3_T3{
  public static void main (String [] args){
    
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    
    for (int i =0; i<input.length(); i++){
      for (int j = 0; j< i+1; j ++){
        System.out.print(input.charAt(j));
        
      }
      System.out.println();
    }
  }
}