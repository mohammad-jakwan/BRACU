public class Shape{
  public String name ;
  public double area;
  
  public void setParameters(String x, int y){
    name =x;
    area =  Math.PI * y * y;     
  }
  
    public void setParameters(String x, int y, int z){
    name =x;
    area =  0.5 * y * z;    
  }
    public void setParameters(String x, int y, int z, int h){
    name =x;
    area =  0.5* (y+z) * h;     
  }
    
    public String details(){
      return "Shape Name: " + name + "\n Area: " + area;
  }  
}