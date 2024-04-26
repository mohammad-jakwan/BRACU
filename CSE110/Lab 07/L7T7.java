import java.util.Scanner;
public class L7T7{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("str1 = ");
    String str1 = sc.nextLine();
    System.out.print("str2 = ");
    String str2 = sc.nextLine();
    int count = 0;
    int length1 = str1.length();
    int length2 = str2.length();
    boolean flag;
    int i = 0;
    while (i <= length1-length2){
      flag = true;
      int j = 0;
      while (j<length2){
        char x = str1.charAt(i + j);
        char c = str2.charAt(j);
        if (x != c){
          flag = false;
          break;
        }
        j++;
      }
      if (flag){
        count++;
        i+=length2;
      }
      else{
        i++;
      }
    }
    System.out.println("Occurrence: "+count+" times");
  }
}