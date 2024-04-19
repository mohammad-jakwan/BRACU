import java.util.Scanner;
public class L7T3{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();
    String str3 = "";
    for (int i = 0; i < str1.length(); i++){
      char c = str1.charAt(i);
      boolean uppfound = false;
      for (int j = 0; j < str2.length(); j++){
        char x = str2.charAt(j);
        if (x==c){
          uppfound = true;
          break;
        }
      }
      if (!uppfound){
        str3+=(char)(c-32);
      }
    }
    for (int i=0; i<str2.length(); i++){
      char c2 = str2.charAt(i);
      boolean uppfound2 = false;
      for (int j = 0; j < str1.length(); j++){
        char y = str1.charAt(j);
        if (y==c2){
          uppfound2 = true;
          break;
        }
      }
      if (!uppfound2){
        str3+= (char)(c2 - 32);
      }
    }
    System.out.println(str3);
  }
}