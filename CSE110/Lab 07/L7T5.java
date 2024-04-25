import java.util.Scanner;
public class L7T5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Given String 1: ");
    String str1 = sc.nextLine();
    System.out.print("Given String 2: ");
    String str2 = sc.nextLine();
    int i = 0;
    int j = 0;
    boolean flag;
    while (i < str1.length()){
      flag = false;
      j = 0;
      while (j < str2.length()) {
        char x = str1.charAt(i);
        char y = str2.charAt(j);
        if (x==y||(x>='A' && x<='Z' && x+32==y)||(x>='a' && x<='z' && x-32==y)){
          flag = true;
          break;
        }
        j++;
      }
      if (!flag) {
        System.out.print(str1.charAt(i));
      }
      i++;
    }
    System.out.println();
  }
}