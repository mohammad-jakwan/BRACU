import java.util.Scanner;
public class Lab5T7 {
  public static void main (String [] args){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int product = 0;
      
    for (int i = a ; i <= b ; i++){
      int temp = i;
      product = 1;
      while (temp>0){
        int d = temp %10;
        product = product * d;
        temp = temp/10;
      }
      if (product%c ==0){
      System.out.print(product + " ");
      }

  }
}
}