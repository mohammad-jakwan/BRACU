import java.util.Scanner;
public class Ass7T6{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    int upp=0;
    int low=0;
    int digi=0;
    int sp=0;
    int length=str1.length();
    boolean flag;
    for(int i=0; i<length; i++){
      char c = str1.charAt(i);
      if (c>= 'A' && c<='Z'){
        upp++;
      }
      else if (c>= 'a' && c<='z'){
        low++;
      }
      else if (c>= '0' && c<='9'){
        digi++;
      }
      else{
        sp++;
      }
    }
    if(upp>0 && low>0 && digi>0 && sp>0){
      flag = true;
    }
    else{
      flag = false;
    }
    if(flag){
      System.out.println("True");
    }
    else{
      System.out.println("False");
    }
  }
}