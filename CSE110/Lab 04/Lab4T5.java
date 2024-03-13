import java.util.Scanner;
import java.lang.Math;
public class Lab4T5{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int temp = n;
    int count =0;
    while (n!=0){
      n=n/10;
      count+=1;
    }
    int num = (int)Math.pow(10,(count-1));    
    while (temp!=0){    
    int output = temp/num;
    temp=temp% num;
    num = num/10;
    if (count>1){
    System.out.print(output+",");
    }
    else{
    System.out.print(output);
    }
    count-=1;
    }
  }
}