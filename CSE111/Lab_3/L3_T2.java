import java.util.Scanner;

public class L3_T2{
  public static void main (String [] args){
    
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    
    for (int i =0; (i<input.length()); i++){
      int store= input.codePointAt(i);
      if (store!=97){
        store -=1;
        System.out.print((char)store);
      }
         else{
           System.out.print("z");
         }
    }
  }
}
             