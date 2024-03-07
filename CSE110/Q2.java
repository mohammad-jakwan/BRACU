public class Q2{
  public static void main(String [] args){
    int x = 0, sum = 0;
    while (x - 7 < 0){
      int y = x + 1;
      while (y < 9){ 
        if (x % y == 0){
          break;
        }
        sum = (++sum % 3) + x - y * (y % 2) ;
        System.out.println(sum--);
        y = y + 1;
      }
      if (x > 5){
        x++;
      }else{
        x += 3;
      }
      System.out.println(x % 3 == 0  &&  y % 3 == 0);
    }
  }
}

