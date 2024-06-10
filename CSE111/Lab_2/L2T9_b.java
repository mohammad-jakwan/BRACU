import java.util.Scanner;
public class L2T9_b{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    int copy = input;
    int count = 1;
    int addzero = 1;
    
    for (int i =1; i <=count; i++){
       input=input/10;
       count+=1;
        if (input==0){
          break;
        }
      }
    for (int j=0; j<count-1; j++){
      addzero= addzero*10;
    }
    
      for(int k =0; k<count-1;k++){  
      int temp = copy%addzero;
      System.out.print(temp*7 + " ");
      copy = copy/10;
      if (copy ==0){
        break;
        }
    }
        
  }
}
