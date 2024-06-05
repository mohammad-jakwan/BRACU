public class L2T1_b{
  public static void main(String [] args){
    
    int temp = 0;
    int i = 1;
    while (true){
      
      temp+=i;
      
      System.out.print(temp);
        if (temp !=120){
        System.out.print(", ");
      }
        if (temp ==120){
          break;
        }
        i+=1;

    }
  }
 }