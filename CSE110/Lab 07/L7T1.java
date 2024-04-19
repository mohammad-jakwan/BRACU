import java.util.Scanner;
public class L7T1{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    int length = str1.length();
    for (int i = length - 1; i >= 0; i--){
      char c = str1.charAt(i);
      int ascii = (int)c;            
      if (ascii == 32 || i == 0){
        int start;
        if (i == 0){
          start = 0;
        }
        else{
          start = i + 1;
        }
        for (int j = start; j < length; j++) {
          char x = str1.charAt(j);
          int ascii2 = (int)x;
          if (ascii2 == 32){
            break;
          }
          else{
            System.out.print(x);
          }
        }
        if (i != 0){
          System.out.print(" ");
        }
      }
    }
  }
}