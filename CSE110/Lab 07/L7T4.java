import java.util.Scanner;
public class L7T4{
  public static void main(String []args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    boolean upp = false;
    for (int i = 0; i < str1.length(); i++) {
      char c = str1.charAt(i);
      if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
        if (!upp){
          if (c >= 'A' && c <= 'Z'){
             c = (char)(c+32);
          }
        }
        else{
          if (c >= 'a' && c <= 'z'){
             c = (char) (c - 32);
          }
        }
        System.out.print(c);
        upp=!upp;
      }
      else{
        System.out.print(c);
      }
    }
  }
}