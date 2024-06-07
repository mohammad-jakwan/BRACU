import java.util.Scanner;
public class L2T6{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    double sum = 0;
    double tweight = 0;
    
    for (int i=0; i<5; i++){
      System.out.println("Enter num");
      double num = sc.nextDouble();
      for (int j=0; j<5;j++){
        System.out.println("Enter weight");
        double weight = sc.nextDouble();
        
         sum = sum + (num*weight);
         tweight = tweight + weight;
         break;
      }

        
    }
      System.out.println("Weighted Average = "+ sum/tweight);
  }
}