public class Student{
  public String name;
  public String prog;
    
  public Student( String x, String y){
    name = x;
    prog = y;
  }
  
  public void updateName( String x){
    name = x;
  }
  
  public String accessName(){
    return name;
  }
      
  public void updateProgram( String x){
    prog = x;
  }
    public String accessProgram(){
    return prog;
  }
}