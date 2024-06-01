import java.util.Scanner;

public class L3_T1{
  public static void main (String [] args){
    
    Scanner sc = new Scanner(System.in);
    System.out.println("PLease enter a string:");
    String input = sc.nextLine();
    String empty = "";
    String empty2 = "";
  
  int mid =input.length()/2;
  if(input.length()%2==0){
    for (int i =0; (i<(input.length()- mid)); i++){
      char a= input.charAt(i);
      empty=empty+a;
    }
    
    for (int j = (input.length()-1); j>= mid; j --){
      char b=input.charAt(j);
      empty2=empty2+b;
    }
  }
    else{
      for (int i =0; (i<(input.length()- mid-1)); i++){
        char a= input.charAt(i);
        empty=empty+a;
      }
      for (int j = (input.length()-1); j> mid; j --){
        char b=input.charAt(j);
        empty2=empty2+b;
    }
  
    }
    if (empty.equals(empty2)){
      System.out.println("Palindrome");
    }
    else{
      System.out.println("Not a palindrome");
}
}
}