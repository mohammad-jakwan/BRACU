import java.lang.Math;
public class Task8
{
  public static void main(String[] args)
  {
    double side = Math.sqrt((4*4)+(3*3));
    double area = ((3*Math.sqrt(3)/2) * (side*side));
    double perimeter = 6 * side;
      
    System.out.println("Area of the hexagon: " + area);
    System.out.println("Perimeter of the hexagon: " + perimeter);

   }
 }