public class Shape2D {
  private int side;
  private int breadth;
  private int length;
  private Boolean flag = true;
    
    public Shape2D(int x){
      length=x;
      System.out.println("A Square has been created with length: "+length);
    }
    
    public Shape2D(int x, int y){
      length=x;
      breadth = y;
      System.out.println("A Rectangle has been created with length: "+length+ " and breadth: "+breadth);
    }
    
    public Shape2D(int x, int y, String s){
      if(s!= null){
        flag = false;
      }
      length=x;
      breadth = y;
      System.out.println("A Tringle has been created with height: "+length+ " and base: "+breadth);
      
    }

    public Shape2D(int x, int y, int s){
      length=x;
      breadth = y;
      side = s;
      System.out.println("A Tringle has been created with the following sides: "+ length+ ", " + breadth + ", "+ side);
    }
    
    public void area(){
      if (side== 0 && breadth == 0 && length>0){
        System.out.println("The area of the Square is: " + (double)length*length);
      }
      if (flag = false ){
        System.out.println("The area of the Triangle is: " + (double)0.5*length*breadth);
      }
      if (side == 0 && length>0 && breadth>0){
        System.out.println("The area of the Rectangle is: " + (double)length*breadth);
      }
      if (side> 0 && breadth >0 && length>0){
        double p = (side+length+breadth)/2;
        double a = Math.sqrt(p* (p-side) * (p-length) * (p-breadth));
        System.out.println("The area of the Triangle is: " + a);
      }
      }
      

}
  