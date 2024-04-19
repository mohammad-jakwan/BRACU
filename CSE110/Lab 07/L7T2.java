import java.util.Scanner;
public class L7T2{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    int length = str1.length();
    String str2 = "";
    int count=0;
    for(int i=0; i<length; i++){
      char c = str1.charAt(i);
      count++;
      if (i+1==length || c!=str1.charAt(i+1)){
        str2+=c+ "" +count;
        count=0;
      }
    }
    System.out.print(str2);
  }
}