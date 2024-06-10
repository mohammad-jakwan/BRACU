import java.util.Scanner;
public class L2T8{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int input1 = sc.nextInt();
    int input2 = sc.nextInt();
    int count = 0;
    int counter =0;
    
    if (input1>input2){
      int temp = input1;
      input1 = input2;
      input2 = temp;
    }
    
    for (int i = input1 + 1 ; i <input2 ; i++){
      for (int j = 2; j < i ; j++){
        if (i%j==0){
          count+=1;
      }
      }
      if (count==0){
        counter+=1;
    }
      count=0;
    }
        System.out.println("There are "+counter+ " prime numbers between "+ input1 + " and "+ input2+"."); 
  
  }
}

